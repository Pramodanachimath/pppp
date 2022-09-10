package com.vfislk.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vfislk.training.model.Plans;
import com.vfislk.training.service.IPlansService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("plans-api")
public class PlansController {

	@Autowired
	IPlansService plansService;

	@PostMapping("/plans")
	public void addPlans(@RequestBody Plans plans) {
		plansService.addPlans(plans);
	}

	@PutMapping("/plans")
	public void updatePlans(@RequestBody Plans plans) {
		plansService.updatePlans(plans);
	}

	@DeleteMapping("/plans/{planId}")
	public void deletePlans(@PathVariable("planId") int planId) {
		plansService.deletePlans(planId);
	}


	@GetMapping("/plans")
	public List<Plans> getAllPlans() {
		return plansService.getAllPlans();

	}

	@GetMapping("/plans/premium/{premium}")
	public List<Plans> getByPremium(@PathVariable("premium") double premium) {
		return plansService.getByPremium(premium);

	}

	@GetMapping("/plans/coverage/{coverage}")
	public List<Plans> getByCoverage(@PathVariable("coverage") String coverage) {
		return plansService.getByCoverage(coverage);

	}

	@GetMapping("/plans/amount/{amount}")
	public List<Plans> getByAmount(@PathVariable("amount") double amount) {
		return plansService.getByAmount(amount);

	}

	@GetMapping("/plans/term/{term}")
	public List<Plans> getByterm(@PathVariable("term") String term) {
		return plansService.getByterm(term);

	}

	@GetMapping("plans/age/{age}")
	public List<Plans> getByAge(@PathVariable("age") int age) {
		return plansService.getByAge(age);

	}

	@GetMapping("plans/age/{age}/amount/{amount}")
	public List<Plans> checkPremium(@PathVariable("age") int age,@PathVariable("amount") double amount) {
		return plansService.checkPremium(age, amount);

	}

	@GetMapping("plans/age/{age}/amount/{amount}/premium/{premium}")
	public List<Plans> checkterm(@PathVariable("age") int age, @PathVariable("amount") double amount,
			@PathVariable("premium") double premium) {
		return plansService.checkterm(age, amount, premium);
	}

	@GetMapping("plans/year/{year}/amount/{amount}")
	public double calculateMaturity(@PathVariable("year") int year, @PathVariable("amount") double amount) {
		return plansService.calculateMaturity(year, amount);

	}

	@GetMapping("plans/agentName/{agentName}")
	public List<Plans> getByAgent(@PathVariable("agentName") String agentName) {
		return plansService.getByAgent(agentName);
	}
	
	@GetMapping("plans/amountPerMonth/{amountPerMonth}/presentAge/{presentAge}")
	 double calculateAmount(@PathVariable("amountPerMonth") double amountPerMonth,@PathVariable("presentAge") int presentAge) {
		 return plansService.calculateAmount(amountPerMonth, presentAge);
	 }

	@GetMapping("plans/firstName/{firstName}/lastName/{lastName}")
	public List<Plans> getByCustomer(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return plansService.getByCustomer(firstName, lastName);

	}

}
