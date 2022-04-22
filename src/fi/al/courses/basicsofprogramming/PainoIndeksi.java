/**
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Painoindeksi
 *
 * Creation Date: 12.1.2007
 */

package fi.al.courses.basicsofprogramming;


import fi.al.utils.Oma;




public final class PainoIndeksi {
  /**  */
  private static final int CENTIMETERS_IN_METER = 100;


  private PainoIndeksi() {
    // NOT TO BE CALLED
  }

  /**
   * Asks length and weight for calculating a body mass index.
   *
   * @param args String[]
   */
  public static void main(final String[] args) {
    double lengthInMeters = 0;
    double weight = 0;

    System.out.print("Pituus: ");
    lengthInMeters = Oma.lueDouble();

    System.out.print("Paino: ");
    weight = Oma.lueDouble();

    System.out.printf(
        "%nPainoindeksi on %.2f.%n",
        bmi(lengthInMeters / CENTIMETERS_IN_METER, weight));
  }


  private static double bmi(final double length, final double weight) {
    return weight / (length * length);
  }
}
