///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P2)
// Files:            (PacketLinkedList)
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

/**
 * A Single-linked linkedlist with a "head" header node (no data in the node), but
 * without a tail node. It implements ListADT<E> and returns
 * PacketLinkedListIterator when requiring a iterator.
 * 
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 3.6
 * @see also
 */
public class PacketLinkedList<E> implements ListADT<E> {
	// fields to hold the variables that will be initialized in the constructor
	private Listnode<E> head;
	private int numItems;
	/**
	 * Constructs a empty PacketLinkedList
	 */
	public PacketLinkedList() {

		head = new Listnode<E>(null);
		numItems = 0;
	}

	@Override
	/**
	 * Add a new element to the end of the list.
	 * @param item; Type E, the one that will be added into the list.
	 */
	public void add(E item) {

		if(null == item)
			throw new IllegalArgumentException();
		Listnode<E> newNode= new Listnode<E>(item);
		if(numItems == 0){
			head.setNext(newNode);

			numItems ++;
		}
		else{
			Listnode<E> curr = head;
			while(null != curr.getNext()){
				curr = curr.getNext();
			}
			curr.setNext(newNode);
			numItems ++;
		}
	}

	@Override
	/**
	 * Add a new element to the special position of the list.
	 * @param pos; type int, the pos of the list.
	 * @param item; Type E, the one that will be added into the list.
	 */
	public void add(int pos, E item) {

		if(null == item)
			throw new IllegalArgumentException();
		if(pos < 0 || pos > numItems){
			throw new IndexOutOfBoundsException();
		}
		Listnode<E> newNode = new Listnode<E>(item);
		Listnode<E> temp;
		Listnode<E> curr = head;
		if(pos == 0){
			temp = head.getNext();
			head.setNext(newNode);
			newNode.setNext(temp);
			numItems ++;
		}else{
			for(int i=0; i < pos ; i++){
				curr = curr.getNext();
			}
			temp = curr.getNext();
			newNode.setNext(temp);
			curr.setNext(newNode);
			numItems ++;
		}
	}

	@Override
	/**
	 * whether the item is in the list
	 * @return boolean whether the item is in the list
	 * @param item; Type E, the one that will be checked.
	 */
	public boolean contains(E item) {

		if(item==null) {
			return false;
		}
		PacketLinkedListIterator<E> itr = iterator();
		while(itr.hasNext()){
			if(item.equals(itr.next())){
				return true;
			}
		}
		return false;
		
		
		
		/*Listnode<E> curr = head;
		if(numItems==0)
			return false;
		if(item.equals(curr.getData())){
			return true;
		}else{
			for(int i=0; i< numItems -1; i++)
			{
				curr=curr.getNext();
				if(curr.getData().equals(item)) return true;
			}
			return false;
		}*/

	}

	@Override
	/**
	 * get the element from the pos in the list
	 * @return E  the element in this pos
	 * @param pos; Type int, the special position in the list.
	 */
	public E get(int pos) {

		if(pos < 0 || pos > numItems - 1){
			throw new IndexOutOfBoundsException();
		}
		Listnode<E> curr = head;
		for(int i = 0; i <= pos; i++){
			curr = curr.getNext();
		}
		return curr.getData();
		//return null;
	}

	@Override
	/**
	 * Whether the list is empty
	 * @return boolean  whether the list is empty.
	 * @param 
	 */
	public boolean isEmpty() {

		return numItems == 0;

	}

	@Override
	/**
	 * Remove an element from a special pos of the list.
	 * 
	 * @Returns: the item at position pos
	 * @param pos; type int, the pos in the list
	 */
	public E remove(int pos) {

		if(pos < 0 || pos > numItems - 1){
			throw new IndexOutOfBoundsException();
		}
		Listnode<E> temp, curr = head;
		if(pos == 0){
			temp = head.getNext();
			head.setNext(head.getNext().getNext());
		}else if(pos == numItems-1){
			for(int i = 0; i < pos ; i++){
				curr = curr.getNext();
			}temp = curr.getNext();
			curr.setNext(null);
		}
		else{
			for(int i = 0; i < pos ; i++){
				curr = curr.getNext();
			}temp = curr.getNext();
			curr.setNext(temp.getNext());
		}

		numItems --;
		return temp.getData();

	}

	@Override
	/**
	 * @Return  the size of the list
	 * @param
	 */
	public int size() {

		return numItems;

	}

	@Override
	/**
	 * Iterator method.
	 * Could generate an iterator for other method to use.
	 * @return the PacketLinkedListIterator<E>; <-- the iterator itself!
	 * @param 
	 */
	public PacketLinkedListIterator<E> iterator() {

		return new PacketLinkedListIterator<E>(head);

	}

}
