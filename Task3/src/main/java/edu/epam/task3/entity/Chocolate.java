package edu.epam.task3.entity;

import edu.epam.task3.entity.enumsource.ChocolateType;
import edu.epam.task3.entity.enumsource.PackagingType;
import edu.epam.task3.entity.enumsource.Production;

import java.time.LocalDate;

public class Chocolate extends Sweet {
    ChocolateType chocolateType;

    public Chocolate() {
        super();
    }

    public Chocolate(String id, String name, LocalDate packingTime, int energy, int sugar, int butter, SweetsValue value, Production production, ChocolateType chocolateType, PackagingType packing) {
        super(id, name, packingTime, energy, sugar, butter, value, production, packing);
        this.chocolateType = chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chocolate chocolate = (Chocolate) o;

        return chocolateType == chocolate.chocolateType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (chocolateType != null ? chocolateType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Sweet {");
        stringBuilder.append("id").append(id);
        stringBuilder.append("name").append(name);
        stringBuilder.append("packingTime").append(packingTime);
        stringBuilder.append("energy").append(energy);
        stringBuilder.append("sugar").append(sugar);
        stringBuilder.append("butter").append(butter);
        stringBuilder.append("sweet value").append(value);
        stringBuilder.append("type of chocolate").append(chocolateType);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
