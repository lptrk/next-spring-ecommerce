package de.lptrk.ecommerce.backend.order;

import de.lptrk.ecommerce.backend.user.UserEty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class OrderEty {
    @Id
    @SequenceGenerator(name = "order_id_sequence", sequenceName = "order_id_sequence")
    @GeneratedValue(strategy = GenerationType.UUID, generator = "order_id_sequence")
    String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEty user;
    private Date orderDate;
    private Double totalAmount;
    private String status;
    private String shippingAddress;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return "OrderEty{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEty orderEty = (OrderEty) o;
        return Objects.equals(id, orderEty.id) && Objects.equals(user, orderEty.user) && Objects.equals(orderDate, orderEty.orderDate) && Objects.equals(totalAmount, orderEty.totalAmount) && Objects.equals(status, orderEty.status) && Objects.equals(shippingAddress, orderEty.shippingAddress) && Objects.equals(createdAt, orderEty.createdAt) && Objects.equals(updatedAt, orderEty.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, orderDate, totalAmount, status, shippingAddress, createdAt, updatedAt);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEty getUser() {
        return user;
    }

    public void setUser(UserEty user) {
        this.user = user;
    }

    public Date getOrdeDate() {
        return orderDate;
    }

    public void setOrdeDate(Date ordeDate) {
        this.orderDate = ordeDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OrderEty() {
    }

    public OrderEty(String id, UserEty user, Date orderDate, Double totalAmount, String status, String shippingAddress, Date createdAt, Date updatedAt) {
        this.id = id;
        this.user = user;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
