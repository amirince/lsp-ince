package org.howard.edu.lsp.assigment7;

import java.util.List;

/**
 * Superclass from which the CalcAvg class and CalcAvgDropTwo extends from
 * 
 * @author Amir Ince
 * 
 */
public class CalculateAverageGrade {

  // creating object of AverageStrategy
  AverageStrategy averageStrategy;

  // Default constructor for CalculateAverageGrade
  /**
   * Default constructor for CalculateAverageGrade
   */
  public CalculateAverageGrade() {}

  /**
   * Function for setting the AverageStrategy
   * 
   * @param as object of AverageStrategy type
   * 
   */
  public void setAverageStrategy(AverageStrategy as) {
    averageStrategy = as;
  }

  /**
   * Calculates the averages grade using either the DropTwoLowest method or regular method depending
   * on what the Average Strategy is set as
   * 
   * @param grades, List of integers
   * @return avgGrade
   */
  public int performCompute(List<Integer> grades) {
    try {
      int avgGrade = averageStrategy.compute(grades);
      return avgGrade;
    }

    // the compute method throws an exception
    catch (EmptyListException ele) {
      // display error to user
      System.out.println(ele);
    }
    return 0;

  }

}
