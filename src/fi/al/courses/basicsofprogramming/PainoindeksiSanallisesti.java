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




public class PainoindeksiSanallisesti {
  public static void main(String[] args) {
    double bmi = 0;

    bmi = BMI(ask4Length() / 100, ask4Weight());
    System.out.printf("%n%nPainoindeksi on %.2f.%nSanallinen luokitus: %s.%n%n", bmi,
        verbalBMI(bmi));
  }

  private static double ask4Length() {
    System.out.printf("%nPituus: ");
    return Oma.lueDouble();
  }

  private static double ask4Weight() {
    System.out.printf("%nPaino: ");
    return Oma.lueDouble();
  }

  private static double BMI(double length, double weight) {
    return weight / (length * length);
  }

  private static String verbalBMI(double bmi) {
    if (bmi < 20)
      return "Alipaino";
    if (bmi < 25)
      return "Normaalipaino";
    if (bmi < 30)
      return "Lievä ylipaino";
    if (bmi < 35)
      return "Huomattava ylipaino";
    if (bmi < 40)
      return "Vaikea ylipaino";

    return "Sairaalloinen lihavuus";
  }
}
