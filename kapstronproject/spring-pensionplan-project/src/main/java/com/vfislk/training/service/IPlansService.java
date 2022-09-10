package com.vfislk.training.service;

import java.util.List;

import com.vfislk.training.exceptions.PlanNotFoundException;
import com.vfislk.training.model.Plans;

public interface IPlansService {

	Plans addPlans(Plans plans);

	void updatePlans(Plans plans);

	void deletePlans(int planId);

	Plans getPlansById(int planId) throws PlanNotFoundException;

	List<Plans> getAllPlans();

	List<Plans> getByPremium(double premium) throws PlanNotFoundException;

	List<Plans> getByCoverage(String coverage) throws PlanNotFoundException;

	List<Plans> getByAmount(double amount) throws PlanNotFoundException;

	List<Plans> getByterm(String term) throws PlanNotFoundException;

	List<Plans> getByAge(int age) throws PlanNotFoundException;

	List<Plans> checkPremium(int age, double amount) throws PlanNotFoundException;

	List<Plans> checkAmount(int age, double premium) throws PlanNotFoundException;

	List<Plans> checkterm(int age, double amount, double premium) throws PlanNotFoundException;

	double calculateMaturity(int year, double amount);

	List<Plans> getByAgent(String agentName) throws PlanNotFoundException;

	List<Plans> getByCustomer(String firstName, String lastName) throws PlanNotFoundException;
	
	 double calculateAmount(double amountPerMonth,int presentAge);
}
