package com.vfislk.training.service;

import java.util.List;

import com.vfislk.training.exceptions.CustomerNotFoundExcepion;
import com.vfislk.training.model.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

	Customer getById(int customerId) throws CustomerNotFoundExcepion;

	List<Customer> customersList();

	List<Customer> getByPlans(String planName) throws CustomerNotFoundExcepion;

	List<Customer> getByPremium(double premium) throws CustomerNotFoundExcepion;

	List<Customer> getByCoverage(String coverage) throws CustomerNotFoundExcepion;

	List<Customer> getByAmount(double amount) throws CustomerNotFoundExcepion;

	List<Customer> getByNomineeName(String nomineeName) throws CustomerNotFoundExcepion;

	List<Customer> getByPhoneNumber(long phoneNumber) throws CustomerNotFoundExcepion;

	List<Customer> getByOccupation(String occupation) throws CustomerNotFoundExcepion;

	List<Customer> getByCustomerAge(int customerAge) throws CustomerNotFoundExcepion;

}
