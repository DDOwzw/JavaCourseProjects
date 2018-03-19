///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (RecipeWrangler)
// Files:            (Recipe.java)
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
 * The Recipe class define a type of object in Recipe type.
 * This class implements the Comparable interface to make the Recipe type 
 * comparable.
 * The compareTo method is redefined to compare two recipe by the name;
 * The recipe will be sort in natural order by the name of the recipe.
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 12.12
 * @see also
 */

public class Recipe implements Comparable <Recipe>{
	// Private field to hold the name of the recipe.
	private String recipeName;
	// Private field to hold the ingredients of the recipe.
	private String ingredients;
	// Private field to hold the instructions of the recipe.
	private String instructions;

	/**
	 * Recipe constructor.
	 * Initializes a new Recipe object with the recipeName, ingredients, and
	 * instructions.
	 * 
	 * @param recipeName	  -String type, the name of the recipe
	 * @param ingredients	  -String type, the ingredients in this recipe
	 * @param instructions    -String type, the instructions in this recipe
	 */

	public Recipe(String recipeName, String ingredients, String instructions){
		// initialize the fields: recipeName, ingredients, instructions with the
		// params.
		this.recipeName = recipeName;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}

	/**
	 * Returns the name of the recipe.
	 * 
	 * @return the name of the recipe.
	 */

	public String getRecipeName(){
		return this.recipeName;
	}

	/**
	 * Sets the field name of the recipe.
	 * 
	 * @param recipeName -String type, the name of the recipe.
	 */

	public void setRecipeName(String recipeName){
		this.recipeName = recipeName;
	}

	/**
	 * Returns the ingredients of the recipe.
	 * 
	 * @return the ingredients of the recipe.
	 */

	public String getingredients(){
		return this.ingredients;
	}

	/**
	 * Sets the field ingredients of the recipe.
	 * 
	 * @param ingredients -String type, the ingredients of the recipe.
	 */

	public void setingredients(String ingredients){
		this.ingredients = ingredients;
	}

	/**
	 * Returns the instructions of the recipe.
	 * 
	 * @return the instructions of the recipe.
	 */

	public String getinstructions(){
		return this.instructions;
	}

	/**
	 * Sets the field instructions of the recipe.
	 * 
	 * @param instructions -String type, the instructions of the recipe.
	 */

	public void setinstructions(String instructions){
		this.instructions = instructions;
	}

	/**
	 * Returns the name of the recipe.
	 * Override the default one, when called it will return a string.
	 * 
	 * @return the name of the recipe.
	 */

	public String toString(){
		return this.recipeName;
	}

	/**
	 * return the name of the recipe, the ingredients, and the instructions
	 * each one in a new line.
	 * 
	 * @return the name of the recipe, the ingredients, and the instructions
	 * each one in a new line.
	 */

	public String printToFile(){
		return recipeName+'\n'+ingredients+'\n'+instructions+'\n';
	}

	/**
	 * Implements from the Comparable<Recipe> interface.
	 * return  -1 if the field is bigger than param;
	 *          0 if they are equal;
	 *          1 if the field is bigger than param.
	 * 
	 * @param other  -Recipe type, comparing two object with the name of recipe
	 * @return -1 if the field is bigger than param;
	 *          0 if they are equal;
	 *          1 if the field is bigger than param.
	 */

	public int compareTo(Recipe other){
		return this.recipeName.compareTo(other.getRecipeName());
	}

}
