///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (RecipeWrangler)
// Files:            (RecipeWrangler.java)
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

//import packages that is needed
import java.io.*;
import java.util.*;

/**
 * The RecipeWrangler class represents an instance of the RecipeWrangler.
 * It contains a main method that will call different method to deal with
 * recipes.
 * It can sort recipes, read recipes from txt files and output into other files.
 * Also, you can input new recipes in the application.
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 12.12
 * @see also
 */


public class RecipeWrangler {
	// Store the instances of the objects that you create for the applications
	// in these member variables: 
	// Private Object Scanner scnr(connected to the keyboard),
	// Private Object RecipeList recipe, will store a list of recipes
	// Private String recipeName, the name of the recipe
	// Private String ingredients, the ingredients of the recipe
	// Private String instructions, the instructions of the recipe
	private Scanner scnr = new Scanner(System.in);
	private RecipeList recipe = new RecipeList();
	private String recipeName,ingredients,instructions;

	/**
	 * This is the main method.
	 * Main method will call the default constructor of RecipeWrangler,
	 * and then the new created object recipeWrangler will be able to call the
	 * in-static methods.
	 * 
	 * 
	 * @param args - command line arguments
	 */

	public static void main(String[] args) {
		// create an object named recipeWrangler in RecipeWrangler type to call
		// instant methods.
		RecipeWrangler recipeWrangler = new RecipeWrangler();
		recipeWrangler.mainMenu();
	}//end of main

	/**
	 * This is the method of main menu.
	 * Almost all of the skeleton of the application are built in this method.
	 * In the method, it will show a welcome MSG first,
	 *  "Recipe Wrangler 2015"
	 *  "Let us help you keep track of your favorite recipes."
	 * And then show the main menu;
	 *  "Main Menu"
	 *  "---------"
	 *	"1. Display recipe names (sorted)"
	 *	"2. Display/Edit/Add a recipe"
	 *	"3. Load recipes from a file"
	 *	"4. Save recipes to a file"
	 *	"5. Exit"
	 *	"Enter choice: "
	 * And read the choice from user to decide which method to call in the next
	 * step.
	 * 
	 * @param 
	 * @return void
	 */

	private  void mainMenu(){
		// Create an int type to hold the choice from user.
		int mainMenuChoice = 0;
		// Show the welcome MSG
		System.out.println("Recipe Wrangler 2015"+'\n'+
				"Let us help you keep track of your favorite recipes.");
		// Use while-loop to repeat main menu until user choice 5 to end the 
		// application.
		while(mainMenuChoice != 5){
			// show the main menu
			System.out.print("Main Menu"+'\n'+
					"---------"+'\n'+
					"1. Display recipe names (sorted)"+'\n'+
					"2. Display/Edit/Add a recipe"+'\n'+
					"3. Load recipes from a file"+'\n'+
					"4. Save recipes to a file"+'\n'+
					"5. Exit"+'\n'+
					"Enter choice: ");
			// Call readChoice method to read the user's choice
			mainMenuChoice = readChoice();
			// Call different methods depending on the choice of user.
			// If choose 1, call the displayRecipe method
			// If choose 2, call the editRecipe method
			// If choose 3, call the readRecipeFromFile method
			// If choose 4, call the saveRecipeToFile method
			// If choose 5, print the end MSG
			switch(mainMenuChoice){
			case (1):{
				displayRecipe();
				break;
			}
			case (2):{
				editRecipe();
				break;
			}
			case (3):{
				readRecipeFromFile();
				break;
			}
			case (4):{
				saveRecipeToFile();
				break;
			}
			case (5):{
				System.out.println("Thanks for using RecipeWrangler!");
				break;
			}
			default :{
				break;
			}
			}//end of switch;
		}
	}//end of mainMenu;

	/**
	 * editRecipe method.
	 * Read what the user types and change it into uppercase;
	 * Save the string as recipeName(the field in the class);
	 * Then read and save whatever user inputs as ingredients and instructions;
	 * Finally create a new object in Recipe type with the three variables(
	 * recipeName,ingredients, and instructions if there is not already one in
	 * the recipe list.
	 * If there is already one in the recipe list, ask the user whether to 
	 * update the ingredients or instructions or do nothing but return to the 
	 * 
	 * main menu.
	 * @param 
	 * @return void
	 */

