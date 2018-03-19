///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P5)
// Files:            (GraphNode.java)
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



/**This is the class defines a graph type named GraphNode
 * The graph is represented using the set of successors.
 * Here holds the name(vortex)
 * boolean field spycam is a special field that store whether this vortex has a
 * spy cam here.
 * @author Zhongwei
 *
 */
public class GraphNode implements Comparable<GraphNode>{
	/* A value that can be used if a cost is needed even if the GraphNode is not
	 * a neighbor of a node. In Dijkstra's algorithm, initializing a node to a
	 * high cost (Integer.MAX_VALUE) can be used to indicate a node is not a
	 * neighbor, or not connected by a path to the starting node.
	 */
	public static final int NOT_NEIGHBOR = Integer.MAX_VALUE;

	private String name;
	private List<Neighbor> listOfNeighbor;
	private boolean spycam;

	/**
	 * Constructor
	 * Represents a valid location in the game graph. There can be a player,
	 * a spycam, or a spy at any graph node.
	 * @param  name - The label that uniquely identifies this graph node.
	 */
	public GraphNode(String name) {

		this.name = name;
		this.listOfNeighbor = new ArrayList<Neighbor>();
		this.spycam = false;
	}

	/**
	 * Maintains sorted order of neighbors by neighbor name.
	 *
	 * @Param neighbor - An adjacent node (a neighbor)
	 * cost - The cost to move to that node (from this node)
	 */

	public void addNeighbor(GraphNode neighbor, int cost) 
			throws IllegalArgumentException{
		// create a Neighbor Object and store it in the listOfNeighbor
		// may need to check whether the node is valid!!!!!!!!!!!!!!!!!!!!!!
		if(neighbor == null) throw new IllegalArgumentException();
		// if the neighbor is already in the list
		if(isNeighbor(neighbor.getNodeName())){
			// found the neighbor and update the cost?
			// or we throw exceptions?
			// or just ignore?

		}else{
			Neighbor newNeighbor = new Neighbor(cost,neighbor);
			listOfNeighbor.add(newNeighbor);
			listOfNeighbor.sort(null);
		}
	}


	/**
	 * Return the results of comparing this node's name to the other node's name.
	 * @param otherNode
	 * @return
	 */
	public int compareTo(GraphNode otherNode){

		return name.compareToIgnoreCase(otherNode.getNodeName());
	}

	/**
	 * 
	 * @param neighborName- name of potential neighbor
	 * @return
	 * cost to neighborName
	 * @Throw:
	 * NotNeighborException - if neighborName is not a neighbor
	 */
	public int getCostTo(String neighborName)throws NotNeighborException{

		int index = -1;
		int cost = 0;
		for(int i = 0; i < listOfNeighbor.size(); i++){
			if(listOfNeighbor.get(i).getNeighborNode().getNodeName().equals(
					neighborName) ){
				index = i;
				cost = listOfNeighbor.get(i).getCost();
			}
		}
		if(index == -1){
			throw new NotNeighborException();
		}else{
			return cost;
		}

	}
	/**
	 * 
	 * @param name- name of potential neighbor
	 * @return
	 * the GraphNode associated with name that is a neighbor of the current node
	 * @Throws:NotNeighborException - if name is not a neighbor of the GraphNode
	 */
	public GraphNode getNeighbor(String name)throws NotNeighborException{

		int index = -1;
		GraphNode neighbor = null;
		for(int i = 0; i < listOfNeighbor.size(); i++){
			if(listOfNeighbor.get(i).getNeighborNode().getNodeName().equals(
					name) ){
				index = i;
				neighbor = listOfNeighbor.get(i).getNeighborNode();
			}
		}
		if(index == -1){
			throw new NotNeighborException();
		}else{
			return neighbor;
		}

	}



	/**
	 * Iterator through ListOfNeighbor
	 * I don't like this method because of the return type.
	 * @return
	 * iterator in string type
	 */
	
	public Iterator<String> getNeighborNames(){
		Iterator<Neighbor> itr = listOfNeighbor.iterator();
		ArrayList<String> Ln = new ArrayList<String>();
		while(itr.hasNext()){
			Ln.add(itr.next().getNeighborNode().getNodeName());
		}
		Iterator<String> si = Ln.iterator();
		return si;
	}
	

	/**
	 * Returns a list of the neighbors of this GraphNode instance. This instance
	 * of GraphNode is not included as it is not a neighbor of itself.
	 * @return a list of neighbors of this GraphNode.
	 */
	public List<Neighbor> getNeighbors() {

		return this.listOfNeighbor;
	}

	/**
	 * Return the name of this GraphNode.
	 * @return name of node
	 */
	public String getNodeName() {

		return name;
	}

	/**
	 * 
	 * @return
	 * true if the GraphNode has a spycam
	 */
	public boolean getSpycam() {

		return spycam;
	}


	/**
	 * Returns true if this node name is a neighbor of current node.
	 * @param neighborName- to look for
	 * @return
	 * true if the node is an adjacent neighbor.
	 */
	public boolean isNeighbor(String neighborName){
		boolean isNeighbor = false; 
		for(int i = 0; i < listOfNeighbor.size() && !isNeighbor; i++){
			if(listOfNeighbor.get(i).getNeighborNode().getNodeName().equals(
					neighborName)){
				isNeighbor = true;
			}
		}
		return isNeighbor;
	}

	/**
	 * Prints a list of neighbors of this GraphNode and 
	 * the cost of the edge to them
	 * 
	 * 1 b
	 * 4 c
	 * 20 d
	 * 1 f
	 */
	public void printNeighborNames() {

		for(int i = 0; i < listOfNeighbor.size(); i++){
			System.out.println( listOfNeighbor.get(i).getCost() + " " + 
		listOfNeighbor.get(i).getNeighborNode().getNodeName());
		}

	}
	/**
	 * 
	 * @param cam- indicates whether the node now has a spycam
	 */
	public void setSpycam(boolean cam) {
		this.spycam = cam;
	}

	@Override
	/**
	 * @return 
	 * the name of the GraphNode
	 */
	public String toString(){
		return name;
	}



}
