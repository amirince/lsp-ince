package org.howard.edu.lsp.assignment4.test;
import org.howard.edu.lsp.assignment4.implementation.IntegerSet;

public class Driver {

	public static void main(String[] args) {
		
		//Creating new set1
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		System.out.println("Inserting 1,2,3,4 to set2");
		
		//Testing basic set functions
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Smallest value in Set1 is: " + set1.smallest());
		System.out.println("Largest value in Set1 is: " + set1.largest());
		System.out.println("The length of Set1 is: " + set1.length());
		System.out.println("");
		
		//Creating new set2
		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);
		set2.add(3);
		set2.add(7);
		set2.add(9);
		set2.add(9); //Testing that set can only have one instance of an element
		System.out.println("Inserting 4,5,3,7,9,9 to set2");
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Removing 7 from set2");
		set2.remove(7); //removing element from set 2
		System.out.println("Trying to Removing 0 from set2 (element not in set)");
		set2.remove(0); //removing element from set that does now exist 
		System.out.println("Value of Set2 after removing 7: " + set2.toString());
		System.out.println("");
		
		
		//Testing union function
		System.out.println("Testing union function:");
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.print("Union of Set1 and Set2: ");
		set1.union(set2); //Calling union function 	
		System.out.println(set1.toString());
		System.out.println("");
		
		//Creating new set that is empty 
		IntegerSet set3 = new IntegerSet();
		
		//checking if exception is handled for empty set
		System.out.println("Testing if exceptions are caught when set is empty");
		System.out.print("Testing smallest method: ");
		System.out.println(set3.smallest());
		System.out.print("Testing largest method: ");
		System.out.println(set3.largest());
		
		
		//Adding elements to set 3
		set3.add(9);
		set3.add(40);
		set3.add(50);
		set3.add(60);
		set3.add(70);
		set3.add(80);
		System.out.println("");
		//Testing the intersect function 
		System.out.println("Testing intersect function:");
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Value of Set3 is: " + set3.toString());
		System.out.print("Intersection of Set2 and Set3: ");
		set2.intersect(set3);	//Calling intersect function 
		System.out.println(set2.toString());
		System.out.println("");
		
		//Testing the clear function 
		System.out.println("Testing clearing function:");
		System.out.println("Value of Set3 prior to clearing is: " + set3.toString());
		set3.clear();  //clearing set3
		System.out.println("Value of Set3 prior after clearing is: " + set3.toString());
		System.out.println("");
		
		//testing equal function 
		System.out.println("Testing equal function:");
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Is set1 equal to set2: " + set1.equals(set2));
		
		
		//Creating set4
		IntegerSet set4 = new IntegerSet();
		set4.add(9);
		set4.add(10);
		set4.add(11);
		
		//Creating set5
		IntegerSet set5 = new IntegerSet();
		set5.add(9);
		set5.add(10);
		set5.add(11);
		
		//Set 4 and set 5 are equal and should return the same value 
		System.out.println("");
		System.out.println("Value of Set4 is: " + set4.toString());
		System.out.println("Value of Set5 is: " + set5.toString());
		System.out.println("Is set4 equal to set5: " + set4.equals(set5));
		System.out.println("");
		
		
		//testing the contains function 
		System.out.println("Testing contains function");
		System.out.println("Value of Set5 is: " + set5.toString());
		System.out.println("Is 70 in set5: " + set5.contains(70));
		System.out.println("Is 11 in set5: " + set5.contains(11));
		System.out.println("");
		
		System.out.println("Testing difference function");
		System.out.println("Value of Set4 is: " + set4.toString());
		System.out.println("Value of Set5 is: " + set5.toString());
		set4.diff(set5);
		System.out.println("Difference of Set4 and Set5 is: " + set4.toString());
		
		IntegerSet set6 = new IntegerSet();
		set6.add(9);
		set6.add(10);
		
		System.out.println("Value of Set5 is: " + set5.toString());
		System.out.println("Value of Set6 is: " + set6.toString());
		set5.diff(set6);
		System.out.println("Difference of Set5 and Set6 is: " + set6.toString());
	}
}
