package com.sachin.repository;

import java.nio.channels.AcceptPendingException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sachin.dto.PasswordResetDto;
@Repository
public class PasswordResetRepoImpl implements PasswordResetRepo {
	 @Autowired
	  private EntityManagerFactory entityManagerFactory;
	 
	 
	    @Override
	    public boolean updateUserPassword(PasswordResetDto passwordResetDto) {
	        EntityManager entityManager= entityManagerFactory.createEntityManager();
	        EntityTransaction entityTransaction= entityManager.getTransaction();
	        try {
	            entityTransaction.begin();
	            Query query=entityManager.createQuery("update RegisterDto set password=:pass where email=:email");
	            query.setParameter("pass",passwordResetDto.getNewpassword());
	            query.setParameter("email",passwordResetDto.getEmail());
	            query.executeUpdate();
	           entityTransaction.commit();
	           return true;

	        }
	        catch (AcceptPendingException pendingException)
	        {
	            pendingException.printStackTrace();
	            entityTransaction.rollback();
	        }
	        finally {
	            entityManager.close();
	        }
	       return  false;
	    }
	    
	    
	    
	    @Override
	    public boolean updateDeptAdminPassword(PasswordResetDto passwordResetDto) {
	        EntityManager entityManager= entityManagerFactory.createEntityManager();
	        EntityTransaction entityTransaction= entityManager.getTransaction();
	        try {
	            entityTransaction.begin();
	            Query query=entityManager.createQuery("update DepartmentAdmin set password=:pass where email=:email");
	            query.setParameter("pass",passwordResetDto.getNewpassword());
	            query.setParameter("email",passwordResetDto.getEmail());
	            query.executeUpdate();
	           entityTransaction.commit();
	           return true;

	        }
	        catch (AcceptPendingException pendingException)
	        {
	            pendingException.printStackTrace();
	            entityTransaction.rollback();
	        }
	        finally {
	            entityManager.close();
	        }
	       return  false;
	    }
}
