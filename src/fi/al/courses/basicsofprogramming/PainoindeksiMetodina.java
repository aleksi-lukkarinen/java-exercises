/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  PainoindeksiMetodina
 * Creation Date:  26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import fi.al.courses.basicsofprogramming.utils.Oma;


public class PainoindeksiMetodina
{
  public static void main(String[] args) {
    CalculateBMI();
  }

  private static void CalculateBMI() {
    double length = 0;
    double weight = 0;

    System.out.printf("%nPituus:%n");
    length = Oma.lueDouble();

    System.out.printf("%nPaino:%n");
    weight = Oma.lueDouble();

    System.out.printf("%nPainoindeksi on %.2f.%n", BMI(length / 100, weight));
  }

  private static double BMI(double length, double weight) {
    return weight / (length * length);
  }
}
