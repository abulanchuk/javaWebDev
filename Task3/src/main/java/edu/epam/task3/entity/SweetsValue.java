package edu.epam.task3.entity;

public class SweetsValue {
    private double proteins;
    private double fats;
    private double carbohydrates;

    public SweetsValue(double proteins, double fats, double carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public double getProtein() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setProtein(double protein) {
        this.proteins = protein;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SweetsValue that = (SweetsValue) o;

        if (Double.compare(that.proteins, proteins) != 0) return false;
        if (Double.compare(that.fats, fats) != 0) return false;
        return Double.compare(that.carbohydrates, carbohydrates) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(proteins);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fats);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carbohydrates);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SweetsValue{");
        stringBuilder.append(" proteins=").append(proteins);
        stringBuilder.append(", fats=").append(fats);
        stringBuilder.append(", carbohydrates=").append(carbohydrates);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
