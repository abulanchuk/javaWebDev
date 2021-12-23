package com.example.finalproject.model.entity;

public class Butler extends CustomEntity{
    private long idButler;
    private long idUser;
    private byte rating;

    public Butler(long idButler, long idUser, byte rating) {
        this.idButler = idButler;
        this.idUser = idUser;
        this.rating = rating;
    }
    public Butler(){}

    public long getIdButler() {
        return idButler;
    }

    public long getIdUser() {
        return idUser;
    }

    public byte getRating() {
        return rating;
    }

    public void setIdButler(long idButler) {
        this.idButler = idButler;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Butler butler = (Butler) o;

        if (idButler != butler.idButler) return false;
        if (idUser != butler.idUser) return false;
        return rating == butler.rating;
    }

    @Override
    public int hashCode() {
        int result = (int) (idButler ^ (idButler >>> 32));
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (int) rating;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Butler{");
        sb.append("idButler=").append(idButler);
        sb.append(", idUser=").append(idUser);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
