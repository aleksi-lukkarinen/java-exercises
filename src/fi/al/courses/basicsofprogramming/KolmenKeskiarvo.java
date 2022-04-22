/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: KolmenKeskiarvo
 *
 * Creation Date: 26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.utils.Oma;




public final class KolmenKeskiarvo {
  private KolmenKeskiarvo() {
    // NOT TO BE CALLED
  }

  /**
   * Main method. <br />
   * <br />
   * This programs takes three numbers as input and outputs their average.
   *
   * @param args String[]
   */
  public static void main(final String[] args) {
    long first = 0;
    long second = 0;
    long third = 0;

    System.out.println("1. luku:");
    first = Oma.lueInt();

    System.out.println("2. luku:");
    second = Oma.lueInt();

    System.out.println("3. luku:");
    third = Oma.lueInt();

    System.out.printf("%nKeskiarvo on %d.%n", (first + second + third) / 3);
  }
}
