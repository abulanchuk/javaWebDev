package edu.epam.finalproject.entity;

public class Discount {
    private int discount;
    private byte perecent;

    public Discount(int discount, byte perecent) {
        this.discount = discount;
        this.perecent = perecent;
    }

    public int getDiscount() {
        return discount;
    }

    public byte getPerecent() {
        return perecent;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setPerecent(byte perecent) {
        this.perecent = perecent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount1 = (Discount) o;

        if (discount != discount1.discount) return false;
        return perecent == discount1.perecent;
    }

    @Override
    public int hashCode() {
        int result = discount;
        result = 31 * result + (int) perecent;
        return result;
    }
}
