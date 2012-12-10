package junit.test;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class AirLineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void save(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		
	}
}
