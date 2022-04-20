/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: LahtoJarjestys
 *
 * Creation Date: 30.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;




/**
 * <p>
 * Title: LahtoJarjestys
 * </p>
 */
public class LahtoJarjestys {
  public static final int NUMBER_OF_SKIERS = 45;

  public static void main(String[] args) {
    int[] skiers = new int[NUMBER_OF_SKIERS + 1];
    int startPos = 0;

    // Arvotaan lähtöpaikat
    for (int skier = 1; skier <= NUMBER_OF_SKIERS; skier++) {
      do {
        startPos = 1 + (int) (java.lang.Math.random() * NUMBER_OF_SKIERS);
      } while (skiers[startPos] != 0);

      skiers[startPos] = skier;
    }

    // Tulostetaan lähtöpaikat
    System.out.println("\nHiihtäjät lähtöjärjestyksessä:");
    for (int startPosition = 1; startPosition <= NUMBER_OF_SKIERS; startPosition++) {
      for (int i = 1; i <= NUMBER_OF_SKIERS; i++) {
        if (skiers[i] == startPosition) {
          System.out.printf("%2d. lähtijä: %d%n", startPosition, i);
          break;
        }
      }
    }

    System.out.println("\nLähtöjärjestysnumerot hiihtäjänumeroiden mukaisessa järjestyksessä:");
    for (int skier = 1; skier <= NUMBER_OF_SKIERS; skier++)
      System.out.printf("Hiihtäjän %2d paikka lähdössä: %d.%n", skier, skiers[skier]);
  }
}
