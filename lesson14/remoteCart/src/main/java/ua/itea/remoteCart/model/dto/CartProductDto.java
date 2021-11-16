package ua.itea.remoteCart.model.dto;

public class CartProductDto {
	private int id;
	private int quantity;

	public int getId() {
		return id;
	}

	public CartProductDto setId(int id) {
		this.id = id;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public CartProductDto setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public String toString() {
		return "CartProductDto [id=" + id + ", quantity=" + quantity + "]";
	}

}
