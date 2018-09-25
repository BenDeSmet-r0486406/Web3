package domain.model;

public class Product {
	private String id;
	private String description;
	private double price;
	private int waardering;
	
	public Product(){
	}
	
	public Product(String id, String description, double price, int waardering) {
		this.setId(id);
		this.setDescription(description);
		this.setPrice(price);
		this.setWaardering(waardering);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if (id == null || id.trim().isEmpty()){
			throw new IllegalArgumentException("id can't be empty");
		} else {
			this.id = id;
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description == null || description.trim().isEmpty()){
			throw new IllegalArgumentException("description can't be empty");
		} else {
			this.description = description;
		}
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price < 0){
			throw new IllegalArgumentException("price can'r be negative");
		} else {
			this.price = price;
		}
	}
	
	public int getWaardering() {
		return waardering;
	}
	public void setWaardering(int waardering) {
		if (price < 0){
			throw new IllegalArgumentException("price can'r be negative or above 100");
		} else {
			this.waardering = waardering;
		}
	}

	
	
}
