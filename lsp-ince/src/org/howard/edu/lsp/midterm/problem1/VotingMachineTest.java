package org.howard.edu.lsp.midterm.problem1;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VotingMachineTest {

	@Test
	@DisplayName("Test cases for GetVotes")
	void testGetVotes() {
		VotingMachine electionOne = new VotingMachine();
		electionOne.addCandidate("Paul");
		//Checking that newly added candidate has 0 votes
		Assert.assertTrue(electionOne.getVotes("Paul")==0);
		
		//Checking that votes are updated 
		electionOne.castVotes("Paul", 10);
		Assert.assertTrue(electionOne.getVotes("Paul")==10);
		
		electionOne.castVotes("Paul", 10);
		Assert.assertTrue(electionOne.getVotes("Paul")==20);
		
		//Checking that exception is thrown when non-existent candidate is entered
		assertThrows(UnknownCandidateException.class, () ->electionOne.getVotesHelper("James"));
		
		//Adding new candidate
		electionOne.addCandidate("Joe");
		
		//Testing that second candidate has 0 votes when added
		Assert.assertTrue(electionOne.getVotes("Joe")==0);
		//Updating votes of second candidate to 7
		electionOne.castVotes("Joe", 7);
		//Checking that votes of second candidate is updated
		Assert.assertTrue(electionOne.getVotes("Joe")==7);
		//Checking that votes of first candidate is the same 
		Assert.assertTrue(electionOne.getVotes("Paul")==20);
	}

	@Test
	@DisplayName("Test cases for Sum")
	void testSum() {
		VotingMachine electionOne = new VotingMachine();
		//Creating new candidates
		electionOne.addCandidate("Paul");
		electionOne.addCandidate("Joe");
		electionOne.addCandidate("Steve");
		
		//Testing sum when all candidates have zero votes
		Assert.assertTrue(electionOne.sum()==0);
		
		//Testing sum is correct when one candidate has votes
		electionOne.castVotes("Joe", 7);
		Assert.assertTrue(electionOne.sum()==7);
		
		//Testing sum is correct when two candidates has votes
		electionOne.castVotes("Paul", 10);
		Assert.assertTrue(electionOne.sum()==17);
		
		//Testing that sum is correct when each candidate has votes 
		electionOne.castVotes("Steve", 60);
		Assert.assertTrue(electionOne.sum()==77);
		
		
	}

}
