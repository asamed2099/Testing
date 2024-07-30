package studs;



import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestUser {
	private static EntityManagerFactory entityfactory;
	private static  String PERSISTENCE_UNIT_NAME="Bullhorn";
	static{entityfactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);}
	public TestUser() {
		// TODO Auto-generated constructor stub
	}
	public static EntityManager getEntityManager() {
		return entityfactory.createEntityManager();
	}
	public static void main(String[] args) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		// Do database transactions here
		User user = new User();
		/*
		user.setFullname("Hamza Khalid");
		user.setPassword("hm123");
		user.setEmail("hm.khalid4@bhorn.com");
		user.setMotto("Make it happen");
		Date now = new Date();
		user.setJoindate(now);
		*/
		entityManager.persist(user);
		
		//end
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Record Inserted successfully");
		
		
		

	}

}
