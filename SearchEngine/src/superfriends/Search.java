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

/**
 * @author Jon Davidson
 * @author Chino Caliente
 * @author John McLain
 * @author Shaz Hosein
 */
public class Search {
    
    public static void main( String args[] ) {
        
        // Creates a map, with a String key and a location pair
        // populated from readIndex(), see class Loc for location pair format
        Map<String, List<Location>> map = readIndex();
    }   
    
    /*
    Reads the index file, and parses its contents into a Map
    */
    private static Map readIndex() {
        
        // creates a hashmap of type String(key), List(of Int pairs) to hold the index
        Map<String, List<Location>> map = new HashMap<>();
        
        try {
            // attempts to created a BufferedReader attached to index.txt
            BufferedReader br = new BufferedReader ( new FileReader ( "index.txt" ) );
            
            // grabs the first full line (i.e. 1 entry) from the index
            String line = br.readLine();

            while( line != null ){
                // index.txt is tab delimited, hence the \t tokenizer
                StringTokenizer st = new StringTokenizer( line, "\t" );
                // the first thing on the line is the actual word we've indexed
                String word = st.nextToken();

                // each subsequent word is an integer location pair
                List list = new ArrayList();
                while ( st.hasMoreTokens() ) {
                    String pair = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer ( pair, "," );
                    int x = Integer.parseInt( st2.nextToken() );
                    int y = Integer.parseInt( st2.nextToken() );
                    Location loc = new Location( x, y );
                    list.add(loc);
                }

                // adds the full map entry to our collection
                map.put(word, list);
                
                // and moves on to the next line
                line = br.readLine();
            }
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                "An error occured when attempting to read the index. " +
                "Please rebuild the index by selecting Maintenance.");
            System.out.println("Failed to read index.\n" + ex );
        }
        
        return map;
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