package org.graviton.bazar.enums;

import java.util.stream.Stream;

public enum Location {
    EVERYWHERE,

    ERBIL,
    KIRKUK,
    SORAN,
    KALAR,
    KHANAKIN,
    SULEYMANI,
    HALABJA,
    RANYA,
    KHOYA,
    ZAXO,
    DUHOK,
    BARZAN;

    public static Location get(int id) {
        return Stream.of(values()).filter(location -> location.ordinal() == id).findAny().orElse(EVERYWHERE);
    }
}
