package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of Integer Set class
 *
 * @author Amir Ince
 *
 */
public class IntegerSet  {
	//Creating ArrayList to store the set
	private List<Integer> set = new ArrayList<Integer>();

	
	/**
	 * Default constructor for IntegerSet class
	 */
	public IntegerSet() {
	}

	/**
	 * Clearing the internal representation of a set
	 */
	public void clear() {
		set.clear();  
	};
	

	/**
	 *Getting the length of internal set
	 * @return number of elements in current set
	 */
	public int length() {
		return set.size();
	}; // returns the length
	
	/**
	 * 
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * @param b object of IntegerSet
	 * @return True if sets are equal, False is they are not
	 */
	public boolean equals(IntegerSet b) {
		
		String str = b.getSet();
		List<Integer> bSet = new ArrayList<Integer>();
		//Edge case if both sets are empty they are equal
		if (b.length()==0 && set.size()==0){
	        return true;
	    }
		
		if (str.length()!=0) {
	    	for(String x : str.split(" ")){
		         bSet.add(Integer.valueOf(x));
		     }
	    }
	    		
		if(set.size()==0 || b.length()==0)
		{
			return false;
		}
		
		if(set.size()!=b.length())
		{
			return false;
		}
		
	    //to avoid messing the order of the lists we will use a copy
	    set = new ArrayList<Integer>(set); 
	    bSet = new ArrayList<Integer>(bSet);   
	    
	    //Sorting the list 
	    Collections.sort(set);
	    Collections.sort(bSet); 
	    
	    //Checking if lists are equal using equal() method 
	    return set.equals(bSet);
	}; 
	 
	/**
	 * Returns true if the set contains the value, otherwise false
	 * @param value to be checked if present in set
	 * @return true if the set contains the value, otherwise false
	 */
	public boolean contains(int value) {
		return set.contains(value);
	};    
	
	/**
	 * Returns the largest item in the set by calling largestHelper method;
	 * @return value of the largest item in the set
	 */
	public int largest(){
		int max=0;
		try {
			max=largestHelper();
		}
		catch(IntegerSetException ise)
		{
			System.out.println("Error: Set is empty");
		}
		return max;
	}; 
	
	/**
	 * Returns the largest element in set, if empty throws exception
	 * @return
	 * @throws IntegerSetException if set is empty
	 */
	protected int largestHelper() throws IntegerSetException
	{
		if (isEmpty()){
			throw new IntegerSetException("Error:Set is empty");	
		//initializing max variable to keep track of largest element 
		}
		int max=set.get(0);
		
		//looping through array list to find largest
		for (int i=1;i<set.size();i++)
		{
			if(max<set.get(i))
				max=set.get(i);
		}
		return max;		//returning the max value
	}
	
	
	/**
	 * Returns the smallest item in the set
	 * @return value of the smallest item in the set
	 * @throws IntegerSetException if the set is empty 
	 */
	public int smallest(){
		int smallestVal=0;
		try {
			smallestVal=smallestHelper();	
		}
		catch (IntegerSetException ise){
			System.out.println("Error: Set is empty");
		}
		return smallestVal;
	};
	
	/**
	 * returns smallest value in set, if empty throws exception
	 * @return
	 * @throws IntegerSetException
	 */
	protected int smallestHelper() throws IntegerSetException
	{
		int smallest=0;
		
		if (isEmpty()){
			throw new IntegerSetException("Error:Set is empty");
		}
		//Setting smallest as first element in ArrayList 
		smallest=set.get(0);
		//Looping through ArrayList to find the smallest element  
		for (int i=1;i<set.size();i++)
		{
			if(smallest>set.get(i))
				smallest=set.get(i);
		}
		//returning smallest element
		return smallest;
	}
	
	
	/**
	 *  Adds an item to the set or does nothing if already there	
	 * @param item to be added to set 
	 */
	public void add(int item) {
		if  (!set.contains(item)){
			set.add(item);
		}
	 }; // adds item to the set or does nothing if it is in set

