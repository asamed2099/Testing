package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import studs.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import service.util.MD5Util;
public class DbUserOperations {

	public DbUserOperations() {
		// TODO Auto-generated constructor stub
	}
	public static User getUser(long UserId) {
		EntityManager em =DBUtils.getEntityManager("Bullhorn");
		User user =em.find(User.class, UserId);
		return user;
	}
	public static void insert(User user) {
		EntityManager em =DBUtils.getEntityManager("Bullhorn");
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			em.close();
		}
	}
	/**
	* Gets a Gravatar URL given the email and size
	* In accordance with Gravatar's requirements the email
	will be hashed
	* with the MD5 hash and returned as part of the url
	* The url will also include the s=xx attribute to
	request a Gravatar of a
	* particular size.
	* References: <a href="http://www.gravatar.
	com">http://www.gravatar.com</>
	@param email - email of the user who's gravatar
	you want
	* @param size - indicates pixel height of the image to
	be returned. Height and Width are same.
	* @return - the gravatar URL. You can test it in a
	browser.
	 * @throws NoSuchAlgorithmException 
	*/
	public static String getGravatarUrl(String email, Integer size) throws NoSuchAlgorithmException {
		
		StringBuilder url=new StringBuilder();
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		url.append("http://www.gravatar.com/avatar/");
		url.append(md5.digest(email.getBytes()));
		url.append("?s=" + size.toString());
		return url.toString();
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
	public static void update(User user) {
		EntityManager entityManager = DBUtils.getEntityManager("Bullhorn");
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			// do transaction 
			entityManager.merge(user);
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
	public static void delete(User user) {
		EntityManager entityManager = DBUtils.getEntityManager("Bullhorn"); 
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.remove(entityManager.merge(user));
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			entityManager.close();
		}
	}
	
	/**
	* Gets a user given their email address.
	* You've got the email when they log in but you really
	need the
	* user and all its related information. This method
	will find the user
	* matching that email. The database should ensure that
	you can't have two users
	* with the same email. Otherwise there's no telling
	what you'd get.
	* @param email
	* @return Bhuser with that unique email address
	*/
	public static User getUserByEmail (String email) {
		EntityManager entityManager = DBUtils.getEntityManager("Bullhorn");
		String query = "SELECT u from User u where u.email=:email";
		TypedQuery<User> quser =entityManager.createQuery(query, User.class);
		quser.setParameter("email", email);
		User user =null;
		try {
			System.out.println("Getting single user");
			user = quser.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		return user;
	}
	/**
	* Is this user valid? This method has the answer for
	you.
	* Checks the database and counts the number of users
	with this
	* username and password. If it returns 0 then either
	the username
	* or password don't exist in the database. If it
	returns 1 then you have found
	* the user with that username and password. If it
	returns >1 then you need to
	* fix your database.
	* @param userEmail and userPassword
	* @return true or false indicating the user exists or
	doesn't
	*/
	public static boolean isUserValid(String userEmail, String password) {
		EntityManager entityManager = DBUtils.getEntityManager("Bullhorn");
		
		String qString = "Select count(b.bhuser_id) from User b "+
				"where b.email=:email and b.password=:password";
				
				TypedQuery<Long> query=entityManager.createQuery(qString, Long.class);
				
				boolean result = false;
				query.setParameter("email", userEmail);
				query.setParameter("password", password);
		
		try {
			long userCount =query.getSingleResult();
			if(userCount>0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			entityManager.close();
			
		}
		return result;
	
	}
	
	
	
	
}
