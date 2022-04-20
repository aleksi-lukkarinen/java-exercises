/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: SyotteenTarkistaminen
 *
 * Creation Date: 2.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;




/**
 * <p>
 * Title: SyotteenTarkistaminen
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public class SyotteenTarkistaminen {
  /**
   * main
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    long sum = 0;

    System.out.printf("%nSovellus laskee kymmenen syöttämäsi positiivisen kokonaisluvun summan.%n");

    for (int i = 1; i <= 10; i++)
      sum += lueJaTarkista();

    System.out.printf("%nSyöttämiesi lukujen summa on %d.%n", sum);
  }


  /**
   *
   *
   * @return long
   */
  private static int lueJaTarkista() {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    int number = 0;

    while (!validInput) {
      System.out.printf("%nSyötä positiivinen kokonaisluku: ");

      try {
        number = Integer.parseInt(stdin.readLine());

        if (number < 0)
          throw new Exception();

        validInput = true;
      } catch (NumberFormatException ex) {
        System.out.printf("Syöte ei ole hyväksyttävä luku.%n");
      } catch (Exception ex) {
        System.out.printf("Negatiiviset luvut eivät kelpaa.%n");
      }
    }

    return number;
  }
}
