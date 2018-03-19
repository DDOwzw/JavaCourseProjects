///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P3)
// Files:            (PriorityQueue.java)
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
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PriorityQueue implemented as a Binary Heap backed by an array. Implements
 * QueueADT. Each entry in the PriorityQueue is of type PriorityQueueNode<E>.
 * First element is array[1]
 * 
 * @author CS367 & Zhongwei Wang
 *
 * @param <E>
 */
public class PriorityQueue<E> implements QueueADT<PriorityQueueItem<E>>
{   //default is 100
	private final int DEFAULT_CAPACITY = 100;
	// Number of elements in heap
	private int currentSize;
	/**
	 * The heap array. First element is array[1]
	 */
	private PriorityQueueItem<E>[] array;






	/**
	 * Construct an empty PriorityQueue.
	 */
	public PriorityQueue()
	{
		currentSize = 0;
		// the below code initializes the array.. similar code used for
		// expanding.
		array = (PriorityQueueItem<E>[]) Array.newInstance(
				PriorityQueueItem.class, DEFAULT_CAPACITY + 1);
	}

	/**
	 * Copy constructor
	 * 
	 * @param pq
	 *            PriorityQueue object to be copied
	 */
	public PriorityQueue(PriorityQueue<E> pq)
	{
		this.currentSize = pq.currentSize;
		this.array = Arrays.copyOf(pq.array, currentSize + 1);
	}

	/**
	 * Adds an item to this PriorityQueue. If array is full, double the array
	 * size.
	 * 
	 * @param item
	 *            object of type PriorityQueueItem<E>.
	 */
	@Override
	public void enqueue(PriorityQueueItem<E> item)
	{
		// TODO write appropriate code
		// Check if array is full - double if necessary
		if(array.length -1 == currentSize)
			doubleArray();

		// Check all nodes and find if one with equal priority exists.
		// Add to the existing node's list if it does
		int index = 0;
		for(int i = 1; i<= currentSize; i++){
			if(item.getPriority() == array[i].getPriority()){
				index = i;
			}
		}

		if(index == 0){
			array[currentSize +1] = item;
			currentSize ++;
		}
		else{

			while(!item.getList().isEmpty())
				array[index].add(item.getList().dequeue());


		}

		// Else create new node with value added to list and percolate it up
		buildHeap();



	}

	/**
	 * Returns the number of items in this PriorityQueue.
	 * 
	 * @return the number of items in this PriorityQueue.
	 */
	public int size()
	{
		// TODO write appropriate code
		return currentSize;
	}

	/**
	 * Returns a PriorityQueueIterator. The iterator should return the
	 * PriorityQueueItems in order of decreasing priority.
	 * 
	 * @return iterator over the elements in this PriorityQueue
	 */
	public Iterator<PriorityQueueItem<E>> iterator()
	{
		// TODO write appropriate code - see PriortyQueueIterator constructor
		// Reconsider!!!
		return new PriorityQueueIterator<E>(this);
	}

	/**
	 * Returns the largest item in the priority queue.
	 * 
	 * @return the largest priority item.
	 * @throws NoSuchElementException
	 *             if empty.
	 */
	@Override
	public PriorityQueueItem<E> peek()
	{
		// TODO fill in appropriate code, replace default return statement

		if(currentSize == 0){
			throw new NoSuchElementException();
		}

		return array[1];
	}

	/**
	 * Removes and returns the largest item in the priority queue. Switch last
	 * element with removed element, and percolate down.
	 * 
	 * @return the largest item.
	 * @throws NoSuchElementException
	 *             if empty.
	 */
	@Override
	public PriorityQueueItem<E> dequeue()
	{
		// TODO

		if (currentSize <= 0) throw new NoSuchElementException();
		// Remove first element
		PriorityQueueItem<E> temp = array[1];
		array[1] = array[currentSize];
		// Replace with last element, percolate down
		currentSize --;

		buildHeap();

		return temp;
	}

	/**
	 * Heapify Establish heap order property from an arbitrary arrangement of
	 * items. ie, initial array that does not satisfy heap property. Runs in
	 * linear time.
	 */
	private void buildHeap()
	{
		for (int i = currentSize / 2;i > 0;i--)
			percolateDown(i);
	}

	/**
	 * Make this PriorityQueue empty.
	 */
	public void clear()
	{
		// TODO write appropriate code

		// Reconsider!!!!!!!
		currentSize = 0;
		// the below code initializes the array.. similar code used for
		// expanding.
		array = (PriorityQueueItem<E>[]) Array.newInstance(
				PriorityQueueItem.class, DEFAULT_CAPACITY + 1);

	}

	/**
	 * Internal method to percolate down in the heap. <a
	 * href="https://en.wikipedia.org/wiki/Binary_heap#Extract">Wiki</a>}
	 * 
	 * @param hole
	 *            the index at which the percolate begins.
	 */
	private void percolateDown(int hole)
	{
		// TODO
		while (2*hole <= currentSize) {
			int left = 2*hole;
			int right = left + 1;
			int target;
			if (right <= currentSize &&
					array[right].getPriority() > array[left].getPriority())
				target = right;
			else
				target = left;
			if (array[target].getPriority() > array[hole].getPriority()) {

				PriorityQueueItem<E> temp = array[hole];

				array[hole] = array[target];
				array[target] = temp;
				hole = target;
			}
			else
				break;
		}


	}


	/**
	 * Internal method to expand array.
	 */
	private void doubleArray()
	{
		PriorityQueueItem<E>[] newArray;

		newArray = (PriorityQueueItem<E>[]) Array.newInstance(
				PriorityQueueItem.class, array.length * 2);

		for (int i = 0;i < array.length;i++)
			newArray[i] = array[i];
		array = newArray;
	}

	@Override
	/**
	 * Whether the PQ is empty.
	 * 
	 * @return true if the PQ is empty.
	 */
	public boolean isEmpty()
	{
		if(currentSize == 0)
			return true;
		return false;
	}


	/*

	// For debug!!! DELETE IT!!!
	public String toString(){
		String a ="";
		for(int i = 1; i <= currentSize; i++)
			a =  a+ array[i].toString();
		return a;
	}

	 */

}
