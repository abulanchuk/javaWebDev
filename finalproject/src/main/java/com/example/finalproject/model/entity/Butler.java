package com.example.finalproject.model.entity;

public class Butler extends User{
    private long idButler;
    private byte rating;

    public Butler(long idUser, String login, String password, UserRole role, String name, String surname,
                  String phoneNumber,long idButler, byte rating) {
        super(idUser, login, password, role, name, surname, phoneNumber);
        this.idButler = idButler;
        this.rating = rating;
    }

    public Butler(String login, String password, UserRole role, String name, String surname, String phoneNumber, byte rating) {
        super(login, password, role, name, surname, phoneNumber);
        this.rating = rating;
    }

    public Butler(User user) {
        super(user.getIdUser(), user.getLogin(), user.getPassword(), user.getRole(), user.getName(), user.getSurname(), user.getPhoneNumber());
    }

    public Butler( byte rating) {
        this.rating = rating;
    }

    public Butler(){}

    public long getIdButler() {
        return idButler;
    }

    public byte getRating() {
        return rating;
    }

    public void setIdButler(long idButler) {
        this.idButler = idButler;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Butler butler = (Butler) o;

        if (idButler != butler.idButler) return false;
        return rating == butler.rating;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (idButler ^ (idButler >>> 32));
        result = 31 * result + (int) rating;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Butler{ ");
        sb.append("idButler=").append(idButler);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
