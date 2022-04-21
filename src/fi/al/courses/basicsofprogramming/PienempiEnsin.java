/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: PienempiEnsin
 *
 * Creation Date: 2.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;




/**
 * <p>
 * Title: PienempiEnsin
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public final class PienempiEnsin {
  private PienempiEnsin() {
    // NOT TO BE CALLED
  }

  /**
   * main
   *
   * @param args String[]
   */
  public static void main(final String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    double a = 0;
    double b = 0;

    do {
      validInput = false;

      System.out.printf("%nSyötä 1. luku: ");

      try {
        a = Double.parseDouble(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    } while (!validInput);

    do {
      validInput = false;

      System.out.printf("%nSyötä 2. luku: ");

      try {
        b = Double.parseDouble(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    } while (!validInput);

    System.out.printf("%nLuvuista pienempi on %f.%n", min(a, b));
  }


  private static double min(final double a, final double b) {
    if (a < b) {
      return a;
    }

    return b;
  }
}
