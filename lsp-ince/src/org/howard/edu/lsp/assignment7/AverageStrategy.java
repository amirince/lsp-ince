package org.howard.edu.lsp.assignment7;

import java.util.List;

/**
 * Interface created for implementation for Strategy Pattern
 * 
 * @author Amir Ince
 * 
 */
public interface AverageStrategy {
  /**
   * 
   * @param grades, a list of integers
   * @return calculated Average grade
   * @throws EmptyListException, when the list is empty
   */
  public int compute(List<Integer> grades) throws EmptyListException;
}

