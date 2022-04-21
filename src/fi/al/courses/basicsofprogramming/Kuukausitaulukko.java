/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Kuukausitaulukko
 *
 * Creation Date: 30.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>
 * Title: Kuukausitaulukko
 * </p>
 */
public final class Kuukausitaulukko {
  private Kuukausitaulukko() {
    // NOT TO BE CALLED
  }

  public static void main(final String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    String strMonth = "";

    while (true) {
      System.out.printf("%nSyötä kuukauden numero ['.' lopettaa]: ");

      try {
        input = stdin.readLine().trim();

        if (input.equals(".")) {
          break;
        }

        strMonth = monthName(Integer.parseInt(input));
        if (strMonth != null) {
          System.out.printf("Kysymäsi kuukauden nimi: %s.%n", strMonth);
        }
        else {
          System.out.printf("Syöttämäsi kuukausinumero oli virheellinen.%n");
        }
      }
      catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }

    System.out.printf("%nOhjelma lopetetaan.%n");
  }



  private static String monthName(final int month) {
    String[] monthNames = { "Tammikuu", "Helmikuu", "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu",
        "Heinäkuu", "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu", "Joulukuu" };

    if (month < 1 || month > 12) {
      return null;
    }

    return monthNames[month - 1];
  }
}
