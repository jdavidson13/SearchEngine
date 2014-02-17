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

import javax.swing.*;

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
    
   public Main() {
	
		JFrame f= new JFrame("Search Engine");
	
		f.setSize(new Dimension(700, 650));
		
		f.setLocationRelativeTo(null);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setLayout(new BorderLayout());
		
		//Top panel
		
		JPanel top = new JPanel();
		
		top.setLayout(new BorderLayout());
		
		top.setBackground(Color.green);
		
		top.setPreferredSize(new Dimension(700, 200));
		
		//SubPanel top
		JPanel tP = new JPanel();
		
		tP.setLayout(new BorderLayout());
		
		tP.setPreferredSize(new Dimension(550, 50));
		
		JLabel search = new JLabel("Search Engine");
		
		search.setFont(new Font("Serif", Font.BOLD, 18));
		
		tP.add(search, BorderLayout.NORTH);
		
		top.add(tP, BorderLayout.NORTH);
		
		//SubPanel for Search Bar
		JPanel tPanel = new JPanel();
		
		tPanel.setLayout(new BorderLayout());
		
		JTextField sInput = new JTextField("Enter Text");
		
		sInput.setPreferredSize(new Dimension(40, 40));
		
		tPanel.add(sInput, BorderLayout.CENTER);
		
		top.add(tPanel, BorderLayout.CENTER);
		
		//Sub panel for radioButtons
		JPanel radioPanel = new JPanel (new FlowLayout (FlowLayout.CENTER));

        JRadioButton button1 = new JRadioButton ("Button 1");
        JRadioButton button2 = new JRadioButton ("Button 2");
        JRadioButton button3 = new JRadioButton ("Button 3");

        ButtonGroup group = new ButtonGroup ();
        group.add (button1);
        group.add (button2);
		
        radioPanel.add (button1);
        radioPanel.add (button2);
        radioPanel.add (button3);
        
        radioPanel.setPreferredSize(new Dimension(100, 50));
        
        top.add (radioPanel, BorderLayout.SOUTH);
        
        //Right sub Panel
        JPanel rP = new JPanel();
        
        JButton s = new JButton("Search");
        
        rP.setBackground(Color.black);
        
        rP.setPreferredSize(new Dimension(300, 300));
        
        rP.add(s);
        
        top.add(rP, BorderLayout.EAST);
        
        //Left SubPanel
        JPanel lP = new JPanel();
        
        lP.setBackground(Color.yellow);
        
        lP.setPreferredSize(new Dimension (50, 50));
        
        JLabel s2 = new JLabel("Search Engine");
		
		s2.setFont(new Font("Serif", Font.PLAIN, 14));
        
		lP.add(s2);
		
		top.add(lP, BorderLayout.WEST);
        
		//Center Panel
		
		JPanel center = new JPanel();
		
		JTextField input = new JTextField("Results", 50);
		
		input.setPreferredSize(new Dimension (700, 500));
		
		center.add(input);
		
		//Bottom Panel
			
		JPanel bottom = new JPanel();
		
		bottom.setLayout(new FlowLayout());
		
		JButton main = new JButton("Maintenance");
		
		JButton about = new JButton("About");
		
		bottom.setBackground(Color.red);
		
		bottom.add(main);
		
		bottom.add(about);
		
		//Add Panels
		
		f.add(center, BorderLayout.CENTER);
		
		f.add(top, BorderLayout.NORTH);
		
		f.add(bottom, BorderLayout.SOUTH);
		
		f.pack();
		
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
				
		
		
        SwingUtilities.invokeLater(new Runnable() {

            @Override    
            public void run() {
            
            	Main form = new Main();
            }
        });

	}

}
