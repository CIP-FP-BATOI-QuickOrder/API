package ApiQuickOrder.models;
// Generated 8 may 2023 19:23:56 by Hibernate Tools 4.3.6.Final

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Raider generated by hbm2java
 */
@Entity
@Table(name = "raider", catalog = "QuickOrder", uniqueConstraints = @UniqueConstraint(columnNames = "nif"))
public class Raider implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String surname;
	private String nif;
	private String status;
	private String password;
	private String city;
	private Set<Order> orders = new HashSet<Order>(0);

	public Raider() {
	}

	public Raider(String name, String surname, String nif, String status, String password, String city, Set<Order> orders) {
		this.name = name;
		this.surname = surname;
		this.nif = nif;
		this.status = status;
		this.password = password;
		this.city = city;
		this.orders = orders;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", length = 60)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "nif", unique = true, length = 9)
	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "status", length = 18)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "city", length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "raider")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}