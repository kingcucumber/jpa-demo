package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.bean.IDCard;
import com.demo.bean.Person;

public class OneToOneTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void save() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Person per = new Person("hello");
		per.setIdcard(new IDCard("323434"));
		em.persist(per);

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
