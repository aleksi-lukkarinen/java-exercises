package fi.al.courses.oopcontinued.ballevents;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




//
// Hallitsee järjestelmän olioiden väliset riippuvuudet
//
public class Controller implements ActionListener {

  Ball b = null; // Model
  BallPanel p = null; // View



  public Controller(BallPanel p, Ball b) {
    this.p = p;
    this.b = b;
  }


  public void actionPerformed(ActionEvent e) {
    String strCmd = e.getActionCommand();

    if (strCmd.equals("Left"))
      this.b.moveLeft();
    else if (strCmd.equals("Right"))
      this.b.moveRight();
    else if (strCmd.equals("Up"))
      this.b.moveUp();
    else if (strCmd.equals("Down"))
      this.b.moveDown();
    else if (strCmd.equals("UpLeft"))
      this.b.moveUpLeft();
    else if (strCmd.equals("DownLeft"))
      this.b.moveDownLeft();
    else if (strCmd.equals("UpRight"))
      this.b.moveUpRight();
    else if (strCmd.equals("DownRight"))
      this.b.moveDownRight();

    this.p.update(this.b.getX(), this.b.getY());
  }

} // end of class Controller
