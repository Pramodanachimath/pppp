package com.vfislk.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vfislk.training.exceptions.CustomerNotFoundExcepion;
import com.vfislk.training.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	// Derived Queries

	@Query("from Customer where phoneNumber=?1")
	List<Customer> findCustomerByPhoneNumber(long phoneNumber) throws CustomerNotFoundExcepion;

	@Query("from Customer where occupation=?1")
	List<Customer> findCustomerByOccupation(String occupation) throws CustomerNotFoundExcepion;

	@Query("from Customer where customerAge=?1")
	List<Customer> findCustomerByCustomerAge(int customerAge) throws CustomerNotFoundExcepion;

	@Query("update Customer set phoneNumber=?1 where customerId=?2")
	void updateCustomer(long phoneNumber, int customerId);

	// Custom Queries

	@Query("from Customer c inner join c.plans p where p.planName=?1")
	List<Customer> findCustomerByPlans(String planName) throws CustomerNotFoundExcepion;

	@Query("from Customer c inner join c.plans p where p.premium=?1")
	List<Customer> findCustomerByPremium(double premium) throws CustomerNotFoundExcepion;

	@Query("from Customer c inner join c.plans p where p.coverage=?1")
	List<Customer> findCustomerByCoverage(String coverage) throws CustomerNotFoundExcepion;

	@Query("from Customer c inner join c.plans p where p.amount=?1")
	List<Customer> findCustomerByAmount(double amount) throws CustomerNotFoundExcepion;

	@Query("from Customer c inner join c.nominees n where n.nomineeName=?1")
	List<Customer> findCustomerByNomineeName(String nomineeName) throws CustomerNotFoundExcepion;

}
