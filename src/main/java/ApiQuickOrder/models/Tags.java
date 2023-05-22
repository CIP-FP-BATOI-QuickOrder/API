package ApiQuickOrder.models;
// Generated 19 may 2023 16:02:57 by Hibernate Tools 4.3.6.Final


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Tags generated by hbm2java
 */
@Entity
@Table(name = "tags", catalog = "quick_order")
public class Tags implements java.io.Serializable {

    private Integer id;
    @JsonIgnore
    private Restaurant restaurant;
    private String name;

    public Tags() {
    }

    public Tags(Restaurant restaurant, String name) {
        this.restaurant = restaurant;
        this.name = name;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
