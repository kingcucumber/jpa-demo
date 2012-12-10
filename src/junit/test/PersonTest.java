package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.bean.Person;

public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new Person("jpa"));
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	@Test
	public void getPerson() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1); // get method
		System.out.println(p.getName());
		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	@Test
	public void getPerson2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Person p = em.getReference(Person.class, 1);// load method
		System.out.println(p.getName());
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void updatePerson() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1);// load method
		p.setName("other");
		System.out.println(p.getName());
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void updatePerson2() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1);// load method
		em.clear(); // / the object become dissociated
		// em.merge(p);// the dissociated object become managed.
		p.setName("other"); // can't be executed
		System.out.println(p.getName());
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	// new //managed //dissociation //delete
	// 瞬时 //持久 //脱管

	@Test
	public void deletePerson() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1);// load method
		em.remove(p);
		System.out.println(p.getName());
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	@Test
	public void query() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");

		EntityManager em = factory.createEntityManager();
		Query query = (Query) em
				.createQuery("select o from Person o where o.id= ?1");
		query.setParameter(1, 2);
		query.getResultList();
		// em.createQuery("from Person where id= ");
		em.close();
		factory.close();
	}

}
