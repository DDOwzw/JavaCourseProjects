///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Portal Snake)
// Files:            (Apple.java)
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
 * The Apple class represents an apple in the game.
 * 
 * The Game class instantiates this class once for each apple present when a new
 * level is loaded.
 * @author Zhongwei Wang, Ying Li
 * @version 11.24
 * @see also
 */
public class Apple 
{
	// Create private field to hold the GraphicObject associated with this apple
	private GraphicObject apple;
	/**
	 * Initializes a new Apple object.
	 * 
	 * @param x		the x position of the apple
	 * @param y		the y position of the apple
	 */
	public Apple(float x, float y)
	{
		// Initialize this apple's associated GraphicObject with type "APPLE" at
		// this apple's x and y coordinates
		apple = new GraphicObject("APPLE", x , y);
	}

	/**
	 * Checks if this apple is colliding with the specified snake.
	 * 
	 * If the GraphicObject associated with this apple is colliding with the
	 * GraphicObject associated with the specified snake's head, grows the snake,
	 * destroys the GraphicObject associated with this apple (causing it to
	 * disappear from the screen), and returns true. Otherwise, returns false.
	 * 
	 * @param snake		snake to check for collisions with
	 * @return true after eating an apple, otherwise false
	 */
	public boolean getEatenBySnakeIfColliding(Snake snake)
	{
		// If this apple is colliding with the snake's head's GraphicObject,
		if(snake.getGraphicObject().isCollidingWith(apple)){
			// grow the snake once and destroy this apple's GraphicObject, then
			snake.grow();
			apple.destroy();
			// return true
			return true;
		}

		else{
			// Otherwise, return false
			return false;
		}
	}	
}
