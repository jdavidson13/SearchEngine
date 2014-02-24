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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Jon Davidson
 * @author Chino Caliente
 * @author John McLain
 * @author Shaz Hosein
 */

public class Maintenance extends JFrame implements ActionListener{
 
	/* Initialize the Maintenance window components and their properties. */
	private static void addComponentsToPane(Container pane) {
 
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    JLabel header = new JLabel("Search Engine - Index Maintenance");
		    header.setFont(new Font("Serif", Font.BOLD, 24));
		    c.insets = new Insets(0, 15, 0, 15);
		    c.gridwidth = 3;
		    c.gridx = 0;
		    c.gridy = 0;
		    c.weightx = 1;
		    c.weighty = 1;
		    pane.add(header, c);
	    
	    String[] columnNames = {"File Name", "Status"};
	    Object[][] data = {};
	    JTable tableFileList = new JTable(data, columnNames);
		    tableFileList.setFillsViewportHeight(true);
		    JScrollPane scrollPane = new JScrollPane(tableFileList);
		    c.fill = GridBagConstraints.BOTH;
		    c.insets = new Insets(0, 15, 0, 15);
		    c.gridwidth = 3;
		    c.gridx = 0;
		    c.gridy = 1;
		    pane.add(scrollPane, c);
	    
	    JButton buttonAddFile = new JButton("Add File...");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.WEST;
	    	c.insets = new Insets(5, 15, 5, 0);
	    	c.gridwidth = 1;
		    c.gridx = 0;
		    c.gridy = 2;
		    pane.add(buttonAddFile, c);
		    buttonAddFile.setMnemonic(KeyEvent.VK_A);
		    buttonAddFile.addActionListener(null);
	 
	    JButton buttonRebuild = new JButton("Rebuild Out-of-date");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.CENTER;
	    	c.insets = new Insets(5, 0, 5, 0);
	    	c.gridwidth = 1;
		    c.gridx = 1;
		    c.gridy = 2;
		    pane.add(buttonRebuild, c);
		    buttonRebuild.setMnemonic(KeyEvent.VK_O);
		    buttonRebuild.addActionListener(null);
	 
	    JButton buttonRemoveFile = new JButton("Remove Selected Files");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.EAST;
	    	c.insets = new Insets(5, 0, 5, 15);
	    	c.gridwidth = 1;
		    c.gridx = 2;
		    c.gridy = 2;
		    pane.add(buttonRemoveFile, c);
		    buttonRemoveFile.setMnemonic(KeyEvent.VK_R);
		    buttonRemoveFile.addActionListener(null);
	
	    JButton buttonResetWindows = new JButton("Reset Windows");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.WEST;
	    	c.insets = new Insets(5, 15, 5, 0);
	    	c.gridwidth = 1;
		    c.gridx = 0;
		    c.gridy = 3;
		    pane.add(buttonResetWindows, c);
		    buttonResetWindows.setMnemonic(KeyEvent.VK_W);
		    buttonResetWindows.addActionListener(null);
	    
	    int filesIndexed = 0; // Placeholder for getFilesIndexed method.
	    JLabel labelFilesIndexed = new JLabel();
		    labelFilesIndexed.setText("Number of files indexed: "
		    						  + filesIndexed);
		    c.fill = GridBagConstraints.NONE;
		    c.anchor = GridBagConstraints.CENTER;
		    c.insets = new Insets(5, 0, 5, 0);
		    c.gridwidth = 1;
		    c.gridx = 1;
		    c.gridy = 3;
		    pane.add(labelFilesIndexed, c);
	    
	    double versionNumber = 1.0; // Placeholder for getVersionNumber method.
	    JLabel labelVersionNumber = new JLabel();
		    labelVersionNumber.setText("Search Engine version: "
		    			               + versionNumber);
		    c.fill = GridBagConstraints.NONE;
		    c.anchor = GridBagConstraints.EAST;
		    c.insets = new Insets(5, 0, 5, 15);
		    c.gridwidth = 1;
		    c.gridx = 2;
		    c.gridy = 3;
		    pane.add(labelVersionNumber, c);    
    }
 
    /* Create and show Maintenance window. */
    private static void createAndShowGUI() {
        
        JFrame frame = new JFrame("Search Engine Maintenance");
        
        addComponentsToPane(frame.getContentPane());
 
        frame.pack();
        frame.setSize(600,570);
        frame.setResizable(true);
        frame.setVisible(true);

    }
    
    /* Initialize and run the Search Engine Maintenance window. */
    public static void initialize() {
        
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

	@Override /* Event handling for Maintenance window components. */
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		
		if(name.equals("Add File...")){
			System.out.println("Add File button has been clicked."); 
		}
		
		else if(name.equals("Rebuild Out-of-date")) {
			System.out.println("Rebuild button has been clicked."); 
		}
		
		else if(name.equals("Remove Selected Files")) {
			System.out.println("Remove File button has been clicked."); 
		}
		
		else if(name.equals("Reset Windows")) {
			System.out.println("Reset Windows has been clicked."); 
		}

	}

}
