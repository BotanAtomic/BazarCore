/*
 * This file is generated by jOOQ.
*/
package org.graviton.bazar.database.generated.tables.records;


import javax.annotation.Generated;

import org.graviton.bazar.database.generated.tables.Announces;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AnnouncesRecord extends UpdatableRecordImpl<AnnouncesRecord> implements Record11<Long, String, String, String, String, Long, Byte, Byte, Long, Byte, String> {

    private static final long serialVersionUID = -893472275;

    /**
     * Setter for <code>bazar.announces.id</code>.
     */
    public AnnouncesRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>bazar.announces.owner</code>.
     */
    public AnnouncesRecord setOwner(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.owner</code>.
     */
    public String getOwner() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bazar.announces.owner_number</code>.
     */
    public AnnouncesRecord setOwnerNumber(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.owner_number</code>.
     */
    public String getOwnerNumber() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bazar.announces.title</code>.
     */
    public AnnouncesRecord setTitle(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.title</code>.
     */
    public String getTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bazar.announces.description</code>.
     */
    public AnnouncesRecord setDescription(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>bazar.announces.price</code>.
     */
    public AnnouncesRecord setPrice(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.price</code>.
     */
    public Long getPrice() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>bazar.announces.category</code>.
     */
    public AnnouncesRecord setCategory(Byte value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.category</code>.
     */
    public Byte getCategory() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>bazar.announces.location</code>.
     */
    public AnnouncesRecord setLocation(Byte value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.location</code>.
     */
    public Byte getLocation() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>bazar.announces.date</code>.
     */
    public AnnouncesRecord setDate(Long value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.date</code>.
     */
    public Long getDate() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>bazar.announces.images_count</code>.
     */
    public AnnouncesRecord setImagesCount(Byte value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.images_count</code>.
     */
    public Byte getImagesCount() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>bazar.announces.favorites</code>.
     */
    public AnnouncesRecord setFavorites(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>bazar.announces.favorites</code>.
     */
    public String getFavorites() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, String, Long, Byte, Byte, Long, Byte, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, String, Long, Byte, Byte, Long, Byte, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Announces.ANNOUNCES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Announces.ANNOUNCES.OWNER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Announces.ANNOUNCES.OWNER_NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Announces.ANNOUNCES.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Announces.ANNOUNCES.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return Announces.ANNOUNCES.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field7() {
        return Announces.ANNOUNCES.CATEGORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Announces.ANNOUNCES.LOCATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return Announces.ANNOUNCES.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field10() {
        return Announces.ANNOUNCES.IMAGES_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Announces.ANNOUNCES.FAVORITES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getOwner();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getOwnerNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value7() {
        return getCategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value10() {
        return getImagesCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getFavorites();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value2(String value) {
        setOwner(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value3(String value) {
        setOwnerNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value4(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value5(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value6(Long value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value7(Byte value) {
        setCategory(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value8(Byte value) {
        setLocation(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value9(Long value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value10(Byte value) {
        setImagesCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord value11(String value) {
        setFavorites(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnnouncesRecord values(Long value1, String value2, String value3, String value4, String value5, Long value6, Byte value7, Byte value8, Long value9, Byte value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AnnouncesRecord
     */
    public AnnouncesRecord() {
        super(Announces.ANNOUNCES);
    }

    /**
     * Create a detached, initialised AnnouncesRecord
     */
    public AnnouncesRecord(Long id, String owner, String ownerNumber, String title, String description, Long price, Byte category, Byte location, Long date, Byte imagesCount, String favorites) {
        super(Announces.ANNOUNCES);

        set(0, id);
        set(1, owner);
        set(2, ownerNumber);
        set(3, title);
        set(4, description);
        set(5, price);
        set(6, category);
        set(7, location);
        set(8, date);
        set(9, imagesCount);
        set(10, favorites);
    }
}