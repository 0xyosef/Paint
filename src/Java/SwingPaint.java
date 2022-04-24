/*
    the next step add Icon to the JButton
 */

package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPaint extends JFrame {
    private Container cp;
    DrawArea drawArea = new DrawArea();
    private JPanel panel;
    JButton[] ColorButton;
    // private JButton clearButton,blakButton,redButton,greenButton,blueButton;

    public SwingPaint() {
        super("Swing Paint");
        cp = this.getContentPane();
        //set layout in content pane
        cp.setLayout(new BorderLayout());
        //add drawArea to content pane
        cp.add(drawArea, BorderLayout.CENTER);
        //add panel to content pane
        panel = new JPanel();
        // clearButton = new JButton("Clear");
        showWindow();
/*
        blakButton = new JButton("Black");
        redButton = new JButton("Red");
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
 */
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addActionButton(ColorButton);
        }
    };


        public void addButton() {
            ColorButton = new JButton[]{
                    new JButton("Clear"),
                    new JButton("Black"),
                    new JButton("Red"),
                    new JButton("Green"),
                    new JButton(" Blue")
            };
            for (JButton item : ColorButton) {
                panel.add(item);
                item.addActionListener(actionListener);
            }
        }

        public void addActionButton(JButton[] buttons) {
            buttons[0].addActionListener(e -> {
                drawArea.clear();
            });
            buttons[1].addActionListener(e -> {
                drawArea.colorBlack();
            });
            buttons[2].addActionListener(e -> {
                drawArea.colorRed();
            });
            buttons[3].addActionListener(e -> {
                drawArea.colorGreen();
            });
            buttons[4].addActionListener(e -> {
                drawArea.colorBlue();
            });
        }
    public void showWindow() {
        addButton();
        //add panel to content pane
        cp.add(panel,BorderLayout.NORTH);
        //set visible
        this.setVisible(true);
        //set size
        this.setSize(1000, 1000);
        //this.setResizable(false);

        //set default close operation
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp.add(panel, BorderLayout.NORTH);
        /*
        add buttons to panel
        clearButton.addActionListener(actionListener);
        add buttons to panel

        panel.add(blakButton);
        blakButton.addActionListener(actionListener);

        panel.add(redButton);
        redButton.addActionListener(actionListener);
        panel.add(greenButton);
        greenButton.addActionListener(actionListener);
        panel.add(blueButton);
        blueButton.addActionListener(actionListener);


         */



    }
    }

