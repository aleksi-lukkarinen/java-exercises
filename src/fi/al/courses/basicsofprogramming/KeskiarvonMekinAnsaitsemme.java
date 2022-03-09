/**************************************************************************************************
 *
 * Course:         The *VERY* Basics of Programming, Spring 2007
 *
 * Participant:    Aleksi Lukkarinen
 *
 * Title of File:  KeskiarvonMekinAnsaitsemme
 * Creation Date:  16.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;

import java.io.*;




/**
 * <p>Title: KeskiarvonMekinAnsaitsemme</p>
 *
 * <p>Description: </p>
 */
public class KeskiarvonMekinAnsaitsemme {
  /**
   * main
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    double sumPositive = 0.0, sumNegative = 0.0;
    long countPositive = 0, countNegative = 0;
    double input = 0.0;

    System.out.println("\nSovellus laskee sekä positiivisten että negatiivisten syötettyjen lukujen keskiarvon.");

    input = readNumber();
    while (input != 0.0) {
      if (input > 0.0) {
        sumPositive += input;
        countPositive++;
      }
      else {
        sumNegative += input;
        countNegative++;
      }

      input = readNumber();
    }

    if (countPositive > 0 && countNegative > 0)
      System.out.println("\nPositiivisten lukujen keskiarvo on " + (sumPositive / countPositive) +
              " ja negatiivisten " + (sumNegative / countNegative) + "." );
    else if (countPositive > 0 && countNegative == 0)
      System.out.println("\nPositiivisten lukujen keskiarvo on " + (sumPositive / countPositive) +
              ", mutta negatiivisia lukuja ei syötetty." );
    else if (countPositive == 0 && countNegative > 0)
      System.out.println("\nNegatiivisten lukujen keskiarvo on " + (sumNegative / countNegative) +
              ", mutta positiivisia lukuja ei syötetty." );
    else
      System.out.println("\nYhtään lukua ei syötetty." );
  }



  private static double readNumber() {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    String strInput = "";
    double dblInput = 0;

    do {
      System.out.printf("%nSyötä luku (muu kuin nolla - '0' lopettaa): ");

      try {
        // Luetaan merkkijono ja muunnetaan se liukuluvuksi. Jos syötetty luku *pyöristyy*
        // muunnoksessa nollaksi, se on liian pieni ja siksi hylätään.
        strInput = stdin.readLine().trim();
        dblInput = Double.parseDouble(strInput);
        if (dblInput == 0.0 && !strInput.equals("0"))
          throw new Exception();

        validInput = true;    // Kaikki kunnossa -> nostetaan merkkilippu
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    }
    while (!validInput);


    // Jos käyttäjä syötti "puhtaan" nollan, palautetaan nolla - muutoin palautetaan syötetty luku.
    if (strInput == "0")
      return 0.0;

    return dblInput;
  }
}
