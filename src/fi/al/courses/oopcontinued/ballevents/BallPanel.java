package fi.al.courses.oopcontinued.ballevents;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;




final public class BallPanel extends JPanel { // view eli model:n tila graafisesti

  static final long serialVersionUID = 112;

  protected int x;
  protected int y;


  public BallPanel() {
    this.x = -100; // aluksi ei näy mitään, ks. paintComponent()
    this.y = -100; // aluksi ei näy mitään, ks. paintComponent()

    setPreferredSize(new Dimension(300, 200));
    setBackground(Color.white);
  }


  public void update(final int newX, final int newY) {
    this.x = newX;
    this.y = newY;

    repaint();
  }


  @Override
  public void paintComponent(final Graphics g) { // päivittää komponentin näytölle
    super.paintComponent(g); // pakollinen aina!

    g.setColor(new Color(0x66, 0xBB, 0xFF));
    g.fillOval(this.x - 8, this.y - 8, 16, 16);
  }

} // end of class BallPanel
