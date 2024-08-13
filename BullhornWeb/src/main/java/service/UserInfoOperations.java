package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import studs.Post;
import studs.User;
import studs.UserInfo;

public class UserInfoOperations {

	public UserInfoOperations() {
	
	}
	public static void insert(UserInfo userinfo) {
		EntityManager em =DBUtils.getEntityManager("UserInfoUnit");
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(userinfo);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			em.close();
		}
	}
	public static void update(UserInfo user) {
		EntityManager entityManager = DBUtils.getEntityManager("UserInfoUnit");
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
	
	public static UserInfo getUserInfoById(long userId) {
		EntityManager em =DBUtils.getEntityManager("UserInfoUnit");
		UserInfo userinfo =em.find(UserInfo.class, userId);
		return userinfo;
	}
	public static UserInfo getUserByUserId (int userId) {
		EntityManager entityManager = DBUtils.getEntityManager("UserUnit");
		String query = "SELECT u from UserInfo u where u.userid=:userid";
		TypedQuery<UserInfo> quser =entityManager.createQuery(query, UserInfo.class);
		quser.setParameter("userid", userId);
		UserInfo userinfo =null;
		try {
			
			userinfo = quser.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		return userinfo;
	}
	
}
