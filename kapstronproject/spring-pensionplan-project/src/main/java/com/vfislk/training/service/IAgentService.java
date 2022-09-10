package com.vfislk.training.service;

import java.util.List;

import com.vfislk.training.exceptions.AgentNotFoundExcepion;
import com.vfislk.training.model.Agent;

public interface IAgentService {

	Agent addAgent(Agent agent);

	void updateAgent(Agent agent);

	void deleteAgent(int agentId);

	Agent getById(int agentId) throws AgentNotFoundExcepion;

	List<Agent> getAllAgents();

	List<Agent> getByState(String state) throws AgentNotFoundExcepion;

	List<Agent> getByphoneNumber(long phoneNumber) throws AgentNotFoundExcepion;

	List<Agent> getByPlans(String planName) throws AgentNotFoundExcepion;

	List<Agent> getByPremium(double premium) throws AgentNotFoundExcepion;

	List<Agent> getByCoverage(String coverage) throws AgentNotFoundExcepion;

	List<Agent> getByAmount(double amount) throws AgentNotFoundExcepion;
	
	List<Agent> getByCustomer(String firstName, String lastName) ;
}
