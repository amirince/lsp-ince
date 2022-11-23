package org.howard.edu.lsp.assignment7;

/**
 * Class which implement the Drop two lowest grading method of the interface
 * 
 * @author Amir Ince
 *
 */
public class CalcAvgDropTwo extends CalculateAverageGrade {
  /**
   * CalcAvgDropTwo method which implements the DropTwoLowestGrading method average strategy
   */
  public CalcAvgDropTwo() {
    averageStrategy = new DropTwoLowestGrading();
  }
}
