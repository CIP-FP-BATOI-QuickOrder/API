package ApiQuickOrder.models;
// Generated 17 may 2023 16:31:47 by Hibernate Tools 4.3.6.Final


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "quick_order", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String phone;
	private Integer credit;
	private String photo;
	private Set<Order> orders = new HashSet<>(0);
	private Set<Address> addresses = new HashSet<>(0);
	private Set<PaymentMethod> paymentMethods = new HashSet<>(0);

	public User() {
	}

	public User(String name, String surname, String email, String password, String phone, Integer credit, Set<Order> orders,
				Set<Address> addresses, String photo, Set<PaymentMethod> paymentMethods) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.credit = credit;
		this.orders = orders;
		this.addresses = addresses;
		this.photo = photo;
		this.paymentMethods = paymentMethods;
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

	@Column(name = "email", unique = true, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", length = 9)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "credit")
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Column(name = "photo", length = 10)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<PaymentMethod> getPaymentMethods() {
		return this.paymentMethods;
	}

	public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
}
