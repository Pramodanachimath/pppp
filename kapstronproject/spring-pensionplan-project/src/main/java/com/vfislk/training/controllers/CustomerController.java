package com.vfislk.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.vfislk.training.model.Customer;
import com.vfislk.training.service.ICustomerService;

//@RestController
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
	}

	@GetMapping("/customers/{customerId}")
	public Customer getById(@PathVariable("customerId") int customerId) {
		return customerService.getById(customerId);

	}

	@GetMapping("/customers")
	public List<Customer> customersList() {
		return customerService.customersList();

	}

	@GetMapping("/customers/{planName}")
	public List<Customer> getByPlans(@PathVariable("planName") String planName) {
		return customerService.getByPlans(planName);

	}

	@GetMapping("/customers/{premium}")
	public List<Customer> getByPremium(@PathVariable("premium") double premium) {
		return customerService.getByPremium(premium);

	}

	@GetMapping("/customers/{coverage}")
	public List<Customer> getByCoverage(@PathVariable("coverage") String coverage) {
		return customerService.getByCoverage(coverage);

	}

	@GetMapping("/customers/{amount}")
	public List<Customer> getByAmount(@PathVariable("amount") double amount) {
		return customerService.getByAmount(amount);

	}

	@GetMapping("/customers/{nomineeName}")
	public List<Customer> getByNomineeName(@PathVariable("nomineeName") String nomineeName) {
		return customerService.getByNomineeName(nomineeName);

	}

	@GetMapping("/customers/{phoneNumber}")
	public List<Customer> getByPhoneNumber(@PathVariable("phoneNumber") long phoneNumber) {
		return customerService.getByPhoneNumber(phoneNumber);

	}

	@GetMapping("/customers/{occupation}")
	public List<Customer> getByOccupation(@PathVariable("occupation") String occupation) {
		return customerService.getByOccupation(occupation);

	}

	@GetMapping("/customers/{customerAge}")
	public List<Customer> getByCustomerAge(@PathVariable("customerAge") int customerAge) {
		return customerService.getByCustomerAge(customerAge);

	}
}
