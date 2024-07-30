package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class DBUtils {

	public DBUtils() {
		// TODO Auto-generated constructor stub
	}
	public static EntityManager getEntityManager(String persisteUnit) {
		return
				Persistence.createEntityManagerFactory(persisteUnit).
				createEntityManager();
	}
}
