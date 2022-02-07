package com.example.finalproject.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order extends CustomEntity{
    private long idOrder;
    private long idButler;
    private LocalDate startDate;
    private LocalDate finishDate;
    private boolean isPaid;
    private boolean isActive;
    private long idClient;
    private BigDecimal totalPrice;

    public Order(long idOrder, long idButler, LocalDate startDate, LocalDate finishDate, boolean isPaid, boolean isActive, long idClient, BigDecimal totalPrice) {
        this.idOrder = idOrder;
        this.idButler = idButler;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isPaid = isPaid;
        this.isActive = isActive;
        this.idClient = idClient;
        this.totalPrice = totalPrice;
    }

    public Order(long idButler, LocalDate startDate, LocalDate finishDate, boolean isPaid, boolean isActive, long idClient, BigDecimal totalPrice) {
        this.idButler = idButler;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isPaid = isPaid;
        this.isActive = isActive;
        this.idClient = idClient;
        this.totalPrice = totalPrice;
    }
    public Order (){}


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public long getIdButler() {
        return idButler;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdButler(long idButler) {
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

    public void setIdClient(long idClient) {
        this.idClient = idClient;
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
        if (idClient != order.idClient) return false;
        if (!startDate.equals(order.startDate)) return false;
        if (!finishDate.equals(order.finishDate)) return false;
        return totalPrice.equals(order.totalPrice);
    }

    @Override
    public int hashCode() {
        int result = (int) (idOrder ^ (idOrder >>> 32));
        result = 31 * result + (int) (idButler ^ (idButler >>> 32));
        result = 31 * result + startDate.hashCode();
        result = 31 * result + finishDate.hashCode();
        result = 31 * result + (isPaid ? 1 : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (int) (idClient ^ (idClient >>> 32));
        result = 31 * result + totalPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{ ");
        sb.append("idOrder=").append(idOrder);
        sb.append(", idButler=").append(idButler);
        sb.append(", startDate=").append(startDate);
        sb.append(", finishDate=").append(finishDate);
        sb.append(", isPaid=").append(isPaid);
        sb.append(", isActive=").append(isActive);
        sb.append(", idClient=").append(idClient);
        sb.append(", totalPrice").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}
