/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  Hypotenuusa
 * Creation Date:  26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import java.lang.Math;
import fi.al.courses.basicsofprogramming.utils.Oma;



public class Hypotenuusa {
  public static void main(String[] args) {
    double eka = 0.0;
    double toka = 0.0;

    System.out.println("1. sivun pituus:");
    eka = Math.abs(Oma.lueDouble());

    System.out.println("2. sivun pituus:");
    toka = Math.abs(Oma.lueDouble());

    System.out.printf("%nHypotenuusa: %f.%n", Math.sqrt(eka * eka + toka * toka));
  }
}
