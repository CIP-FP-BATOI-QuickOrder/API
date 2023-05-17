package ApiQuickOrder.models;
// Generated 8 may 2023 19:23:56 by Hibernate Tools 4.3.6.Final

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "address", catalog = "QuickOrder")
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private String address;
	private Integer number;
	private String name;
	private String city;
	private Integer cp;
	private Set<Order> orders = new HashSet<Order>(0);

	public Address() {
	}

	public Address(User user, String address, Integer number, String name, String city, Integer cp, Set<Order> orders) {
		this.user = user;
		this.address = address;
		this.number = number;
		this.name = name;
		this.city = city;
		this.cp = cp;
		this.orders = orders;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "cp")
	public Integer getCp() {
		return this.cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
