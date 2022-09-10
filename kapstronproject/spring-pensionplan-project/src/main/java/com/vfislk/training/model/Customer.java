package com.vfislk.training.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	private String firstName;
	private String lastName;
	@Id
	@GeneratedValue(generator = "customer_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "customer_gen", sequenceName = "customer_sequence", initialValue = 1, allocationSize = 1)
	private Integer customerId;
	@Column(length = 20)
	private String dateOfBirth;
	@Column(length = 30)
	private String email;
	private String phoneNumber;
	@Min(21)
	@Max(60)
	private int customerAge;
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Occupation occupation;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	Set<Nominee> nominees;


	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "plans_id")
	Plans plans;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "agent_id")
	Agent agent;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String dateOfBirth, String email, String phoneNumber,
			@Min(21) @Max(60) int customerAge, Occupation occupation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerAge = customerAge;
		this.occupation = occupation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Set<Nominee> getNominees() {
		return nominees;
	}

	public void setNominees(Set<Nominee> nominees) {
		this.nominees = nominees;
	}


	public Plans getPlans() {
		return plans;
	}

	public void setPlans(Plans plans) {
		this.plans = plans;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", customerAge=" + customerAge + ", occupation="
				+ occupation + "]";
	}

	

	
}
