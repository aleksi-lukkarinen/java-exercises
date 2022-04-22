/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Excercise 4 from "Java 2 - Ohjelmoinnin peruskirja"
 *
 * Creation Date: 12.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.utils.Oma;




public final class Ex4 {
  private Ex4() {
    // NOT TO BE CALLED
  }

  /**
   *
   *
   * @param args
   */
  public static void main(final String[] args) {
    long number = 0;

    System.out.print("Arvaa kokonaisluku: ");
    number = Oma.lueInt();

    System.out.printf("%nMinun lukuni on %s, hävisit niukasti.%n", number + 1);
  }
}
