package com.example.finalproject.model.entity;

public class Discount extends CustomEntity{
    private long idDiscount;
    private byte percent;

    public Discount(long idDiscount, byte percent) {
        this.idDiscount = idDiscount;
        this.percent = percent;
    }

    public long getIdDiscount() {
        return idDiscount;
    }

    public byte getPercent() {
        return percent;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public void setPercent(byte percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount1 = (Discount) o;

        if (idDiscount != discount1.idDiscount) return false;
        return percent == discount1.percent;
    }

    @Override
    public int hashCode() {
        int result = (int) (idDiscount ^ (idDiscount >>> 32));
        result = 31 * result + (int) percent;
        return result;
    }
}
