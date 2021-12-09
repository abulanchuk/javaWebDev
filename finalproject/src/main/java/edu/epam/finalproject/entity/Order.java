package edu.epam.finalproject.entity;

import java.time.LocalDateTime;

public class Order {
    private long idOrder;
    private int idButler;
    private LocalDateTime startDate;
    private int bookingDays;
    private boolean isPaid;
    private boolean isActive;
    private long idBooking;
}
