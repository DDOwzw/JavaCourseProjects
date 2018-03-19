///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P5)
// Files:            (Player.java)
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
import java.util.List;

/**This is the class defines Player!
 * Player is the object that has all the information related to the player
 * name is the name of the player;
 * budget is the num of money the player has
 * spycams is the num of spy cams remaining that this player has
 * startnode is the place(vortex) where the player current at
 * ListOfCam is a list that contains the name of the current using cams.
 * 
 * @author Zhongwei
 *
 */
public class Player {
	// local fields:
	private String name;
	private int budget;
	private int spycams;
	private GraphNode startnode;
	private List<String> ListOfCam;



	/**Constructor
	 * 
	 * @param name- Player's name
	 * @param budget- Player budget to spend on moves
	 * @param spycams- the number of spy cams the player starts with
	 * @param startnode- the node the player starts on
	 */
	public Player(String name, int budget, int spycams, GraphNode startnode) {

		this.name = name;
		this.budget = budget;
		this.spycams = spycams;
		this.startnode = startnode;
		ListOfCam = new ArrayList<String>();
	}


	/**
	 * Decrease the budget; check before call this method!!
	 * @param dec
	 */
	public void decreaseBudget(int dec) {
		this.budget = this.budget - dec;
	}

	/**
	 * If there are no remaining spy cams to drop, display "Not enough spycams" 
	 * and return false. Otherwise: If there is not a spy cam at the player's 
	 * current location: drop a spy cam (here) D decrement the remaining spy cam
	 * count if there was not already a spycam.
	 * 
	 * @return true if a spycam is dropped
	 */
	public boolean dropSpycam() {
		
		if(spycams <= 0){
			System.out.println("Not enough spycams");
			return false;
		}else{
			// If there is not a spy cam at the player's current location
			if( !startnode.getSpycam()){
				// drop cam here
				startnode.setSpycam(true);
				spycams --;
				ListOfCam.add(startnode.getNodeName());
				System.out.println("Dropped a Spy Cam at " + startnode);
				return true;
			}else{
				// if there is already a cam here
				
				System.out.println("Already a Spy Cam there");
				return false;
			}

		}

	}

	/**
	 * 
	 * @return remaining budget
	 */
	public int getBudget() {

		return this.budget;
	}

	/**
	 * Returns the node where the player is currently located.
	 * @return player's current node
	 */
	public GraphNode getLocation() {

		return startnode;
	}


	/**
	 * Returns the node where the player is currently located.
	 * 
	 * @return node label for the current location of the player
	 */
	public String getLocationName() {

		return startnode.getNodeName();
	}

	/**
	 * 
	 * @return name of player
	 */
	public String getName() {

		return this.name;
	}

	/**
	 * If pickupSpyCam is true, increment the number of spy cams remaining.
	 * @param pickupSpyCam - true if a spy cam was picked up. 
	 * False means there was no spy cam
	 */
	public void getSpycamBack(boolean pickupSpyCam){
		// If pickupSpyCam is true, increment the number of spy cams remaining.
		if(pickupSpyCam)
			spycams ++;
	}

	/**
	 * 
	 * @return number of spycams remaining
	 */
	public int getSpycams() {

		return spycams;
	}

	/**
	 * 
	 * @param name- Neighboring node to move to
	 * @return true if the player successfully moves to this node 
	 * if the cost is greater than 1, decrement budget by that amount
	 */
	public boolean move(String name) {
		
		boolean moveSuc = false;
		// if is neighbor
		if(startnode.isNeighbor(name)){
			
			// check budget
			int cost = 0;
			try {
				cost = startnode.getCostTo(name);
			} catch (NotNeighborException e1) {

				e1.printStackTrace();
			}
			if (budget >= cost){
				
				// move
				try {
					GraphNode neighbor = startnode.getNeighbor(name);
					startnode = neighbor;
					//if the cost is greater than 1, decrement budget by that amount
					if(cost > 1)
						decreaseBudget(cost);
					moveSuc = true;

				} catch (NotNeighborException e) {

					e.printStackTrace();
				}
			}else{
				System.out.println("Not enough money cost is " 
			+ cost + " budget is " + budget);
			}
		}else{
			// return false
			
			System.out.println(name +
					" is not a neighbor of your current location");
		}

		return moveSuc;
	}
	/**
	 * Check the node to see if there is a spy cam. If there is a spy cam at 
	 * that node, remove the spy cam from that node. Also, remove the spy cam 
	 * name from the Player's list of spy cam names. Otherwise, return false.
	 * 
	 * @param node- The node the player asked to remove a spy cam from.
	 * @return true if a spycam is retrieved
	 */
	public boolean pickupSpycam(GraphNode node) {
		if(node == null){
			
			System.out.println("There is no such location!");
		}
		boolean isCam = node.getSpycam();
		// If there is a spy cam at that node
		if(isCam){
			// remove the spy cam from that node
			node.setSpycam(false);
			// remove the spy cam name from the Player's list of spy cam names.
			getSpycamBack(ListOfCam.remove(node.getNodeName()));
		}else{
			// return false
		}
		return isCam;
	}

	/**
	 * Display the names of the locations where Spy Cams were dropped 
	 * (and are still there).
	 */
	public void printSpyCamLocations() {

		for(int i  = 0; i < ListOfCam.size(); i++){
			System.out.println("Spy cam at " + ListOfCam.get(i));
		}
	}




}
