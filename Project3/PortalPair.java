///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Portal Snake)
// Files:            (PortalPair.java)
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
 * The PortalPair class represents a pair of portals.
 * 
 * The Game class instantiates this class once for each pair of portals present
 * when a new level is loaded.
 * @author Zhongwei Wang, Ying Li
 * @version 11.24
 * @see also
 */
public class PortalPair 
{
	// Create private field to hold the GraphicObject associated
	//with the blue portal
	private GraphicObject bluePortalX;
	// Create private field to hold the GraphicObject associated
	//with the orange portal
	private GraphicObject orangePortalX;
	/**
	 * portalPair constructor;
	 * will initiate the object with the name and coordinates past in.
	 * 
	 * @param name		name displayed on each end of the portal pair
	 * @param blueX		the x position of the blue portal
	 * @param blueY		the y position of the blue portal
	 * @param orangeX	the x position of the orange portal
	 * @param orangeY	the y position of the orange portal
	 */
	public PortalPair(String name, float blueX, float blueY, 
			float orangeX, float orangeY)
	{
		// Initialize the GraphicObjects associated with the blue and orange
		// portals, setting the type to "BLUE_PORTAL_name" or
		// "ORANGE_PORTAL_name", respectively, and setting their x and y
		// coordinates appropriately
		
		bluePortalX = 
				new GraphicObject("BLUE_PORTAL_"+ name, blueX , blueY);
		orangePortalX = 
				new GraphicObject("ORANGE_PORTAL_"+ name, orangeX, orangeY);
	}

	/**
	 * Checks if either end of this portal pair is colliding with the specified
	 * snake.
	 * 
	 * If either end of this portal pair is colliding with the snake, moves the
	 * snake past the other end of the portal.
	 * 
	 * 
	 * @param snake		the snake to check for collisions with
	 */
	public void teleportSnakeIfColliding(Snake snake)
	{
		// If the blue portal is colliding with the snake's head's GraphicObject
		if(bluePortalX.isCollidingWith(snake.getGraphicObject())){
			// move the snake's head's GraphicObject past the orange portal
			float x = orangePortalX.getX();
			float y = orangePortalX.getY();
			snake.getGraphicObject().movePast(orangePortalX);
		}
		

		// If the orange portal is colliding with the snake's head's
		if(orangePortalX.isCollidingWith(snake.getGraphicObject())){
		// GraphicObject, move the snake's head's GraphicObject past the 
		// blue portal
			float x = bluePortalX.getX();
			float y = bluePortalX.getY();
			snake.getGraphicObject().movePast(bluePortalX);
		}
	}
}