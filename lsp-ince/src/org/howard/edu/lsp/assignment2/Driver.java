package org.howard.edu.lsp.assignment2;
/**
 * Amir Ince
 * @author incea
 *
 */

public class Driver {

	public static void main(String[] args) {
		
		//Creating new comb object from Combinations class
		Combinations comb = new Combinations();
		
		//Tests cases to test the functionality of the code 
		comb.compute(new int[]{5,5,15,10}, 15);// test case 1
		comb.compute(new int[]{1,2,3,4,5,6}, 6);// test case 2
		comb.compute(new int[]{}, 6);
		comb.compute(new int[]{10,1,2,7,6,1,5}, 8);
		comb.compute(new int[]{10,11,53,7,30,1,5}, 7);
		comb.compute(new int[]{10,1,2,7,5,1,5}, 5);
		comb.compute(new int[]{10,1,6,1,5}, 3);
		comb.compute(new int[]{10,1,2,7,100,1,99}, 1000);
		comb.compute(new int[]{1,3,4,7,3,3,2,4,22,53},7);
		comb.compute(new int[]{10,1,2,7,100,1,99}, 1000);
		comb.compute(new int[]{}, 999);
		

	}

}
