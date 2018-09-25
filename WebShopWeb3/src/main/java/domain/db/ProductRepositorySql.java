package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.model.Product;

public class ProductRepositorySql implements ProductRepository{
	private PreparedStatement statement;
	private Connection connection;
	private Properties properties;
	
	public ProductRepositorySql(Properties properties) {
		try {
			Class.forName("org.postgresql.Driver");
			setProperties(properties);
		} catch (Exception e){
			throw new DbException(e.getMessage(), e);
		}
	}
	
	private Properties getProperties(){
		return properties;
	}
	
	private void setProperties(Properties properties){
		this.properties = properties;
	}
	
	private void closeConnection() {
		try{
			statement.close();
			connection.close();
		} catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}
		
	}
	
	@Override
	public Product get(String productId){
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			Product product = new Product();
			String sql = "SELECT *" 
				+ "FROM r0486406_test.product"
				+ "WHERE id = ?";
		
			statement = connection.prepareStatement(sql);
			statement.setString(1 ,productId);
			ResultSet result = statement.executeQuery();
			while(result.next()){
				String id = result.getString("id");
				String description = result.getString("description");
				double price = result.getDouble("price");
				int waardering = result.getInt("waardering");
				product= new Product(id, description, price, waardering);
			}
			return product;
				
		} catch(Exception e){
			throw new DbException(e.getMessage(), e);
		}finally {
			closeConnection();
		}
	}
	
	@Override
	public List<Product> getAll(){
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			Product product;
			ArrayList<Product> producten = new ArrayList<Product>();
			String sql = "Select * From r0486406_test.product";

			statement = connection.prepareStatement(sql);

			ResultSet set = statement.executeQuery();

			while (set.next()) {

				String id = set.getString("id");
				String description = set.getString("description");
				Double price = set.getDouble("price");
				int waardering = set.getInt("waardering");
				product = new Product(id, description, price, waardering);
				producten.add(product);
			}
			return producten;
		} catch(Exception e){
			throw new DbException(e.getMessage(), e);
		}finally {
			closeConnection();
		}
		
	}

	@Override
	public void add(Product product){
		if(product == null){
			throw new DbException("No product given");
		}
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			String sql = "INSERT INTO r0486406_test.product(id, description, price, waardering)"
				+ "VALUES (?, ?, ?, ?)";
		
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, product.getId());
			statement.setString(2, product.getDescription());
			statement.setDouble(3, product.getPrice());
			statement.setInt(4, product.getWaardering());
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		} finally{
			closeConnection();
		}
	}
	
	@Override
	public void update(Product product){
		if(product == null){
			throw new IllegalArgumentException("No product given");
		}
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			String sql = "UPDATE r0486406_test.product "
				+ "SET description = ?, price = ?, waardering = ? "
				+ "WHERE id = ?";
		
			statement = connection.prepareStatement(sql);

			statement.setString(1, product.getDescription());
			statement.setDouble(2, product.getPrice());
			statement.setInt(3, product.getWaardering());
			statement.setString(4, product.getId());

			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}finally{
			closeConnection();
		}
	}
	
	@Override
	public void delete(String productId){
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());	
			String sql = "DELETE FROM r0486406_test.product WHERE id = ?";
		
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, productId);
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}finally{
			closeConnection();
		}
	}

}