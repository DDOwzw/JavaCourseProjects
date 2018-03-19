///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (Portal Snake)
// Files:            (Game.java)
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

//import java.util.*
import java.util.*;

/**
 * The Game class represents a running instance of the PortalSnake game. It
 * keeps track of the Snake object, lists of Apple, Rock, and PortalPair
 * objects, the current score, and whether the player has won.
 * 
 * The game engine (which we've written for you) will create a new instance of
 * this class when the player chooses a level to play. 
 * 
 * At each iteration of the game loop, the game engine calls the update() method
 * in the Game class. The update() method tells each of the objects in the game
 * to update itself based on the rules of the game. It then checks if the game
 * is over or not.
 * @author Zhongwei Wang, Ying Li
 * @version 11.24
 * @see also
 */
public class Game 
{	
	// Store the instances of the game objects that you create for your game
	// in these member variables: 
	// GraphicObject Snake snake,
	// ArrayLists to store GraphicObjects with type Apple, GraphicObjects with 
	// type Rock and GraphicObjects with type PortalPair
	
	private Snake snake;
	private ArrayList<Apple> apples;		
	private ArrayList<Rock> rocks;			
	private ArrayList<PortalPair> portals;	
	// Create member variables to track the controlType, score (ie number
	// of apples eaten by the snake), and whether the game has been won
	// or lost here.
	private int controlType = 1;
	private int score;

	/**
	 * This is the game constructor.
	 * This will be called if other method create a new game.
	 * 
	 * @param level - String "RANDOM" or String that describe the level to load
	 * @param controlType - 1: classic, 2: analog, 3: slither
	 */
	public Game(String level, int controlType) {
		// Initialize all member variables
		rocks = new ArrayList<Rock>();
		apples = new ArrayList<Apple>();
		portals = new ArrayList<PortalPair>();
		this.controlType = controlType;
		// Create a random level when level contains: RANDOM
		if(level.contains("RANDOM")){
			createRandomLevel();
		}
		// Otherwise load the objects described in the string level
		else{
			loadLevel(level);
		}
	}

	/**
	 * createRandomLevel method.
	 * create a new level with randomly positioned:
	 * Snake(1), Rocks(20), Apples(8), and PortalPairs(3)
	 * @return void create Random level
	 */
	public void createRandomLevel()
	{
		// create a snake: positioned as specified in the write-up
		snake = new Snake(Engine.getWidth()/2,Engine.getHeight()/2);
		// create 20 randomly positioned rocks
		for(int i = 0; i < 20; i++){
			rocks.add(new Rock((float)(Math.random())*Engine.getWidth(),
					(float)(Math.random())*Engine.getHeight()));
		}
			

		// create 8 randomly positioned apples
		for(int i = 0; i < 8; i++){
			apples.add(new Apple((float)(Math.random())*Engine.getWidth(),
					(float)(Math.random())*Engine.getHeight()));
		}
		// create 3 randomly positioned portal pairs
		for(int i = 0; i < 3; i++){
			portals.add(new PortalPair("" + i, 
					(float)(Math.random())*Engine.getWidth(),
					(float)(Math.random())*Engine.getHeight(), 
					(float)(Math.random())*Engine.getWidth(),
					(float)(Math.random())*Engine.getHeight()));
		}
	}

