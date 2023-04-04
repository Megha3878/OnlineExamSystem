package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Candidate;

public interface CandidateService {

	Candidate findCandidateByCandnameAndPassword(String username, String password);

	Candidate saveCandidate(Candidate candidate);

	List<Candidate> findAllCandidate();

	void deleteCandidateById(Integer candid);

	Candidate updateCandidateById(Integer candid);

	Candidate findDetailsById(Integer candid);

}
