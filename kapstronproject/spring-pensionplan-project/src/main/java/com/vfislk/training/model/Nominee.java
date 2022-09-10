package com.vfislk.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Nominee {

	private String nomineeName;
	@Id
	@GeneratedValue(generator = "nominee_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "nominee_gen", sequenceName = "nominee_sequence", initialValue = 1, allocationSize = 1)
	private Integer nomineeId;
	@Min(21)
	@Max(60)
	private int age;
	private String number;
	@Column(length = 20)
	@Enumerated(value = EnumType.STRING)
	private Relationship relationship;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "customer_id")
	Customer customer;

	public Nominee() {
		super();
	}

	public Nominee(String nomineeName, @Min(21) @Max(60) int age, String number, Relationship relationship) {
		super();
		this.nomineeName = nomineeName;
		this.age = age;
		this.number = number;
		this.relationship = relationship;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public Integer getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(Integer nomineeId) {
		this.nomineeId = nomineeId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Nominee [nomineeName=" + nomineeName + ", age=" + age + ", number=" + number + ", relationship="
				+ relationship + "]";
	}

	

}
