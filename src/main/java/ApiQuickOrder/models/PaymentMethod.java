package ApiQuickOrder.models;
// Generated 8 may 2023 19:23:56 by Hibernate Tools 4.3.6.Final


import jakarta.persistence.*;

/**
 * PaymentMethod generated by hbm2java
 */
@Entity
@Table(name = "paymentMethod", catalog = "QuickOrder")
public class PaymentMethod implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Integer creditCart;
	private String expirationDate;
	private String name;

	public PaymentMethod() {
	}

	public PaymentMethod(User user, Integer creditCart, String expirationDate, String name) {
		this.user = user;
		this.creditCart = creditCart;
		this.expirationDate = expirationDate;
		this.name = name;
	}

	@Id

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

	@Column(name = "creditCart")
	public Integer getCreditCart() {
		return this.creditCart;
	}

	public void setCreditCart(Integer creditCart) {
		this.creditCart = creditCart;
	}

	@Column(name = "expirationDate", length = 50)
	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
