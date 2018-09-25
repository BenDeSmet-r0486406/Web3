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

import domain.model.Person;

public class PersonRepositorySql implements PersonRepository{
	private PreparedStatement statement;
	private Connection connection;
	
	public PersonRepositorySql() {
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
	public Person get(String personId){
		if(personId == null || personId.isEmpty()){
			throw new DbException("cannot find person because the id is empty or null");
		}
		ResultSet result;
		Person person = new Person();
		String sql = "SELECT * FROM person WHERE userid = ?";
		try{
			statement = connection.prepareStatement(sql);
			statement.setString(1 ,personId);
			result = statement.executeQuery();
			while(result.next()){
				String userid = result.getString("userid");
				String email = result.getString("email");
				String password = result.getString("password");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				String salt = result.getString("salt");
				
				/*Role roleConverted = Role.valueOf(role);*/
				
				person = new Person(userid, email, password, firstname, lastname, salt);
				/*person.setRole(roleConverted)*/
			}
		}catch (SQLException e){
			throw new DbException(e.getMessage(), e);
		}
		return person;
	}
	
	@Override
	public List<Person> getAll(){
		List<Person> persons = new ArrayList<Person>();
		String sql = "SELECT * FROM person";
		try{
			statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
		
			while(result.next()){
				String userid = result.getString("userid");
				String email = result.getString("email");
				String password = result.getString("password");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				Person person = new Person(userid, email, password, firstname, lastname);
				persons.add(person);
			}
		}catch (SQLException e){
			throw new DbException(e.getMessage(), e);
		}
		return persons;
	}

	@Override
	public void add(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		String sql = "INSERT INTO r0486406.person(userid, email, password, firstName, lastName, salt)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, person.getUserid());
			statement.setString(2, person.getEmail());
			statement.setString(3, person.getPassword());
			statement.setString(4, person.getFirstName());
			statement.setString(5, person.getLastName());
			statement.setString(6, person.getSalt());
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}
	}
	
	@Override
	public void update(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		String sql = "UPDATE r0486406.person "
				+ "SET email = ?, password = ?, firstName = ?, lastName = ?)"
				+ "WHERE userid = ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, person.getEmail());
			statement.setString(2, person.getPassword());
			statement.setString(3, person.getFirstName());
			statement.setString(4, person.getLastName());
			statement.setString(5, person.getUserid());
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}
	}
	
	@Override
	public void delete(String personId){
		String sql = "DELETE FROM person WHERE userid = ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, personId);
			
			statement.execute();
		} catch (SQLException e){
			throw new DbException(e);
		}
	}
	
	public void finalize() throws SQLException{
		connection.close();
	}

}