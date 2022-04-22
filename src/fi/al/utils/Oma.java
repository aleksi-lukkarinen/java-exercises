package fi.al.utils;



import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * A utility class for reading user input.
 *
 * @author Simo Silander
 * @version 1.0
 */

public final class Oma {
  /**  */
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private Oma() {
    // NOT TO BE CALLED
  }

  /**
   *
   *
   * @return the read and parsed number
   */
  public static synchronized int lueInt() {
    int luku = 0;
    String lukuStr;
    boolean ok;

    do {
      ok = true;
      try {
        lukuStr = br.readLine();
        luku = Integer.parseInt(lukuStr);
      }
      catch (Exception e) {
        System.out.println("Virheellinen syöte, anna uudestaan");
        ok = false;
      }
    } while (!ok);
    return luku;
  }


  /**
   *
   *
   * @return the read and parsed number
   */
  public static synchronized double lueDouble() {
    double luku = 0.0;
    String lukuStr;
    boolean ok;

    do {
      ok = true;
      try {
        lukuStr = br.readLine();
        luku = Double.parseDouble(lukuStr);
      }
      catch (Exception e) {
        System.out.println("Virheellinen syöte, anna uudestaan");
        ok = false;
      }
    } while (!ok);
    return luku;
  }


  /**
   *
   *
   * @return the read string
   */
  public static synchronized String lueString() {
    String str = null;
    boolean ok;

    do {
      ok = true;
      try {
        str = br.readLine();
      }
      catch (Exception e) {
        System.out.println("Virhe lukemisessa, anna uudestaan");
        ok = false;
      }
    } while (!ok);
    return str;
  }


  /**
   *
   *
   * @return the read and parsed character
   */
  public static synchronized char lueChar() {
    char merkki = ' ';
    String str = null;
    boolean ok;

    do {
      ok = true;
      try {
        str = br.readLine();
        merkki = str.charAt(0);
      }
      catch (Exception e) {
        System.out.println("Virhe lukemisessa, anna uudestaan");
        ok = false;
      }
    } while (!ok);

    return merkki;
  }
}
