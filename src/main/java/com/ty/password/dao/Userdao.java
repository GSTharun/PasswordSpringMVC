package com.ty.password.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.password.dto.ApplicationDto;
import com.ty.password.dto.User;

@Repository
public class Userdao 
{
	@Autowired
	 private EntityManager entityManager;
	
	public User saveUser(User user)
	{
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user;
		
	}
	
	public User updateUser(User user) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;
	}
	
	public User findUserByID(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
	
	public boolean deleteUserById(int id) 
	{
		User user = entityManager.find(User.class, id);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();

		return true;
	}
	
	public List<User> getAllUser(){
		Query query=entityManager.createQuery("select u from User u");
		
		return query.getResultList();
		
	}
	
	public User getUserByEmail(String email)
	{
		Query query=entityManager.createQuery("select u from User u where u.email=?1",User.class);
		return (User) query.setParameter(1, email).getSingleResult();
		
	}
	
	public ApplicationDto saveApplication(ApplicationDto applicationDto)
	{
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(applicationDto);
		entityTransaction.commit();
		
		return applicationDto;
		
	}
	
	public List<ApplicationDto> getAllApplication(int id){
		return entityManager.createQuery("select s from ApplicationDto s where s.user_id=?1").setParameter(1, id).getResultList();
			
	}
	
	public ApplicationDto getApplicationByEmail(String email)
	{
		return entityManager.createQuery("select a from ApplicationDto a where a.email=?1",ApplicationDto.class).setParameter(1, email).getSingleResult();
		
	}
	



}
