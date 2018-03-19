///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P4)
// Files:            (BSTIterator.java)
// Semester:         (CS367) Spring 2016
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deppler)
// Lab Section:      (Lecture 2)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     ()
// Email:            ()
// CS Login:         ()
// Lecturer's Name:  ()
// Lab Section:      ()
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


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * The Iterator for Binary Search Tree (BST) that is built using Java's Stack
 * class. This iterator steps through the items BST using an INORDER traversal.
 *
 * @author CS367, Zhongwei
 */
public class BSTIterator<K> implements Iterator<K> {

	/** Stack to track where the iterator is in the BST*/
	Stack<BSTNode<K>> stack;
	private BSTNode<K> curr;
	/**
	 * Constructs the iterator so that it is initially at the smallest
	 * value in the set. Hint: Go to farthest left node and push each node
	 * onto the stack while stepping down the BST to get there.
	 *
	 * @param n the root node of the BST
	 */
	public BSTIterator(BSTNode<K> n){
		//TODO
		stack = new Stack<BSTNode<K>>();
		curr = n;
		while(curr != null){
			stack.add(curr);
			curr = curr.getLeftChild();
		}

	}

	/**
	 * Returns true iff the iterator has more items.
	 *
	 * @return true iff the iterator has more items
	 */
	public boolean hasNext() {
		//TODO
		return !(stack.isEmpty() && curr == null);
	}

	/**
	 * Returns the next item in the iteration.
	 *
	 * @return the next item in the iteration
	 * @throws NoSuchElementException if the iterator has no more items
	 */
	public K next() {
		//TODO
		if(!hasNext()) throw new NoSuchElementException();
		BSTNode<K> key = stack.pop();

		curr = key.getRightChild();

		while(curr != null){
			stack.add(curr);
			curr = curr.getLeftChild();
		}

		return key.getKey();
	}

	/**
	 * Not Supported
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}


}
