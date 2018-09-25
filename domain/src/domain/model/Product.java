package domain.model;

public class Product {
	private String id;
	private String description;
	private double price;
	
	public Product(){
	}
	
	public Product(String id, String description, double price) {
		this.setId(id);
		this.setDescription(description);
		this.setPrice(price);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	
}