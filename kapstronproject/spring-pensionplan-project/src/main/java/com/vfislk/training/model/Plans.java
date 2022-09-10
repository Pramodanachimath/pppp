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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plans {

	private String planName;
	@Id
	@GeneratedValue(generator = "plan_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "plan_gen", sequenceName = "plan_sequence", initialValue = 1, allocationSize = 1)
	private Integer plansId;
	private int age;
	@Column(length = 20)
	private String term;
	@Column(length = 20)
	private double premium;
	private double amount;
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Coverage coverage;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "plans_id")
	Set<Customer> customers;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "plans_id")
	Set<Agent> agent;

	public Plans() {
		super();
	}

	public Plans(String planName, int age, String term, double premium, double amount, Coverage coverage) {
		super();
		this.planName = planName;
		this.age = age;
		this.term = term;
		this.premium = premium;
		this.amount = amount;
		this.coverage = coverage;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getPlansId() {
		return plansId;
	}

	public void setPlansId(Integer plansId) {
		this.plansId = plansId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Coverage getCoverage() {
		return coverage;
	}

	public void setCoverage(Coverage coverage) {
		this.coverage = coverage;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Agent> getAgent() {
		return agent;
	}

	public void setAgent(Set<Agent> agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "Plans [planName=" + planName + ", age=" + age + ", term=" + term + ", premium=" + premium + ", amount="
				+ amount + ", coverage=" + coverage + "]";
	}

	

}
