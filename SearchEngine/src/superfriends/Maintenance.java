/*
 * Project:         Java II (COP 2805) Search Engine
 * Team:            Super Friends
 * Authors:         Jon Davidson
 *                  Thanh J. Duong
 *                  John McLain
 *                  Shaz Hosein        
 *
 * Date Started:    January 29th, 2014
 */

package superfriends;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Jon Davidson
 * @author Thanh J. Duong
 * @author John McLain
 * @author Shaz Hosein
 */

public class Maintenance extends JFrame implements ActionListener{
 
	private JLabel labelFilesIndexed = new JLabel();
	private DefaultTableModel model = new DefaultTableModel();
	private JTable tableFileList = new JTable(model);

	/* Initialize the Maintenance window components and their properties. */
	public void initialize(Container pane) {
 
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    JLabel header = new JLabel("Search Engine - Index Maintenance");
		    header.setFont(new Font("Serif", Font.BOLD, 16));
		    c.insets = new Insets(0, 15, 0, 15);
		    c.gridwidth = 3;
		    c.gridx = 0;
		    c.gridy = 0;
		    c.weightx = 1;
		    c.weighty = 1;
		    pane.add(header, c);
		    
			model.addColumn("File Path:");
			model.addColumn("Last Modified:");   
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
		    buttonAddFile.addActionListener(this);
	 
	    JButton buttonRebuild = new JButton("Rebuild Out-of-date");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.CENTER;
	    	c.insets = new Insets(5, 0, 5, 0);
	    	c.gridwidth = 1;
		    c.gridx = 1;
		    c.gridy = 2;
		    pane.add(buttonRebuild, c);
		    buttonRebuild.setMnemonic(KeyEvent.VK_O);
		    buttonRebuild.addActionListener(this);
	 
	    JButton buttonRemoveFile = new JButton("Remove Selected Files");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.EAST;
	    	c.insets = new Insets(5, 0, 5, 15);
	    	c.gridwidth = 1;
		    c.gridx = 2;
		    c.gridy = 2;
		    pane.add(buttonRemoveFile, c);
		    buttonRemoveFile.setMnemonic(KeyEvent.VK_R);
		    buttonRemoveFile.addActionListener(this);
	
	    JButton buttonResetWindows = new JButton("Reset Windows");
	    	c.fill = GridBagConstraints.NONE;
	    	c.anchor = GridBagConstraints.WEST;
	    	c.insets = new Insets(5, 15, 5, 0);
	    	c.gridwidth = 1;
		    c.gridx = 0;
		    c.gridy = 3;
		    pane.add(buttonResetWindows, c);
		    buttonResetWindows.setMnemonic(KeyEvent.VK_W);
		    buttonResetWindows.addActionListener(this);
	    
	    int filesIndexed = 0; // Placeholder for getFilesIndexed method.
	    	//JLabel labelFilesIndexed = new JLabel();
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
		    
		updateFileTable();
		updateFileCount();
	}
    
    /* Initialize and run the Search Engine Maintenance window. */
    public Maintenance() {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	initialize(getContentPane());
            	setTitle("Search Engine Maintenance");
            	setSize(600,570);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setResizable(true);
                setLocationRelativeTo(null);
            }
        });	
    }

	@Override /* Event handling for Maintenance window components. */
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		
		/* Event handling for the 'Add File' button; Prompts the user to select
		 * a file, then adds the file to the table of files to index. */
		if(name.equals("Add File...")){
			System.out.println("Add File button has been clicked.");
			
			final JFileChooser file = new JFileChooser();
    		int response = file.showOpenDialog(rootPane);
    		
    		if (response == JFileChooser.APPROVE_OPTION) {
    			System.out.println("Added file to list.");
    			File test = new File(file.getSelectedFile().toString());

    			model.addRow(new Object[] { test.getAbsolutePath(),
    					new Date(test.lastModified())});
    		}
    		
    		else { 
    			JOptionPane.showMessageDialog(null,
                        "The open operation was cancelled.");
    		}
    		
    		updateFileCount();
    		writeFileList();
		}
		
		/* TODO in part 3 of the project. */
		else if(name.equals("Rebuild Out-of-date")) {
			System.out.println("Rebuild button has been clicked."); 
		}
		
		/* Event handling for the 'Remove Files' button; Prompts the user to
		 * confirm deletion of the currently selected table rows and removes
		 * them from the current file list. */
		else if(name.equals("Remove Selected Files")) {
			System.out.println("Remove File button has been clicked."); 
			
			if (tableFileList.getRowCount() > 0) {
				int dialogueConfirmRemove = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to remove the currently selected"
								+ " files?", "", 0, 3);
				
				if (dialogueConfirmRemove == 0) {
					int[] rows = tableFileList.getSelectedRows();
					for (int i = rows.length - 1; i >= 0; i--) {
						model.removeRow(rows[i]);
					}
					updateFileCount();
					writeFileList();
				}
			}

			else {
				JOptionPane.showMessageDialog(null,
                    "There are currently no files to remove.");
			}
		}
		
		
		/* Resets the positions and sizes of both the main and maintenance
		 * windows to their default values. */
		else if(name.equals("Reset Windows")) {
			System.out.println("Reset Windows has been clicked.");
			
			//Reset maintenance window
			setSize(getPreferredSize());
			setLocationRelativeTo(null);
			
			// Reset main window
			Frame[] main = Main.getFrames();
			main[0].setSize(main[0].getPreferredSize());;
			main[0].setLocationRelativeTo(null);
		}
	}
	
	/* Updates the counter for the current number of files being indexed. */
	private void updateFileCount() {
		labelFilesIndexed.setText("Number of files indexed: "
				  + tableFileList.getRowCount());
	}
	
	/* Writes the current table of indexed files to disk to preserve the file
	 * list between sessions. */
	private void writeFileList() {
		
		System.out.println("Attempting to write file list to disk...");
		
		for (int i = 0; i < tableFileList.getRowCount(); i++) {
			System.out.println(tableFileList.getValueAt(i, 0) + "\t"
				+ tableFileList.getValueAt(i, 1));
		}
		try {
			PrintWriter outputStream = new PrintWriter("filelist.txt", "UTF-8");
			for (int i = 0; i < tableFileList.getRowCount(); i++) {
				outputStream.println(tableFileList.getValueAt(i, 0) + "\t"
					+ tableFileList.getValueAt(i, 1));
			}
			outputStream.close();
			System.out.println("Write operation successful.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
                    "An error occured when attempting to write the file list"
                    + "contents to disk: the specified file was not found.");
			System.out.println("Write operation failed!");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
                    "An error occured when attempting to write the file list"
                    + "contents to disk: UTF-8 encoding not supported.");
			System.out.println("Write operation failed!");
		}
	}
	
	/* Reads and populates the list of files in the maintenance window
     * from the file index. */
	private void updateFileTable() {
		
		try {
			File file = new File("filelist.txt");
			Scanner getFileParams = new Scanner(file);
			while (getFileParams.hasNextLine() == true) {
				String buffer = getFileParams.nextLine();
				String[] ar = buffer.split("\t");
				model.addRow(new Object[] { ar[0], ar[1] });
			}

		} catch (FileNotFoundException e) {
			//e.printStackTrace();
		}
	}
}