	private void editRecipe(){
		// Show the implement to let user input a recipe name
		System.out.print("What is the name of the recipe? ");
		// Use scanner to scanner the input string and save it into the field
		recipeName = scnr.nextLine();
		// Change the name into Upper case
		recipeName=recipeName.toUpperCase();
		// Detect whether there is already the same recipe in the list;
		// If not, save the recipe;
		// If there is already one, ask the user whether to update the 
		// information of the recipe or not.
		if(recipe.size() == 0){
			System.out.println("Adding recipe for: "+recipeName);
			System.out.println("Enter the ingredients:");
			ingredients = scnr.nextLine();
			System.out.println("Enter the instructions:");
			instructions = scnr.nextLine();
			recipe.add(new Recipe(recipeName,ingredients,instructions));
		}else{
			int i = checkRecipe(recipeName);
			if (i >= 0){
				System.out.println("Found recipe for: " + recipeName);
				System.out.println("Recipe name: " + recipeName);
				System.out.println("Ingredients: " + 
						recipe.get(i).getingredients());
				System.out.println("Instructions: " + 
						recipe.get(i).getinstructions());
				int choice = 0;
				// print implements to guild the user whether to do since there
				// is already a same recipe in the list.
				// Choose 1 to edit ingredient list;
				// Choose 2 to edit instructions;
				// Choose 3 to finish editing;
				// This step will repeat until user input 3 or input any invalid
				// inputs.
				do{
					System.out.print("1. Edit ingredient list"+'\n'+
							"2. Edit instructions"+'\n'+
							"3. Done editing"+'\n'+
							"Enter choice: ");
					if(scnr.hasNextInt()){
						choice = scnr.nextInt();
					}
					scnr.nextLine();

					switch (choice){
					case (1):{
						System.out.println("Enter the ingredients:");
						ingredients = scnr.nextLine();
						recipe.get(i).setingredients(ingredients);

						System.out.println("Recipe name: "+
								recipe.get(i).getRecipeName());
						System.out.println("Ingredients: "+
								recipe.get(i).getingredients());
						System.out.println("Instructions: "+
								recipe.get(i).getinstructions());
						break;
					}case(2):{
						System.out.println("Enter the instructions:");
						instructions = scnr.nextLine();
						recipe.get(i).setinstructions(instructions);

						System.out.println("Recipe name: "+
								recipe.get(i).getRecipeName());
						System.out.println("Ingredients: "+
								recipe.get(i).getingredients());
						System.out.println("Instructions: "+
								recipe.get(i).getinstructions());
						break;
					}case (3):{

						break;
					}default :{
						break;
					}
					}//end of switch
				}while(choice ==1 || choice == 2);
			}else{
				System.out.println("Adding recipe for: "+recipeName);
				System.out.println("Enter the ingredients:");
				ingredients = scnr.nextLine();
				System.out.println("Enter the instructions:");
				instructions = scnr.nextLine();
				recipe.add(new Recipe(recipeName,ingredients,instructions));
			}
		}//end of else;
	}//end of editRecipe;

	/**
	 *  checkRecipe method.
	 * In this method, the parameter string: recipeName will be checked.
	 * This method will find in which index that has the same recipe name with
	 * the one that user typed. And then return the index number.
	 * If not found, return -1.
	 * 
	 * @param recipeName - A string type which stands the user input recipe name
	 * @return int - The index of the recipe in the recipe list; if there is no
	 * elements match the name in the list, return -1.
	 */

	private int checkRecipe(String recipeName){
		// Create an int type to save the number of index in the recipelist.
		// The default value is -1.
		int indexOfRecipe = -1;
		// Check every elements in the recipe list to find one with the same
		// name, save the index number into the local variable indexOfRecipe.
		for (int i = 0; i < recipe.size(); i++){
			if(recipeName.equals(recipe.get(i).getRecipeName())){
				indexOfRecipe =i;
			}
		}
		// return the index number(variable indexOfRecipe).
		return indexOfRecipe;
	}//end of checkRecipe;

	/**
	 * displayRecipe method.
	 * Print "No recipes" if the recipe list is empty.
	 * Sort the recipe list first, and then print every elements in the list.
	 * 
	 * @void
	 */

	private void displayRecipe(){
		// Print "No recipes" if the recipe list is empty.
		if(recipe.isEmpty()){
			System.out.println("No recipes");
		}else{
			// Call the sort method in the recipeList class to sort the list.
			recipe.sort();
			// Print the list element by element.
			for(int i = 0; i < recipe.size(); i++){
				System.out.println(recipe.get(i));
			}
		}
	}//end of displayRecipe

	/**
	 * saveRecipeToFile method.
	 * Guild the user to input an filename and save it into the local variable.
	 * Create a new file with the filename in the default pathway.
	 * Call sort method to sort the list.
	 * Print the list to the file. (Print the total number in the list first.)
	 * If FileNotFoundException happened, print a warning MSG to the console.
	 * 
	 * @void
	 */

