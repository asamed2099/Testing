package studs;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.DbUserOperations;

public class TestPosts {
	private static EntityManagerFactory entityfactory;
	private static  String PERSISTENCE_UNIT_NAME="PostUnit";
	static{entityfactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);}
	public TestPosts() {
		// TODO Auto-generated constructor stub
	}
	public static EntityManager getEntityManager() {
		return entityfactory.createEntityManager();
	}
	public static void main(String[] args) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		/*/ Do database transactions here
		String text ="Trial Post for testing purposess";
		Post post = new Post();
		Date now = new Date();
		post.setPostdate(now);
		post.setPosttext(text);
		post.setBhuserId(1);
		entityManager.persist(post);
		*/
		//end
		entityManager.getTransaction().commit();
		entityManager.close();
		
		/*
		System.out.println("Record Inserted successfully");
		try {
			String ds= DbUserOperations.getGravatarUrl("asamed2099@yahoo.com", 12);
			System.out.println(ds);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		*/
		

	}

}