	/**
	 * Loads a level from a String description.
	 * 
	 * Initializes all of the class private fields which hold the Snake object
	 * and the lists of Apple, Rock, and PortalPair objects from the provided
	 * String which contains  
	 * 
	 * @param level - a string object containing the names and locations of 
	 * objects
	 */
	public void loadLevel(String level)
	{
		// Initialize Rock, Apple, and PortalPair ArrayLists
		rocks = new ArrayList<Rock>();
		apples = new ArrayList<Apple>();
		portals = new ArrayList<PortalPair>();
		// newline to hold each line read by the scanner.
		String newline;
		// array of coord to hold the xcoord and ycoord read.
		float [] coord= new float[4];
		// objectType to hold the Object Type read.
		String objectType;
		// objectName to hold the Object Name read.
		String objectName;
		// array of tokens to hold each tokens split from the newline.
		String tokens[];
		// a counter of index for the tokens array.
		int j = 0;

		// Create a new scanner to read the level description
		Scanner input = new Scanner(level);
		// Loop through lines in the level description
		do{


			// Get the next line
			newline = input.nextLine();
			// Split the line into tokens
			// Determine the type of object to add to the level
			// If it's a snake, create a new snake at the x and y
			// coordinates specified by the second and third tokens
			if(newline.startsWith("Snake,")){
				objectType = "Snake";
				tokens = newline.split(",");
				j = 0;
				// for each token in the input line
				for(int i = 0; i < tokens.length; i++){
					tokens[i] = tokens[i].trim();
					// if token is not null and token first char is within range
					// 0-9
					if(tokens[i].length() > 0  && tokens[i].charAt(0) >= '0' 
							&& tokens[i].charAt(0) <= '9'){
						//set the token to cood[0] and cood[1]
						coord[j] = Float.parseFloat(tokens[i]);
						j++;
					}
				}
				snake = new Snake(coord[0],coord[1]);
			}
			// If it's an apple, create a new apple at the x and y
			// coordinates specified by the second and third tokens, and add
			// it to the list of apples
			else if(newline.startsWith("Apple,")){
				objectType = "Apple";
				tokens = newline.split(",");
				j = 0;
				for(int i = 0; i < tokens.length; i++){
					tokens[i] = tokens[i].trim();
					if(tokens[i].length() > 0  && tokens[i].charAt(0) >= '0' 
							&& tokens[i].charAt(0) <= '9'){
						coord[j] = Float.parseFloat(tokens[i]);
						j++;
					}
				}
				apples.add(new Apple(coord[0],coord[1]));
			}
			// If it's a rock, create a new rock at the x and y coordinates
			// specified by the second and third tokens and add it to the
			// list of rocks
			else if(newline.startsWith("Rock,")){
				objectType = "Rock";
				tokens = newline.split(",");
				j = 0;
				for(int i = 0; i < tokens.length; i++){
					tokens[i] = tokens[i].trim();
					if(tokens[i].length() > 0  && tokens[i].charAt(0) >= '0' 
							&& tokens[i].charAt(0) <= '9'){
						coord[j] = Float.parseFloat(tokens[i]);
						j++;
					}
				}
				rocks.add(new Rock(coord[0],coord[1]));
			}
			// If it's a portal pair, create a new PortalPair with the
			// name equal to the second token, with the first portal at the
			// x and y coordinates specified by the third and fourth
			// tokens, and the second portal at the x and y coordinates
			// specified by the fifth and sixth tokens
			else if(newline.startsWith("PortalPair,")){
				objectType = "PortalPair";
				tokens = newline.split(",");
				objectName = tokens[1];
				j = 0;
				for(int i = 0; i < tokens.length; i++){
					tokens[i] = tokens[i].trim();
					if(tokens[i].length() > 0  && tokens[i].charAt(0) >= '0' 
							&& tokens[i].charAt(0) <= '9'){
						coord[j] = Float.parseFloat(tokens[i]);
						j++;
					}
				}
				portals.add(new PortalPair(objectName,coord[0],
						coord[1],coord[2],coord[3]));
			}
			// If it's anything else, ignore it.
			else{

			}
		}while(input.hasNextLine());
		// Close the scanner
		input.close();
	}

	/**
	 * Updates the game objects.
	 * 
	 * Goes through each of the objects--the snake, rocks, apples, and portals--
	 * and tells them to behave according to the rules of the game. This method
	 * returns true if the game should continue, or false if the game is over.
	 * 
	 * @return - false if the game is over, otherwise true
	 */
	public boolean update()
	{
		// Tell the snake to update itself
		snake.updateMoveDirection(controlType);
		// Tell the snake to die if it's colliding with itself
		snake.dieIfCollidingWithOwnBody();
		// For each rock, tell the rock to kill the snake if the two are
		// colliding
		for(int i  =0; i < rocks.size(); i++){
			rocks.get(i).killSnakeIfColliding(snake);
		}
		// For each apple, tell the apple to be eaten by the snake if the two
		// are colliding, and if so update the score
		for(int i = 0; i < apples.size(); i++){
			if(apples.get(i).getEatenBySnakeIfColliding(snake)){
				score++;
			}
		}
		// For each portal pair, tell the pair to teleport the snake if the two
		// are colliding
		for(int i = 0; i < portals.size(); i++){
			portals.get(i).teleportSnakeIfColliding(snake);
		}
		// Check for win/loss
		// If the score is equal to the number of apples
		if(playerHasWon()){
			// make sure playerHasWon() will return true and then return false
			return false;
		}
		// Else, if the snake is dead
		else if(snake.isDead() && (!playerHasWon())){
			// make sure playerHasWon() will return false and then return false
			return playerHasWon();
		}
		// If the game isn't over, return true
		return true;
	}

	/**
	 *  Returns true if the player has won and false if  plyer not won the game
	 * 
	 * 
	 * @return boolean with value true when player won and false when not 
	 * won
	 */
	public boolean playerHasWon()
	{
		if(score == apples.size()){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Returns the player's score.
	 * @return the current score. This is used to count the number of apples 
	 * eaten.
	 */
	public int getScore() {
		return score;
	}	

	/**
	 * There is nothing left to implement in this method, it simply calls
	 * Engine.startEngineAndGame(), which in turn starts the Engine and creates
	 * an instance of this Game class.  The engine will then repeatedly call
	 * the update() method on this Game until it returns false.
	 * 
	 * If you want to turn off the logging you can change the parameter being
	 * passed to startEngineAndGame to false.  
	 *  
	 * @param args - command line arguments
	 */
	public static void main(String[] args)
	{
		Application.startEngineAndGame(true);
	}
}
