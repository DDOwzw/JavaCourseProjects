///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P4)
// Files:            (BSTreeSetTester.java)
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * SetTesterADT implementation using a Binary Search Tree (BST) as the data
 * structure.
 *
 * <p>The BST rebalances if a specified threshold is exceeded (explained below).
 * If rebalanceThreshold is non-positive (&lt;=0) then the BST DOES NOT
 * rebalance. It is a basic BStree. If the rebalanceThreshold is positive
 * then the BST does rebalance. It is a BSTreeB where the last B means the
 * tree is balanced.</p>
 *
 * <p>Rebalancing is triggered if the absolute value of the balancedFfactor in
 * any BSTNode is &gt;= to the rebalanceThreshold in its BSTreeSetTester.
 * Rebalancing requires the BST to be completely rebuilt.</p>
 *
 * @author CS367, Zhongwei
 */
public class BSTreeSetTester <K extends Comparable<K>> 
implements SetTesterADT<K>{

	/** Root of this tree */
	BSTNode<K> root;

	/** Number of items in this tree*/
	int numKeys;

	/**
	 * rebalanceThreshold &lt;= 0 DOES NOT REBALANCE (BSTree).<br>
	 * rebalanceThreshold  &gt;0 rebalances the tree (BSTreeB).
	 */
	int rebalanceThreshold;

	/**
	 * True iff tree is balanced, i.e., if rebalanceThreshold is NOT exceeded
	 * by absolute value of balanceFactor in any of the tree's BSTnodes.Note if
	 * rebalanceThreshold is non-positive, isBalanced must be true.
	 */
	boolean isBalanced;
	
	// a List<k> to hold the subSet; Use it as a field to save memorary
	// it will be initialized in the subSet method.
	private List<K> subList;
	/**
	 * Constructs an empty BSTreeSetTester with a given rebalanceThreshold.
	 *
	 * @param rbt the rebalance threshold
	 */


	public BSTreeSetTester(int rbt) {
		//TODO
		this.root = null;
		this.numKeys = 0;

		this.isBalanced = true;
		this.rebalanceThreshold = rbt;
	}

	/**
	 * Add node to binary search tree. Remember to update the height and
	 * balancedFfactor of each node. Also rebalance as needed based on
	 * rebalanceThreshold.
	 *
	 * @param key the key to add into the BST
	 * @throws IllegalArgumentException if the key is null
	 * @throws DuplicateKeyException if the key is a duplicate
	 */
	public void add(K key) {
		//TODO
		if(key == null) throw new IllegalArgumentException();
		root = addHelper(root, key);
		// increase the numKeys
		numKeys ++;
		// check balance 
		if(!isBalanced) rebalance();
	}
	/**
	 * Companion method for add.
	 *
	 * @param n the BSTNode that we will add our key into
	 * @param key the key to add into the BST
	 * @return BSTNode<K> the node adding into the root recursively
	 * @throws DuplicateKeyException if the key is a duplicate
	 */
	private BSTNode<K> addHelper(BSTNode<K> n, K key)
			throws DuplicateKeyException{
		if(n == null){
			return new BSTNode<K>(key);
		}

		else if(n.getKey().equals(key)){
			throw new DuplicateKeyException();
		}
		else if(key.compareTo(n.getKey()) < 0){
			n.setLeftChild(addHelper(n.getLeftChild(),key));
			setAll(n);
			return n;
		}
		else{
			n.setRightChild(addHelper(n.getRightChild(),key));
			setAll(n);
			return n;
		}

	}



	/**
	 * Rebalances the tree by:
	 * 1. Copying all keys in the BST in sorted order into an array.
	 *    Hint: Use your BSTIterator.
	 * 2. Rebuilding the tree from the sorted array of keys.
	 */
	public void rebalance() {
		K[] keys = (K[]) new Comparable[numKeys];
		//TODO
		Iterator<K> ite = iterator();
		for(int i  = 0; i < numKeys; i++){
			keys[i] = ite.next();
		}
		root = sortedArrayToBST(keys,0,numKeys -1);
		isBalanced = true;

	}

	/**
	 * Recursively rebuilds a binary search tree from a sorted array.
	 * Reconstruct the tree in a way similar to how binary search would explore
	 * elements in the sorted array. The middle value in the sorted array will
	 * become the root, the middles of the two remaining halves become the left
	 * and right children of the root, and so on. This can be done recursively.
	 * Remember to update the height and balanceFactor of each node.
	 *
	 * @param keys the sorted array of keys
	 * @param start the first index of the part of the array used
	 * @param stop the last index of the part of the array used
	 * @return root of the new balanced binary search tree
	 */

	private BSTNode<K> sortedArrayToBST(K[] keys, int start, int stop) {
		//TODO
		int mid = (start + stop)/2;
		BSTNode<K> temp = null;
		if(start > stop){
			return null;
		}
		temp = new BSTNode<K>(keys[mid]);

		temp.setLeftChild (sortedArrayToBST(keys, start, mid-1) );
		setAll(temp);
		temp.setRightChild( sortedArrayToBST(keys, mid+1, stop) );
		setAll(temp);

		return temp;

	}

	/**
	 * Returns true iff the key is in the binary search tree.
	 *
	 * @param key the key to search
	 * @return true if the key is in the binary search tree
	 * @throws IllegalArgumentException if key is null
	 */
	public boolean contains(K key) {
		//TODO
		if(key == null) throw new IllegalArgumentException();
		if(root == null) return false;
		return contains(root, key);
	}
	/**
	 * Companion method contains
	 *
	 * @param n the BSTNode we search from
	 * @param key the key to search
	 * @return true if the key is in the binary search tree
	 * 
	 */
	private boolean contains(BSTNode<K> n,K key) {
		if (n == null) {
			return false;
		}
		if (n.getKey().equals(key)) {
			return true;
		}

		if (key.compareTo(n.getKey()) < 0) {
			// key < this node's key; look in left subtree
			return contains(n.getLeftChild(), key);
		}

		else {
			// key > this node's key; look in right subtree
			return contains(n.getRightChild(), key);
		}
	}

	/**
	 * Returns the sorted list of keys in the tree that are in the specified
	 * range (inclusive of minValue, exclusive of maxValue). This can be done
	 * recursively.
	 *
	 * @param minValue the minimum value of the desired range (inclusive)
	 * @param maxValue the maximum value of the desired range (exclusive)
	 * @return the sorted list of keys in the specified range
	 * @throws IllegalArgumentException if either minValue or maxValue is
	 * null, or minValue is larger than maxValue
	 */
	public List<K> subSet(K minValue, K maxValue) {
		//TODO
		if(minValue == null || maxValue == null ||
				minValue.compareTo(maxValue)>0)
			throw new IllegalArgumentException();

		subList = new ArrayList<K>();
		if(numKeys == 0) return subList;
		subList = subSetHelper(root, minValue, maxValue);
		return subList;
	}

	/**
	 * Companion method for subSet.
	 *
	 * @param n the BSTNode that we will search from
	 * @param min the min value subset start with(inclusively)
	 * @param max the max value subset could end(exclusively)
	 * @return ArrayList<K> the node adding into the root recursively
	 * 
	 */
	private List<K> subSetHelper(BSTNode<K> n, K min, K max){

		if(n == null)
			return subList;
		if(n.getKey().compareTo(min) < 0){
			subSetHelper(n.getRightChild(), min, max);
			//System.out.println("key is "+n.getKey()+" and it is less than min.");
		}
		else if(n.getKey().compareTo(max) >= 0){
			subSetHelper(n.getLeftChild(), min, max);
			//System.out.println("key is "+n.getKey()+" and it is greater than or equal to max.");
		}
		else{
			subSetHelper(n.getLeftChild(), min, max);
			subList.add(n.getKey());
			//System.out.println("key is "+n.getKey()+" and add it into the list.");
			subSetHelper(n.getRightChild(), min, max);
		}
		return subList;
	}

	/**
	 * Return an iterator for the binary search tree.
	 * @return the iterator
	 */
	public Iterator<K> iterator() {
		//TODO
		return new BSTIterator<K>(root);
	}

	/**
	 * Clears the tree, i.e., removes all the keys in the tree.
	 */
	public void clear() {
		//TODO
		this.root = null;
		this.numKeys = 0;
		this.isBalanced = true;
	}

	/**
	 * Returns the number of keys in the tree.
	 *
	 * @return the number of keys
	 */
	public int size() {
		//TODO
		return numKeys;
	}

	/**
	 * Displays the top maxNumLevels of the tree. DO NOT CHANGE IT!
	 *
	 * @param maxDisplayLevels from the top of the BST that will be displayed
	 */
	public void displayTree(int maxDisplayLevels) {
		if (rebalanceThreshold > 0) {
			System.out.println("---------------------------" +
					"BSTreeBSet Display-------------------------------");
		} else {
			System.out.println("---------------------------" +
					"BSTreeSet Display--------------------------------");   
		}
		displayTreeHelper(root, 0, maxDisplayLevels);
	}
	/**
	 * Companion method for displayTree
	 *
	 * @param n the BSTNode that we will display
	 * @param maxDisplayLevels from the top of the BST that will be displayed
	 */
	private void displayTreeHelper(BSTNode<K> n, int curDepth,
			int maxDisplayLevels) {
		if(maxDisplayLevels <= curDepth) return;
		if (n == null)
			return;
		for (int i = 0; i < curDepth; i++) {
			System.out.print("|--");
		}
		System.out.println(n.getKey() + "[" + n.getHeight() + "]{" +
				n.getBalanceFactor() + "}");
		displayTreeHelper(n.getLeftChild(), curDepth + 1, maxDisplayLevels);
		displayTreeHelper(n.getRightChild(), curDepth + 1, maxDisplayLevels);
	}

	/**
	 * SetAll method, In here we set the high, balance factor and the isBalanced
	 * for every node.
	 *
	 * @param n the BSTNode that we will set its high, balance factor and 
	 * the isBalanced
	 *
	 */

	private void setAll(BSTNode<K> n){

		if(n.getLeftChild() == null && n.getRightChild() == null){
			// set the height of n;
			n.setHeight(1);
			// set the balance factor of n
			n.setBalanceFactor(0);
		}

		else if(n.getRightChild() == null){
			// set the height of n;
			n.setHeight(n.getLeftChild().getHeight() +1);
			// set the balance factor of n
			n.setBalanceFactor(n.getLeftChild().getHeight());
		}
		else if(n.getLeftChild() == null){

			// set the height of n;
			n.setHeight(n.getRightChild().getHeight() +1);
			// set the balance factor of n
			n.setBalanceFactor(0 - n.getRightChild().getHeight());

		}

		else{
			// set the height of n;
			n.setHeight(Math.max(n.getLeftChild().getHeight() ,
					n.getRightChild().getHeight()) +1);
			// set the balance factor of n
			n.setBalanceFactor(n.getLeftChild().getHeight() - 
					n.getRightChild().getHeight());
		}
		if(rebalanceThreshold > 0 && 
				Math.abs(n.getBalanceFactor()) > rebalanceThreshold){
			isBalanced = false;
		}

	}
}
