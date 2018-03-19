// See Commenting Guide (Learn@UW)
// put file header here
///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (MyMazeProgram)
// Files:            (MyMazeProgram.java)
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
import java.util.Scanner;
import java.util.Random;

// put class header here
public class MyMazeProgram {
	/**
	 * This class is the main class for the MyMazeProgram.
	 * It is in a large loop so that it shall never crash or end until the user
	 * input a int 4 when in the main menu.
	 *
	 * <p>Bugs: (when asking the user to input a move(1,2,3 or 4 valid),and user
	 *input an invalid one, the counter(moves) doesnt't well.)
	 * @zhongwei WANG
	 */
	// put method header here
	public static void main(String[] args) {
		/**
		 * This part is to declare that I will use scanner and random.
		 * And also output a welcome message.
		 *  
		 * @param (n) (the variable that user choosed in the main menu)
		 * @param (junk) (nothing but to clear the buff and only for debug)
		 */

		// Scanner connected to keyboard for reading user input
		Scanner scnr = new Scanner(System.in);

		// Random number generated seeded according to Config file
		Random rng = new Random(Config.SEED);

		//System.out.println("The seed is " + Config.SEED);

		// DISPLAY WELCOME MESSAGE AND HELP
		System.out.println("Welcome to MyMazeProgram!");

		// Declare variables and describe their use
		int n = 0;
		String junk = "junk";

		// MAIN COMMAND LOOP
		// while the user has not selected the Exit value
		/**
		 * This part is for the making sure user input a valid int[1,4]
		 * And also to keep this problem going until the user input 4.
		 */
		while (n != 4)
		{
			// DISPLAY MENU
			System.out.println();
			System.out.println("1. Temperature Converter");
			System.out.println("2. Simple Robot Maze");
			System.out.println("3. Random Robot Maze with Obstacle");
			System.out.println("4. Exit");
			// DISPLAY COMMAND PROMPT
			System.out.print("Enter choice:");

			// Execute command and display results to user
			if (scnr.hasNextInt())
			{
				// IF the user intput is the correct type:
				n = scnr.nextInt();
				scnr.nextLine();
			}
			//System.out.println( "n=" + n );
			// READ (SCAN) user input
			else
			{
				System.out.println("Sorry, I don't understand that.");
				junk = scnr.nextLine();
			}



			// 1.Temp Converter Code 
			/**
			 * This part is for the 1. Temp Converter Program.
			 * I used one if-statements to make sure the input value is valid
			 * 
			 * @param (Fah) (degree in Fah)
			 * @param (Temp) (degree in C)
			 * @return ("XX F= YY C")
			 */
			if ( n == 1) {
				double Fah = 1.0;
				double Temp = 1.0;
				System.out.print("Enter Fahrenheit temperature:");

				//while(true)
				//{
				if (scnr.hasNextDouble()){
					Fah = scnr.nextDouble();
					scnr.nextLine();
					//break;
					Temp = (Fah - 32) * 5 / 9;
					System.out.println( Fah + "F=" + Temp + "C" );
				}
				else
				{
					junk = scnr.next();
					scnr.nextLine();
					System.out.println("Sorry, I don't understand that.");
					//System.out.print("Enter Fahrenheit temperature:");
				}
				//}
				//System.out.println( "Fah=" + Fah );
				//Temp = (Fah - 32) * 5 / 9;
				//System.out.println( Fah + "F=" + Temp + "C" );

			}

			//2. Simple Robot Maze
			/**
			 * This part is for the 2. Simple Robot Maze Program.
			 * I used several if-statements to value what character should put
			 * in the maze.
			 * 
			 * @param (moves) (a counter counts how many steps that it takes)
			 * @param (xr) (horizontal position of Robot)
			 * @param (yr) (vertical position of Robot)
			 * @param (step) (means to go up/down/left/right or nothing)
			 * @return (a sized maze & "Congratulations! Robot is free!")
			 * @return	"It took XXXXX moves."
			 */
			else if ( n == 2) {
				int moves=0, xr=0, yr =0;
				int step = 0;
				System.out.println("Help Robot (R) get to Exit (E)");
				System.out.println("R o o o o ");
				System.out.println("o o o o o ");
				System.out.println("o o o o o ");
				System.out.println("o o o o o ");
				System.out.println("o o o o E ");
				while (xr!=4 || yr!=4)
				{
					System.out.println("1. up");
					System.out.println("2. down");
					System.out.println("3. left");
					System.out.println("4. right");
					System.out.print("Move?");
					do {
						if (scnr.hasNextInt())
						{
							step = scnr.nextInt();
							scnr.nextLine();
							if (step >= 1 && step <= 4)
							{
								//break;
							}
							else
							{
								moves=moves+1;
								//junk = scnr.nextLine();
								step = 0;
								//System.out.println("out of range");

								for (int y =0; y <= 4; y++)
								{
									for (int x =0; x <= 4; x++)
									{

										if ( x==xr)
										{
											if ( y ==yr)
											{
												System.out.print("R ");
											}
											else
											{
												System.out.print("o ");
											}
										}
										else if (x==4)
										{
											if (y==4)
											{
												System.out.print("E ");
											}
											else
											{
												System.out.print("o ");
											}
										}

										else
										{
											System.out.print("o ");
										}

										if (x == 4)
										{
											System.out.println();
										}
										else
										{
										}
									}
								}
								System.out.println("1. up");
								System.out.println("2. down");
								System.out.println("3. left");
								System.out.println("4. right");
								System.out.print("Move?");
							}
						}
						else
						{
							moves=moves+1;
							junk = scnr.nextLine();
							step = 0;
							//System.out.println("out of range");

							for (int y =0; y <= 4; y++)
							{
								for (int x =0; x <= 4; x++)
								{

									if ( x==xr)
									{
										if ( y ==yr)
										{
											System.out.print("R ");
										}
										else
										{
											System.out.print("o ");
										}
									}
									else if (x==4)
									{
										if (y==4)
										{
											System.out.print("E ");
										}
										else
										{
											System.out.print("o ");
										}
									}

									else
									{
										System.out.print("o ");
									}

									if (x == 4)
									{
										System.out.println();
									}
									else
									{
									}
								}
							}
							System.out.println("1. up");
							System.out.println("2. down");
							System.out.println("3. left");
							System.out.println("4. right");
							System.out.print("Move?");
							//System.out.println("not a num");
						}
					}while (step <1 || step>4);
					if (step==1)
					{
						yr=yr-1;
						moves=moves+1;
						if (yr < 0)
						{
							yr=0;
						}
						else if (yr>4)
						{
							yr=4;
						}
						else
						{

						}
					}
					else if (step==2)
					{
						yr=yr+1;
						moves=moves+1;
						if (yr < 0)
						{
							yr=0;
						}
						else if (yr>4)
						{
							yr=4;
						}
						else
						{

						}
					}
					else if (step==3)
					{
						xr=xr-1;
						moves=moves+1;
						if (xr < 0)
						{
							xr=0;
						}
						else if (xr>4)
						{
							xr=4;
						}
						else
						{

						}
					}
					else
					{
						xr=xr+1;
						moves=moves+1;
						if (xr < 0)
						{
							xr=0;
						}
						else if (xr>4)
						{
							xr=4;
						}
						else
						{

						}
					}
					if (xr==4)
					{
						if (yr==4)
						{
							System.out.println("Congratulations! Robot is free!");
							System.out.println("It took " +moves + " moves.");

						}
						else
						{
							for (int y =0; y <= 4; y++)
							{
								for (int x =0; x <= 4; x++)
								{

									if ( x==4)
									{
										if ( y ==yr)
										{
											System.out.print("R ");
										}
										else if (y == 4)
										{
											System.out.print("E ");
										}
										else {
											System.out.print("o ");
										}
									}
									/*else if (x==4)
									{
										if (y==4)
										{
											System.out.println("E ");
										}
										else
										{
											System.out.print("o ");
										}
									}*/

									else
									{
										System.out.print("o ");
									}

									if (x == 4)
									{
										System.out.println();
									}
									else
									{
									}
								}
							}
						}
					}
					else
					{
						for (int y =0; y <= 4; y++)
						{
							for (int x =0; x <= 4; x++)
							{

								if ( x==xr)
								{
									if ( y ==yr)
									{
										System.out.print("R ");
									}
									else
									{
										System.out.print("o ");
									}
								}
								else if (x==4)
								{
									if (y==4)
									{
										System.out.print("E ");
									}
									else
									{
										System.out.print("o ");
									}
								}

								else
								{
									System.out.print("o ");
								}

								if (x == 4)
								{
									System.out.println();
								}
								else
								{
								}
							}
						}
					}
				}
			}
			//3. Random Robot Maze with Obstacle
			/**
			 * This part is for the 3. Random Maze Program.
			 * I used several if statments to value what character should put
			 * in the maze.
			 * 
			 * @param (moves) (a counter counts how many steps that it takes)
			 * @param (xr) (horizontal position of Robot)
			 * @param (yr) (vertical position of Robot)
			 * @param (xe) (horizontal position of Exit)
			 * @param (ye) (vertical position of Exit)
			 * @param (xx) (horizontal position of obstacle "X")
			 * @param (yx) (vertical position of obstacle "X")
			 * @param (step) (means to go up/down/left/right or nothing)
			 * @param (N) (the input value of the size of the maze)
			 * @return (a random maze & "Congratulations! Robot is free!")
			 * @return	"It took XXXXX moves."
			 */
			else if ( n == 3) {
				int moves=0, xr=0, yr =0, xe=0, ye=0, xx=0, yx=0;
				int step = 0;
				int N =0;

				System.out.println("How big is the maze? ("+Config.MIN+"-"+Config.MAX+")");
				while (N <Config.MIN || N>Config.MAX)
				{

					if (scnr.hasNextInt())
					{

						N = scnr.nextInt();
						scnr.nextLine();
						if (N >=Config.MIN && N <= Config.MAX)
						{
							//break;

						}
						else
						{
							System.out.println("Must be between "+Config.MIN+" and "+Config.MAX+", inclusive.");
							System.out.println("How big is the maze? ("+Config.MIN+"-"+Config.MAX+")");

						}
					}


					else
					{
						System.out.println("Must be between "+Config.MIN+" and "+Config.MAX+", inclusive.");
						System.out.println("How big is the maze? ("+Config.MIN+"-"+Config.MAX+")");
						junk = scnr.nextLine();


					}

				}

				System.out.println("Help Robot (R) get to Exit (E)");

				xr = rng.nextInt( N ); 
				yr = 0; 
				xe = rng.nextInt( N ); 
				ye = N-1;
				xx = rng.nextInt( N ); 
				yx = rng.nextInt( N -2 ) +1; 

				//System.out.println("xx="+xx+";yx="+yx+";xr="+xr+";yr="+yr+";xe="+xe+";ye="+ye);
				//System.out.println("randInt="+randInt);
				for (int y=0; y <= N-1; y++)
				{
					for ( int x = 0; x <= N-1; x++)
					{
						if ( x==xx && y==yx )
						{
							System.out.print("X ");
						}
						else if ( x==xr && y==yr)
						{
							System.out.print("R ");
						}
						else if ( x==xe && y==ye)
						{
							System.out.print("E ");
						}
						else
						{
							System.out.print("o ");
						}
						if ( x== N-1)
						{
							System.out.println();
						}
						else
						{

						}
					}
				}
				while ( xr != xe || yr != ye)
				{
					System.out.println("1. up");
					System.out.println("2. down");
					System.out.println("3. left");
					System.out.println("4. right");
					System.out.print("Move?");
					do {
						if (scnr.hasNextInt())
						{
							step = scnr.nextInt();
							scnr.nextLine();
							if (step >= 1 && step <= 4)
							{
								//break;
							}
							else
							{
								moves=moves+1;
								//junk = scnr.nextLine();
								step = 0;

								for (int y=0; y <= N-1; y++)
								{
									for ( int x = 0; x <= N-1; x++)
									{
										if ( x==xx && y==yx )
										{
											System.out.print("X ");
										}
										else if ( x==xr && y==yr)
										{
											System.out.print("R ");
										}
										else if ( x==xe && y==ye)
										{
											System.out.print("E ");
										}
										else
										{
											System.out.print("o ");
										}
										if ( x== N-1)
										{
											System.out.println();
										}
										else
										{

										}
									}
								}
								System.out.println("1. up");
								System.out.println("2. down");
								System.out.println("3. left");
								System.out.println("4. right");
								System.out.print("Move?");
							}
						}
						else
						{
							moves=moves+1;
							junk = scnr.nextLine();
							step = 0;

							for (int y=0; y <= N-1; y++)
							{
								for ( int x = 0; x <= N-1; x++)
								{
									if ( x==xx && y==yx )
									{
										System.out.print("X ");
									}
									else if ( x==xr && y==yr)
									{
										System.out.print("R ");
									}
									else if ( x==xe && y==ye)
									{
										System.out.print("E ");
									}
									else
									{
										System.out.print("o ");
									}
									if ( x== N-1)
									{
										System.out.println();
									}
									else
									{

									}
								}
							}
							System.out.println("1. up");
							System.out.println("2. down");
							System.out.println("3. left");
							System.out.println("4. right");
							System.out.print("Move?");
						}
					}while (step <1 || step>4);
					if (step==1)
					{
						yr=yr-1;
						moves=moves+1;
						if (yr == yx && xr == xx)
						{
							yr=yr+1;
						}
						else
						{

						}
						if (yr < 0)
						{
							yr=0;
						}
						else if (yr>N-1)
						{
							yr=N-1;
						}
						else
						{

						}
					}
					else if (step==2)
					{
						yr=yr+1;
						moves=moves+1;
						if (yr == yx && xr == xx)
						{
							yr=yr-1;
						}
						else
						{

						}
						if (yr < 0)
						{
							yr=0;
						}
						else if (yr>N-1)
						{
							yr=N-1;
						}
						else
						{

						}
					}
					else if (step==3)
					{
						xr=xr-1;
						moves=moves+1;
						if (yr == yx && xr == xx)
						{
							xr=xr+1;
						}
						else
						{

						}
						if (xr < 0)
						{
							xr=0;
						}
						else if (xr>N-1)
						{
							xr=N-1;
						}
						else
						{

						}
					}
					else if (step==4)
					{
						xr=xr+1;
						moves=moves+1;
						if (yr == yx && xr == xx)
						{
							xr=xr-1;
						}
						else
						{

						}
						if (xr < 0)
						{
							xr=0;
						}
						else if (xr>N-1)
						{
							xr=N-1;
						}
						else
						{

						}
					}
					else
					{
						moves=moves+1;
					}
					if (xr==xe && yr==ye)
					{
						System.out.println("Congratulations! Robot is free!");
						System.out.println("It took " +moves + " moves.");

					}
					else
					{
						for (int y=0; y <= N-1; y++)
						{
							for ( int x = 0; x <= N-1; x++)
							{
								if ( x==xx && y==yx )
								{
									System.out.print("X ");
								}
								else if ( x==xr && y==yr)
								{
									System.out.print("R ");
								}
								else if ( x==xe && y==ye)
								{
									System.out.print("E ");
								}
								else
								{
									System.out.print("o ");
								}
								if ( x== N-1)
								{
									System.out.println();
								}
								else
								{

								}
							}
						}
					}
				}
			}

			// EXIT command
			/**
			 * This part is for 4.exit the program.
			 * 
			 * @return ("Live Long and Prosper!")
			 */
			else if ( n == 4) {
				System.out.println("Live Long and Prosper!");
				System.exit(-1);
			}
			/**
			 * This part is just for making sure the initial value of n won't
			 * matter the usage of the program.
			 */
			else if (n==0)
			{

			}
			// IGNORE UNRECOGNIZED command
			// ELSE the input is incorrect type

			// READ (SCAN) user input as a String
			// Display bad type message to user

			// Clear or reset variables if necessary before loop repeats
			/**
			 * This part is to let the user know that they miss type sth
			 * 
			 * @return ("Sorry, I don't understand that.")
			 */
			else
			{
				System.out.println("Sorry, I don't understand that.");
				junk = scnr.nextLine();
			}


		}
		// Close the scanner to avoid potential resource leak
		scnr.close();



	} // end of main method

} // end of MyMazeProgram class
