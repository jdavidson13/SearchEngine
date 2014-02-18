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

import java.awt.Container; 
import java.awt.Font;
import java.awt.Insets;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
    
   public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);
 
        JRadioButton rB1 = new JRadioButton("All Search Terms");
        JRadioButton rB2 = new JRadioButton("Any of the Terms");
        JRadioButton rB3 = new JRadioButton("Exact Phrase");
 
        
        JButton b1 = new JButton("About");
        JButton b2 = new JButton("Maintenance");
        JButton b3 = new JButton("Search");
        
        JLabel jlM = new JLabel("Matching Files:");
        JLabel jL = new JLabel("Search Engine");
        jL.setFont(new Font("Courier New", Font.BOLD, 14));
        JLabel jLS = new JLabel("Search Terms: ");
        
        JTextField jF = new JTextField("Enter Text");
        JTextField jFR = new JTextField("[RESULTS]");
        
        pane.add(b1);
        pane.add(b2);
        pane.add(b3);
        pane.add(jlM);
        pane.add(jLS);
        pane.add(jL);
        pane.add(jF);
        pane.add(jFR);
        pane.add(rB1);
        pane.add(rB2);
        pane.add(rB3);
 
        Insets insets = pane.getInsets();
        
        Dimension size = rB1.getPreferredSize();
        
        jL.setBounds(250 + insets.left, 5 + insets.top, size.width, size.height);
        
        jLS.setBounds(125 + insets.left, 45 + insets.top, size.width, size.height);
        
        jlM.setBounds(55 + insets.left, 145 + insets.top, size.width, size.height);
        
        jF.setBounds(225 + insets.left, 45 + insets.top, size.width + 100, size.height);
       
        jFR.setBounds(65 + insets.left, 175 + insets.top, size.width + 400, size.height + 300);
        
        //JBUTTONS
       
        b1.setBounds(525 + insets.left, 550 + insets.top, size.width, size.height);
        b2.setBounds(65 + insets.left, 550 + insets.top, size.width, size.height);
        b3.setBounds(500 + insets.left, 45 + insets.top, size.width, size.height);
        
        // radio buttons
        
        rB1.setBounds(125 + insets.left, 70 + insets.top, size.width, size.height);
                
        rB2.setBounds(250 + insets.left, 70 + insets.top, size.width, size.height);
        
        rB3.setBounds(375 + insets.left, 70 + insets.top, size.width, size.height);
        
        
        
    }
 
    /**
     * Create the GUI and show it.
     */
    private static void createAndInvokeGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Search Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Size and display the window.
        Insets insets = frame.getInsets();
        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndInvokeGUI();
            }
        });
    }

}
