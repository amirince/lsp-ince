package org.howard.edu.lsp.assigment7;

import java.util.ArrayList;
import java.util.List;

public class Driving {

  public static void main(String[] args) {

    CalculateAverageGrade mygrades = new CalcAvg();
    List<Integer> grades = new ArrayList<>();

    CalculateAverageGrade mygrade = new CalcAvgDropTwo();
    int grade = mygrade.performCompute(grades);

    System.out.println(grade);
  }
}
