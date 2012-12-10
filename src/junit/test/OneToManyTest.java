package junit.test;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.demo.bean.Order;
import com.demo.bean.OrderItem;

public class OneToManyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Order order = new Order();
		order.setAmount(34f);
		// order.setOrderId(UUID.randomUUID().toString());
		order.setOrderId("1111");

		OrderItem orderItem = new OrderItem();
		orderItem.setProductName("name1");
		orderItem.setSellPrice(90f);
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProductName("name2");
		orderItem2.setSellPrice(20f);
		order.addOrderItem(orderItem);
		order.addOrderItem(orderItem2);

		em.persist(order);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
