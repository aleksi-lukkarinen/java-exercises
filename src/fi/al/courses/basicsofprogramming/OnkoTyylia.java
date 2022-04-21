/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: OnkoTyylia
 *
 * Creation Date: 30.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>
 * Title: OnkoTyylia
 * </p>
 */
public final class OnkoTyylia {
  private static final double MAX_POINTS = 20.0;
  private static final int NUMBER_OF_JUDGES = 5;

  private OnkoTyylia() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    double[] points;

    points = new double[NUMBER_OF_JUDGES];

    for (int i = 0; i < NUMBER_OF_JUDGES; i++) {
      points[i] = askPointsOfJudge(i + 1);
    }

    System.out.println("\nYhteispisteet: " + calculateScore(points));
  }



  private static double askPointsOfJudge(final int judgeNum) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    double points = 0;

    while (true) {
      System.out.printf("%nSyötä %d. tuomarin arvosana: ", judgeNum);

      try {
        points = Double.parseDouble(stdin.readLine());

        if (points < 0.0 || points > MAX_POINTS) {
          throw new Exception();
        }

        return points;
      }
      catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }


  private static double calculateScore(double[] points) {
    int min = 0;
    int max = points.length - 1;
    double sum = 0.0;

    for (int i = 0; i < points.length; i++) {
      if (points[i] < points[min]) {
        min = i;
      }

      if (points[i] > points[max]) {
        max = i;
      }
    }

    for (int i = 0; i < points.length; i++) {
      if (i != min && i != max) {
        sum += points[i];
      }
    }

    return java.lang.Math.floor(sum * 100 + 0.5) / 100.0;
  }
}
