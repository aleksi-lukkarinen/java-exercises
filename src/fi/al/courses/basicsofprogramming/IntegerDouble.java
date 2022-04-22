/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Arvosanajakauma
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import fi.al.utils.Oma;




public final class IntegerDouble {
  private IntegerDouble() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    int intLuku;
    double doubleLuku;

    System.out.print("Anna kokonaisluku : ");
    intLuku = Oma.lueInt();

    System.out.print("Anna liukuluku : ");
    doubleLuku = Oma.lueDouble();

    System.out.println("Lukujen tulo = " + intLuku * doubleLuku);
  }
}
