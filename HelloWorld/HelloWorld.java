///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            HelloWorld
// Files:            HelloWorld.java
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
 * Application that displays "Hello, "and the name you input to console window.
 * There is a warning that "input" is never closed, but I don't know how
 * to end an input.
 * Besides, I did this alone in my home, because the lab time was not enough.
 */ 

import java.util.*;
/**
 * In order to use the Scanner input, I need to import java.util.Scanner first.
 */
public class HelloWorld implements Comparable <HelloWorld>{
	/**
	 * Program execution begins here.
	 * 
	 * 
	 */
	private int b =2;
	public static int si = 1000;
	static String s = "nibambi";
	public HelloWorld(){
		si += 1;
	}
	public String toString(){
		return "sb\n";
	}
	
	private static ArrayList <Integer> a;
	public static void main(String [] args){
		
		System.out.println(-1/2);
		/*String x = null;
		x.equals(null);
		
		new HelloWorld().sb();
		Object asf = new Object();
		//String ifi = (String) asf;
		
		for(int i = 0; i< 10; i++){
			System.out.print(new HelloWorld().compareTo(new HelloWorld()));
			new HelloWorld().sb();
		}
		
		try{
			new nephe().hen(a);
		}
		catch(NullPointerException e){
			System.out.println("\t NullPointerException");
		}catch(IndexOutOfBoundsException e){
			System.out.println("\t IndexOutOfBoundsException");
		}finally{
			System.out.println("\t Finally statements");
			new test(2).twoOb();
			System.out.print(s);
		}*/
		/*String s = "";
		int i = 1;
		double d = 1.0;
		float f = 1.0f;
		char c = '\n';
		long l = 1L;
		short a = 1;
		boolean b = false;
		HelloWorld h = new HelloWorld();
		System.out.println(h.si);
		HelloWorld j = new HelloWorld();
		System.out.println(h.si);
		
		HelloWorld k = new HelloWorld();
		System.out.println(h.si);
		String command = "";*/
		/*if (command == null){
			throw new Exception("null command");
		}else if (command.compareTo("") == 0){
			throw new Exception("empty command");
		}*/
	}
	/*public static char mystery( double a , int b , String s ) {
		return 's';
	}*/
	public void sb(){
		System.out.print(toString()+s.charAt(0));
	}
	
	public int compareTo(HelloWorld other){
		
		if(b-1 > 0)	return b-1;
		return 0;
		
	}
}




