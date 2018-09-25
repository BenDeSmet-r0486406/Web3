package domain.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.db.DbException;

public class Person {
	private String userid;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String salt;
	
	public Person(String userid, String email, String password, String firstName, String lastName, String salt) {
		setUserid(userid);
		setEmail(email);
		try {
			setPasswordHashed(password);
		} catch (NoSuchAlgorithmException e) {
			throw new DbException("Password wrong!!!!");
		} catch (UnsupportedEncodingException e) {
			throw new DbException("Password wrong!!!!");
		}
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Person(String userid, String email, String password, String firstName, String lastName) {
		setUserid(userid);
		setEmail(email);
		try {
			setPasswordHashed(password);
		} catch (NoSuchAlgorithmException e) {
			throw new DbException("Password wrong!!!!");
		} catch (UnsupportedEncodingException e) {
			throw new DbException("Password wrong!!!!");
		}
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Person() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		if(userid.isEmpty()){
			throw new IllegalArgumentException("No userid given");
		}
		this.userid = userid;
	}

	public void setEmail(String email) {
		if(email.isEmpty()){
			throw new IllegalArgumentException("No email given");
		}
		String USERID_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.email = email;
	}

	
	
	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.isEmpty()){
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.isEmpty()){
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPasswordHashed(String password2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (password2.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password2);
	}
	
	private String hashPassword(String password2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		if (this.getSalt() == null || salt.isEmpty()) {
			SecureRandom random = new SecureRandom();
			byte seed[] = random.generateSeed(40);
			String hallo = new String(seed);
			this.setSalt(hallo);
		}

		crypt.update(salt.getBytes("UTF-8"));
		crypt.update(password2.getBytes("UTF-8"));
		return new BigInteger(1, crypt.digest()).toString(16);
	}
	
	public boolean isCorrectPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		return hashPassword(password).equals(this.password);
	}
	
	public void setPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}
	
	public String getSalt(){
		return salt;
	}
	
	public void setSalt(String salt){
		if (salt==null || salt.isEmpty()) {
			throw new IllegalArgumentException("No salt given");
		}
		this.salt = salt;
	}
}