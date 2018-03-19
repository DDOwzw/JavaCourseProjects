///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P5)
// Files:            (Neighbor.java)
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

/** This is the class that defines the type Neighbor!
 *  Neighbor is the edge in the graph, with a cost.
 * @author Zhongwei
 *
 */
public class Neighbor implements Comparable<Neighbor>{

	// fields are here:
	private int cost;
	private GraphNode neighbor;

	/** Constructor
	 * A neighbor is added to an existing GraphNode by creating an instance of 
	 * Neighbor that stores the neighbor and the cost to reach that neighbor.
	 * @param cost- The cost to reach this neighbor.
	 * @param neighbor- The neighbor node being reached by this edge.
	 */
	public Neighbor(int cost, GraphNode neighbor){
		this.cost = cost;
		this.neighbor = neighbor;
	}

	/**
	 * Returns the Neighbor (node) that is at the other end of "this" node's 
	 * edge.
	 * @return
	 * the neighbor node itself.
	 */

	public GraphNode getNeighborNode() {
		
		return neighbor;
	}
	/**
	 * Returns the cost of travelling this edge to get to the Neighbor at the 
	 * other end of this edge.
	 * @return
	 * the cost of the edge to get to this neighbor
	 */
	public int getCost() {
		
		return cost;
	}

	@Override
	/**
	 * Compares the node names of this node and the otherNode. Returns the 
	 * results of comparing this node's name to the otherNode's name. Allows 
	 * Lists of Neighbors to be sorted using built-in sort methods.	 
	 * 
	 * @param otherNode - neighbor to be compared
	 * @return 
	 * compareTo the node names of two neighbors
	 */
	public int compareTo(Neighbor otherNode) {
		return this.neighbor.getNodeName().compareToIgnoreCase(
				otherNode.getNeighborNode().getNodeName());
	}
	@Override
	/**
	 * Returns a String representation of this Neighbor. The String that is 
	 * returned shows an arrow (with the cost in the middle) and then the 
	 * Neighbor node's name. Example:
	 *  --1--> b 
	 * indicates a cost of 1 to get to node b
	 * 
	 * Overrides: toString in class java.lang.Object
	 * @return
	 * a String with the cost and destination node:
	 */
	public String toString(){
		
		String a;
		a = "--" + cost + "--> " + neighbor.getNodeName();
		return a;
	}

}
