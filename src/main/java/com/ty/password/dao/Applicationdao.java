package com.ty.password.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.password.dto.ApplicationDto;


@Repository
public class Applicationdao {
	
	@Autowired
	 private EntityManager entityManager;
	
	public ApplicationDto saveApplication(ApplicationDto applicationDto)
	{
		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(applicationDto);
		entityTransaction.commit();
		
		return applicationDto;
		
	}
	
	public ApplicationDto updateApplication(ApplicationDto applicationDto) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(applicationDto);
		entityTransaction.commit();

		return applicationDto;
	}
	
	public ApplicationDto findApplicationByID(int id) {
		ApplicationDto applicationDto = entityManager.find(ApplicationDto.class, id);
		if (applicationDto != null) {
			return applicationDto;
		} else {
			return null;
		}
	}
	
	public boolean deleteApplicationById(int id) 
	{
		ApplicationDto applicationDto = entityManager.find(ApplicationDto.class, id);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(applicationDto);
		entityTransaction.commit();

		return true;
	}
	
	public List<ApplicationDto> getAllApplication(){
		Query query=entityManager.createQuery("select a from ApplicationDto a");
		
		return query.getResultList();
		
	}
	
	public ApplicationDto getApplicationByEmail(String email)
	{
		Query query=entityManager.createQuery("select a from ApplicationDto a where a.email=?1",ApplicationDto.class);
		return (ApplicationDto) query.setParameter(1, email).getSingleResult();
		
	}

}
