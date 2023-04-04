package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csmtech.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	@Query("SELECT c From  Candidate c where c.candusername=:username and c.candpassword=:password")
	Candidate findCandidateByCandnameAndPassword(String username, String password);
	
	@Transactional
	@Modifying
	@Query("Update Candidate set isdelete='Yes' where candid=:candid")
	void deleteCandidateById(Integer candid);

	@Query("From Candidate where isdelete='No'")
	List<Candidate> findAllNotDeleted();

	@Query(nativeQuery = true, value = "select * from Candidate where candid=:candid")
	Candidate findDetailsById(Integer candid);

}
