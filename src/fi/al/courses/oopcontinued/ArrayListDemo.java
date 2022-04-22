/**
 *
 * Course: OOP Continued
 *
 * Semester: Spring 2008
 *
 * Participant: Aleksi Lukkarinen, 0602574, TO06, Helsinki Polytechnic Stadia
 *
 * Project Description: Solutions for Programming Excercises
 *
 * File Description: Class fi.al.OOPContinued.ArrayListDemo
 *
 * Creation Date: 23.1.2008
 */

package fi.al.courses.oopcontinued;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.al.utils.Oma;




public final class ArrayListDemo {

  private ArrayListDemo() {
    // NOT TO BE CALLED
  }

  /**
   *
   *
   * @param args
   */
  public static void main(final String[] args) {
    Point p;
    String s;
    int x;
    int y;
    List<Point> lstPoints = new ArrayList<>();

    // Kysytään pisteiden koordinaatteja ja tallennetaan pisteet ArrayListiin
    while (true) {
      System.out.println("Syötä X-koordinaatti: ");
      x = Oma.lueInt();
      System.out.println("Syötä Y-koordinaatti: ");
      y = Oma.lueInt();

      lstPoints.add(new Point(x, y));

      System.out.println("Syötetäänkö lisää koordinaatteja (k/e)? ");
      s = Oma.lueString();
      if (s.trim().substring(0, 1).equalsIgnoreCase("e")) {
        break;
      }
    }

    // Tulostetaan syötetyt pisteet Iterator-rajapinnan toteuttavan olion avulla
    System.out.println("\nSyötetyt pisteet Iterator-rajapinnan avulla tulostettuna:");
    Iterator<Point> i = lstPoints.iterator();
    while (i.hasNext()) {
      p = (Point) i.next();
      System.out.print(" (" + p.x + ", " + p.y + ")");
    }
  } // end method main

} // end class ArrayListDemo
