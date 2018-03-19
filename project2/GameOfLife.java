// PUT FILE HEADER HERE
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (GameOfLife)
// Files:            (GameOfLife.java)
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
// Pair Partner:     (name of your pair programming partner)
// Email:            (email address of your programming partner)
// CS Login:         (partner's login name)
// Lecturer's Name:  (name of your partner's lecturer)
// Lab Section:      (your partner's lab section number)
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
 * This game is based on John Conway's Game of Life as described in Wikipedia.
 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */


// PUT import statements here
import java.util.*;

//PUT CLASS HEADER HERE
/**
 * This class is based on John Conway's Game of Life.
 * The main method will call different method to solve problem.
 * More details are available in the method comments.
 *
 * @zhongwei wang
 */
public class GameOfLife {

	// DO NOT ADD STATIC FIELDS TO THIS CLASS
	// YOU MUST SOLVE ALL PARTS BY PASSING THE 
	// THE VALUES YOU NEED TO AND FROM METHODS.
	// WE WILL TEST ALL METHODS INDEPENDENT OF 
	// OTHER METHODS.  
	//
	// THAT CAN ONLY WORK IF YOU DEFINE EACH 
	// METHOD AS DESCRIBED.  YOU MAY NOT IMPLEMENT
	// YOUR OWN DESIGN EXCEPT TO ADD PRIVATE
	// HELPER METHODS AS YOU LIKE.  YOU MUST
	// STILL IMPLEMENT ALL PUBLIC METHODS
	// OF THIS CLASS.

	/**
	 * Program execution starts here.
	 * main method is here
	 * in main method, a welcome msg will show and a main menu will show as 
	 * below.
	 * Welcome to the Game Of Life
	 * 
	 * Select a pattern of life for the world
	 *1 - Glider
	 *2 - Beacon
	 *3 - Boat
	 *4 - R-pentomino
	 *5 - Random
	 *9 - Exit
	 *Choice:
	 *If user doesn't input valid value, the program will show
	 *Invalid input
	 *and return the main menu.
	 *In every sub opinion, the program will show the name of the method, 
	 *calling different method to create different pattern of world of life,
	 *and show the pattern, how many cells are alive, and the generation of 
	 *world of life as well as a guideline below.
	 *Options
	 *(Enter): show next generation
	 *end(Enter): end this simulation
	 *Choice:
	 *In addition, user can input enter to show the next generation, while any 
	 *other input is invalid and will return to the main menu.
	 *(I think the key word "end" is supposed to be the only word that will 
	 *allow the program return main menu, but in the error example, any input 
	 *except enter will do so.
	 *The program will end when user input 9 in the main menu.
	 * @param args UNUSED
	 * @param numRows  Number of rows 
	 * @paramnumColumns Number of columns
	 * @param choiceOfMenu Number of choice that user input
	 * @param generation The generation number of cells
	 * @param world[][] The array of current world of life.
	 * @param newWorld[][] The next generation of current world.
	 * @param choiceOfNextGeneration The choice user input for sub menu.
	 * @param menuName[] = {"Glider","Beacon","Boat","R-pentomino","Random"}
	 * The name of different pattern of life.
	 * @param input scanner's name.
	 */    
	public static void main(String[] args){
		//declare local variables
		int numRows =  Config.WORLD_ROWS, numColumns = Config.WORLD_COLUMNS;
		int choiceOfMenu = 0;
		int generation = 0;
		boolean[][] world = createNewWorld( numRows, numColumns);
		boolean[][] newWorld = createNewWorld( numRows, numColumns);
		String choiceOfNextGeneration = "";
		String[] menuName = {"Glider","Beacon","Boat","R-pentomino","Random"};
		Scanner input = new Scanner(System.in);
		// Display Welcome message   
		System.out.println("Welcome to the Game Of Life");
		//menu choices  
		do{
			System.out.println("Select a pattern of life for the world");
			System.out.println("1 - Glider");
			System.out.println("2 - Beacon");
			System.out.println("3 - Boat");
			System.out.println("4 - R-pentomino");
			System.out.println("5 - Random");
			System.out.println("9 - Exit");
			System.out.print("Choice:");
			// check for integer input
			if (input.hasNextInt()){
				choiceOfMenu = input.nextInt();
				input.nextLine();
			}
			else {
				input.nextLine();
			}
			//initialize the world based on the user's choice
			//call initialize method to initialize world
			//print the name of pattern
			//call printWorld method to print the world
			if(choiceOfMenu>=1 && choiceOfMenu <= 5){
				switch(choiceOfMenu){
				//If user choose 1, show the Glider pattern.
				case (1):{
					initializeGlider(world);
					generation = 0;
					System.out.println('\n'+"Glider generation: "+generation);
					printWorld("",world,4);
					break;
				}
				//If user choose 2, show the Beacon pattern.
				case (2):{
					initializeBeacon(world);
					generation = 0;
					System.out.println('\n'+"Beacon generation: "+generation);
					printWorld("",world,4);
					break;
				}
				//If user choose 3, show the Boat pattern.
				case (3):{
					initializeBoat(world);
					generation = 0;
					System.out.println('\n'+"Boat generation: "+generation);
					printWorld("",world,4);
					break;
				}
				//If user choose 4, show the R-pentomino pattern.
				case (4):{
					initializeRpentomino(world);
					generation = 0;
					System.out.println('\n'+"R-pentomino gen"
							+ "eration: "+generation);
					printWorld("",world,4);
					break;
				}
				//If user choose 5, show the Random pattern.
				case (5):{
					initializeRandomWorld(world);
					generation = 0;
					System.out.println('\n'+"Random generation: "+generation);
					printWorld("",world,4);
					break;
				}
				default:{
				}
				}
				//loop to print out world and prompt for next generation or Exit
				//Print the guideline for user first
				//Check whether user input enter,
				//If so, calling method to show the next generation.
				//If not, return the main menu.
				do{
					System.out.println('\n'+"Options");
					System.out.println(	"(Enter): show next generation");
					System.out.println("end(Enter): end this simulation");
					System.out.print("Choice:");
					choiceOfNextGeneration = input.nextLine();
					if(choiceOfNextGeneration.length() == 0){
						nextGeneration(world, newWorld);
						generation++;
						System.out.println('\n'+menuName[choiceOfMenu-1]+
								" generation: "+generation);
						printWorld("",world,4);
					}
					else{
					}
				}while(choiceOfNextGeneration.equals(""));
			}
			//End the program if user inputs 9;
			else if (choiceOfMenu==9){
				System.out.println("End of Game Of Life.");
				System.exit(-1);
			}
			//Print msg to tell user that he/she inputed invalid one.
			else {
				System.out.println("Invalid input");
			}

		}while(choiceOfMenu != 9 );

		//Close the scanner
		input.close();
	} 	

