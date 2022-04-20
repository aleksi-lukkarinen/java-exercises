/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: PainoindeksiMetodeina
 *
 * Creation Date: 26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.courses.basicsofprogramming.utils.Oma;




public class PainoindeksiMetodeina {
  public static void main(String[] args) {
    double length = 0;
    double weight = 0;

    length = ask4Length();
    weight = ask4Weight();

    System.out.printf("%nPainoindeksi on %.2f.%n", BMI(length / 100, weight));
  }

  private static double ask4Length() {
    System.out.printf("%nPituus:%n");
    return Oma.lueDouble();
  }

  private static double ask4Weight() {
    System.out.printf("%nPaino:%n");
    return Oma.lueDouble();
  }

  private static double BMI(double length, double weight) {
    return weight / (length * length);
  }
}
