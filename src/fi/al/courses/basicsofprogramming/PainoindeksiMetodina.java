/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: PainoindeksiMetodina
 *
 * Creation Date: 26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.courses.basicsofprogramming.utils.Oma;




public final class PainoindeksiMetodina {
  private PainoindeksiMetodina() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    calculateBmi();
  }

  private static void calculateBmi() {
    double length = 0;
    double weight = 0;

    System.out.printf("%nPituus:%n");
    length = Oma.lueDouble();

    System.out.printf("%nPaino:%n");
    weight = Oma.lueDouble();

    System.out.printf("%nPainoindeksi on %.2f.%n", bmi(length / 100, weight));
  }

  private static double bmi(final double length, final double weight) {
    return weight / (length * length);
  }
}
