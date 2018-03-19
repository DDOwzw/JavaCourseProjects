///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P3)
// Files:            (Queue.java)
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

//import packages that is needed

/**
 * An ordered collection of items, where items are added to the rear and removed
 * from the front.
 * 
 * @author CS367 & Zhongwei Wang
 */
public class Queue<E> implements QueueADT<E>
{

	// TODO
	// You may use a naive expandable circular array or a chain of listnodes.
	// You may NOT use Java's predefined classes such as ArrayList or
	// LinkedList.
	private static final int INITSIZE = 10;

	// private!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private E[] queue;
	
	// private!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	int start;
	// private!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	int end;
	private int numItems;


	/**
	 * The constructor of the Queue class
	 * 
	 * 
	 */
	public Queue()
	{
		this.queue = (E[])(new Object[INITSIZE]);
		start = 0;
		end = queue.length -1;
		numItems = 0;

	}

	/**
	 * Adds an item to the rear of the queue.
	 * 
	 * @param item
	 *            the item to add to the queue.
	 * @throws IllegalArgumentException
	 *             if item is null.
	 */
	public void enqueue(E item)
	{
		if(item == null) throw new IllegalArgumentException();


		// check for full array and expand if necessary
		if (queue.length == numItems) {

			expandCapacity();
		}

		// use auxiliary method to increment rear index with wraparound
		end = incrementIndex(end);

		// insert new item at rear of queue
		queue[end] = item;
		numItems++;





	}

	/**
	 * Removes an item from the front of the Queue and returns it.
	 * 
	 * @return the front item in the queue.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E dequeue()
	{
		// circular array.
		//if the queue is empty, throws EmptyQueueException
		if(numItems == 0) throw new EmptyQueueException();


		E item = queue[start];
		if(start == queue.length - 1){
			start = 0;
		}else{
			start ++;
		}
		numItems --;

		return item;
	}

	/**
	 * Returns the item at front of the Queue without removing it.
	 * 
	 * @return the front item in the queue.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E peek()
	{
		// if the queue is empty, throws EmptyQueueException
		if(numItems == 0) throw new EmptyQueueException();

		return queue[start];
	}

	/**
	 * Returns true iff the Queue is empty.
	 * 
	 * @return true if queue is empty; otherwise false.
	 */
	public boolean isEmpty()
	{
		if(numItems <= 0)
			return true;
		else
			return false;
	}

	/**
	 * Removes all items in the queue leaving an empty queue.
	 */
	public void clear()
	{
		this.queue = (E[])(new Object[INITSIZE]);
		start = 0;
		end = queue.length -1;
		numItems = 0;

	}

	/**
	 * Returns the number of items in the Queue.
	 * 
	 * @return the size of the queue.
	 */
	public int size()
	{
		return numItems;

	}
	
	/**
	 * Expand the size of the Queue.
	 * 
	 * 
	 */
	private void expandCapacity()
	{
		//expanding should be done using the naive copy-all-elements approach

		E[] tmp = (E[])(new Object[queue.length*2]);
		System.arraycopy(queue, start, tmp, start,
				queue.length-start);
		if (start != 0) {
			System.arraycopy(queue, 0, tmp, queue.length, start);
		}
		queue = tmp;
		end = start + numItems - 1;
		

	}
	
	/**
	 * Returns the new index.
	 * 
	 * @return the new index.
	 */
	private int incrementIndex(int index) {
		if (index == queue.length-1) 
			return 0;
		else 
			return index + 1;
	}

	/*

	// my debug method DELETE IT!
	public String toString(){
		String a = "";
		for(int i =0; i < queue.length; i++){
			a = a + queue[i];
		}
		return a;
	}

	 */

}
