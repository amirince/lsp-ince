package org.howard.edu.lsp.assignment7;

import java.util.Collections;
import java.util.List;


/**
 * Class for implementation of Calculating the average grade, dropping the two lowest. Implements
 * the Average Strategy Interface
 * 
 * @author Amir Ince
 *
 */
public class DropTwoLowestGrading implements AverageStrategy {

  /**
   * @author Amir Ince
   * @param grades, Takes in a List of Integers
   * @throws EmptyListException if List is empty or has 2 or less elements
   * @return Returns the average grade neglecting the lowest two scores
   */
  public int compute(List<Integer> grades) throws EmptyListException {

    // if the list is empty throw EmptyListException
    if (grades.size() == 0) {
      throw new EmptyListException("Error! List is empty!");
    }

    // if two elements of less are in the lest then it is impossible to drop the two lowest
    else if (grades.size() <= 2) {
      throw new EmptyListException("Error! Too little elements in list to drop two lowest!");
    }

    // Removing smallest value
    int min = Collections.min(grades);
    grades.remove(grades.indexOf(min));

    // Removing second smallest value
    min = Collections.min(grades);
    grades.remove(grades.indexOf(min));

    // stores the sum of the grades in list
    int sum = 0;

    // keeps track of the number of grades in the list
    int count = 0;

    // looping through the list to find the number of elements and get the sum of grades
    for (int i = 0; i < grades.size(); i++) {
      sum += grades.get(i);
      count += 1;
    }

    // calculating the average of the array
    int avg = sum / count;

    // returning the average of the array
    return avg;
  }

}
