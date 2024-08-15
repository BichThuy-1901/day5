package jpa.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "orderDate")
    private LocalDate orderDate;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerAddress")
    private String customerAddress;


    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderDetailEntity> ordersDetailsEntities;

    public OrderEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderDetailEntity> getOrdersDetailsEntities() {
        return ordersDetailsEntities;
    }

    public void setOrdersDetailsEntities(List<OrderDetailEntity> ordersDetailsEntities) {
        this.ordersDetailsEntities = ordersDetailsEntities;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", ordersDetailsEntities=" + ordersDetailsEntities +
                '}';
    }
}
