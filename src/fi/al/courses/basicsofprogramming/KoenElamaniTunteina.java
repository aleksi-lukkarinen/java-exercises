/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: KoenElamaniTunteina
 *
 * Creation Date: 26.1.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;




/**
 *
 * <p>
 * Title: KoenElamaniTunteina
 * </p>
 *
 * <p>
 * Description: My experience of life is measured in hours.
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) Aleksi Lukkarinen 2007
 * </p>
 *
 * @author Aleksi Lukkarinen
 * @version 1.0
 */
public class KoenElamaniTunteina {
  /**
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    String strOutput = "";
    Time t1, t2, tDiff;

    t1 = ask4Time(1);
    t2 = ask4Time(2);
    tDiff = t1.difference(t2);

    strOutput = "%n1. ajankohta: %d h %d min %d sek. (= %d sekuntia)%n"
        + "2. ajankohta: %d h %d min %d sek. (= %d sekuntia)%n"
        + "%nAjankohtien erotus: %d sekuntia eli " + "%d tunti" + ((tDiff.hours() != 1) ? "a" : "")
        + ", " + "%d minuutti" + ((tDiff.minutes() != 1) ? "a" : "") + " ja " + "%d sekunti"
        + ((tDiff.seconds() != 1) ? "a" : "") + ".%n";

    System.out.printf(strOutput, t1.hours(), t1.minutes(), t1.seconds(), t1.asSeconds(), t2.hours(),
        t2.minutes(), t2.seconds(), t2.asSeconds(), tDiff.asSeconds(), tDiff.hours(),
        tDiff.minutes(), tDiff.seconds());
  }


  /**
   *
   * @param count long
   * @return Time
   */
  private static Time ask4Time(long count) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String[] splittedTime = null;
    boolean validInput = false;
    long h = 0, m = 0, s = 0;

    if (count < 1) {
      count = 1;
    }

    do {
      System.out.printf("%nSyötä %d. ajankohta muodossa H.M.S: ", count);

      try {
        splittedTime = stdin.readLine().trim().split("\\.");

        if (splittedTime.length != 3) {
          throw new Exception();
        } else if (splittedTime[0].length() > 2 || splittedTime[0].length() < 1
            || splittedTime[1].length() > 2 || splittedTime[1].length() < 1
            || splittedTime[2].length() > 2 || splittedTime[2].length() < 1) {
          throw new Exception();
        }

        h = Long.parseLong(splittedTime[0]);
        m = Long.parseLong(splittedTime[1]);
        s = Long.parseLong(splittedTime[2]);

        if (h < 0 || h > 23 || m < 0 || m > 59 || s < 0 || s > 59) {
          throw new Exception();
        }

        validInput = true;
      } catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    } while (!validInput);

    return new Time(h, m, s);
  }


  /**
   *
   * @param hours1   long
   * @param minutes1 long
   * @param seconds1 long
   * @param hours2   long
   * @param minutes2 long
   * @param seconds2 long
   * @return long Time difference as seconds.
   */
  @SuppressWarnings("unused")
  private static long timeDiff(long hours1, long minutes1, long seconds1, long hours2,
      long minutes2, long seconds2) {
    long s1 = toSeconds(hours1, minutes1, seconds1);
    long s2 = toSeconds(hours2, minutes2, seconds2);
    long stmp = 0;

    if (s1 < s2) {
      stmp = s1;
      s1 = s2;
      s2 = stmp;
    }

    return s1 - s2;
  }


  /**
   *
   * @param t1 Time
   * @param t2 Time
   * @return Time
   */
  @SuppressWarnings("unused")
  private static Time timeDiff(Time t1, Time t2) {
    long sDiff = 0, mDiff = 0, hDiff = 0, sTmp = 0;
    long s1 = t1.asSeconds();
    long s2 = t2.asSeconds();

    if (s1 < s2) {
      sTmp = s1;
      s1 = s2;
      s2 = sTmp;
    }

    sTmp = s1 - s2;

    hDiff = (long) Math.floor(sTmp / Time.SECONDS_IN_HOUR);
    sTmp %= Time.SECONDS_IN_HOUR;
    mDiff = (long) Math.floor(sTmp / Time.SECONDS_IN_MINUTE);
    sDiff = sTmp % Time.SECONDS_IN_MINUTE;

    return new Time(hDiff, mDiff, sDiff);
  }


  /**
   *
   * @param hours   long
   * @param minutes long
   * @param seconds long
   * @return long
   */
  private static long toSeconds(long hours, long minutes, long seconds) {
    return seconds + minutes * Time.SECONDS_IN_MINUTE + hours * Time.SECONDS_IN_HOUR;
  }
}



