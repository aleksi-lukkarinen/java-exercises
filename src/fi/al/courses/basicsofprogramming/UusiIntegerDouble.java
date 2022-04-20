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


import javax.swing.*;




public class UusiIntegerDouble {
  public static void main(String[] args) {
    String numeroJono;
    int intLuku;
    double doubleLuku;

    numeroJono = JOptionPane.showInputDialog("Anna kokonaisluku");
    intLuku = Integer.parseInt(numeroJono);

    numeroJono = JOptionPane.showInputDialog("Anna liukuluku");
    doubleLuku = Double.parseDouble(numeroJono);

    JOptionPane.showMessageDialog(null, "Lukujen tulo = " + intLuku * doubleLuku);
    System.exit(0);
  }
}
