///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (HW5)
// Files:            (State.java)
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


import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wzwfa
 *
 */
public class State<T> {
private ArrayList<T> state;

	/**
	 * 
	 */
	public State() {
		// TODO Auto-generated constructor stub
		state = new ArrayList<T>();
		
	}

	public void add(T t){
		state.add(t);
	}
	
	public int size(){
		return state.size();
	}
	
	public T get(int index){
		return state.get(index);
	}
	
}
