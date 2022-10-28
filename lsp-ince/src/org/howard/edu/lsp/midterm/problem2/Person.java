package org.howard.edu.lsp.midterm.problem2;

/**
 * Implementation of Person class
 *
 * @author Amir Ince
 *
 */
public class Person { 
	
	private String name; 
	private int age; 
	private String socialSecurityNumber;
	
	
	//Constructor for Person object
	public Person(String name,  String socialSecurityNumber, int age) {
		this.name = name;
		this.age=age;
		this.socialSecurityNumber=socialSecurityNumber;
	}
	
	//Overriding toString method to return name, age and ssn
	 @Override
	 public String toString() {
		 return this.name + " " + this.age + " " + this.socialSecurityNumber;
	 }
	 
	 
	 //Overriding equals method to compares SSN of each object
	 @Override
	 public boolean equals(Object obj) {
		 
		 //If object is null return false
		 if (obj == null) {
			 return false;
		 }
		 
		 //if the objects are from different classes return false 
		 if (obj.getClass() != this.getClass()) {
			 return false;
		 }
		 
		 //creating Person object from obj
		 final Person other = (Person) obj;

		 //If the ssn are no equal return false
		 if (this.socialSecurityNumber != other.socialSecurityNumber) {
			 return false;
		 }
		 //return true is ssn are equal
		 else {
			 return true;
		 }
	}
 
} 
