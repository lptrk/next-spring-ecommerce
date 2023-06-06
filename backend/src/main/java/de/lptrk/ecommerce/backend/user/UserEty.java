package de.lptrk.ecommerce.backend.user;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class UserEty {
    @Id
    @SequenceGenerator(name = "user_id_sequence", sequenceName = "user_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return "UserEty{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEty userEty = (UserEty) o;
        return Objects.equals(id, userEty.id) && Objects.equals(userName, userEty.userName) && Objects.equals(email, userEty.email) && Objects.equals(password, userEty.password) && Objects.equals(createdAt, userEty.createdAt) && Objects.equals(updatedAt, userEty.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, password, createdAt, updatedAt);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserEty() {
    }

    public UserEty(Integer id, String userName, String email, String password, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
