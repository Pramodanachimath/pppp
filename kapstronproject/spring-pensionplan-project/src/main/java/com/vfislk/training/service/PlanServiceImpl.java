package com.vfislk.training.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.training.exceptions.PlanNotFoundException;
import com.vfislk.training.model.Plans;
import com.vfislk.training.repository.IPlansRepository;

@Service
public class PlanServiceImpl implements IPlansService {

	IPlansRepository plansRepository;

	@Autowired
	public void setPlansRepository(IPlansRepository plansRepository) {
		this.plansRepository = plansRepository;
	}

	@Override
	public Plans addPlans(Plans plans) {
		return plansRepository.save(plans);
	}

	@Override
	public void updatePlans(Plans plans) {
		plansRepository.save(plans);
	}

	@Override
	public void deletePlans(int planId) {
		plansRepository.deleteById(planId);
	}

	@Override
	public Plans getPlansById(int planId) throws PlanNotFoundException {
		return plansRepository.findById(planId).get();
	}

	@Override
	public List<Plans> getAllPlans() {
		return plansRepository.findAll();
	}

	@Override
	public List<Plans> getByAgent(String agentName) throws PlanNotFoundException {
		return plansRepository.findByAgent(agentName);
	}

	@Override
	public List<Plans> getByCustomer(String firstName, String lastName) throws PlanNotFoundException {
		return plansRepository.findByCustomer(firstName, lastName);
	}

	@Override
	public List<Plans> getByPremium(double premium) throws PlanNotFoundException {
		return plansRepository.findByPremium(premium);
	}

	@Override
	public List<Plans> getByCoverage(String coverage) throws PlanNotFoundException {
		return plansRepository.findByCoverage(coverage);
	}

	@Override
	public List<Plans> getByAmount(double amount) throws PlanNotFoundException {
		return plansRepository.findByAmount(amount);
	}

	@Override
	public List<Plans> getByterm(String term) throws PlanNotFoundException {
		return plansRepository.findByterm(term);
	}

	@Override
	public List<Plans> getByAge(int age) throws PlanNotFoundException {
		return plansRepository.findByAge(age);
	}

	@Override
	public List<Plans> checkPremium(int age, double amount) throws PlanNotFoundException {
		return plansRepository.checkPremium(age, amount);
	}

	@Override
	public List<Plans> checkAmount(int age, double premium) throws PlanNotFoundException {
		return plansRepository.checkAmount(age, premium);
	}

	@Override
	public List<Plans> checkterm(int age, double amount, double premium) throws PlanNotFoundException {
		return plansRepository.checkterm(age, amount, premium);
	}

	@Override
	public double calculateMaturity(int year, double amount) {
		int month = year * 12;
		double rate = 0.48 * 12;
		double MV = amount * Math.pow((1 + rate), month);
		return MV;//maturity Value
	}
	
	public double calculateAmount(double amountPerMonth,int presentAge) {
		double FutureValuePerMonth=0;
//		int month=12*year;
		double rate=0.14;
		int yearOfRetirment=(60-presentAge);
		 FutureValuePerMonth=amountPerMonth*(Math.pow((1+rate),yearOfRetirment));
		 return FutureValuePerMonth*12;
		 
	}

}
