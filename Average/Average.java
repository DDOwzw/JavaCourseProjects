///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Average		
// Files:            Average.java
// Semester:         Fall 2015
//
// Author:           Zhongwei Wang zwang685@wisc.edu
// CS Login:         zhongwei
// Lecturer's Name:  DEPPELER
// Lab Section:      311
//
//                   PAIR PROGRAMMERS COMPLETE THIS SECTION
// Pair Partner:     (name of your pair programming partner and their email address)
// CS Login:         (partner's login name)
// Lecturer's Name:  (name of your partner's lecturer)
// Lab Section:      (your partner's lab section number)
//
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          Lab #1 Eclipse tutorial instructions
//////////////////////////// 80 columns wide //////////////////////////////////

/** 
 * Application that displays the average of the three numbers you input 
 * to console window.
 * There is a warning that "in" is never closed, but I don't know how
 * to end an input.
 * Besides, I did this alone in my home, because the lab time was not enough.
*/ 

import java.lang.reflect.Array;
import java.util.*;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Program execution begins here.
		 */
		
		Array.newInstance(Integer.class, 10);
		
		Scanner in=new Scanner(System.in);
		System.out.println("please enter a: ");
		    double a=in.nextDouble();//This is to input a
		System.out.println("Please enter b: ");
		    double b=in.nextDouble();//This is to input b
		System.out.println("Please enter b: ");
		    double c=in.nextDouble();//This is to input c
		double d=(a+b+c)/3; 
		/**
		 * First allow user to input three numbers.
		 * @param (a) (The first number input.)
		 * @param (b) (The second number input.)
		 * @param (c) (The third number input.)
		 * @param (d) (The average of that three.)
		 */
		System.out.println("The average of the three number is :"+d);
		//This is to output the result.
	}

}
