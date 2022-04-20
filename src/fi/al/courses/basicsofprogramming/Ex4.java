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


import fi.al.courses.basicsofprogramming.utils.Oma;




/**
 * <p>
 * Title: Ex4
 * </p>
 *
 * <p>
 * Description: Excercise 4
 * </p>
 */
public class Ex4 {
  public static void main(String[] args) {
    long number = 0;

    System.out.print("Arvaa kokonaisluku: ");
    number = Oma.lueInt();

    System.out.printf("%nMinun lukuni on %s, hävisit niukasti.%n", ++number);
  }
}
