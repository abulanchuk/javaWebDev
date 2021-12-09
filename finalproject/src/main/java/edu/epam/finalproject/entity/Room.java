package edu.epam.finalproject.entity;

import java.math.BigDecimal;

public class Room {
    private int idRoom;
    private BigDecimal price;
    private int roomType;
    private int floor;
    private int roomNumber;
    private int idDiscount;
    private String imageUrl;

    public Room(int idRoom, BigDecimal price, int roomType, int floor, int roomNumber, int idDiscount, String imageUrl) {
        this.idRoom = idRoom;
        this.price = price;
        this.roomType = roomType;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.idDiscount = idDiscount;
        this.imageUrl = imageUrl;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getRoomType() {
        return roomType;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (idRoom != room.idRoom) return false;
        if (roomType != room.roomType) return false;
        if (floor != room.floor) return false;
        if (roomNumber != room.roomNumber) return false;
        if (idDiscount != room.idDiscount) return false;
        if (!price.equals(room.price)) return false;
        return imageUrl.equals(room.imageUrl);
    }
    // Room r = new Room(..., "http://fsdfsdf")
    // Room r = new Room(..., null)
    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + roomType;
        result = 31 * result + floor;
        result = 31 * result + roomNumber;
        result = 31 * result + idDiscount;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
