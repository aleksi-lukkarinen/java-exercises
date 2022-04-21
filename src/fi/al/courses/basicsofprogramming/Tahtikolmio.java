/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Excercise 28 from "Java 2 - Ohjelmoinnin peruskirja"
 *
 * Creation Date: 12.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;




/**
 * <p>
 * Title: Tahtikolmio
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public final class Tahtikolmio {
  private Tahtikolmio() {
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
    long rowsToRepeat = 0;

    do {
      validInput = false;

      System.out.printf("%nSyötä rivimäärä: ");

      try {
        rowsToRepeat = Long.parseLong(stdin.readLine());
        if (rowsToRepeat < 1) {
          throw new Exception();
        }

        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    } while (!validInput);

    printCharLines('*', rowsToRepeat);
  }


  private static void printCharLines(final char charToRepeat, final long rowsToRepeat) {

    long charsPerRow = 0;

    for (long i = 0; i < rowsToRepeat; i++) {
      charsPerRow++;

      System.out.print("\n");

      for (long j = 0; j < charsPerRow; j++) {
        System.out.print(charToRepeat);
      }
    }

    System.out.print("\n\n");
  }
}