/**
 *
 * <p>
 * Title: Time
 * </p>
 *
 * <p>
 * Description: Contains time as hours, minutes and seconds
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) Aleksi Lukkarinen 2007
 * </p>
 *
 * @author Aleksi Lukkarinen
 * @version 1.0
 */
class Time implements Cloneable {
  private long m_Hours;
  private long m_Minutes;
  private long m_Seconds;


  /**
   * Amount of seconds in an hour (3600).
   */
  public static final long SECONDS_IN_HOUR = 3600;

  /**
   * Amount of minutes in an hour (60).
   */
  public static final long MINUTES_IN_HOUR = 60;

  /**
   * Amount of seconds in a minute (60).
   */
  public static final long SECONDS_IN_MINUTE = 60;


  /**
   * Time
   *
   * @param h int
   * @param m long
   * @param s long
   */
  public Time(long h, long m, long s) {
    if (h < 0 || h > 10000 || m < 0 || m > 59 || s < 0 || s > 59) {
      throw new IllegalArgumentException();
    }

    m_Hours = h;
    m_Minutes = m;
    m_Seconds = s;
  }


  /**
   *
   * @return long
   */
  public long seconds() {
    return m_Seconds;
  }


  /**
   *
   * @return long
   */
  public long minutes() {
    return m_Minutes;
  }


  /**
   *
   * @return long
   */
  public long hours() {
    return m_Hours;
  }


  /**
   *
   * @return long
   */
  public long asSeconds() {
    return m_Seconds + m_Minutes * SECONDS_IN_MINUTE + m_Hours * SECONDS_IN_HOUR;
  }


  /**
   *
   * @param t Time
   * @return Time
   */
  public Time difference(Time t) {
    long sDiff = 0, mDiff = 0, hDiff = 0, sTmp = 0;
    long s1 = this.asSeconds();
    long s2 = t.asSeconds();

    if (s1 < s2) { // Jos 2. aika on ensimmäistä suurempi, vaihdetaan 1. ja 2. keskenään
      sTmp = s1;
      s1 = s2;
      s2 = sTmp;
    }

    sTmp = s1 - s2; // Lasketaan aikaero

    // Muunnetaan aikaero tunneiksi, minuuteiksi ja sekunneiksi
    hDiff = (long) Math.floor(sTmp / SECONDS_IN_HOUR);
    sTmp %= SECONDS_IN_HOUR;
    mDiff = (long) Math.floor(sTmp / SECONDS_IN_MINUTE);
    sDiff = sTmp % SECONDS_IN_MINUTE;

    return new Time(hDiff, mDiff, sDiff); // Palautetaan aikaero uutena aikaoliona
  }


  public Time clone() throws CloneNotSupportedException {
    Time t = (Time) super.clone();

    t.m_Hours = m_Hours;
    t.m_Minutes = m_Minutes;
    t.m_Seconds = m_Seconds;

    return t;
  }


  /**
   *
   * @return String
   */
  public String toString() {
    return "Aika: " + m_Hours + "." + m_Minutes + "." + m_Seconds;
  }
}