	/**
	 * Create a new world
	 * @param numRows The number of rows to be in the created world
	 * @param numColumns  The number of columns to be in the created world
	 * @return A double dimension array of boolean that is numRows by 
	 * numColumns in size and initialized to all false values. 
	 */



	public static boolean[][] createNewWorld( int numRows, int numColumns) {

		// TODO: Implement this method		
		//create the world of the proper size
		boolean[][] creatNewWorld = new boolean [numRows][numColumns];

		return creatNewWorld;
	}

	/**
	 * Sets all the cells in the world to not alive (false).
	 * @param world 
	 */
	public static void clearWorld( boolean[][]world) {

		// TODO: Implement this method	
		//For every row of the array,
		for (int i = 0; i < world.length; i++){
			//For every column of the array,
			for (int j = 0 ; j < world[0].length ; j++){
				//Initial it to false.
				world[i][j] = false;
			}
		}

	}	

	/**
	 * Initializes the world to the Glider pattern.
	 * <pre>
	 * ..........
	 * .@........
	 * ..@@......
	 * .@@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre>
	 * @param world  the existing double dimension array that will be 
	 * reinitialized to the Glider pattern. 
	 */
	public static void initializeGlider(boolean[][]world) {

		// TODO: Implement this method	
		//initialize to all false values
		clearWorld( world );
		//in the world set specific cells to true that are alive for the 
		//glider pattern
		world[1][1]= true;
		world[2][2]= true;
		world[2][3]= true;
		world[3][1]= true;
		world[3][2]= true;
	}

	/**
	 * Initializes the world to the Beacon pattern.
	 * <pre>
	 * ..........
	 * .@@.......
	 * .@........
	 * ....@.....
	 * ...@@.....
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the Beacon pattern.
	 */		
	public static void initializeBeacon(boolean[][] world) {

		// TODO: Implement this method	
		//initialize to all false values
		clearWorld( world );
		//in the world set the cells to true that are alive for the 
		// Beacon pattern.
		world[1][1]= true;
		world[1][2]= true;
		world[2][1]= true;
		world[3][4]= true;
		world[4][3]= true;
		world[4][4]= true;


	}

