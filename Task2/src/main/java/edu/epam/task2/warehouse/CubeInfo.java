package edu.epam.task2.warehouse;

public class CubeInfo {
    private double area;
    private double volume;
    private double edgeLength;

    public CubeInfo(double area, double volume, double edgeLength) {
        this.area = area;
        this.volume = volume;
        this.edgeLength = edgeLength;
    }


    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeInfo that = (CubeInfo) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.volume, volume) == 0 && Double.compare(that.edgeLength, edgeLength) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = (int) (result * 31 + area);
        result = (int) (result * 31 + volume);
        result = (int) (result * 31 + edgeLength);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cube {");
        sb.append("area= ").append(area);
        sb.append(", volume= ").append(volume);
        sb.append(", length of edge= ").append(edgeLength);
        sb.append('}');
        return sb.toString();
    }
}
