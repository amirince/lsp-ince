/**
 * 
 */
package org.howard.edu.lsp.assignment7;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Amir Ince
 * 
 *         Test methods for regular grading method
 */
class CalcAvgTest {

  /**
   * Test method for testing the regular grading method
   *
   */
  @DisplayName("Test casaes for regular grading method")
  @Test
  void testCalcAvg() {

    // testing that performCompute method throws an exception when the list is empty for regular
    // grading
    CalculateAverageGrade regularGrading = new CalcAvg();
    List<Integer> grades = new ArrayList<>();
    assertThrows(EmptyListException.class, () -> regularGrading.performCompute(grades));

    // Adding items to grades
    grades.add(90);
    grades.add(60);
    grades.add(70);

    // testing that regularGrading method returns correct average
    try {
      Assert.assertTrue(regularGrading.performCompute(grades) == 73);
    } catch (EmptyListException ele) {
      Assert.fail("Fatal error! List exception should not have been thrown");
    }
  }

}
