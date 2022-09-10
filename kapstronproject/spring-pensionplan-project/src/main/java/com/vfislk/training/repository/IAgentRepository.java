package com.vfislk.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vfislk.training.exceptions.AgentNotFoundExcepion;
import com.vfislk.training.model.Agent;

@Repository
public interface IAgentRepository extends JpaRepository<Agent, Integer> {

	// Derived Queries

	@Query("from Agent where state=?1")
	List<Agent> findAgentByState(String state) throws AgentNotFoundExcepion;

	@Query("from Agent where phoneNumber=?1")
	List<Agent> findAgentByphoneNumber(long phoneNumber) throws AgentNotFoundExcepion;

	@Query("update Agent set state=?1 where agentId=?2")
	void updateAgent(long state, int agentId);

	// Custom Queries

	@Query("from Agent a inner join a.plans p where p.planName=?1")
	List<Agent> findAgentByPlans(String planName) throws AgentNotFoundExcepion;

	@Query("from Agent a inner join a.plans p where p.premium=?1")
	List<Agent> findAgentByPremium(double premium) throws AgentNotFoundExcepion;

	@Query("from Agent a inner join a.plans p where p.coverage=?1")
	List<Agent> findAgentByCoverage(String coverage) throws AgentNotFoundExcepion;

	@Query("from Agent a inner join a.plans p where p.amount=?1")
	List<Agent> findAgentByAmount(double amount) throws AgentNotFoundExcepion;
	
	@Query("from Agent a inner join a.customers c where c.firstName=?1 or c.lastName=?2")
	List<Agent> findByCustomer(String firstName, String lastName) ;

}
