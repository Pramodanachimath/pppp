package com.vfislk.training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vfislk.training.model.Agent;
import com.vfislk.training.model.Coverage;
import com.vfislk.training.model.Customer;
import com.vfislk.training.model.Nominee;
import com.vfislk.training.model.Occupation;
import com.vfislk.training.model.Plans;
import com.vfislk.training.model.Relationship;
import com.vfislk.training.service.IAgentService;
import com.vfislk.training.service.ICustomerService;
import com.vfislk.training.service.INomineeService;
import com.vfislk.training.service.IPlansService;

@SpringBootApplication
public class SpringPensionplanProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringPensionplanProjectApplication.class, args);
	}

	@Autowired
	IAgentService agentService;

	@Autowired
	ICustomerService customerService;

	@Autowired
	IPlansService plansService;

	@Autowired
	INomineeService nomineeService;

	@Override
	public void run(String... args) throws Exception {

//		Nominee nominee1 = new Nominee("Virat", 35, "6360359939", Relationship.BROTHER);
//		Nominee nominee2 = new Nominee("Rahul", 25, "7562323939", Relationship.BROTHER);
//		Nominee nominee3 = new Nominee("Pramod", 60, "8660458636", Relationship.FATHER);
//		Nominee nominee4 = new Nominee("Joe", 45, "6360359939", Relationship.FATHER);
//		Nominee nominee5 = new Nominee("Sita", 28, "7562323958", Relationship.SISTER);
//		Nominee nominee6 = new Nominee("Nikita", 30, "7660458621", Relationship.SISTER);
//		Nominee nominee7 = new Nominee("Surekha", 40, "6360359945", Relationship.MOTHER);
//		Nominee nominee8 = new Nominee("Sita", 46, "8772323939", Relationship.MOTHER);
//		Nominee nominee9 = new Nominee("Poornima", 35, "4660458620", Relationship.WIFE);
//		Nominee nominee10 = new Nominee("Root", 48, "9660458645", Relationship.HUSBAND);
//
//		nomineeService.addNominee(nominee1);
//		nomineeService.addNominee(nominee2);
//		nomineeService.addNominee(nominee3);
//		nomineeService.addNominee(nominee4);
//		nomineeService.addNominee(nominee5);
//		nomineeService.addNominee(nominee6);
//		nomineeService.addNominee(nominee7);
//		nomineeService.addNominee(nominee8);
//		nomineeService.addNominee(nominee9);
//		nomineeService.addNominee(nominee10);
//
//		Set<Nominee> nominees = new HashSet<>(Arrays.asList(nominee1, nominee2, nominee3));
//
//		Customer customer1 = new Customer("Pramod", "Anachimath", "14/06/1999", "pramodanachimath@gmail.com",
//				"9695632144", 23, Occupation.SALARIED);
//		Customer customer2 = new Customer("Virat", "Kohli", "05/011/1988", "viratkohli@gmail.com", "6895632145", 32,
//				Occupation.SALARIED);
//		Customer customer3 = new Customer("Guru", "Itagi", "11/10/1998", "Pramod@gmail.com", "5895632142", 24,
//				Occupation.SELFEMPLOYEED);
//		Customer customer4 = new Customer("Rahul", "Dravid", "11/01/1973", "rahuldravid@gmail.com", "4895632143", 45,
//				Occupation.SELFEMPLOYEED);
//		Customer customer5 = new Customer("Rohit", "Sharma", "30/04/1987", "rohitsharma@gmail.com", "3895632144", 33,
//				Occupation.STUDENT);
//		Customer customer6 = new Customer("Dhoni", "Sing", "14/06/1999", "dhonising@gmail.com", "7895632149", 40,
//				Occupation.STUDENT);
//		Customer customer7 = new Customer("Yajuvendra", "Chahal", "7/07/1981", "yajuvendrachal@gmail.com", "8895632148",
//				30, Occupation.UNEMPLOYEED);
//		Customer customer8 = new Customer("Rishab", "Pant", "04/10/1997", "rishabpant@gmail.com", "9895632147", 24,
//				Occupation.UNEMPLOYEED);
//		Customer customer9 = new Customer("Naveen", "Gurannavar", "25/05/1999", "naveengurannavar@gmail.com",
//				"2895632146", 31, Occupation.SALARIED);
//		Customer customer10 = new Customer("Harshal", "Patel", "23/06/1990", "harshapatell@gmail.com", "1895632145", 25,
//				Occupation.SELFEMPLOYEED);
//
//		customerService.addCustomer(customer1);
//		customerService.addCustomer(customer2);
//		customerService.addCustomer(customer3);
//		customerService.addCustomer(customer4);
//		customerService.addCustomer(customer5);
//		customerService.addCustomer(customer6);
//		customerService.addCustomer(customer7);
//		customerService.addCustomer(customer8);
//		customerService.addCustomer(customer9);
//		customerService.addCustomer(customer10);
//
//		Agent agent1 = new Agent("Root", "Karnataka", "6360355939");
//		agentService.addAgent(agent1);
//		Agent agent2 = new Agent("Joe", "Hydrabad", "7895631149");
//		agentService.addAgent(agent2);
//		Agent agent3 = new Agent("Amith", "Karnataka", "8762323939");
//		agentService.addAgent(agent3);
//
//		Plans plans1 = new Plans("Aditya Birla Sunlife Empower Pension Plan", 25, "5-30", 18000, 500000,
//				Coverage.PARENTS);
//		Plans plans2 = new Plans("Aegon Life Guaranteed Income Advantage Plan", 20, "25-55", 10000, 200000,
//				Coverage.SHARING);
//		Plans plans3 = new Plans("Aviva Next Innings Pension Plan", 42, "13-18", 50000, 500000, Coverage.SINGLE);
//		Plans plans4 = new Plans("Bajaj Life-Long Goal Pension Scheme", 25, "99", 18000, 600000,
//				Coverage.SINGLEPLUSHEALTH);
//		Plans plans5 = new Plans("Canara HSBC Invest 4G Whole Life", 25, "5-30", 18000, 500000, Coverage.PARENTS);
//		Plans plans6 = new Plans("Pramerica Life Golden Age Plus", 18, "15-25", 10800, 500000, Coverage.SHARING);
//		Plans plans7 = new Plans("Edelweiss Tokio Life -Wealth Ultima", 20, "10-100", 48000, 500000, Coverage.SINGLE);
//		Plans plans8 = new Plans("Exide Life Golden years Retirement Plan", 25, "10-42", 18000, 500000,
//				Coverage.SINGLEPLUSHEALTH);
//		Plans plans9 = new Plans("Future Generali - Big Dreams Pension Scheme", 18, "5-20", 60000, 500000,
//				Coverage.PARENTS);
//		Plans plans10 = new Plans("HDFC Life Click 2 Retire", 18, "10-35", 24000, 500000, Coverage.SHARING);
//
//		plansService.addPlans(plans1);
//		plansService.addPlans(plans2);
//		plansService.addPlans(plans3);
//		plansService.addPlans(plans4);
//		plansService.addPlans(plans5);
//		plansService.addPlans(plans6);
//		plansService.addPlans(plans7);
//		plansService.addPlans(plans8);
//		plansService.addPlans(plans9);
//		plansService.addPlans(plans10);

		System.out.println("Get All");
		agentService.getAllAgents().forEach(System.out::println);
	
	}

}
