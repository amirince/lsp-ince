package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerSetTest {

	@Test
	@DisplayName("Test cases for Clear")
	void testClear() {
		//Testing clear method 
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		Assert.assertTrue(set1.toString().equals("[1, 2, 3, 4]"));
		set1.clear();
		Assert.assertTrue("[]"==set1.toString());
	}

	@Test
	@DisplayName("Test cases for Length")
	void testLength() {
		//testing length of empty set
		IntegerSet set1 = new IntegerSet();
		Assert.assertTrue(0==set1.length());
		set1.add(1);
		//testing length of non-empty set
		Assert.assertTrue(1==set1.length());
		set1.add(2);
		Assert.assertTrue(2==set1.length());
	}

	@Test
	@DisplayName("Test cases for Equals")
	void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		//Testing if two empty sets are equal
		Assert.assertTrue(set1.equals(set2));
		
		//Testing if two sets of different lengths are equal
		set1.add(5);
		set2.add(30);
		set2.add(40);
		Assert.assertFalse(set1.equals(set2));
		//Testing if set1 is not empty and set2 is empty if they are equal
		set1.clear();
		set2.clear();
		set1.add(5);
		set1.add(3);
		set1.add(4);
		Assert.assertFalse(set1.equals(set2));
		
		
		//Testing if set1 empty and set2 is not empty if they are equal
		set1.clear();
		set2.add(4);
		set2.add(5);
		set2.add(3);
		Assert.assertFalse(set1.equals(set2));
		
		//Testing if two sets with the same elements in different order are equal
		set1.add(5);
		set1.add(3);
		set1.add(4);
		Assert.assertTrue(set1.equals(set2));
		
		//Testing if two non equal sets are equal, but one set is a subset of the other
		set2.remove(3);
		Assert.assertFalse(set1.equals(set2));
	}

	@Test
	@DisplayName("Test cases for contains")
	void testContains() {
		IntegerSet set1 = new IntegerSet();
		//Testing if empty sets contains element 
		Assert.assertFalse(set1.contains(1));
		
		//testing is non-empty set contains element 20
		set1.add(20);
		Assert.assertTrue(set1.contains(20));
		Assert.assertFalse(set1.contains(50));
		
	}

	@Test
	@DisplayName("Test cases for Largest")
	void testLargest() {
		
		//Asserting that the helper function for largest throws an exception when set is empty 
		IntegerSet set1 = new IntegerSet();
		assertThrows(IntegerSetException.class, () ->set1.largestHelper());
		
		//Adding elements to the set 
		set1.add(20);
		set1.add(21);
		//Asserting that the largest returned is corrected
		Assert.assertTrue(set1.largest()==21);
		
		set1.add(3000);
		Assert.assertTrue(set1.largest()==3000);
	}
	

	@Test
	@DisplayName("Test cases for Smallest")
	void testSmallest() {
		//Asserting that the helper function for largest throws an exception when set is empty 
		IntegerSet set1 = new IntegerSet();
		assertThrows(IntegerSetException.class, () ->set1.smallestHelper());
		
		//Adding elements to the set 
		set1.add(4);
		set1.add(4000);
		//Asserting that the smallest returned is correct
		Assert.assertTrue(set1.smallest()==4);
		
		set1.add(1);
		Assert.assertTrue(set1.smallest()==1);
	}

	@Test
	@DisplayName("Test cases for Add")
	void testAdd() {
		IntegerSet set1 = new IntegerSet();
		//Testing that new set is empty 
		Assert.assertTrue("[]"==set1.toString());
		
		//Testing that items are added to set 
		set1.add(5);
		set1.add(3);
		set1.add(4);
		Assert.assertTrue(set1.toString().equals("[5, 3, 4]"));
		
		//Testing if trying to add duplicates is ignored
		set1.add(5);
		Assert.assertTrue(set1.toString().equals("[5, 3, 4]"));
	}

	@Test
	@DisplayName("Test cases for Remove")
	void testRemove() {
		IntegerSet set1 = new IntegerSet();
		
		//Trying to remove elem from empty set
		Assert.assertTrue("[]"==set1.toString());
		
		//Removing element from a non empty set
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(7);
		Assert.assertTrue(set1.toString().equals("[1, 2, 3, 7]"));
		
		//Trying to remove element that is not in non empty set
		set1.remove(500);
		Assert.assertTrue(set1.toString().equals("[1, 2, 3, 7]"));
		
		//Removing and element from list after removing an element 
		set1.remove(2);
		Assert.assertTrue(set1.toString().equals("[1, 3, 7]")); 
	}

	@Test
	@DisplayName("Test cases for Union")
	void testUnion() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		//testing union method on two empty sets
		set1.union(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
		
	
		//Testing union when set1 is empty and set2 is not 
		set2.add(4);
		set2.add(5);
		set2.add(3);
		set1.union(set2);
		Assert.assertTrue(set1.toString().equals("[4, 5, 3]"));
		
		
		//Testing union when set2 is empty and set1 is not
		set2.clear();
		set1.union(set2);
		Assert.assertTrue(set1.toString().equals("[4, 5, 3]"));
		
		//Testing union when set1 and set2 are not empty also testing if common element
		//in sets are duplicated in union
		set2.add(80);
		set2.add(3);
		set2.add(90);
		set1.union(set2);
		Assert.assertTrue(set1.toString().equals("[4, 5, 3, 80, 90]"));
		
		set1.clear();
		set2.clear();
		set1.union(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
	}

	@Test
	@DisplayName("Test cases for Intersect")
	void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		//testing intersect method on two empty sets
		set1.intersect(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
		
		//Testing intersection with set1 empty and set2 not empty 
		set2.add(1);
		set2.add(5);
		set2.add(43);
		set1.intersect(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
		
		
		//Testing intersection with set1 not empty and set2 empty 
		set2.clear();
		set1.add(5);
		set1.add(3);
		set1.add(4);
		set1.intersect(set2);
		Assert.assertTrue(set1.toString().equals("[]"));

		//Testing intersection with both sets not empty and containing all same elements
		set1.clear();
		set2.clear();
		set1.add(20);
		set2.add(20);
		set1.add(40);
		set2.add(40);
		set1.intersect(set2);
		Assert.assertTrue(set1.toString().equals("[20, 40]"));
		
		//Testing intersection with both sets not empty and containing no same elements
		set1.clear();
		set2.clear();
		set1.add(20);
		set2.add(40);
		set1.intersect(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
		
		//Testing intersection with both sets not empty and some elements in common
		set1.clear();
		set2.clear();
		
		set1.add(20);
		set1.add(300);
		set1.add(67);
		
		set2.add(40);
		set2.add(32);
		set2.add(20);
		set1.intersect(set2);
		Assert.assertTrue(set1.toString().equals("[20]"));
	}

	@Test
	@DisplayName("Test cases for Diff")
	void testDiff() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		//testing difference method on two empty sets
		set1.diff(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
		
		//Testing diff method when set1 is empty and set 2 is empty 
		set2.add(1);
		set2.add(5);
		set2.add(43);
		set1.diff(set2);
		Assert.assertTrue(set1.toString().equals("[]"));
		
		//testing diff method when set1 is not empty and set2 is empty 
		set2.clear();
		set1.add(5);
		set1.add(3);
		set1.add(4);
		set1.diff(set2);
		Assert.assertTrue(set1.toString().equals("[5, 3, 4]"));
		
		//Testing diff when both sets contain common elements
		set1.clear();
		set2.clear();
		
		set1.add(20);
		set1.add(1);
		set1.add(2);
		
		set2.add(20);
		set2.add(4);
		set2.add(5);
		
		set1.diff(set2);
		Assert.assertTrue(set1.toString().equals("[1, 2]"));
		
		//Testing diff when both sets contain elements but no common elements
		set1.clear();
		set2.clear();
		
		set1.add(40);
		set1.add(1);
		set1.add(2);
		
		set2.add(20);
		set2.add(4);
		set2.add(5);
		set1.diff(set2);
		Assert.assertTrue(set1.toString().equals("[40, 1, 2]"));
	}

	@Test
	@DisplayName("Test cases for IsEmpty")
	void testIsEmpty() {
		//testing that empty set is empty
		IntegerSet set1 = new IntegerSet();
		
		//testing that non-empty set is not empty
		Assert.assertTrue(set1.isEmpty());
		set1.add(10);
		Assert.assertFalse(set1.isEmpty());
		set1.clear();
		Assert.assertTrue(set1.isEmpty());
	}
	
	@Test
	@DisplayName("Test cases for ToString")
	void testToString() {
		//Testing tostring with empty set
		IntegerSet set1 = new IntegerSet();
		Assert.assertTrue(set1.toString().equals("[]"));
		
		//Testing to string with one element in set
		set1.add(20);
		Assert.assertTrue(set1.toString().equals("[20]"));
		
		//testing to string with multiple elements in the set 
		set1.add(10);
		Assert.assertTrue(set1.toString().equals("[20, 10]"));
	}

}
