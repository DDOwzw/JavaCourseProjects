///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P2)
// Files:            (PacketLinkedListIterator)
// Semester:         (367) Spring 2016
//
// Author:           (Zhongwei Wang)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deb Deppler)
// Lab Section:      (02)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (Ying Li)
// Email:            (li528@wisc.edu)
// CS Login:         (yli)
// Lecturer's Name:  (Deb Deppler)
// Lab Section:      (02)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

//Requirement: Source files for OTHER CLASSES must have a file header comment located at the beginning of the file containing the following (see example):

//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The iterator implementation for PacketLinkedList.
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 3.6
 * @see also
 */

public class PacketLinkedListIterator<T> implements Iterator<T> {
	// field
	private Listnode<T> curr;


	/**
	 * Constructs a PacketLinkedListIterator by passing a head node of
	 * PacketLinkedList.
	 * 
	 * @param head
	 */
	public PacketLinkedListIterator(Listnode<T> head) {
		
		curr = head.getNext();


	}

	/**
	 * Returns the next element in the iteration.
	 * @return the next element in the iteration
	 * @throws NoSuchElementException if the iteration has no more elements
	 */
	@Override
	public T next() {
		
		if(null == curr)
			throw new NoSuchElementException();
		T result = curr.getData();
		curr = curr.getNext();
		return result;
		
	}

	/**
	 * Returns true if the iteration has more elements.
	 * @return true if the iteration has more elements
	 */
	@Override
	public boolean hasNext() {
		if(curr == null){
			return false;
		}
		else if(null == curr.getData()){
			return false;
		}
		return true;
		
	}

	/**
	 * The remove operation is not supported by this iterator
	 * @throws UnsupportedOperationException 
	 * if the remove operation is not supported by this iterator
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
