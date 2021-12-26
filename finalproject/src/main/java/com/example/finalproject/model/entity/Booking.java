package com.example.finalproject.model.entity;

public class Booking {
    private long idClient;
    private long idRoom;

    public Booking(long idClient, long idRoom) {

        this.idClient = idClient;
        this.idRoom = idRoom;
    }

    public long getIdClient() {
        return idClient;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (idClient != booking.idClient) return false;
        return idRoom == booking.idRoom;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClient ^ (idClient >>> 32));
        result = 31 * result + (int) (idRoom ^ (idRoom >>> 32));
        return result;
    }
}
