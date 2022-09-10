package com.vfislk.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vfislk.training.exceptions.PlanNotFoundException;
import com.vfislk.training.model.Nominee;
import com.vfislk.training.repository.INomineeRepository;

@Service
public class NomineeServiceImpl implements INomineeService {

	INomineeRepository nomineeRepository;

	@Autowired
	public void setNomineeRepository(INomineeRepository nomineeRepository) {
		this.nomineeRepository = nomineeRepository;
	}

	@Override
	public Nominee addNominee(Nominee nominee) {
		return nomineeRepository.save(nominee);
	}

	@Override
	public void updateNominee(Nominee nominee) {
		nomineeRepository.save(nominee);
	}

	@Override
	public void deleteNominee(int nomineeId) {
		nomineeRepository.deleteById(nomineeId);
	}

	@Override
	public Nominee getNomineeById(int nomineeId) throws PlanNotFoundException {
		return nomineeRepository.findById(nomineeId).get();
	}

	@Override
	public List<Nominee> getAllNominees() {
		return nomineeRepository.findAll();
	}

	@Override
	public List<Nominee> getByAge(int age) throws PlanNotFoundException {
		return nomineeRepository.findByAge(age);
	}

	@Override
	public List<Nominee> getByRelation(String relationship) throws PlanNotFoundException {
		return nomineeRepository.findByRelation(relationship);
	}

}
