/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: OsavalinSumma
 *
 * Creation Date: 30.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>
 * Title: OsavalinSumma
 * </p>
 */
public final class OsavalinSumma {
  private static final int MAX = 50;

  private OsavalinSumma() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    int[] luvut = new int[MAX + 1];
    int a = 0;
    int y = MAX;

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



  private static void arvoTaulukkooon(final int[] luvut) {
    for (int i = 0; i < luvut.length; i++) {
      luvut[i] = (int) (java.lang.Math.random() * (MAX + 1));
    }
  }


  private static void tulostaTaulukko(final int[] luvut) {
    System.out.println("\nTaulukon luvut ovat:");

    for (int i = 0; i < luvut.length; i++) {
      System.out.printf("Solun indeksi: %2d, arvo: %2d%n", i, luvut[i]);
    }
  }


  private static long osaSumma(final int[] luvut, final int yla, final int ala) {
    long sum = 0;

    int y = yla;
    int a = ala;
    if (ala > yla) {
      y = ala;
      a = yla;
    }

    if (a < 0) {
      throw new ArrayIndexOutOfBoundsException("Osasumman alaindeksi on liian pieni.");
    }

    if (y >= luvut.length) {
      throw new ArrayIndexOutOfBoundsException("Osasumman yläindeksi on liian suuri.");
    }

    for (int i = a; i <= y; i++) {
      sum += luvut[i];
    }

    return sum;
  }


  private static void taulukonMinimi(final int[] luvut) {
    int minValue = Integer.MAX_VALUE;
    int minValueIndex = 0;

    for (int i = 0; i < luvut.length; i++) {
      if (luvut[i] < minValue) {
        minValue = luvut[i];
        minValueIndex = i;
      }
    }

    System.out.printf("\nTaulukon pienin arvo %d sijaitsee kohdassa %d.\n", minValue,
        minValueIndex);
  }


  private static void onkoAlkioSamaKuinIndeksi(final int[] luvut) {
    int cellCount = 0;
    String strCells = "";

    for (int i = 0; i < luvut.length; i++) {
      if (luvut[i] == i) {
        cellCount++;
        strCells += String.valueOf(i) + "\n";
      }
    }

    if (cellCount > 0) {
      System.out.printf("\nTaulukossa %d solulla solun indeksi on yhtä suuri kuin sen arvo.\n"
          + "Kyseisten solujen indeksit ovat:%n%s", cellCount, strCells);
    }
    else {
      System.out.printf("\nTaulukon millään solulla ei ollut arvonaan kyseisen omaa indeksiään.\n");
    }
  }


  private static int askPartialSumIndex(final boolean upper) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      if (upper) {
        System.out.printf("%nSyötä osasumman nollakantainen yläindeksi: ");
      }
      else {
        System.out.printf("%nSyötä osasumman nollakantainen alaindeksi: ");
      }

      try {
        return Integer.parseInt(stdin.readLine());
      }
      catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }
}
