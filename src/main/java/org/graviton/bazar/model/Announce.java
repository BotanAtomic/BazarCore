package org.graviton.bazar.model;

import lombok.Data;
import org.graviton.bazar.enums.Category;
import org.graviton.bazar.enums.Location;
import org.jooq.Record;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.graviton.bazar.database.generated.tables.Announces.ANNOUNCES;
import static org.graviton.bazar.utils.StringUtils.getOrElse;

@Data
public class Announce {

    private long id, price;
    private String title, description, contactName, contactNumber;

    private byte imageCount;

    private Category category;
    private Location location;

    private Date date;

    private List<String> favorites;

    public Announce(Record record) {
        this.id = record.get(ANNOUNCES.ID);
        this.price = record.get(ANNOUNCES.PRICE);
        this.title = record.get(ANNOUNCES.TITLE);
        this.description = record.get(ANNOUNCES.DESCRIPTION);
        this.contactName = record.get(ANNOUNCES.OWNER);
        this.contactNumber = record.get(ANNOUNCES.OWNER_NUMBER);
        this.category = Category.get(record.get(ANNOUNCES.CATEGORY));
        this.location = Location.get(record.get(ANNOUNCES.LOCATION));
        this.date = new Date(record.get(ANNOUNCES.DATE));
        this.imageCount = record.get(ANNOUNCES.IMAGES_COUNT);

        String favoriteData = getOrElse(record.get(ANNOUNCES.FAVORITES));
        if (!favoriteData.isEmpty())
            this.favorites = Stream.of(favoriteData.split(",")).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        else
            this.favorites = new CopyOnWriteArrayList<>();
    }

    public Announce(long id, JSONObject data) {
        this.id = id;
        this.price = Long.parseLong(data.getString("price"));
        this.title = data.getString("title");
        this.description = data.getString("description");
        this.description = data.getString("description");
        this.contactName = data.getString("owner_name");
        this.contactNumber = data.getString("owner_number");
        this.category = Category.get(data.getInt("category"));
        this.location = Location.get(data.getInt("location"));
        this.imageCount = (byte) data.getInt("images_size");
        this.date = new Date();
        this.favorites = new CopyOnWriteArrayList<>();
    }

    public String compileFavorites() {
        if (favorites == null || favorites.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        favorites.forEach(favorite -> builder.append(favorite).append(","));
        return builder.substring(0, builder.length() - 1);
    }

    public void addFavorite(String contactNumber) {
        if (!favorites.contains(contactNumber))
            this.favorites.add(contactNumber);
    }

    public void removeFavorite(String contactNumber) {
        this.favorites.remove(contactNumber);
    }

}
