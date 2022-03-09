/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  KahdenJarjestys
 * Creation Date:  2.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>Title: KahdenJarjestys</p>
 *
 * <p>Description: </p>
 */
public class KahdenJarjestys
{
  public static void main(String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    long number1 = 0;
    long number2 = 0;

    do {
      validInput = false;

      System.out.printf("%nSyötä 1. kokonaisluku: ");

      try {
        number1 = Integer.parseInt(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    }
    while (!validInput);

    do {
      validInput = false;

      System.out.printf("%nSyötä 2. kokonaisluku: ");

      try {
        number2 = Integer.parseInt(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    }
    while (!validInput);

    System.out.print("\n\n" + orderOfMagnitude(number1, number2) + "\n");
  }


  private static String orderOfMagnitude(long a, long b) {
    if (a < b) {
      return "Ensimmäinen luku on pienempi.";
    }
    if (a == b) {
      return "Luvut ovat yhtä suuria.";
    }

    return "Ensimmäinen luku on suurempi.";
  }
}
