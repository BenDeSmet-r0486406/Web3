package service;

import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryInMemory;
import domain.Person;

public class ShopService {
	private PersonRepository personRepository = new PersonRepositoryInMemory();

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
}
