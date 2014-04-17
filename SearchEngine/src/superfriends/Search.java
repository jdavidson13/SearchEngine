/*
 * Project:         Java II (COP 2805) Search Engine
 * Team:            Super Friends
 * Authors:         Jon Davidson
 *                  Thanh J. Duong A.K.A. Chino Caliente
 *                  John McLain
 *                  Shaz Hosein        
 *
 * File Created:    April 17th, 2014
 */

package superfriends;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

import static superfriends.Normalize.normalize;

/**
 * @author Jon Davidson
 * @author Chino Caliente
 * @author John McLain
 * @author Shaz Hosein
 */
public class Search {
    
    /*
    Main entry point from Main class
    */
    public static List Query ( String s ) {
        Map<String,List<Integer>> map = readIndex();
        Map<Integer,String> files = readFiles();
        
        List<String> results = new ArrayList();
        Set<Integer> set = new TreeSet();
        
        // normalizes the text to all lowercase, no special characters
        s = normalize( s );
        
        // adds each search term to a list, where they can be managed individually
        StringTokenizer st = new StringTokenizer( s, " " );
        
        // checks for presence of each word
        while ( st.hasMoreTokens() ) {
            String word = st.nextToken();
            
            // pulls the list of files containing each word
            if ( map.containsKey(word) ) {
                List<Integer> list = map.get(word);
                System.out.println( list.toString() + list.size() );
                StringTokenizer st2 = new StringTokenizer( list.toString(), "[,] " );
                while ( st2.hasMoreTokens() ) {
                    set.add( Integer.parseInt( st2.nextToken() ) );
                }
            }
        }
                
        // makes a list of file paths, based on their index keys
        Iterator<Integer> iterator = set.iterator();
        while ( iterator.hasNext() ) {
            results.add( files.get( iterator.next() ) );
        }
        
        return results;
    }
    
    /*
    Reads the index file, and parses its contents into a Map
    */
    private static Map readIndex() {
        
        // this will hold the index
        Map<String,List<Integer>> map = new TreeMap();
        
        try {
            
            BufferedReader br = new BufferedReader ( new FileReader ( "index.txt" ) );
            String line = br.readLine();

            while( line != null ){
                
                StringTokenizer st = new StringTokenizer( line, "\t" );
                
                // the first thing on each line is our key word (searchable term)
                String word = st.nextToken();

                // each subsequent word is an integer location pair which
                // we're making into a List<Location>
                List list = new ArrayList();
                while ( st.hasMoreTokens() ) {
                    String pair = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer ( pair, "," );
                    int x = Integer.parseInt( st2.nextToken() );
                    // int y = Integer.parseInt( st2.nextToken() );
                    // Location loc = new Location( x, y );
                    list.add(x); //list.add(loc);
                }

                map.put(word, list);    // adds the full map entry to our collection
                line = br.readLine();   // and moves on to the next one...
            }
            
            return map;
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "An error occured when attempting to read the index. " +
                "Please rebuild the index by selecting Maintenance.");
            System.out.println("Failed to read index.\n" + ex );
        }
        
        return null;
    }
    
    /*
    Reads filelist.txt and grabs the first two fields, index number and file path
    */
    private static Map readFiles() {
        
        Map<Integer,String> map = new TreeMap();
        
        try {
            BufferedReader br = new BufferedReader ( new FileReader ( "filelist.txt" ) );
            String line = br.readLine();
            
            while( line != null ){
                
                StringTokenizer st = new StringTokenizer( line, "," );
                
                int id = Integer.parseInt( st.nextToken() );
                String path = st.nextToken();
                map.put( id, path );

                line = br.readLine();
            }
            
            return map;
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "An error occured when attempting to read the index. " +
                "Please rebuild the index by selecting Maintenance.");
            System.out.println("Failed to read index.\n" + ex );
        }
        
        return null;
    }
}

/*
The Location class simply holds coordinate pairs to facilitate word location
within indexed files. The x variable refers to the file number, and the y
value indicates the location within the document.
*/
class Location {
    int x, y;
    
    public Location ( int x, int y ) {
        this.x = x;
        this.y = y;
    }
}