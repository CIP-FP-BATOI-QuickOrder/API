package ApiQuickOrder.models;
// Generated 8 may 2023 19:23:56 by Hibernate Tools 4.3.6.Final

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "review", catalog = "QuickOrder")
public class Review implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private User user;
    private Restaurant restaurant;
    private String content;
    private Date createdAt;


    public Review() {
    }

    public Review(User user, Restaurant restaurant, String content, Integer id, Date createdAt) {
        this.user = user;
        this.content = content;
        this.id = id;
        this.createdAt = createdAt;
        this.restaurant = restaurant;
    }

    public Review(User user,Restaurant restaurant, String content, Date createdAt) {
        this.user = user;
        this.content = content;
        this.createdAt = createdAt;
        this.restaurant = restaurant;
    }
    public Review(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Column(name = "content", length = 100)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}