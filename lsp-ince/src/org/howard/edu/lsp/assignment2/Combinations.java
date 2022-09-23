package org.howard.edu.lsp.assignment2;
/**
 * Amir Ince
 * @author incea
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Combinations 
{	
	private int target;
    private Stack<Integer> stack = new Stack<>();
    private int sumInStack = 0;
    private List<Integer[]>combinationList=new ArrayList<>();
    
    /**
     * Function for clearing class variables
     */
    private void clearData()
    {
    	combinationList.clear();
    	stack.clear();
    	target=0;
    	sumInStack=0;
    }
    
    
    /**
     * Public function that user can call in driver to get combinations
     * @param input
     * @param sum
     */
    public void compute(int[] input, int sum)
	{
    	clearData();	//Clearing data in class variables each time compute is called
		target=sum;		//initializing target as sum
		
		
		getSummation(input,0, input.length);				  //Calling getSummation 
		System.out.print("Input: " + Arrays.toString(input)); //Printing input array
		System.out.print(" Sum: " + sum+"\n");				  //Printing target sum
		System.out.println("Combinations: ");
		if(combinationList.isEmpty())						  //If no combinations found
		{
			System.out.println("[]");
			System.out.println();
		}
		else				//Printing each Array in combinations in list
		{	
			for (Integer[] intArray : combinationList)
			{
	            System.out.println(Arrays.toString(intArray));
	        } 
			System.out.println();
		}
   	}
    
    
	/**
	 * Function that recursively find the combinations of elements which sum to target and
	 * stores those combinations into a stack and then stores the stack in a list
	 * @param data
	 * @param startIndex
	 * @param endIndex
	 */
	private void getSummation(int[] data, int startIndex, int endIndex)
	{	
		
		//Base case, if the sum of value in the stack is equivalent to target value
	    if(sumInStack==target)
	    {	
	    	//Add the stack to the list of arrays. Stack is converted to an array
	        combinationList.add(stack.toArray(new Integer[stack.size()])); 
	    }
	    //Looping through all elements from the current element onward
	    for(int currIndex=startIndex; currIndex<endIndex;currIndex++)
	    {	
	    	//If the sum in the stack is less than the target value
	        if(sumInStack + data[currIndex]<=target)
	        {
	        	//Add current index to stack
	            stack.push(currIndex);
	            //Add value at current index to sumInStack
	            sumInStack+=data[currIndex];
	            
	            //Recursively call getSummation with an incremented start index
	            getSummation(data,currIndex+1,endIndex);
	            
	            //Remove values from stack as we traverse back up the 
	            //recursive call stack to clear the sumInStack variable
	            sumInStack-=data[stack.pop()];
	        }  
	    }
	}
}
