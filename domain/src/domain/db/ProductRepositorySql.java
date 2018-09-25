package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.model.Product;

public class ProductRepositorySql implements ProductRepository{
	private PreparedStatement statement;
	private Connection connection;
	
	public ProductRepositorySql() {
		Properties properties = new Properties();
		String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51617/2TX32";
		properties.setProperty("user", "r0486406");
		properties.setProperty("password", "B20d5s81");
		properties.setProperty("ssl", "true");
		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new DbException(e.getMessage(), e);
		}
	}
	
	@Override
	public Product get(String productId){
		Product product = new Product();
		String sql = "SELECT *" 
				+ "FROM product"
				+ "WHERE userid = ?";
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(1 ,productId);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				String id = result.getString("id");
				String description = result.getString("description");
				double price = result.getDouble("price");
				product= new Product(id, description, price);
			}
		}catch (SQLException e){
			throw new DbException(e.getMessage(), e);
		}
		return product;
	}
	
	@Override
	public List<Product> getAll(){

		Product product;
		ArrayList<Product> producten = new ArrayList<Product>();
		try {
			String sql = "Select * From product";

			statement = connection.prepareStatement(sql);

			ResultSet set = statement.executeQuery();

			while (set.next()) {

				String id = set.getString("id");
				String description = set.getString("description");
				Double price = set.getDouble("price");
				product = new Product(id, description, price);
				producten.add(product);
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage(), e);
		}

		return producten;
	}

	@Override
	public void add(Product product){
		if(product == null){
			throw new DbException("No product given");
		}
		String sql = "INSERT INTO r0486406.product(id, description, price)"
				+ "VALUES (?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, product.getId());
			statement.setString(2, product.getDescription());
			statement.setDouble(3, product.getPrice());
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}
	}
	
	@Override
	public void update(Product product){
		if(product == null){
			throw new IllegalArgumentException("No product given");
		}
		String sql = "UPDATE product "
				+ "SET description = ?, price = ? "
				+ "WHERE id = ?";
		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, product.getDescription());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getId());

			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}
	}
	
	@Override
	public void delete(String productId){
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, productId);
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}
	}
	
	public void finalize() throws SQLException{
		connection.close();
	}

}