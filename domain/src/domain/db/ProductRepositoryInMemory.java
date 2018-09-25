package domain.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.model.Product;

public class ProductRepositoryInMemory implements ProductRepository{
private Map<String, Product> products = new HashMap<String, Product>();
	
	public ProductRepositoryInMemory () {
		Product product1 = new Product("product1", "eerste product", 4.95);
		add(product1);
		Product product2 = new Product("product2", "tweede product", 6.95);
		add(product2);
	}
	@Override
	public Product get(String productId){
		if(productId == null){
			throw new IllegalArgumentException("No id given");
		}
		return products.get(productId);
	}
	
	@Override
	public List<Product> getAll(){
		return new ArrayList<Product>(products.values());	
	}

	@Override
	public void add(Product product){
		if(product == null){
			throw new IllegalArgumentException("No product given");
		}
		if (products.containsKey(product.getId())) {
			throw new IllegalArgumentException("User already exists");
		}
		products.put(product.getId(), product);
	}
	
	@Override
	public void update(Product product){
		if(product == null){
			throw new IllegalArgumentException("No product given");
		}
		if(!products.containsKey(product.getId())){
			throw new IllegalArgumentException("No product found");
		}
		products.put(product.getId(), product);
	}
	
	@Override
	public void delete(String productId){
		if(productId == null){
			throw new IllegalArgumentException("No id given");
		}
		products.remove(productId);
	}

}
