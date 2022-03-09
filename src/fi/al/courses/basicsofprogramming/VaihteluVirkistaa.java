/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  VaihteluVirkistaa
 * Creation Date:  26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import fi.al.courses.basicsofprogramming.utils.Oma;


public class VaihteluVirkistaa
{
  public static void main(String[] args) {
    double eka = 0.0;
    double toka = 0.0;
    double tmp = 0.0;

    System.out.println("1. luku:");
    eka = Oma.lueDouble();

    System.out.println("2. luku:");
    toka = Oma.lueDouble();

    System.out.printf("%nLuvut ennen vaihtoa ovat %f ja %f.%n", eka, toka);

    tmp = eka;
    eka = toka;
    toka = tmp;

    System.out.printf("%nLuvut vaihdon jälkeen ovat %f ja %f.%n", eka, toka);
  }
}
