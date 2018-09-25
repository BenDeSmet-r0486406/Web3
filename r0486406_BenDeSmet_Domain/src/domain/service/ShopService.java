package domain.service;

import java.util.List;

import domain.db.PersonRepository;
import domain.db.ProductRepository;
import domain.db.ProductRepositorySql;
import domain.db.PersonRepositorySql;
import domain.model.Person;
import domain.model.Product;

public class ShopService {
	private PersonRepository personRepository = new PersonRepositorySql();
	private ProductRepository productRepository = new ProductRepositorySql();

	public ShopService(){
	}
	
	public Person getPerson(String personId) {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
	
	public Object getPersonsOrdered() {
		return getPersonRepository().orderPersons();
	}
	
	//Products
	
	
	public Product getProduct(String productId) {
		return getProductRepository().get(productId);
	}

	public List<Product> getProducts() {
		return getProductRepository().getAll();
	}

	public void addProduct(Product product) {
		getProductRepository().add(product);
	}

	public void updateProducts(Product product) {
		getProductRepository().update(product);
	}

	public void deleteProduct(String id) {
		getProductRepository().delete(id);
	}

	private ProductRepository getProductRepository() {
		return productRepository;
	}

	
}
