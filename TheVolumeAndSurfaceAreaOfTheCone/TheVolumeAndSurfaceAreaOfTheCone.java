///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            TheVolumeAndSurfaceAreaOfTheCone
//Files:            TheVolumeAndSurfaceAreaOfTheCone.java
//Semester:         Fall 2015
//
//Author:           Zhongwei Wang zwang685@wisc.edu
//CS Login:         zhongwei
//Lecturer's Name:  DEPPELER
//Lab Section:      311
//
//PAIR PROGRAMMERS COMPLETE THIS SECTION
//Pair Partner:     (name of your pair programming partner and their email address)
//CS Login:         (partner's login name)
//Lecturer's Name:  (name of your partner's lecturer)
//Lab Section:      (your partner's lab section number)
//
//STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
//Credits:          Lab #1 Eclipse tutorial instructions
////////////////////////////80 columns wide //////////////////////////////////

/** 
 * Application that displays the volume and surface area of the cone with given
 * radius and height to console window.
 * There is a warning that "in" is never closed, but I don't know how
 * to end an input.
 * Besides, I did this alone in my home, because the lab time was not enough.
*/ 

import java.util.*;

public class TheVolumeAndSurfaceAreaOfTheCone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Program execution begins here.
		 */
		Scanner in=new Scanner(System.in);
		System.out.println("please enter the radius of the cone: ");
			  double r=in.nextDouble();//This is to input radius.
		System.out.println("Please enter the height of the cone: ");
			  double h=in.nextDouble();//This is to input height.
		double l = Math.sqrt(r*r + h*h);
		double s = r*(l+r)* Math.PI;
		double v = (h*(Math.PI*r*r))/3;
		/**
		 * First allow user to input the radius and the height.
		 * Then scan and save these as double separately.
		 * @param (r) (The radius that user input.)
		 * @param (h) (The height that user input.)
		 * @param (l) (The line that cut the cone's surface into a fan.)
		 * @param (s) (The surface area of the cone.)
		 * @param (v) (The volume of the cone.)
		 */
		System.out.println("The Volume is :"+v);
		//This is to output the volume.
		System.out.println("The Surface Area is :"+s);
		//This is to output the surface area.
	}

}