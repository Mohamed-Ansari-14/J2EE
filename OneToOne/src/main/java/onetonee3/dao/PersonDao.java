package onetonee3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetonee3.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ansari");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void findPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
//			person id is present
			System.out.println(person);
		} else {
			System.out.println("Sorry that id is Not Present");
		}
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person dbPerson = entityManager.find(Person.class, id);
//		poojitha aadhacard details also
		if (dbPerson != null) {
//			person id is present
			entityTransaction.begin();

			person.setId(id);
//			person=2,poo,chennai
			//person.setAadharCard(dbPerson.getAadharCard()); //-->Don't Use this line for CasCade !!!(it will not work for CasCade !!!)
//			person=2,poo,chennai,same old adharCard details
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry that id is Not Present");
		}
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
//			person id is present
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry that id is Not Present");
		}
	}

}
