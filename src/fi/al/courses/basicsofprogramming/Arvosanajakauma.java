/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: Arvosanajakauma
 *
 * Creation Date: 30.3.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.*;




/**
 * <p>
 * Title: Arvosanajakauma
 * </p>
 */
public class Arvosanajakauma {
  private final static String MSG_END = "%nOhjelma lopetetaan.%n";
  private final static int MAX_STUDENTS = 50;
  private final static int MAX_GRADE = 5;

  public static void main(String[] args) {
    String strTmp = "";
    int numberOfStudents = 0;
    int studentCount = 0;
    int grade = 0;
    int[] gradeDistribution = new int[MAX_GRADE + 1];
    int[] grades;

    // Kysytään oppilasmäärä
    numberOfStudents = askNumberOfStudents(MAX_STUDENTS);
    if (numberOfStudents < 1) {
      System.out.printf(MSG_END);
      return;
    }

    // Alustetaan arvosanataulukko
    grades = new int[numberOfStudents];

    // Kysellään arvosanat
    for (int i = 0; i < numberOfStudents; i++) {
      grade = askGradeForStudent(i + 1);

      if (grade == -1) {
        System.out.printf(MSG_END);
        break;
      }

      grades[i] = grade;
      studentCount++;
    }

    // Käsitellään mahdollisesti syötetyt arvosanat
    if (studentCount > 0) {
      // Luodaan arvosanajakauma
      for (int i = 0; i < studentCount; i++)
        gradeDistribution[grades[i]]++;

      // Tulostetaan arvosanajakauma
      System.out.printf("%nSyöttämäsi arvosanat jakautuvat arvosana-asteikolle seuraavasti:%n");
      for (int i = 0; i <= MAX_GRADE; i++) {
        // Luodaan tähtimerkkijono
        strTmp = "";
        for (int j = 0; j < gradeDistribution[i]; j++)
          strTmp += "*";

        // Tulostetaan arvosanaa vastaava rivi
        System.out.printf("%d: %s%n", i, strTmp);
      }
    }
  }



  private static int askGradeForStudent(int student_num) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    int grade = 0;

    while (true) {
      System.out.printf("%nSyötä %d. oppilaan arvosana ['.' lopettaa]: ", student_num);

      try {
        input = stdin.readLine().trim();

        if (input.equals("."))
          return -1;

        grade = Integer.parseInt(input);

        if (grade < 0 || grade > MAX_GRADE)
          throw new Exception();

        return grade;
      } catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }


  private static int askNumberOfStudents(int max) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    int numberOfstudents = 0;

    while (true) {
      System.out.printf("%nSyötä oppilasmäärä [1 - %d, '.' lopettaa]: ", max);

      try {
        input = stdin.readLine().trim();

        if (input.equals("."))
          return -1;

        numberOfstudents = Integer.parseInt(input);

        if (numberOfstudents < 1 || numberOfstudents > max)
          throw new Exception();

        return numberOfstudents;
      } catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }
}
