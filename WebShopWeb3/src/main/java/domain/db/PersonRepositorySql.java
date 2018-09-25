package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.model.Person;
import domain.model.Role;

public class PersonRepositorySql implements PersonRepository{
	private PreparedStatement statement;
	private Connection connection;
	private Properties properties;
	public PersonRepositorySql(Properties properties) {
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
	public Person get(String personId){
		if(personId == null || personId.isEmpty()){
			throw new DbException("cannot find person because the id is empty or null");
		}
		
		try {
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			ResultSet result;
			Person person = new Person();
			String sql = "SELECT * FROM r0486406_test.person WHERE userid = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1 ,personId);
			result = statement.executeQuery();
			while(result.next()){
				String userid = result.getString("userid");
				String email = result.getString("email");
				String password = result.getString("password");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				//String salt = result.getString("salt");
				String roleAsString = result.getString("role");
				String roleAsUppercaseString = roleAsString.toUpperCase();
				Role role = Role.valueOf(roleAsUppercaseString);
				person = new Person(userid, email, password, firstname, lastname/*, salt*/, role);
			}
			return person;
		} catch(Exception e){
			throw new DbException(e.getMessage(), e);
		}finally {
			closeConnection();
		}
		
		
	}
	
	
	@Override
	public List<Person> getAll(){
		try {
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			
			List<Person> persons = new ArrayList<Person>();
			String sql = "SELECT * FROM r0486406_test.person";
			
			statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
		
			while(result.next()){
				String userid = result.getString("userid");
				String email = result.getString("email");
				String password = result.getString("password");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String roleAsString = result.getString("role");
				String roleAsUppercaseString = roleAsString.toUpperCase();
				Role role = Role.valueOf(roleAsUppercaseString);
				Person person = new Person(userid, email, password, firstname, lastname, role);
				persons.add(person);
			}
		
		return persons;
		}catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}finally {
			closeConnection();
		}
	}

	@Override
	public void add(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			
			String sql = "INSERT INTO r0486406_test.person(userid, email, password, firstName, lastName, role)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, person.getUserid());
			statement.setString(2, person.getEmail());
			statement.setString(3, person.getPassword());
			statement.setString(4, person.getFirstName());
			statement.setString(5, person.getLastName());
			/*statement.setString(6, person.getSalt());*/
			statement.setString(6, person.getRole().name());
			
			statement.execute();
		}catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}finally {
			closeConnection();
		}
	}
	
	@Override
	public void update(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			
			String sql = "UPDATE r0486406_test.person "
				+ "SET email = ?, password = ?, firstName = ?, lastName = ?)"
				+ "WHERE userid = ?";
		
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, person.getEmail());
			statement.setString(2, person.getPassword());
			statement.setString(3, person.getFirstName());
			statement.setString(4, person.getLastName());
			statement.setString(5, person.getUserid());
			
			statement.execute();
		}catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}finally {
			closeConnection();
		}
	}
	
	@Override
	public void delete(String personId){
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			
			String sql = "DELETE FROM r0486406_test.person WHERE userid = ?";
		
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, personId);
			
			statement.execute();
		}catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}finally {
			closeConnection();
		}
	}
	
	@Override
	public List<Person> orderPersons() {
		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			
			List<Person> persons = new ArrayList<Person>();
			String sql = "SELECT * FROM r0486406_test.person ORDER BY email";
		
			statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
		
			while(result.next()){
				String userid = result.getString("userid");
				String email = result.getString("email");
				String password = result.getString("password");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String roleAsString = result.getString("role");
				String roleAsUppercaseString = roleAsString.toUpperCase();
				Role role = Role.valueOf(roleAsUppercaseString);
				Person person = new Person(userid, email, password, firstname, lastname/*, salt*/, role);
				persons.add(person);
			}
		
			return persons;
		}catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}finally {
			closeConnection();
		}
	}
	
	@Override
	public Person getAuthenticated(String userid, String password) {
		if (userid == null || password == null || userid.isEmpty()|| password.isEmpty()){
			throw new DbException("password or userid is empty");
		}

		try{
			String url = getProperties().getProperty("url");
			connection = DriverManager.getConnection(url, getProperties());
			
			List<Person> persons = this.getAll();
		
			for (Person p : persons){
			
				if (p.getUserid().equals(userid) && p.getPassword().equals(password)){
					return p;
				} 
			}
			return null;
		}catch(Exception e){
			throw new DbException(e.getMessage(),e);
		}finally {
			closeConnection();
		}
	}

}