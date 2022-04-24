package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/*
  Component: DrawArea
  Description: This class is the draw area for the program.
 */
public class DrawArea extends JComponent {
    private Image image;
    //Graphics2D object to draw on the image
    private Graphics2D graphics;
    // mouse position
    private int currentX, currentY, oldX, oldY;

    public DrawArea() {
        //
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // get the mouse position when the mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionListener() {  // mouse motion listener
            @Override
            public void mouseDragged(MouseEvent e) {
                // get the current mouse position
                // get the mouse position when the mouse is dragged
                currentX = e.getX();
                currentY = e.getY();
                if (graphics != null) {
                    // draw a line from the old mouse position to the current mouse position
                    graphics.drawLine(oldX, oldY, currentX, currentY);
                    // refresh the draw area to rep
                    repaint();
                    // update the old mouse position
                    oldX = currentX;
                    oldY = currentY;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // do nothing
            }
        });
    }
    public void paintComponent(Graphics g) {
       // to Image ==> Size panel in JFrame

        if (image ==null) {
          // create a new image
          image = createImage(getSize().width, getSize().height);
          // get the graphics object of the image
          // to draw on the image
          graphics = (Graphics2D) image.getGraphics();
          // set the background color to white
          graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          //to clear the drawing area
          clear();
      }
        g.drawImage(image, 0, 0, null);
    }
    void clear() {
        // set the background color to white
        graphics.setPaint(Color.white);
        // fill the entire drawing area
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        // set the color to black
        graphics.setPaint(Color.black);
        // refresh the drawing area
        repaint();
    }
    public void colorRed() {
        graphics.setPaint(Color.red);
        repaint();
    }
    public void colorBlue() {
        graphics.setPaint(Color.blue);
        repaint();
    }
    public void colorGreen() {
        graphics.setPaint(Color.green);
        repaint();
    }
    public void colorBlack() {
        graphics.setPaint(Color.black);
        repaint();
    }
}