package com.vfislk.training.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agent {

	@Column(name = "agentname")
	private String agentName;
	@Id
	@GeneratedValue(generator = "agent_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "agent_gen", sequenceName = "agent_sequence", initialValue = 1, allocationSize = 1)
	private Integer agentId;
	@Column(length = 20)
	private String state;
	private String phoneNumber;


	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "plans_id")
	Plans plans;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "agent")
	Set<Customer> customers;

	public Agent() {
		super();
	}

	public Agent(String agentName, String state, String phoneNumber) {
		super();
		this.agentName = agentName;
		this.state = state;
		this.phoneNumber = phoneNumber;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Plans getPlans() {
		return plans;
	}

	public void setPlans(Plans plans) {
		this.plans = plans;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Agent [agentName=" + agentName + ", state=" + state + ", phoneNumber=" + phoneNumber + "]";
	}

	

	

}
