/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: OnkoJaollinen
 *
 * Creation Date: 2.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>
 * Title: OnkoJaollinen
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public final class OnkoJaollinen {
  private OnkoJaollinen() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    long number1 = 0;
    long number2 = 0;

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

    if (isDivisible(number1, number2)) {
      System.out.print("\n\n1. luku ON jaollinen 2. luvulla.\n");
    }
    else {
      System.out.print("\n\n1. luku EI OLE jaollinen 2. luvulla.\n");
    }
  }


  private static boolean isDivisible(final long a, final long b) {
    if (b == 0) { // Mikään luku ei ole jaollinen nollalla
      return false;
    }

    if (a == 0) { // Nolla on jaollinen kaikilla luvuilla
      return true;
    }

    return (a % b == 0); // Onko a!=0 jaollinen b!=0:lla?
  }
}