	private void saveRecipeToFile(){
		// Print an implement to guild the user to input an filename.
		System.out.print("Enter filename: ");
		// Create a local variable and initial it with the string user typed.
		String fileName = scnr.nextLine();
		// Create a new file in the default pathway with the name user typed.
		File file = new File(fileName);
		// Call the sort method in the recipeList class to sort the list.
		recipe.sort();
		// Print the list to the file.
		try{PrintWriter output = new PrintWriter(file);
		output.println(recipe.size());
		for(int i = 0; i < recipe.size(); i++){
			output.print(recipe.get(i).printToFile());
		}
		// close the PrintWriter connected to the file.
		output.close();
		}catch(FileNotFoundException exception){
			// Print a warning MSG when FileNotFoundException happens.
			System.out.println("Unable to write to file: " + fileName);
		}
		// Print the results of this method.
		System.out.println("Saved "+recipe.size()+" recipes to "+fileName);
	}//end of saveRecipeToFile

	/**
	 * readRecipeFromFile method.
	 * The method can read the recipes from a file.
	 * 
	 * 
	 * @void
	 */

	private void readRecipeFromFile(){
		// Create local variable in String type newrecipe to save the string
		// read from the file.
		// Create local variable in String type firstLine to save the first 
		// line read from the file.
		String newrecipe,firstLine;
		// Create local variable in int type numberOfInput to count the recipes
		// input from the file, set it to 0.
		int numberOfInput = 0;
		// Create local variable in indexOfRecipe type numberOfInput to hold the 
		// index of the recipe list; set it to -1.
		int indexOfRecipe = -1;
		// Print an implement to tell the user to input the file name.
		System.out.print("Enter filename: ");
		// Save the string read from user's input.
		newrecipe = scnr.nextLine();
		// Create an object in File type connected to the input filename.
		File file = new File(newrecipe);
		// Try to read the file and save the valid input from the file into the
		// list of recipe. If the recipe is exist, update it; if not exist,
		// create it and save it into the list.
		// If the file cannot read, print an waning MSG to the console.
		try{
			Scanner readFile = new Scanner(file);

			firstLine = readFile.nextLine();

			while(readFile.hasNextLine()){
				recipeName = readFile.nextLine().toUpperCase();
				ingredients = readFile.nextLine();
				instructions = readFile.nextLine();
				if (!recipeName.isEmpty()){
					if(!recipe.isEmpty()){
						indexOfRecipe = checkRecipe(recipeName);
						if(indexOfRecipe == -1){
							recipe.add(new Recipe(recipeName,
									ingredients,instructions));
							System.out.println("Added "+recipeName);
							numberOfInput++;
						}else{
							System.out.println("Updated "+recipeName);
							recipe.get(indexOfRecipe).setingredients(
									ingredients);
							recipe.get(indexOfRecipe).setinstructions(
									instructions);
							numberOfInput++;
						}
					}else{
						recipe.add(new Recipe(recipeName,
								ingredients,instructions));
						System.out.println("Added "+recipeName);
						numberOfInput++;
					}
				}
			}//end of while
			readFile.close();
		}catch(FileNotFoundException exception){
			System.out.println("Unable to read from file: "+ newrecipe);
		}
		System.out.println("Added "+numberOfInput+" recipes from "+newrecipe);

	}//end of readRecipeFromFile

	/**
	 * readChoice method.
	 * In this method, the user input will be detected.
	 * If the input is valid(from 1 to 5), return the input value;
	 * If not valid, print a MSG to the console, telling the user to type again
	 * until the input is valid.
	 * 
	 * @return int 
	 */

	private int readChoice(){
		// Create an int mainMenuChoice to save the int value input from user.
		// Set the default value to -1.
		int mainMenuChoice = -1;
		// Create an boolean type valid, if the input is valid, set it to true.
		// Set the default value to false.
		boolean valid = false;
		do {
			try {
				// If the input is not an Int, throw NumberFormatException.
				mainMenuChoice = Integer.parseInt(scnr.nextLine());
				// If the input is not between 1 and 5, throw 
				// InvalidInputException.
				if(mainMenuChoice <1 || mainMenuChoice > 5){
					throw new InvalidInputException(
							"Enter integer choice between 1-5: ");
				}
				// If the input is valid, set the variable valid to true.
				valid = true;
			} catch (NumberFormatException exception) {
				// Print a warning MSG to tell the user that his/her input is 
				// invalid and let him/her input again.
				System.out.print("Enter integer choice between 1-5: ");

			} catch (InvalidInputException exception){
				// Print a warning MSG to tell the user that his/her input is 
				// invalid and let him/her input again.
				System.out.print("Enter integer choice between 1-5: ");

			}
		} while (!valid);
		return mainMenuChoice;
	}



}//end of class;