package org.howard.edu.lsp.assignment7;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Amir Ince
 * 
 *         Test methods for drop two lowest grading method
 *
 */
class CalcAvgDropTwoTest {
  /**
   * Testing the drop two lowest grading method
   */
  @DisplayName("Test casaes for drop two lowwest grading method")
  @Test
  void testCalcAvgDropTwo() {
    // testing that performCompute method throws an exception when the list is empty for droptwo
    // lowest grading method
    CalculateAverageGrade dropTwoLowest = new CalcAvgDropTwo();
    List<Integer> grades = new ArrayList<>();
    assertThrows(EmptyListException.class, () -> dropTwoLowest.performCompute(grades));

    // Adding items to grades
    grades.add(90);
    grades.add(60);

    // Testing that exception is thrown when the droptwo average method is called when two or
    // less elements are in the list
    assertThrows(EmptyListException.class, () -> dropTwoLowest.performCompute(grades));

    // adding more elements to the list
    grades.add(90);
    grades.add(60);

    // testing that Droptwo method returns correct average
    try {
      Assert.assertTrue(dropTwoLowest.performCompute(grades) == 90);
    } catch (EmptyListException ele) {
      Assert.fail("Fatal error! List exception should not have been thrown");
    }
  }
}
