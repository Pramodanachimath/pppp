package com.vfislk.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.training.exceptions.AgentNotFoundExcepion;
import com.vfislk.training.model.Agent;
import com.vfislk.training.repository.IAgentRepository;

@Service
public class AgentServiceImpl implements IAgentService {

	IAgentRepository agentRepository;

	@Autowired
	public void setAgentRepository(IAgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}

	@Override
	public Agent addAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	@Override
	public void updateAgent(Agent agent) {
		agentRepository.save(agent);
	}

	@Override
	public void deleteAgent(int agentId) {
		agentRepository.deleteById(agentId);
	}

	@Override
	public Agent getById(int agentId) throws AgentNotFoundExcepion {
		return agentRepository.findById(agentId).get();
	}

	@Override
	public List<Agent> getAllAgents() {
		return agentRepository.findAll();
	}

	@Override
	public List<Agent> getByPlans(String planName) throws AgentNotFoundExcepion {
		return agentRepository.findAgentByPlans(planName);
	}

	@Override
	public List<Agent> getByPremium(double premium) throws AgentNotFoundExcepion {
		return agentRepository.findAgentByPremium(premium);
	}

	@Override
	public List<Agent> getByCoverage(String coverage) throws AgentNotFoundExcepion {
		return agentRepository.findAgentByCoverage(coverage);
	}

	@Override
	public List<Agent> getByAmount(double amount) throws AgentNotFoundExcepion {
		return agentRepository.findAgentByAmount(amount);
	}

	@Override
	public List<Agent> getByState(String state) throws AgentNotFoundExcepion {
		return agentRepository.findAgentByState(state);
	}

	@Override
	public List<Agent> getByphoneNumber(long phoneNumber) throws AgentNotFoundExcepion {
		return agentRepository.findAgentByphoneNumber(phoneNumber);
	}

	@Override
	public List<Agent> getByCustomer(String firstName, String lastName) {
		return agentRepository.findByCustomer(firstName, lastName);
	}

}
