///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Portal Snake)
// Files:            (Rock.java)
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
/**
 * The Rock class represents a rock in the game.
 * 
 * The Game class instantiates this class once for each rock present when a new
 * level is loaded.
 * @author Zhongwei Wang, Ying Li
 * @version 11.24
 * @see also
 */
public class Rock 
{
	// Create private field to hold the GraphicObject associated with this rock
	private GraphicObject rock;
	/**
	 * Rock constructor.
	 * will initiate the object with coordinates past in.
	 * 
	 * @param x		the x position of the rock
	 * @param y		the y position of the rock
	 */
	public Rock(float x, float y)
	{
		// Initialize this rock's associated GraphicObject with type "ROCK" at 
		// this rock's x and y coordinates
		rock = new GraphicObject("ROCK", x , y);
	}

	/**
	 * Checks if this rock is colliding with the specified snake.
	 * 
	 * If the GraphicObject associated with this rock is colliding with the head 
	 * of the GraphicObject associated with the head of the snake, kills the 
	 * snake.
	 *
	 * 
	 * @param snake		snake to check for collisions with
	 */
	public void killSnakeIfColliding(Snake snake)
	{
		// If this rock is colliding with the snake's head's GraphicObject, kill
		// the snake
		//System.out.println(snake.getGraphicObject());
		if(snake.getGraphicObject().isCollidingWith(rock)){
			snake.die();
			//System.out.println(snake.getGraphicObject());
		}
		
	}
}