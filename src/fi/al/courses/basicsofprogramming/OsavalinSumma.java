/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  OsavalinSumma
 * Creation Date:  30.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import java.io.*;




/**
 * <p>Title: OsavalinSumma</p>
 */
public class OsavalinSumma
{
  public static final int MAX = 50;

  public static void main(String[] args) {
    int[] luvut = new int[MAX + 1];
    int a       = 0;
    int y       = MAX;

    arvoTaulukkooon(luvut);

    a = askPartialSumIndex(false);
    y = askPartialSumIndex(true);

    tulostaTaulukko(luvut);

    taulukonMinimi(luvut);

    onkoAlkioSamaKuinIndeksi(luvut);

    try {
      System.out.printf("%nOsasumma indeksivälillä %d - %d = %d.%n", a, y, osaSumma(luvut, a, y));
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("\n" + e.getMessage() + "\n");
    }
    catch (Exception e) {
      System.out.println("\nTuntematon virhe osasummaa laskettaessa.\n");
    }
  }



  private static void arvoTaulukkooon(int[] luvut) {
    for (int i = 0; i < luvut.length; i++) {
      luvut[i] = (int) (java.lang.Math.random() * (MAX + 1));
    }
  }


  private static void tulostaTaulukko(int[] luvut) {
    System.out.println("\nTaulukon luvut ovat:");

    for (int i = 0; i < luvut.length; i++) {
      System.out.printf("Solun indeksi: %2d, arvo: %2d%n", i, luvut[i]);
    }
  }


  private static long osaSumma(int[] luvut, int yla, int ala) {
    long sum = 0;
    int  tmp = 0;

    if (ala > yla) {
      tmp = ala;
      ala = yla;
      yla = tmp;
    }

    if (ala < 0)
      throw new ArrayIndexOutOfBoundsException("Osasumman alaindeksi on liian pieni.");
    if (yla >= luvut.length)
      throw new ArrayIndexOutOfBoundsException("Osasumman yläindeksi on liian suuri.");

    for (int i = ala; i <= yla; i++) {
      sum += luvut[i];
    }

    return sum;
  }


  private static void taulukonMinimi(int[] luvut) {
    int minValue      = Integer.MAX_VALUE;
    int minValueIndex = 0;

    for (int i = 0; i < luvut.length; i++) {
      if (luvut[i] < minValue) {
        minValue = luvut[i];
        minValueIndex = i;
      }
    }

    System.out.printf("\nTaulukon pienin arvo %d sijaitsee kohdassa %d.\n", minValue, minValueIndex);
  }


  private static void onkoAlkioSamaKuinIndeksi(int[] luvut) {
    int     cellCount   = 0;
    String  strCells    = "";

    for (int i = 0; i < luvut.length; i++) {
      if (luvut[i] == i) {
        cellCount++;
        strCells += String.valueOf(i) + "\n";
      }
    }

    if (cellCount > 0)
      System.out.printf("\nTaulukossa %d solulla solun indeksi on yhtä suuri kuin sen arvo.\n" +
              "Kyseisten solujen indeksit ovat:%n%s", cellCount, strCells);
    else
      System.out.printf("\nTaulukon millään solulla ei ollut arvonaan kyseisen omaa indeksiään.\n");
  }


  private static int askPartialSumIndex(boolean upper) {
    BufferedReader stdin  = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      if (upper)
        System.out.printf("%nSyötä osasumman nollakantainen yläindeksi: ");
      else
        System.out.printf("%nSyötä osasumman nollakantainen alaindeksi: ");

      try {
        return Integer.parseInt(stdin.readLine());
      }
      catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }
}
