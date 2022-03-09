/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  SanallinenArvosana ja ArvosanojaToistellen
 * Creation Date:  16.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;




/**
 * <p>Title: SanallinenArvosana ja ArvosanojaToistellen</p>
 *
 * <p>Description: </p>
 */
public class SanallinenArvosana
{
  public static void main(String[] args) {
    System.out.printf("%nNumeeristen ja sanallisten arvosanojen vastaavuus:%n");

    for (int i = -1; i <= 6; i++) {
      System.out.printf("  %3d: ", i);
      printVerbalGrade(i);
      System.out.println();
    }
  }


  private static void printVerbalGrade(int grade) {
    String verbalGrade = "<<Virheellinen parametri>>";

    switch (grade) {
      case 0: verbalGrade = "Hylätty";      break;
      case 1: verbalGrade = "Välttävä";     break;
      case 2: verbalGrade = "Tyydyttävä";   break;
      case 3: verbalGrade = "Hyvä";         break;
      case 4: verbalGrade = "Kiitettävä";   break;
      case 5: verbalGrade = "Erinomainen";  break;
    }

    System.out.printf(verbalGrade);
  }
}
