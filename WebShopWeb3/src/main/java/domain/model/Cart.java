package domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Cart {
	private Date creationDate;
	private List<ProductOrder> productsOrdered = new ArrayList<>();
	
	public List<ProductOrder> getProductsOrdered() {
		return productsOrdered;
	}

	public Cart() {
		this.creationDate = new Date();
	}
	
	public void addProduct(Product product, int quantity) {
		ProductOrder order = new ProductOrder(product, quantity);
		productsOrdered.add(order);
	}
	
	private ProductOrder getOrder(String id) {
		for(ProductOrder order : productsOrdered){
			if(order.getProductId().equals(id)){
				return order;
			}
		}
		return null;
	}

	public void replaceQuantityOrdered(String orderId, int guantity) {
		if (guantity < 0) {
			throw new IllegalArgumentException("No valid guantity");
		}
		if(guantity == 0) {
			deleteProduct(orderId);
		} else {
			ProductOrder order = getOrder(orderId);
			order.setQuantity(guantity);
		}
	}

	public void deleteProduct(String orderId) {
		productsOrdered.remove(orderId);
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	public double getTotalPrice() {
		double total = 0;
		Collection<ProductOrder> orders = productsOrdered;
		for(ProductOrder order : orders){
			total += order.getTotalPrice();
		}
		return total;
	}


	public int getNumberOfProductOrdersInCart() {
		return productsOrdered.size();
	}

}
