package org.howard.edu.lsp.midterm.problem2;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	@DisplayName("Test cases for ToString")
	void testToString() {
		Person personOne = new Person("Jeff", "111-11-1111", 37);
		Person personTwo = new Person("Mark", "190-51-1311", 21);
		Person personThree = new Person("Joe", "291-41-1511", 39);
		
		//Testing toString() method for each object
		Assert.assertTrue(personOne.toString().equals("Jeff 37 111-11-1111"));
		Assert.assertTrue(personTwo.toString().equals("Mark 21 190-51-1311"));
		Assert.assertTrue(personThree.toString().equals("Joe 39 291-41-1511"));
		
	}

	@Test
	@DisplayName("Test cases for Equals")
	void testEquals() {
		Person personOne = new Person("Jeff", "111-11-1111", 37);
		Person personTwo = new Person("Mark", "111-11-1111", 21);
		Person personThree = new Person("Joe", "291-41-1511", 39);
		
		//Testing that two object with different ssn are not equal
		Assert.assertFalse(personOne.equals(personThree));
		
		//Testing that objects with same ssn are equal
		Assert.assertTrue(personOne.equals(personTwo));
		Assert.assertTrue(personTwo.equals(personOne));
	}

}
