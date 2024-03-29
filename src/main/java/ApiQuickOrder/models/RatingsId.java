package ApiQuickOrder.models;
// Generated 22 may 2023 16:45:41 by Hibernate Tools 4.3.6.Final

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * RatingsId generated by hbm2java
 */
@Embeddable
public class RatingsId implements java.io.Serializable {

	private int userId;
	private int restaurantId;

	public RatingsId() {
	}

	public RatingsId(int userId, int restaurantId) {
		this.userId = userId;
		this.restaurantId = restaurantId;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "restaurant_id", nullable = false)
	public int getRestaurantId() {
		return this.restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RatingsId))
			return false;
		RatingsId castOther = (RatingsId) other;

		return (this.getUserId() == castOther.getUserId()) && (this.getRestaurantId() == castOther.getRestaurantId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getRestaurantId();
		return result;
	}

}
