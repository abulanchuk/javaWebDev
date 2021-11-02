package entity;

import entity.enumsource.CandyType;
import entity.enumsource.PackagingType;
import entity.enumsource.Production;

import java.time.LocalDate;

public class Candy extends Sweet {
    private CandyType candyType;
    private boolean filled;

    public Candy() {
        super();
    }

    public Candy(String id, String name, LocalDate packingTime, int energy, int sugar, int butter, SweetsValue value, Production production, CandyType candyType, PackagingType packing, boolean filled) {
        super(id, name, packingTime, energy, sugar, butter, value, production, packing);
        this.candyType = candyType;
        this.filled = filled;
    }

    public void setCandyType(CandyType candyType) {
        this.candyType = candyType;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Candy candy = (Candy) o;

        if (filled != candy.filled) return false;
        return candyType == candy.candyType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (candyType != null ? candyType.hashCode() : 0);
        result = 31 * result + (filled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Sweet {");
        stringBuilder.append("id").append(id);
        stringBuilder.append("name").append(name);
        stringBuilder.append("packingTime").append(packingTime);
        stringBuilder.append("energy").append(energy);
        stringBuilder.append("sugar").append(sugar);
        stringBuilder.append("butter").append(butter);
        stringBuilder.append("sweet value").append(value);
        stringBuilder.append("type of candy").append(candyType);
        stringBuilder.append("packaging Type").append(packing);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
