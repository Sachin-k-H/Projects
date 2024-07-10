package com.sachin.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sachin.dto.RegisterDto;
@Repository
public class ForgotPasswordRepoImpl implements ForgotPasswordRepo {
	 @Autowired
	  private EntityManagerFactory entityManagerFactory;
	
	  @Override
	    public RegisterDto updatepassword(RegisterDto registerdto) {
	        EntityManager entityManager= entityManagerFactory.createEntityManager();
	        EntityTransaction entityTransaction= entityManager.getTransaction();
	        try {
	            entityTransaction.begin();
	            Query query=entityManager.createQuery("update RegisterDto set password=:pass where email=:email");
	            query.setParameter("pass",registerdto.getPassword());
	            query.setParameter("email",registerdto.getEmail());
	            query.executeUpdate();
	            entityTransaction.commit();
	            return registerdto;

	        }
	        catch (PersistenceException persistenceException)
	        {
	            persistenceException.printStackTrace();
	        }
	        finally {
	            entityManager.close();
	        }
	        return null;
	    }
}
