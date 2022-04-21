/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: PainoindeksiSanallisesti
 *
 * Creation Date: 2.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.courses.basicsofprogramming.utils.Oma;




public final class PainoindeksiSanallisesti {
  private PainoindeksiSanallisesti() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    double bmi = 0;

    bmi = bmi(askForLength() / 100, askForWeight());
    System.out.printf("%n%nPainoindeksi on %.2f.%nSanallinen luokitus: %s.%n%n", bmi,
        verbalBmi(bmi));
  }

  private static double askForLength() {
    System.out.printf("%nPituus: ");
    return Oma.lueDouble();
  }

  private static double askForWeight() {
    System.out.printf("%nPaino: ");
    return Oma.lueDouble();
  }

  private static double bmi(final double length, final double weight) {
    return weight / (length * length);
  }

  private static String verbalBmi(final double bmi) {
    if (bmi < 20) {
      return "Alipaino";
    }
    if (bmi < 25) {
      return "Normaalipaino";
    }
    if (bmi < 30) {
      return "Lievä ylipaino";
    }
    if (bmi < 35) {
      return "Huomattava ylipaino";
    }
    if (bmi < 40) {
      return "Vaikea ylipaino";
    }

    return "Sairaalloinen lihavuus";
  }
}
