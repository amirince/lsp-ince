package org.howard.edu.lsp.assignment7;

import java.util.List;

/**
 * Class for implementation of Calculating the average grade. Implements the Average Strategy
 * Interface
 * 
 * @author Amir Ince
 *
 */
public class RegularGrading implements AverageStrategy {

  /**
   * @author Amir Ince
   * @param grades, a List of Integers
   * @throws EmptyListException is List is empty
   * @return Returns the average grade without dropping any scores
   */
  public int compute(List<Integer> grades) throws EmptyListException {
    // if the list is empty throw EmptyListException
    if (grades.size() == 0) {
      throw new EmptyListException("Error! List is empty!");
    }

    // storing sum of grades in the list
    int sum = 0;
    // Storing the number of elements in the list
    int count = 0;

    // iterating through list to find sum and count
    for (int i = 0; i < grades.size(); i++) {
      sum += grades.get(i);
      count += 1;
    }

    // Calculating the avg grade
    int avg = sum / count;

    // returning the avg grades
    return avg;
  }

}
