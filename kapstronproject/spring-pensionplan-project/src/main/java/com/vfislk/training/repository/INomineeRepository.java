package com.vfislk.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vfislk.training.exceptions.PlanNotFoundException;
import com.vfislk.training.model.Nominee;

@Repository
public interface INomineeRepository extends JpaRepository<Nominee, Integer> {

	// Derived Queries

	@Query("from Nominee where age=?1")
	List<Nominee> findByAge(int age) throws PlanNotFoundException;

	@Query("from Nominee where relation=?1")
	List<Nominee> findByRelation(String relationship) throws PlanNotFoundException;

	@Query("update Customer set age=?1 where nomineeId=?2")
	void updateNominee(int age, int nomineeId);

}
