package org.howard.edu.lsp.assignment7;

/**
 * Class which implement the Regular grading method of the interface
 * 
 * @author Amir Ince
 *
 */
public class CalcAvg extends CalculateAverageGrade {
  /**
   * CalcAvg method which implements the RegularGrading method average strategy
   */
  public CalcAvg() {
    averageStrategy = new RegularGrading();
  }
}