	/**
	 * Removes an item from the set or does nothing if not there
	 * @param item to be removed 
	 */
	  public void remove(int item) { 
		  set.remove(Integer.valueOf(item));  // ignored if item is not there 
	    } 
	
	/**
	 * Gets the union of two sets and store the union in the set of object that called the method
	 * @param intSetb, an Object of class IntegerSet
	 */
	public void union(IntegerSet intSetb) {
		
		//Geting the set from intSetb object
		String str = intSetb.getSet();
		List<Integer> bSet = new ArrayList<Integer>();
	    if (str.length()!=0) {
	    	for(String x : str.split(" ")){
		         bSet.add(Integer.valueOf(x));
		     }
	    }
	     
	     
		//Checking if an element of Bset is not in Set then we add it to set 
		for(int y=0;y<intSetb.length();y++)
		{
			if (!set.contains(bSet.get(y))) {
				set.add(bSet.get(y));
			}
		}
	};
	

	/**
	 * Gets intersection of two sets and store the union in the set of object that called the method
	 * @param intSetb, an Object of class IntegerSet
	 */
	public void intersect(IntegerSet intSetb) {
		
		//Getting set from intSetB object 
		String str = intSetb.getSet();
		List<Integer> setB = new ArrayList<Integer>();
	    
		if (str.length()!=0) {
	    	for(String x : str.split(" ")){
		         setB.add(Integer.valueOf(x));
		     }
	    }
	    
	     //Creating new array list to store the intersection of sets 
	     List<Integer> intersect = new ArrayList<Integer>();
	     //if setB is larger than Set, then check what elements of SetB are in set and add 
	     // them to  intersection 
		if (intSetb.length() > length()){
			for (int i=0;i<intSetb.length();i++)
			{
				if(set.contains(setB.get(i)))
				{
					intersect.add(setB.get(i));
				}
			}
		}
		//if set is larger than SetB, then check what elements of Set are in setB and add 
	    // them to intersection 
		else {
			for (int i=0;i<length();i++)
			{
				if(setB.contains(set.get(i)))
				{
					intersect.add(set.get(i));
				}
			}
		}
		//Make set the intersection
		set=intersect;
	}; 
	
	
	/**
	 * Gets the difference of two sets and store the union in the set of object that called the method.
	 * Set difference, i.e., s1 –s2
	 * @param intSetb, an Object of class IntegerSet
	 */
	public void diff(IntegerSet intSetb){
		//getting set from IntSetb object 
		String str = intSetb.getSet();
		List<Integer> setB = new ArrayList<Integer>();
	    
		if (str.length()!=0) {
	    	for(String x : str.split(" ")){
		         setB.add(Integer.valueOf(x));
		     }
	    }
	     
		List<Integer> diff = new ArrayList<Integer>();
		
		//If SetB does not contain an element in I then add it to diff
		for (int i=0;i<set.size();i++)
		{
			if(!setB.contains(set.get(i)))
			{
				diff.add(set.get(i));
			}
		}
		//Making set diff
		set=diff;
		
	}; // set difference, i.e. s1 - s2
	

	/**
	 * Checking if the set is empty
	 * @return true if the set is empty, false otherwise
	 */
	boolean isEmpty() {
		if (set.size()==0){
			return true;
		}
		else{
			return false;
		}
	}; 
	

	/**
	 * Converting ArrayList to String 
	 * @return String representation of set
	 */
	public String toString() {
		
	    return set.toString();
		
	};	// return String representation of set
	
	/**
	 * Get the set with whitespace between values in string format
	 * @return set in string format without "[" and  "]" 
	 */
	private String getSet() {
		StringBuffer sb = new StringBuffer();
	      
	    for (Integer s : set) {
	    	sb.append(s);
	    	sb.append(" ");
	    }
	    String str = sb.toString();
	    return str;
	}; //returns Set as string with whitespace between values
	
}
