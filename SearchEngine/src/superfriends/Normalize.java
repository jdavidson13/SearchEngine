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

/**
 *
 * @author John McLain
 */
public class Normalize {
    
    /* Simple utility method which accepts a string value, removes all non-alphanumeric
     * characters, converts them to lowercase, and then returns the modified string. */
    public static String normalize(String s) {
		s = s.replaceAll("[\\d[^\\w\\s]]+", "").replaceAll("(\\s{2,})", " ");
    		s = s.toLowerCase();
		return s;
	}
}
