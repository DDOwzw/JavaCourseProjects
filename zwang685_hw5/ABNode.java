///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (HW5)
// Files:            (ABNode.java)
// Semester:         (CS540) Fall 2016
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Jerry Zhu)
// Lab Section:      (Lecture 1)
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
 * @author wzwfa
 *
 */
public class ABNode {
	
	private char XO;
	private int PosiX, PosiY;

	/**
	 * 
	 */
	public ABNode(int x, int y, char c) {
		// TODO Auto-generated constructor stub
		this.PosiX = x;
		this.PosiY = y;
		this.XO = c;
		
	}

	public char getXO(){
		return this.XO;
	}

	public void setXO(char c){
		this.XO = c;
	}
}
