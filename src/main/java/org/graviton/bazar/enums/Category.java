package org.graviton.bazar.enums;

import java.util.stream.Stream;

public enum Category {
    ALL,

    VEHICLES,
    CAR(VEHICLES),
    MOTORBIKE(VEHICLES),
    EQUIPMENT(VEHICLES),

    REAL_ESTATE,
    REAL_ESTATE_SELL(REAL_ESTATE),
    RENTING(REAL_ESTATE),
    TRADE(REAL_ESTATE),

    MULTIMEDIA,
    COMPUTER_SCIENCE(MULTIMEDIA),
    CONSOLE(MULTIMEDIA),
    IMAGE_AND_SOUND(MULTIMEDIA),
    TELEPHONY(MULTIMEDIA),

    HOLIDAYS,
    HOLIDAYS_HOUSE(HOLIDAYS),
    HOTEL(HOLIDAYS),

    HOUSE,
    FURNITURE(HOUSE),
    DECORATION(HOUSE),
    GARDENING(HOUSE),
    CLOTHING(HOUSE),
    SHOOS(HOUSE),
    LUX(HOUSE),

    OTHERS,
    SPORTS(OTHERS),
    MUSIC(OTHERS),
    FOOD(OTHERS),
    ANIMAL(OTHERS);

    private final Category superCategory;

    Category(Category superCategory) {
        this.superCategory = superCategory;
    }

    Category() {
        this.superCategory = null;
    }

    public static Category get(int id) {
        return Stream.of(values()).filter(category -> category.ordinal() == id).findAny().orElse(ALL);
    }

    public boolean isNot(int query) {
        if (query == ALL.ordinal())
            return false;

        return !(superCategory != null && superCategory.ordinal() == query) && !(query == ordinal());
    }

}
