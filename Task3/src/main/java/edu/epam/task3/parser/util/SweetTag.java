package edu.epam.task3.parser.util;

public enum SweetTag {
    CANDIES("candies"),
    CANDY("candy"),
    CHOCOLATE("chocolate"),
    ID("id"),
    PACKING("packing"),
    SWEETS_VALUE("sweets-value"),
    CANDY_TYPE("candy-type"),
    CHOCOLATE_TYPE("chocolate_type"),
    NAME("name"),
    PACKING_TIME("packing-time"),
    ENERGY("energy"),
    SUGAR("sugar"),
    BUTTER("butter"),
    PROTEIN("protein"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production"),
    FILLED("filled");

    private String value;

    SweetTag(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
