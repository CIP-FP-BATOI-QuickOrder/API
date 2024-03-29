package ApiQuickOrder.models;
// Generated 8 may 2023 19:23:56 by Hibernate Tools 4.3.6.Final


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * PaymentMethod generated by hbm2java
 */
@Entity
@Table(name = "paymentMethod", catalog = "QuickOrder")
public class PaymentMethod implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@JsonIgnore
	private User user;
	private String creditCart;
	private String expirationDate;
	private String bank;
	private String name;

	public PaymentMethod() {
	}

	public PaymentMethod(User user, String creditCart, String expirationDate, String bank, String name) {
		this.user = user;
		this.creditCart = creditCart;
		this.expirationDate = expirationDate;
		this.bank = bank;
		this.name = name;
	}

	public PaymentMethod(String creditCart, String expirationDate, String bank, String name) {
		this.creditCart = creditCart;
		this.expirationDate = expirationDate;
		this.bank = bank;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "creditCart")
	public String getCreditCart() {
		return this.creditCart;
	}

	public void setCreditCart(String creditCart) {
		this.creditCart = creditCart;
	}

	@Column(name = "expirationDate", length = 50)
	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "bank", length = 50)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
