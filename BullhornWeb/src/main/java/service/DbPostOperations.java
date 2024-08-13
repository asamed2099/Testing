package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import studs.Post;
import studs.User;

public class DbPostOperations {

	public DbPostOperations() {
		
	}
	public static void insert(Post post) {
		EntityManager em =DBUtils.getEntityManager("PostUnit");
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(post);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			em.close();
		}
	}
	
	/**
	* Updates the data in a Bhuser
	* Pass the method a Bhuser with all the values set to
	your liking and
	* this method will update the database with these
	values.
	* This method doesn't actually return anything but the
	good feeling
	* that your update has been completed. If it can't be
	completed then
	* it won't tell you. Sounds like something needs to be
	added in the future. Hmmm.
	* @param bhUser
	*/
	public static void update(Post post) {
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit");
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			// do transaction 
			entityManager.merge(post );
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}
		
		
		
	}
	
	/**
	* Removes a Bhuser from the database.
	* Not sure why you'd want to delete a Bhuser from the
	database but this
	* method will do it for you. This method does not
	explicitly remove the user's
	* posts, but most likely you've set up the database
	with cascading deletes, which
	* will take care of that. Gives no feedback.
	* @param bhUser that you never want to see again
	*/
	public static void delete(Post post) {
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit"); 
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.remove(entityManager.merge(post));
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}
	}
	public static List<Post>posts (){
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit");
		String qString ="select b from Post b ORDER BY b.postdate desc";
		List<Post>posts =null;
		
		try {
			TypedQuery<Post> query=entityManager.createQuery(qString, Post.class);
			
			posts = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		return posts;
	}
	
	public static List<Post>listPostOfUser(long userId){
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit");
		List<Post> userposts = null;
		
		String qString = "select p from Post p where p.user.bhuser_id=:userId";
		
		try {
			TypedQuery<Post> query =entityManager.createQuery(qString, Post.class);
			query.setParameter("userId", userId);
			userposts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		
		return  userposts;
	}
	

	public static List<Post>listPostOfUser(String email){
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit");
		List<Post> userposts = null;
		
		String qString = "select p from Post p where p.user.email=:email";
		
		try {
			TypedQuery<Post> query =entityManager.createQuery(qString, Post.class);
			query.setParameter("email", email);
			userposts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		
		return  userposts;
	}
	public static List<Post>searchPosts(String search){
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit");
		List<Post> searchposts = null;
		String qString = "select b from Post b "
		+ "where b.posttext like:search";
		
		try {
			TypedQuery<Post>query = entityManager.createQuery(qString, Post.class);
			query.setParameter("search", "%" +search + "%");
			searchposts =query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		return searchposts; 
	}
	public static User poster(int userId) {
		/*
		EntityManager entityManager = DBUtils.getEntityManager("PostUnit");
		List<Post> userposts = null;
		
		String qString = "select p from Post p where p.bhuserId=:userId";
		
		try {
			TypedQuery<Post> query =entityManager.createQuery(qString, Post.class);
			query.setParameter("bhuser_id", userId);
			userposts = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		
		return  userposts.get(userId);
		*/	
		return null;
		
	}
}
