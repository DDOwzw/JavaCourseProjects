///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (RecipeWrangler)
// Files:            (RecipeWrangler.java)
// Semester:         (CS302) Fall 2015
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deppler)
// Lab Section:      (311)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (Ying Li)
// Email:            (li528@wisc.edu)
// CS Login:         (yli)
// Lecturer's Name:  (Deppler)
// Lab Section:      (315)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * The InvalidInputException class define a new exception under the Exception
 * class.
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 12.12
 * @see also
 */

public class InvalidInputException extends Exception {
	
	/**
	 * InvalidInputException constructor.
	 * Initializes a new InvalidInputException with the message.
	 * 
	 * 
	 * @param message	  -String type, the MSG that would be print to the
	 * console.(Or maybe not :)It depends.)
	 */
	
    public InvalidInputException(String message) {
        super(message);
    }
}