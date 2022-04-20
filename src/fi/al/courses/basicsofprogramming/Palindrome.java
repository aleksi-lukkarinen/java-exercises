/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Palindrome
 *
 * Creation Date: 23.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;
import fi.al.courses.basicsofprogramming.utils.ALException;




/**
 * <p>
 * Title: Palindrome
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public class Palindrome {
  /**
   * main
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    String candidate = "";

    // Aloitusviesti
    System.out.printf("%n--:: Palindromitarkastaja(tm) ::--%n%n%n"
        + "Terve! Tämä ohjelma tarkastaa, onko sille syötetty merkkijono palindromi.%n");

    // Luetaan ja tarkastetaan merkkijonoja, kunnes käyttäjä syöttää pisteen ('.')
    candidate = readAndCheck();
    while (candidate != null) {
      System.out.printf("Ehdokas: %s%n", candidate);
      if (isPalindrome(candidate))
        System.out.printf("Tulos: Ehdokas on palindromi.%n");
      else
        System.out.printf("Tulos: Ehdokas ei ole palindromi.%n");

      candidate = readAndCheck();
    }

    System.out.printf("%nOhjelma lopetetaan. Näkemiin!%n");
  }



  private static String readAndCheck() {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    int charCounter = 0;
    char[] inputChars, candidate;

    // Luetaan käyttäjältä merkkijonoja, kunnes hän syöttää
    // joko kelvollisen ehdokkaan tai pisteen lopetuksen merkiksi.
    while (true) {
      System.out.printf("%nSyötä ehdokasmerkkijono ['.' lopettaa]: ");

      try {
        input = stdin.readLine().trim();

        // Jos syötettiin piste, ei tarkastella syötettä enempää, vaan lopetetaan
        if (input.equals("."))
          return null;

        // Tyhjiä merkkijonoja ei hyväksytä
        if (input.equals(""))
          throw new ALException("Virheellinen syöte - tyhjiä merkkijonoja ei hyväksytä.");

        // Tyhjiä merkkijonoja ei hyväksytä
        if (input.length() < 3)
          throw new ALException("Virheellinen syöte - merkkijonon vähimmäispituus on 3 merkkiä.");

        // Käydään ehdokasmerkkijono läpi merkki merkiltä muodostaen testausta
        // varten uusi vain sallittuja merkkejä sisältävä merkkijono. Jos
        // vastaan tulee virheellisiä merkkejä, syöte hylätään.
        inputChars = input.toCharArray();
        candidate = new char[inputChars.length];
        charCounter = 0;
        for (char c : inputChars) {
          // Hypätään tyhjän tilan yli
          if (Character.isWhitespace(c))
            continue;

          // Jos kyseessä on merkki, tallennetaan se uutta merkkijonoa edustavaan
          // taulukkoon pieneksi kirjaimeksi (jos mahdollista) muuntaen.
          if (Character.isLetter(c))
            candidate[charCounter++] = Character.toLowerCase(c);
          else
            throw new ALException("Virheellinen syöte - sallittuja merkkejä ovat vain kirjaimet.");
        }

        // Palautetaan uusi merkkijono mahdollisuuksien mukaan pieniksi kirjaimiksi muunnettuna
        return new String(candidate).substring(0, charCounter);
      } catch (ALException ex) {
        // Käsitellään itse luodut poikkeukset
        String msg = ex.getMessage();

        if (msg != null)
          System.out.printf("%s%n", msg);
        else
          System.out.printf("Virheellinen syöte.%n");
      } catch (Exception ex) {
        // Käsitellään Javan luomat poikkeukset
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }



  private static boolean isPalindrome(String candidate) {
    char[] tbl = candidate.toCharArray();
    int b = 0;
    int e = tbl.length - 1;

    // Tarkistetaan parametrina annetun merkkijonon palindromius
    while (b <= e) {
      if (tbl[b] != tbl[e])
        return false;

      b++;
      e--;
    }

    return true;
  }
}
