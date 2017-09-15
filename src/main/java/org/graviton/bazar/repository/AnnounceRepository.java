package org.graviton.bazar.repository;

import lombok.extern.slf4j.Slf4j;
import org.graviton.bazar.api.Service;
import org.graviton.bazar.database.DatabaseService;
import org.graviton.bazar.model.Announce;

import javax.inject.Inject;
import java.util.concurrent.ConcurrentHashMap;

import static org.graviton.bazar.database.generated.tables.Announces.ANNOUNCES;

@Slf4j
public class AnnounceRepository extends ConcurrentHashMap<Long, Announce> implements Service {

    @Inject private DatabaseService databaseService;

    public AnnounceRepository() {

    }

    @Override
    public void start() throws Exception {
        databaseService.getResult(ANNOUNCES).forEach(record -> put(record.get(ANNOUNCES.ID), new Announce(record)));
        log.info("{} announces loaded", size());
    }

    @Override
    public void stop() throws Exception {

    }
}
