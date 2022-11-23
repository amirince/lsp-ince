package org.howard.edu.lsp.assigment7;

/**
 * 
 * @author Amir Ince class for custom exception within the program
 */
public class EmptyListException extends Exception {
  /**
   * Exception object to be thrown
   * 
   * @param msg, which is the message of error specified when the Exception is thrown
   */
  public EmptyListException(String msg) {
    super(msg);
  }
}
