package ua.itea.remoteCart.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;

	public int getId() {
		return id;
	}

	public CartProductEntity setId(int id) {
		this.id = id;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public CartProductEntity setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "CartProductEntity [id=" + id + ", quantity=" + quantity + "]";
	}

}
