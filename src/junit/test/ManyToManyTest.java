package junit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.demo.bean.Student;
import com.demo.bean.Teacher;

public class ManyToManyTest {

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new Student("xiaozhang"));
		em.persist(new Teacher("laozhang"));

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
 /**
  * build the association between teacher and student .
  */
	@Test
	public void buildTS() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		student.addTeacher(teacher);

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	/**
	 * remove the connection between teacher and student.
	 */
	@Test
	public void removeTS() {
		EntityManagerFactory factory = Persistence
		.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = em.find(Student.class, 1);
		Teacher teacher = em.getReference(Teacher.class, 1);
		student.removeTeacher(teacher);
		 
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
}
