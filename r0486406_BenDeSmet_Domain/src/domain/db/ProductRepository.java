package domain.db;

import java.util.List;
import domain.model.Product;

public interface ProductRepository {
	public Product get(String ProductId);

	public List<Product> getAll();

	public void add(Product product);

	public void update(Product product);

	public void delete(String productId);

}
