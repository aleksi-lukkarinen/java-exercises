/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: RandomHypotenuusa
 *
 * Creation Date: 26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;




public final class RandomHypotenuusa {
  private RandomHypotenuusa() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    double eka = 1 + (Math.random() * 10000);
    double toka = 1 + (Math.random() * 10000);

    System.out.printf("%nSivut: %f ja %f.%n", eka, toka);
    System.out.printf("Hypotenuusa: %f.%n", Math.sqrt(eka * eka + toka * toka));
  }
}
