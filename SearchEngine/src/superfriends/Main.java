/*
 * Project:         Java II (COP 2805) Search Engine
 * Team:            Super Friends
 * Authors:         Jon Davidson
 *                  Thanh J. Duong A.K.A. Chino Caliente
 *                  John McLain
 *                  Shaz Hosein        
 *
 * Date Started:    January 29th, 2014
 */

package superfriends;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.xml.stream.Location;
/**
 * @author Jon Davidson
 * @author Chino Caliente
 * @author John McLain
 * @author Shaz Hosein       ]
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public void createPlayground() {
        JFrame frame = new JFrame("ForFun Maze");
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        Border outline = BorderFactory.createLineBorder(Color.black);

        Location[][] array = null;
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(700, 400));
        centerPanel.setMinimumSize(new Dimension(700, 400));
        centerPanel.setBackground(Color.blue);
        
        JPanel northPanel = new JPanel();   
        northPanel.setPreferredSize(new Dimension(700, 150));
        northPanel.setBorder(outline);
        
        JLabel s = new JLabel("Search Terms: ");
        JButton search = new JButton("Search");
        JRadioButton jB1   = new JRadioButton("All of the Search Terms");
        JRadioButton jB2   = new JRadioButton("Any of the Search Terms");
        JRadioButton jB3   = new JRadioButton("Exact Phrase");
        JTextField inputText = new JTextField("In put here");
        
        northPanel.add(s);
        northPanel.add(search);
        northPanel.add(inputText);
        northPanel.add(jB3);
        northPanel.add(jB2);
        northPanel.add(jB1);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(700, 30));
        bottomPanel.setBackground(Color.GREEN);
        bottomPanel.setBorder(outline);
        bottomPanel.setLayout(new BorderLayout());
        JButton about = new JButton("About");
        JButton main = new JButton("Maintenance");
        bottomPanel.add(main, BorderLayout.WEST);
        bottomPanel.add(about, BorderLayout.EAST);
    
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }     
     
    public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Example().createPlayground();
            }
        });
    }

}
