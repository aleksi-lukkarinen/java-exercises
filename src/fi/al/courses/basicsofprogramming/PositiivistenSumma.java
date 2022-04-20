/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: PositiivistenSumma
 *
 * Creation Date: 16.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;




/**
 * <p>
 * Title: PositiivistenSumma
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public class PositiivistenSumma {
  /**
   * main
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    long retVal = 0;

    System.out.printf("%nSovellus laskee kokonaislukujen 0 - <syötetty luku> summan.%n");
    retVal = calculateSum(askLong());

    if (retVal == -1)
      System.out.printf("%nSyötetty luku oli negatiivinen - summaa ei voida laskea.%n");
    else if (retVal == -2)
      System.out.printf("%nSyötetty luku oli liian suuri - summaa ei voida laskea.%n");
    else
      System.out.printf("%nSumma: %d%n", retVal);
  }


  /**
   *
   *
   * @param number long
   * @return long
   */
  private static long calculateSum(long number) {
    long sum = 0;

    // Jos parametri oli negatiivinen, sitä ei hyväksytä
    if (number < 0)
      return -1;

    // Lasketaan summa
    for (long i = 0; i <= number; i++) {
      // Tarkistetaan, ettei summa kasva liian isoksi (ylivuoto)
      if (Long.MAX_VALUE - sum < i)
        return -2;

      // Kasvatetaan summaa
      sum += i;
    }

    return sum;
  }


  /**
   *
   *
   * @return long
   */
  private static long askLong() {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.printf("%nSyötä positiivinen kokonaisluku: ");

      try {
        return Long.parseLong(stdin.readLine());
      } catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }
}
