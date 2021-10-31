package entity;

public class SweetsValue {
    private double proteins;
    private double fats;
    private double carbohydrates;

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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SweetsValue{");
        stringBuilder.append(" proteins=").append(proteins);
        stringBuilder.append(", fats=").append(fats);
        stringBuilder.append(", carbohydrates=").append(carbohydrates);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
