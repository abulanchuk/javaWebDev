package edu.epam.task3.entity;

import edu.epam.task3.entity.enumsource.PackagingType;
import edu.epam.task3.entity.enumsource.Production;


import java.time.LocalDate;

public class Sweet {
    public String id;
    public String name;
    public LocalDate packingTime;
    public int energy;
    public int sugar;
    public int butter;
    public SweetsValue value;
    public Production production;
    public PackagingType packing;

    public Sweet(){
        value = new SweetsValue(0,0,0);
        packing = PackagingType.BLACK;
    }


    public Sweet(String id, String name, LocalDate packingTime, int energy, int sugar, int butter, SweetsValue value, Production production, PackagingType packing) {
        this.id = id;
        this.name = name;
        this.packingTime = packingTime;
        this.energy = energy;
        this.sugar = sugar;
        this.butter = butter;
        this.value = value;
        this.production = production;
        this.packing = packing;
    }

    public void setPacking(PackagingType packing) {
        this.packing = packing;
    }

    public PackagingType getPacking() {
        return packing;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPackingTime() {
        return packingTime;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSugar() {
        return sugar;
    }

    public int getButter() {
        return butter;
    }

    public SweetsValue getValue() {
        return value;
    }

    public Production getProduction() {
        return production;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackingTime(LocalDate packingTime) {
        this.packingTime = packingTime;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setButter(int butter) {
        this.butter = butter;
    }

    public void setValue(SweetsValue value) {
        this.value = value;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sweet sweet = (Sweet) o;

        if (energy != sweet.energy) return false;
        if (sugar != sweet.sugar) return false;
        if (butter != sweet.butter) return false;
        if (!id.equals(sweet.id)) return false;
        if (!name.equals(sweet.name)) return false;
        if (!packingTime.equals(sweet.packingTime)) return false;
        if (!value.equals(sweet.value)) return false;
        if (production != sweet.production) return false;
        return packing == sweet.packing;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (packingTime != null ? packingTime.hashCode() : 0);
        result = 31 * result + energy;
        result = 31 * result + sugar;
        result = 31 * result + butter;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (production != null ? production.hashCode() : 0);
        result = 31 * result + (packing != null ? packing.hashCode() : 0);
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
        stringBuilder.append("production").append(production);
        stringBuilder.append("packaging Type").append(packing);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

