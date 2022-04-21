/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Painoindeksi
 *
 * Creation Date: 12.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.courses.basicsofprogramming.utils.Oma;




public final class PainoIndeksi {
  private PainoIndeksi() {
    // NOT TO BE CALLED
  }

  /**
   * Main method. <br />
   * <br />
   * This program asks length and weight to calculate a body mass index based on them.
   *
   * @param args String[]
   */
  public static void main(final String[] args) {
    double length = 0;
    double weight = 0;

    System.out.print("Pituus: ");
    length = Oma.lueDouble();

    System.out.print("Paino: ");
    weight = Oma.lueDouble();

    System.out.printf("%nPainoindeksi on %.2f.%n", bmi(length / 100, weight));
  }


  private static double bmi(final double length, final double weight) {
    return weight / (length * length);
  }
}
