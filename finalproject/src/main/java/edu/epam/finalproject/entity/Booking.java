package edu.epam.finalproject.entity;

public class Booking {
    private long idBooking;
    private long idClient;
    private int idRoom;

    public Booking(long idBooking, long idClient, int idRoom) {
        this.idBooking = idBooking;
        this.idClient = idClient;
        this.idRoom = idRoom;
    }

    public long getIdBooking() {
        return idBooking;
    }

    public long getIdClient() {
        return idClient;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdBooking(long idBooking) {
        this.idBooking = idBooking;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (idBooking != booking.idBooking) return false;
        if (idClient != booking.idClient) return false;
        return idRoom == booking.idRoom;
    }

    @Override
    public int hashCode() {
        int result = (int) (idBooking ^ (idBooking >>> 32));
        result = 31 * result + (int) (idClient ^ (idClient >>> 32));
        result = 31 * result + idRoom;
        return result;
    }
}
