package edu.epam.finalproject.entity;

public enum RoomType {
    SUITE(1), DELUXE(2), STANDART(3);
    private int typeId;

    RoomType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }
}
