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

// import what is need in this class.
import java.util.*;

/**
 * The RecipeList class define a type of object in RecipeList type.
 * This RecipeList type is almost the same with an ArrayList type.
 * 
 * @author Zhongwei Wang, Ying Li
 * @version 12.12
 * @see also
 */

public class RecipeList {
	
	// Private field recipe in ArrayList <Recipe> type.
	
	private ArrayList <Recipe> recipe;

	/**
	 * RecipeList constructor.
	 * Initializes a new RecipeList object
	 * 
	 * @param 
	 */
	
	public RecipeList(){
		// initialize the field with a new ArrayList <Recipe>.
		recipe = new ArrayList <Recipe>();
	}

	/**
	 * Returns the size of the recipe.
	 * 
	 * @return the size of the recipe.
	 */
	
	public int size(){
		return this.recipe.size();
	}
	
	/**
	 * Adds another new element into the recipe.
	 * 
	 * @param newRecipe -Recipe type
	 */

	public void add(Recipe newRecipe){
		recipe.add(newRecipe);
	}
	
	/**
	 * Returns the element of the recipe in the required index.
	 * 
	 * @param index -int type, the index of element.
	 * @return the size of the recipe.
	 */
	
	
	public Recipe get(int index){
		return recipe.get(index);
	}

	/**
	 * Returns true if the recipe is empty.
	 *         false if the recipe is not empty.
	 * 
	 * @return true if the recipe is empty.
	 *         false if the recipe is not empty.
	 */
	
	public boolean isEmpty(){
		return this.recipe.isEmpty();
	}

	/**
	 * Sort method.
	 * Call the sort method in the ArrayList class to sort the list.
	 * 
	 * @param 
	 */
	
	public void sort(){
		this.recipe.sort(null);
	}

}
