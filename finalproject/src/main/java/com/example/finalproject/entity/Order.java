package com.example.finalproject.entity;

import java.time.LocalDate;

public class Order extends CustomEntity{
    private long idOrder;
    private int idButler;
    private LocalDate startDate;
    private LocalDate finishDate;
    private boolean isPaid;
    private boolean isActive;
    private long idBooking;

    public Order(long idOrder, int idButler, LocalDate startDate, LocalDate finishDate, boolean isPaid, boolean isActive, long idBooking) {
        this.idOrder = idOrder;
        this.idButler = idButler;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isPaid = isPaid;
        this.isActive = isActive;
        this.idBooking = idBooking;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public int getIdButler() {
        return idButler;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isActive() {
        return isActive;
    }

    public long getIdBooking() {
        return idBooking;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdButler(int idButler) {
        this.idButler = idButler;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setIdBooking(long idBooking) {
        this.idBooking = idBooking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        if (idButler != order.idButler) return false;
        if (isPaid != order.isPaid) return false;
        if (isActive != order.isActive) return false;
        if (idBooking != order.idBooking) return false;
        if (!startDate.equals(order.startDate)) return false;
        return finishDate.equals(order.finishDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (idOrder ^ (idOrder >>> 32));
        result = 31 * result + idButler;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + finishDate.hashCode();
        result = 31 * result + (isPaid ? 1 : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (int) (idBooking ^ (idBooking >>> 32));
        return result;
    }
}
