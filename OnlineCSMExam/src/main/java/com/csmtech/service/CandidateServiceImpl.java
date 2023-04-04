package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Candidate;
import com.csmtech.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepository candidateRepo;

	@Override
	public Candidate findCandidateByCandnameAndPassword(String username, String password) {
		
		return candidateRepo.findCandidateByCandnameAndPassword(username,password);
	}

	@Override
	public Candidate saveCandidate(Candidate candidate) {
		
		return candidateRepo.save(candidate);
	}

	@Override
	public List<Candidate> findAllCandidate() {
		
		return candidateRepo.findAllNotDeleted();
	}

	@Override
	public void deleteCandidateById(Integer candid) {
		
		candidateRepo.deleteCandidateById(candid);
	}

	@Override
	public Candidate updateCandidateById(Integer candid) {
		
		return candidateRepo.findById(candid).get();
	}

	@Override
	public Candidate findDetailsById(Integer candid) {
		
		return candidateRepo.findDetailsById(candid);
	}

}
