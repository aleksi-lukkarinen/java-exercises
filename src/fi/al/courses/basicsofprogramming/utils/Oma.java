package fi.al.courses.basicsofprogramming.utils;



import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Title: Luokka tietojen syöttämiseen
 *
 * @author Simo Silander
 * @version 1.0
 */

public final class Oma {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private Oma() {
    // NOT TO BE CALLED
  }

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
