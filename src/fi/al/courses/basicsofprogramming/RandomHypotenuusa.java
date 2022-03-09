/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  RandomHypotenuusa
 * Creation Date:  26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import java.lang.Math;


public class RandomHypotenuusa
{
  public static void main(String[] args) {
    double eka = 1 + (Math.random() * 10000);
    double toka = 1 + (Math.random() * 10000);

    System.out.printf("%nSivut: %f ja %f.%n", eka, toka);
    System.out.printf("Hypotenuusa: %f.%n", Math.sqrt(eka * eka + toka * toka));
  }
}
