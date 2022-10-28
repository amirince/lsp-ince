package org.howard.edu.lsp.midterm.problem1;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of VotingMachine
 * @author Amir Ince
 *
 */
public class VotingMachine {
	
	//HashMap to store candidates and their votes 
	private Map<String, Integer> candidates = new HashMap<String, Integer>();
	
	
	/**
	 * Adds new candidate to voting list 
	 * @param name
	 */
	public void addCandidate(String name) {
		// Add a candidate to the list, initialize number of votes to 0
		candidates.put(name, 0);
	} 

	/**
	 * Allow user to cast votes by passing candidate name and number of votes 
	 * @param name
	 * @param votes
	 */
	public void castVotes(String name, int votes) {
		// Cast votes to the candidate with the given name
		candidates.put(name, candidates.get(name) + votes);
	}
	
	
	/**
	 * Helper method for getVotes, return the number of votes a candidate has when name is passed
	 * if candidate is invalid, throws UnknownCandidateException
	 * @param names
	 * @return
	 * @throws UnknownCandidateException
	 */
	public int getVotesHelper(String names)  throws UnknownCandidateException {
		if (candidates.containsKey(names))
		{
			return candidates.get(names);
		}
		else {
			throw new UnknownCandidateException("Error! Candidate does not exist");
		}
	}
	
	/**
	 * Method for getting votes for a specific candidate
	 * @param names
	 * @return number of votes for specified candidate
	 */
	public int getVotes(String names){
		try {
			return getVotesHelper(names);
		}
		catch (UnknownCandidateException uce){
			System.out.println("Error! Candidate does not exsit");
		}
		return -1;
	}

	
	/**
	 * Method to return the sum of all of the votes for the candidates 
	 * @return the sum of all of the candidates votes 
	 */
	public int sum() {
		Integer sumAll=0;
		// Return the total number of votes for all candidates.	
		for (String name: candidates.keySet()) {;
		    Integer value = candidates.get(name);
		    sumAll=sumAll+value;
		}
		return sumAll;
	}
}