	/**
	 * Initializes the world to the Boat pattern.
	 * <pre>
	 * ..........
	 * .@@.......
	 * .@.@......
	 * ..@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the Boat pattern.
	 */		
	public static void initializeBoat(boolean[][] world) {
		// TODO: Implement this method
		//initialize to all false values
		clearWorld( world );

		//in the world set the cells to true that are alive for the 
		// Boat pattern.
		world[1][1]= true;
		world[1][2]= true;
		world[2][1]= true;
		world[2][3]= true;
		world[3][2]= true;		


	}	
	/**
	 * Initializes the world to the R-pentomino pattern.
	 * <pre>
	 * ..........
	 * ..@@......
	 * .@@.......
	 * ..@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the R-pentomino pattern.
	 */		
	public static void initializeRpentomino(boolean[][] world) {
		// TODO: Implement this method
		//initialize to all false values
		clearWorld(world);


		//in the world set the cells to true that are alive for the 
		// R-pentomino pattern.	
		world[1][2]= true;
		world[1][3]= true;
		world[2][1]= true;
		world[2][2]= true;
		world[3][2]= true;


	}	
	/**
	 * Initialize the GameOfLife world with a random selection of cells alive. 
	 * 
	 * @param world  the existing double dimension array that will be 
	 * reinitialized to a Random pattern.
	 */	
	public static void initializeRandomWorld(boolean[][] world){
		// TODO: Implement this method	    	

		//initialize to all false values
		clearWorld(world);
		//loop through every row
		for (int i = 0; i < world.length; i++){
			//here we are within a row, so loop through every column
			for (int j = 0; j < world[0].length; j++){
				//for the cell in the specific row and column, give it a 
				//true value 'Config.CHANCE_ALIVE' percent of the time.
				//(hint: if Config.CHANCE_ALIVE is 0.25, then there should be 
				// about a 25% chance this cell is alive.  
				// Recall that the nextDouble() method from the java.util.Random 
				// class returns a uniformly distributed double value between 
				// 0.0 and 1.0.)   
				if( Config.RNG.nextDouble() < Config.CHANCE_ALIVE) {
					//set cell to be alive
					world[i][j] = true;
				}
			}
		}
	}

	/** 
	 * Whether a cell is living in the next generation of the game.
	 * 
	 * The rules of the game are as follows:
	 * 1) Any live cell with fewer than two live neighbors dies, as if caused
	 *    by under-population.
	 * 2) Any live cell with two or three live neighbors lives on to the next 
	 *    generation.
	 * 3) Any live cell with more than three live neighbors dies, as if by 
	 *    overcrowding.
	 * 4) Any dead cell with exactly three live neighbors becomes a live cell, 
	 *    as if by reproduction.
	 * 
	 * @param numLivingNeighbors The number of neighbors that are currently
	 *        living.
	 * @param cellCurrentlyLiving Whether the cell is currently living.
	 * 
	 * @return True if this cell is living in the next generation.    
	 */
	public static boolean isCellLivingInNextGeneration( 
			int numLivingNeighbors, 
			boolean cellCurrentlyLiving) {
		// TODO: Implement this method	
		// Initial isCellLivingInNextGeneration to false.
		boolean isCellLivingInNextGeneration = false;
		//If current cell is alive, let it dead unless the number of neighbors 
		//is 2 or 3.
		if(cellCurrentlyLiving){
			if (numLivingNeighbors < 2){
				isCellLivingInNextGeneration = false;
			}
			else if (numLivingNeighbors == 2 ||numLivingNeighbors == 3){
				isCellLivingInNextGeneration = true;
			}
			else {
				isCellLivingInNextGeneration = false;
			}
		}
		//If current cell is dead, let it be alive when the number of neighbors
		// is 3.
		else{
			if (numLivingNeighbors == 3){
				isCellLivingInNextGeneration = true;
			}
			else{
				isCellLivingInNextGeneration = false;
			}
		}

		return isCellLivingInNextGeneration;
	}


	/**
	 * Whether a specific neighbor is alive.
	 *
	 * Check whether the specific cell is alive or dead.
	 * 
	 * Note that cellRow and cellColumn may not be valid. If the cellRow is 
	 * less than 0 or greater than the number of rows -1 
	 * then the cell is outside the world. If the cellColumn is less than 0 
	 * or is greater than the number of columns -1 then 
	 * the cell is outside the world. Return false for any cell outside the 
	 * world.
	 * 
	 * @param world The current world.
	 * @param neighborCellRow The row of the cell which we are wanting to know
	 *  is alive.
	 * @param neighborCellColumn The column of the cell for which we are wanting
	 *  to know is alive.
	 * 
	 * @return Whether the cell is alive.
	 */	
	public static boolean isNeighborAlive(boolean [][]world, 
			int neighborCellRow, int neighborCellColumn) {

		// TODO: Implement this method  
		//Create a bigger world to put the current one in the middle.
		//Every cells in the initial world has 8 neighbors now.
		boolean[][]BiggerWorld = new boolean[world.length+2][world[0].length+2];
		clearWorld(BiggerWorld);
		//if valid row index
		if(neighborCellRow<0 || neighborCellRow >= Config.WORLD_ROWS){
			return false;
		}
		//if valid column index
		else if(neighborCellColumn<0 ||
				neighborCellColumn>= Config.WORLD_COLUMNS){
			return false;
		}
		else{
			//Put the current one in the middle.
			for(int i = 0; i < world.length; i++){
				for(int j = 0; j < world[0].length; j++){
					BiggerWorld[i+1][j+1]=world[i][j];
				}
			}
			//Check the state of the cell applied by other method
			if(BiggerWorld[neighborCellRow+1][neighborCellColumn+1]){
				return true;
			}
			else{
				return false;
			}
		}
	}

