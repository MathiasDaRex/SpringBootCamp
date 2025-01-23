package com.mathiasdarex.springmvc.bikerental.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bicycle bicycle;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "rental_start", nullable = false)
    private LocalDate rentalStart;

    @Column(name = "planned_return", nullable = false)
    private LocalDate plannedReturn;

    @Column(name = "actual_return")
    private LocalDate actualReturn;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RentalStatus status;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    public enum RentalStatus {
        ACTIVE, CLOSED, OVERDUE
    }

    public Rental() {
    }

    public Rental(int id, Bicycle bicycle, Customer customer, LocalDate rentalStart, LocalDate plannedReturn, LocalDate actualReturn, RentalStatus status, BigDecimal totalPrice) {
        this.id = id;
        this.bicycle = bicycle;
        this.customer = customer;
        this.rentalStart = rentalStart;
        this.plannedReturn = plannedReturn;
        this.actualReturn = actualReturn;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDate rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDate getPlannedReturn() {
        return plannedReturn;
    }

    public void setPlannedReturn(LocalDate plannedReturn) {
        this.plannedReturn = plannedReturn;
    }

    public LocalDate getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(LocalDate actualReturn) {
        this.actualReturn = actualReturn;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", bicycle=" + bicycle +
                ", customer=" + customer +
                ", rentalStart=" + rentalStart +
                ", plannedReturn=" + plannedReturn +
                ", actualReturn=" + actualReturn +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
