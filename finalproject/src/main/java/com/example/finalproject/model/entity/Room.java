package com.example.finalproject.model.entity;

import java.math.BigDecimal;

public class Room extends CustomEntity{
    private long idRoom;
    private BigDecimal price;
    private RoomType roomType;
    private int floor;
    private int roomNumber;
    private long idDiscount;
    private String imageUrl;

    public Room(long idRoom, BigDecimal price, RoomType roomType, int floor, int roomNumber, long idDiscount, String imageUrl) {
        this.idRoom = idRoom;
        this.price = price;
        this.roomType = roomType;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.idDiscount = idDiscount;
        this.imageUrl = imageUrl;
    }

    public Room(BigDecimal price, RoomType roomType, int floor, int roomNumber, long idDiscount, String imageUrl) {
        this.price = price;
        this.roomType = roomType;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.idDiscount = idDiscount;
        this.imageUrl = imageUrl;
    }

    public Room(){

    }

    public long getIdRoom() {
        return idRoom;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public long getIdDiscount() {
        return idDiscount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setIdDiscount(long idDiscount) {
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
        if (floor != room.floor) return false;
        if (roomNumber != room.roomNumber) return false;
        if (idDiscount != room.idDiscount) return false;
        if (!price.equals(room.price)) return false;
        if (roomType != room.roomType) return false;
        return imageUrl != null ? imageUrl.equals(room.imageUrl) : room.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRoom ^ (idRoom >>> 32));
        result = 31 * result + price.hashCode();
        result = 31 * result + roomType.hashCode();
        result = 31 * result + floor;
        result = 31 * result + roomNumber;
        result = 31 * result + (int) (idDiscount ^ (idDiscount >>> 32));
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{ ");
        sb.append("idRoom=").append(idRoom);
        sb.append(", price=").append(price);
        sb.append(", roomType=").append(roomType);
        sb.append(", floor=").append(floor);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", idDiscount=").append(idDiscount);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

