package com.example.finalproject.entity;

public class Butler extends CustomEntity{
    private long idButler;
    private long idUser;
    private long idComment;

    public Butler(long idButler, long idUser, long idComment) {
        this.idButler = idButler;
        this.idUser = idUser;
        this.idComment = idComment;
    }

    public long getIdButler() {
        return idButler;
    }

    public long getIdUser() {
        return idUser;
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdButler(int idButler) {
        this.idButler = idButler;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Butler butler = (Butler) o;

        if (idButler != butler.idButler) return false;
        if (idUser != butler.idUser) return false;
        return idComment == butler.idComment;
    }

    @Override
    public int hashCode() {
        int result = (int) (idButler ^ (idButler >>> 32));
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (int) (idComment ^ (idComment >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Butler{");
        sb.append("idButler=").append(idButler);
        sb.append(", idUser=").append(idUser);
        sb.append(", idComment=").append(idComment);
        sb.append('}');
        return sb.toString();
    }
}
