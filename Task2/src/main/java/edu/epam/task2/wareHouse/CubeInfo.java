package edu.epam.task2.wareHouse;

public class CubeInfo {
    private double area;
    private double volume;

    public CubeInfo(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeInfo that = (CubeInfo) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (result * 31 + area);
        result = (int) (result * 31 + volume);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cube {");
        sb.append("area=").append(area);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
