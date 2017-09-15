package org.graviton.bazar.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.graviton.bazar.api.DatabaseProperties;
import org.graviton.bazar.api.Service;
import org.graviton.bazar.model.Announce;
import org.graviton.bazar.repository.AnnounceRepository;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.json.JSONObject;

import javax.inject.Inject;
import java.util.Properties;

import static org.graviton.bazar.database.generated.tables.Announces.ANNOUNCES;


@Slf4j
public class DatabaseService implements Service {
    private final HikariDataSource dataSource;

    @Inject @Getter private AnnounceRepository announceRepository;

    @Getter
    private DSLContext dslContext;

    @Inject
    public DatabaseService(@DatabaseProperties Properties properties) {
        this.dataSource = new HikariDataSource(new HikariConfig(properties));
    }


    @Override
    public void start() throws Exception {
        dslContext = DSL.using(dataSource.getConnection(), SQLDialect.MYSQL);
        log.info("connected to database server [{}]", dataSource.getDataSourceProperties().getProperty("url"));
    }

    @Override
    public void stop() throws Exception {
        dataSource.getConnection().close();
    }

    public Result<Record> getResult(Table<?> table) {
        return dslContext.select().from(table).fetch();
    }

    public Result<Record> getResult(Table<?> table, Condition... condition) {
        return dslContext.select().from(table).where(condition).fetch();
    }

    private long getNextId(Table<?> table, Field<?> field) {
        try {
            return (long) dslContext.select((field.max()).add(1)).from(table).fetchAny().get(0);
        } catch (Exception e) {
            return 1;
        }
    }

    public void updateAnnounce(Announce announce) {
        dslContext.update(ANNOUNCES).set(ANNOUNCES.FAVORITES, announce.compileFavorites()).where(ANNOUNCES.ID.equal(announce.getId())).execute();
    }

    public void removeAnnounce(Announce announce) {
        dslContext.delete(ANNOUNCES).where(ANNOUNCES.ID.equal(announce.getId())).execute();
    }

    public long createAnnounce(JSONObject data) {
        long id = getNextId(ANNOUNCES, ANNOUNCES.ID);

        Announce announce = new Announce(id, data);

        announceRepository.put(announce.getId(), announce);

        dslContext.insertInto(ANNOUNCES, ANNOUNCES.ID, ANNOUNCES.OWNER, ANNOUNCES.OWNER_NUMBER,
                ANNOUNCES.TITLE, ANNOUNCES.DESCRIPTION, ANNOUNCES.PRICE, ANNOUNCES.CATEGORY, ANNOUNCES.LOCATION,
                ANNOUNCES.DATE, ANNOUNCES.IMAGES_COUNT).values(id, announce.getContactName(),
                announce.getContactNumber(), announce.getTitle(), announce.getDescription(),
                announce.getPrice(), (byte) announce.getCategory().ordinal(), (byte) announce.getLocation().ordinal(),
                announce.getDate().getTime(), announce.getImageCount()).executeAsync();

        return id;
    }

}
