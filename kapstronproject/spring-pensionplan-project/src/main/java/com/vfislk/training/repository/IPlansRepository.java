package com.vfislk.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vfislk.training.exceptions.PlanNotFoundException;
import com.vfislk.training.model.Plans;

@Repository
public interface IPlansRepository extends JpaRepository<Plans, Integer> {

	// Derived Queries

	@Query("from Plans where premium=?1")
	List<Plans> findByPremium(double premium) throws PlanNotFoundException;

	@Query("from Plans where coverage=?1")
	List<Plans> findByCoverage(String coverage) throws PlanNotFoundException;

	@Query("from Plans where amount=?1")
	List<Plans> findByAmount(double amount) throws PlanNotFoundException;

	@Query("from Plans where term=?1")
	List<Plans> findByterm(String term) throws PlanNotFoundException;

	@Query("from Plans where age=?1")
	List<Plans> findByAge(int age) throws PlanNotFoundException;

	@Query("from Plans where age=?1 and amount=?2")
	List<Plans> checkPremium(int age, double amount) throws PlanNotFoundException;

	@Query("from Plans where age=?1 and premium=?2")
	List<Plans> checkAmount(int age, double premium) throws PlanNotFoundException;

	@Query("from Plans where age=?1 or amount=?2 or premium=?3")
	List<Plans> checkterm(int age, double amount, double premium) throws PlanNotFoundException;

	// custom Queries

	@Query("update Plans set premium=?1 where plansId=?2")
	void updatePlans(double premium, int planId);

	@Query("from Plans p inner join p.agent a where a.agentName=?1")
	List<Plans> findByAgent(String agentName) throws PlanNotFoundException;

	@Query("from Plans p inner join p.customers c where c.firstName=?1 or c.lastName=?2")
	List<Plans> findByCustomer(String firstName, String lastName) throws PlanNotFoundException;

}
