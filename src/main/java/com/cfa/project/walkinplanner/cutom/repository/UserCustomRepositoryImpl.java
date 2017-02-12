/**
 * 
 */
package com.cfa.project.walkinplanner.cutom.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfa.project.walkinplanner.exception.CustomException;
import com.cfa.project.walkinplanner.models.User;

/**
 * @author RAKESH
 *
 */
@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

	/**
	 * 
	 */
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@PersistenceContext
	private EntityManager entityManager;
	private Session session;
	public UserCustomRepositoryImpl() {
		
	}

	@Override
	public User findUsernameAndPassword(String username, String password) throws CustomException{
       Session session = sessionFactory.openSession();
       List<?> UsersList = null;
         if(session==null){
    			   throw new CustomException("Invalid Session");  
    		   }
         UsersList= session.createQuery("from User as u where u.username like '"+username+"' and u.password like '"+password+"'").list(); 
         if (UsersList.size()>0){
        	  return (User) UsersList.get(0);
        	}
    	return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
