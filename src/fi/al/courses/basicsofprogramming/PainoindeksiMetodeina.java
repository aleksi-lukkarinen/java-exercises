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


import fi.al.utils.Oma;




public final class PainoindeksiMetodeina {
  private PainoindeksiMetodeina() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    double length = 0;
    double weight = 0;

    length = askForLength();
    weight = askForWeight();

    System.out.printf("%nPainoindeksi on %.2f.%n", bmi(length / 100, weight));
  }

  private static double askForLength() {
    System.out.printf("%nPituus:%n");
    return Oma.lueDouble();
  }

  private static double askForWeight() {
    System.out.printf("%nPaino:%n");
    return Oma.lueDouble();
  }

  private static double bmi(final double length, final double weight) {
    return weight / (length * length);
  }
}
