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


import fi.al.courses.basicsofprogramming.utils.Oma;




public class IntegerDouble {
  public static void main(String[] args) {
    int intLuku;
    double doubleLuku;
    System.out.print("Anna kokonaisluku : ");
    intLuku = Oma.lueInt();
    System.out.print("Anna liukuluku : ");
    doubleLuku = Oma.lueDouble();
    System.out.println("Lukujen tulo = " + intLuku * doubleLuku);
  }
}
