/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: KolmenJarjestys
 *
 * Creation Date: 2.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>
 * Title: KolmenJarjestys
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public final class KolmenJarjestys {
  private KolmenJarjestys() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    long number1 = 0;
    long number2 = 0;
    long number3 = 0;

    System.out.println();

    do {
      validInput = false;

      System.out.print("Syötä 1. kokonaisluku: ");

      try {
        number1 = Long.parseLong(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.println("Virheellinen syöte.\n");
      }
    } while (!validInput);

    do {
      validInput = false;

      System.out.print("Syötä 2. kokonaisluku: ");

      try {
        number2 = Long.parseLong(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.println("Virheellinen syöte.\n");
      }
    } while (!validInput);

    do {
      validInput = false;

      System.out.print("Syötä 3. kokonaisluku: ");

      try {
        number3 = Long.parseLong(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.println("Virheellinen syöte.\n");
      }
    } while (!validInput);

    System.out.println();
    printInAscendingOrder(number1, number2, number3);
    printInDescendingOrder(number1, number2, number3);
  }


  private static void printInAscendingOrder(final long a, final long b, final long c) {

    String strOut = "Nouseva järjestys: ";

    if (a <= b && a <= c) { // a pienin
      strOut += a + ", ";

      if (b < c) {
        strOut += b + ", " + c;
      }
      else {
        strOut += c + ", " + b;
      }
    }
    else if (b <= a && b <= c) { // b pienin
      strOut += b + ", ";

      if (a < c) {
        strOut += a + ", " + c;
      }
      else {
        strOut += c + ", " + a;
      }
    }
    else { // c pienin
      strOut += c + ", ";

      if (a < b) {
        strOut += a + ", " + b;
      }
      else {
        strOut += b + ", " + a;
      }
    }

    strOut += ".\n";
    System.out.print(strOut);
  }


  private static void printInDescendingOrder(final long a, final long b, final long c) {
    String strOut = "Laskeva järjestys: ";

    if (a >= b && a >= c) { // a suurin
      strOut += a + ", ";

      if (b > c) {
        strOut += b + ", " + c;
      }
      else {
        strOut += c + ", " + b;
      }
    }
    else if (b >= a && b >= c) { // b suurin
      strOut += b + ", ";

      if (a > c) {
        strOut += a + ", " + c;
      }
      else {
        strOut += c + ", " + a;
      }
    }
    else { // c suurin
      strOut += c + ", ";

      if (a > b) {
        strOut += a + ", " + b;
      }
      else {
        strOut += b + ", " + a;
      }
    }

    strOut += ".\n";
    System.out.print(strOut);
  }
}
