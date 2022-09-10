package com.vfislk.training.service;

import java.util.List;

import com.vfislk.training.exceptions.PlanNotFoundException;
import com.vfislk.training.model.Nominee;

public interface INomineeService {

	Nominee addNominee(Nominee nominee);

	void updateNominee(Nominee nominee);

	void deleteNominee(int nomineeId);

	Nominee getNomineeById(int nomineeId) throws PlanNotFoundException;

	List<Nominee> getAllNominees();

	List<Nominee> getByAge(int age) throws PlanNotFoundException;

	List<Nominee> getByRelation(String relationship) throws PlanNotFoundException;
}
