package fi.al.courses.oopcontinued.ballevents;


import java.awt.Point;




public class Ball {

  private Point ptCenter = new Point(400, 200);


  public void moveUp() {
    this.ptCenter.y -= 10;
  }

  public void moveUpLeft() {
    this.ptCenter.x -= 10;
    this.ptCenter.y -= 10;
  }

  public void moveLeft() {
    this.ptCenter.x -= 10;
  }

  public void moveDownLeft() {
    this.ptCenter.x -= 10;
    this.ptCenter.y += 10;
  }

  public void moveDown() {
    this.ptCenter.y += 10;
  }

  public void moveDownRight() {
    this.ptCenter.x += 10;
    this.ptCenter.y += 10;
  }

  public void moveRight() {
    this.ptCenter.x += 10;
  }

  public void moveUpRight() {
    this.ptCenter.x += 10;
    this.ptCenter.y -= 10;
  }

  public int getX() {
    return this.ptCenter.x;
  }

  public int getY() {
    return this.ptCenter.y;
  }

} // end of class Ball
