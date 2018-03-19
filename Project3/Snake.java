///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Portal Snake)
// Files:            (Snake.java)
// Semester:         (CS302) Fall 2015
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deppler)
// Lab Section:      (311)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     (Ying Li)
// Email:            (li528@wisc.edu)
// CS Login:         (yli)
// Lecturer's Name:  (Deppler)
// Lab Section:      (315)
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

/**
 * The Snake class represents the player-controlled snake. 
 *
 * The Game class instantiates this class exactly once, when a new level is
 * loaded.
 * @author Zhongwei Wang, Ying Li
 * @version 11.24
 * @see also
 */
public class Snake 
{
	// Private variables to hold the GraphicObject associated with the snake's head
	private GraphicObject head;
	// and an ArrayList of GraphicObject associated with the snake's body
	private ArrayList<GraphicObject> body;


	/**
	 * Snake constructor.
	 * Initializes a new Snake object at the specified (x,y) position.
	 * 
	 * 
	 * 
	 * @param x		the initial x position of the snake
	 * @param y		the initial y position of the snake
	 */
	public Snake(float x, float y)
	{

		// Initialize new ArrayList to hold body segments
		body = new ArrayList<GraphicObject>();
		// Initialize the head
		head = new GraphicObject("HEAD", x, y);
		// Set the speed of the head
		head.setSpeed(2);;
		// Set the direction of the head
		head.setDirection(90);
		// Add the head to the list of body segments
		body.add(head);
		// Add four body segments (grow the snake four times)
		grow();
		grow();
		grow();
		grow();
	}

	/**
	 * Returns the GraphicObject associated with the head of this snake.
	 * 
	 * @return the GraphicObject associated with the head of this snake
	 */
	public GraphicObject getGraphicObject() {
		return body.get(0);
	}

	/**
	 * Grows the snake by one body segment.
	 * 
	 * TODO: Implement this.
	 */
	public void grow()
	{
		float radian = (float)(body.get(0).getDirection()*
				Math.PI/180);
		// Create a new GraphicObject with type "BODY"
		GraphicObject newBody;
		// Find the last body segment in the list of body segments
		float x = (float)(body.get(body.size()-1).getX()-Math.cos(radian)*
				(body.get(body.size()-1).getSize()));
		float y = (float)(body.get(body.size()-1).getY()-Math.sin(radian)*
				(body.get(body.size()-1).getSize()));
		// Set the leader of the new body segment to be the last body segment
		newBody = new GraphicObject("BODY",x,y);
		newBody.setLeader(body.get(body.size()-1));
		// Add the new body segment to the end of the list of body segments
		body.add(newBody);
	}

	/**
	 * Reads keyboard input and changes the snake's direction as necessary.
	 * 
	 * 
	 * @param controlType - 1: classic, 2: analog, 3: slither
	 */
	public void updateMoveDirection(int controlType)
	{
		// if controlType is one
		if(controlType == 1){
			// implementation for controlType one
			if(Engine.isKeyPressed("LEFT")){
				head.setDirection(head.getDirection()+90);
			}
			else if(Engine.isKeyPressed("RIGHT")){
				head.setDirection(head.getDirection()-90);
			}
		}
		// if controlType is two
		else if(controlType == 2){
			// implementation for controlType two
			if(Engine.isKeyHeld("LEFT")){
				head.setDirection(head.getDirection()+6);
			}
			else if(Engine.isKeyHeld("RIGHT")){
				head.setDirection(head.getDirection()-6);
			}
		}
		// if controlType is three
		else if(controlType == 3){
			// implementation for controlType three
			if(Engine.isKeyHeld("SPACE")){
				head.setDirection(head.getDirection()+6);
			}
			else {
				head.setDirection(head.getDirection()-6);
			}
		}
	}

	/**
	 * Kills the snake if the head is colliding with any of the body segments.
	 * 
	 */
	public void dieIfCollidingWithOwnBody()
	{
		// For each game object in the body...
		for(int i =1; i < body.size(); i++){
			// if the head is colliding with this segment...
			if(head.isCollidingWith(body.get(i))){
				// tell the snake to die.
				die();
			}
		}
	}

	/**
	 * Kills the snake.
	 * 
	 */
	public void die()
	{
		// Set the head's type to "DEAD"
		head.setType("DEAD");
		// For each GraphicObject in the snake's body, set its type to "DEAD"
		for(int i = 1; i < body.size(); i++){
			body.get(i).setType("DEAD");
		}
	}

	/**
	 * Returns true if the snake is dead.
	 * 
	 * 
	 * @return true if the snake is dead, false otherwise
	 */
	public boolean isDead() {
		if(body.get(0).getType().equals("DEAD")){
			return true;
		}
		else{
			return false;
		}
	}
}
