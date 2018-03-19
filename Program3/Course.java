///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (P3)
// Files:            (Course.java)
// Semester:         (CS367) Spring 2016
//
// Author:           (Zhongwei WANG)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Deppler)
// Lab Section:      (Lecture 2)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     ()
// Email:            ()
// CS Login:         ()
// Lecturer's Name:  ()
// Lab Section:      ()
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class to represent every Course in our Course Registration environment
 * 
 * @author CS367 & Zhongwei Wang
 *
 */

public class Course
{
	// all the fields
	private String courseCode;
	private String name;
	// Number of students allowed in the course
	private int maxCapacity;
	// Number of students enrolled in the course
	private int classCount;
	// The PriorityQueue structure Should be private!!!!!!!!!!!!!!!!!!!!!!!!
	PriorityQueue<Student> registrationQueue;
	// List of students who are finally enrolled in the course
	private List<Student> courseRoster;




	/**
	 * The constructor of the class.
	 * 
	 * @param classCode
	 *            the courseCode of the course
	 * @param name
	 *            the name of the course
	 * @param maxCapacity
	 *            the number of the students that the course could be chosed
	 */

	public Course(String classCode, String name, int maxCapacity)
	{
		// TODO initialize all parameters

		//Reconsider whether the classcode is coursecode!!!!!!!!!!!
		courseCode = classCode;
		this.name = name;
		this.maxCapacity = maxCapacity;
		registrationQueue = new PriorityQueue<Student>();
		courseRoster = new ArrayList<Student>();


	}

	/**
	 * Creates a new PriorityqueueItem - with appropriate priority(coins) and
	 * this student in the item's queue. Add this item to the registrationQueue.
	 * 
	 * @param student
	 *            the student
	 * @param coins
	 *            the number of coins the student has
	 */
	public void addStudent(Student student, int coins)
	{
		// This method is called from Studentcenter.java

		// Enqueue a newly created PQItem.
		// Checking if a PriorityQueueItem with the same priority already 
		// exists is done in the enqueue method.

		// TODO : see function header
		PriorityQueueItem<Student> a = new PriorityQueueItem<Student>(coins);
		a.add(student);
		registrationQueue.enqueue(a);
	}

	/**
	 * Populates the courseRoster from the registration list.
	 * Use the PriorityQueueIterator for this task.
	 */
	public void processRegistrationList()
	{
		// TODO : populate courseRoster from registrationQueue
		// Use the PriorityQueueIterator for this task.

		// Set classCount to zero.
		classCount = 0;

		// Maybe we should set it to the current number of 
		// students in the course
		//classCount = courseRoster.size();


		Iterator<PriorityQueueItem<Student>> i = registrationQueue.iterator();
		while(i.hasNext()){

			Queue<Student> a = i.next().getList();

			while(!a.isEmpty() && classCount < maxCapacity){
				courseRoster.add(a.dequeue());
				classCount ++;
			}

		}

	}

	public String getCourseName()
	{
		// TODO
		return name;
	}

	public String getCourseCode()
	{
		// TODO
		return courseCode;
	}

	public List<Student> getCourseRegister()
	{
		// TODO Reconsider!!!!!
		return courseRoster;
	}



	/*

	// for debug use DELETE IT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String toString(){
		String a = "";
		a = "courseName " +name+ " CouseNum "+courseCode +" Cap " + maxCapacity;

		return a;
	}

	 */


}
