///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P3)
// Files:            (PriorityQueueItem.java)
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

/**
 * 
 * Class to represent object stored at every entry in the PriorityQueue. ie, The
 * internal node structure of {@link PriorityQueue}
 * 
 * @author CS367 & Zhongwei Wang
 *
 * @param <E>
 *            the generic type of the data content stored in the list
 */
public class PriorityQueueItem<E> implements Comparable<PriorityQueueItem<E>>
{
	// fields
	private int priority;
	private Queue<E> queue;

	
	/** 
	 * The constructor of the class
	 *
	 * @param priority
	 *            the priority of the item
	 */
	public PriorityQueueItem(int priority)
	{
		// TODO initialize variables
		this.priority = priority;
		queue = new Queue<E>();

	}
	/** 
	 * Get Priority method.
	 * Return the Priority of the item.
	 *
	 * @return priority
	 *            the priority of the item
	 */
	public int getPriority()
	{
		// TODO
		return priority;
	}
	/** 
	 * Get List method.
	 * Return the queue.
	 *
	 * @return queue<E>
	 *            the queue of items in this special "item".
	 */
	public Queue<E> getList()
	{
		// TODO
		return queue;
	}

	/**
	 * Add an item to the queue of this PriorityQueueItem object
	 * 
	 * @param item
	 *            item to add to the queue
	 */
	public void add(E item)
	{
		// TODO
		queue.enqueue(item);
	}

	/**
	 * Compares this Node to another node on basis of priority
	 * 
	 * @param o
	 *            other node to compare to
	 * @return -1 if this node's priority is lesser, +1 if this nodes priority
	 *         is higher after, else 0 if priorities are the same.
	 */
	@Override
	public int compareTo(PriorityQueueItem<E> o)
	{
		// TODO
		if(o.priority > priority)
			return -1;
		else if(o.priority < priority)
			return 1;
		return 0;
	}


	/*

	// For debug!!! DELETE IT!!!
	public String toString(){
		String a = "PQI =";
		Queue<E> temp = queue;

		for(int i = 0; i < queue.size(); i++){
			a = a+ temp.queue[i];
		}

		return a;
	}

	 */
}