	/**
	 * Counts the number of neighbors that are currently living around the 
	 * specified cell.
	 *
	 * A cell has eight neighbors. The neighbors are the cells that are 
	 * horizontally, vertically and diagonally adjacent.
	 * 
	 * Note that if a specific cell is on the edge of the world then it may not 
	 * have neighboring cells.  For example: for the 0'th row (top row) of the 
	 * world there are not any rows above it.
	 * Assume all those cells are dead (have false values).
	 * 
	 * @param world The current world.
	 * @param cellRow The row of the cell for which we are looking for 
	 * neighbors.
	 * @param cellColumn The column of the cell for which we are looking for 
	 * neighbors.
	 * 
	 * @return The number of neighbor cells that are currently living.
	 */
	public static int numNeighborsAlive(boolean[][] world, int cellRow, 
			int cellColumn) {
		// TODO: Implement this method		
		int numNeighborsAlive = 0;
		//neighbors in the row above
		if(isNeighborAlive(world, cellRow-1, cellColumn-1)){
			numNeighborsAlive++;
		}
		if(isNeighborAlive(world, cellRow-1, cellColumn)){
			numNeighborsAlive++;
		}
		if(isNeighborAlive(world, cellRow-1, cellColumn+1)){
			numNeighborsAlive++;
		}
		//neighbors in the row below
		if(isNeighborAlive(world, cellRow+1, cellColumn-1)){
			numNeighborsAlive++;
		}
		if(isNeighborAlive(world, cellRow+1, cellColumn)){
			numNeighborsAlive++;
		}
		if(isNeighborAlive(world, cellRow+1, cellColumn+1)){
			numNeighborsAlive++;
		}
		//neighbor to the left
		if(isNeighborAlive(world, cellRow, cellColumn-1)){
			numNeighborsAlive++;
		}
		//neighbor to the right
		if(isNeighborAlive(world, cellRow, cellColumn+1)){
			numNeighborsAlive++;
		}
		return numNeighborsAlive;
	}

	/**
	 * Determines the next generation of the world.
	 * 
	 * @param currentWorld The world currently shown. 
	 * @param newWorld The new world to determine by looking at
	 * each cells neighbors in the current world. 
	 */
	public static void nextGeneration(boolean[][] currentWorld, 
			boolean[][] newWorld) {
		// TODO: Implement this method		

		//for each row
		for (int i =0; i < currentWorld.length; i++){
			//for each column
			for (int j =0; j <currentWorld[0].length; j++ ){
				//determine the number of neighbors that are alive for the 
				//specific cell

				//determine whether the cell should be alive the next generation

				newWorld[i][j]=isCellLivingInNextGeneration(
						numNeighborsAlive(currentWorld,i,j)
						,currentWorld[i][j]);
			}
		}
		// Assign every element in the newWorld to the currentWorld
		for (int i = 0; i < newWorld.length; i++){
			for (int j = 0; j < newWorld[0].length; j++){
				currentWorld [i][j] = newWorld[i][j];
			}
		}
	}

	/**
	 * Prints out the world showing each cell as alive or dead.
	 * 
	 * Loops through every cell of the world. If a cell is alive, print out
	 * the Config.ALIVE character, otherwise the Config.DEAD character. 
	 * 
	 * Tracks how many cells are alive and prints out the number of cells alive
	 * or that no cells are alive.
	 * 
	 * @param patternName The name of the pattern chosen by the user. 
	 * @param world The array representation of the current world. 
	 * @param generationNum The number of the current generation.  
	 */    
	public static void printWorld( String patternName, boolean[][] world, 
			int generationNum) {
		// TODO: Implement this method    	
		//declare and initialize local variables
		int numOfCellsAlive = 0;
		//print out pattern and generation
		//for each row in the world
		for (int i =0; i < world.length; i++){
			//for each column in the world
			for (int j = 0; j< world[0].length; j++){
				//if the cell is alive
				if (world[i][j]){
					numOfCellsAlive++;
					System.out.print(Config.ALIVE);
				}
				//otherwise if the cell is dead.
				else {
					System.out.print(Config.DEAD);
				}
			}
			//print an new line char at the end of a row
			System.out.println();
		}

		//print out the number of cells alive.
		System.out.println(numOfCellsAlive+" cells are alive.");

	}
}