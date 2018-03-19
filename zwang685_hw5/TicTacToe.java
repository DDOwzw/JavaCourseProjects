///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (HW5)
// Files:            (TicTacToe.java)
// Semester:         (CS540) Fall 2016
//
// Author:           (Zhongwei WANG)
// wisc username     (zwang685)
// Email:            (zwang685@wisc.edu)
// CS Login:         (zhongwei)
// Lecturer's Name:  (Jerry Zhu)
// Class Section:    (Section 1)
// submission date   (10/26/2016)
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


import java.util.LinkedList;
import java.util.Queue;



/**
 * @author wzwfa
 *
 */
public class TicTacToe {
	private State<ABNode> ttt;
	private static char YesOrNo;
	private State<ABNode> bestChoice = new State<ABNode>();
	private LinkedList<State<ABNode>> succList;


	

	/**Main method
	 * @param args
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe t =  new TicTacToe();
		t.readComLine(args);
	}
	
	/**readComLine method
	 * It reads the command line first, and then create the first current state
	 * Since it is gurantee that next step is AI's choice, it calls the min method
	 * @param args   the command line
	 */	
	public void readComLine(String[] args){
		ttt = new State<ABNode>();
		// read from CommandLine
		for(int i = 0; i < args.length - 2; i++){
			String a = args[i+2];
			//System.out.print(a);
			if(a.equalsIgnoreCase("Y")){
				YesOrNo = 'Y';
				break;
			}else if(a.equalsIgnoreCase("N")){
				YesOrNo = 'N';
				break;
			}else if(a.equalsIgnoreCase("O")){
				ttt.add(new ABNode(i % 4, i /4 , 'O'));
				//System.out.println("O");
			}else if(a.equalsIgnoreCase("X")){
				ttt.add(new ABNode(i % 4, i /4 , 'X'));
				//System.out.println("X");
			}else if(a.equalsIgnoreCase("#")){
				ttt.add(new ABNode(i % 4, i /4 , '#'));
				//System.out.println("#");
			}else if(a.equalsIgnoreCase("_")){
				ttt.add(new ABNode(i % 4, i /4 , '_'));
				//System.out.println("_");
			}
		}
		int b2 = min(ttt, -2, 2);

		System.out.println("SOLUTION");
		printAr(bestChoice);

	}
	
	/**printAr method
	 * 
	 * @param s the state that needed to be printed
	 */	
	public void printAr(State<ABNode> s){
		for(int i = 0; i < s.size(); i++){
			ABNode a = s.get(i);
			if(i % 4 == 3){
				System.out.println(a.getXO());
			}else{
				System.out.print(a.getXO() + " ");
			}
		}
		
	}
	
	/**printAr method
	 * print state with alpha beta value
	 * 
	 * @param s the state that needed to be printed
	 * @param alpha 
	 * @param beta
	 */	
	public void printAr(State<ABNode> s, int alpha, int beta){
		if(YesOrNo == 'Y'){
			printAr(s);
			System.out.println("Alpha: "+alpha+" Beta: "+ beta);
		}

	}
	
	/**copyState method
	 * 
	 * @param cur the state that needed to be copied
	 * @return a new State<ABNode> containing the same value with cur
	 */	

	public State<ABNode> copyState(State<ABNode> cur){
		State<ABNode> child = new State<ABNode>();
		for(int i = 0; i < cur.size(); i++){
			char temp = cur.get(i).getXO();
			child.add(new ABNode(i % 4, i /4 , temp));
		}
		return child;
	}

	/**checkWin method
	 * check whether some one wins or it is a duel or none of them above
	 * 
	 * @param cur the state that needed to be checked
	 */	
	public char checkWin(State<ABNode> cur){
		//"X" wins
		char win = '_';
		// center (1,1)
		win = cur.get(5).getXO();
		if(win == cur.get(0).getXO() && win == cur.get(10).getXO())
			return win;
		if(win == cur.get(1).getXO() && win == cur.get(9).getXO())
			return win;
		if(win == cur.get(2).getXO() && win == cur.get(8).getXO())
			return win;
		if(win == cur.get(4).getXO() && win == cur.get(6).getXO())
			return win;

		// center(1,2)
		win = cur.get(6).getXO();
		if(win == cur.get(1).getXO() && win == cur.get(11).getXO())
			return win;
		if(win == cur.get(2).getXO() && win == cur.get(10).getXO())
			return win;
		if(win == cur.get(3).getXO() && win == cur.get(9).getXO())
			return win;
		if(win == cur.get(5).getXO() && win == cur.get(7).getXO())
			return win;

		// 0,1,2 or 1,2,3 in the first row but no 0,1,2,3
		win = cur.get(1).getXO();
		if(win == cur.get(0).getXO() && win == cur.get(2).getXO() 
				&& win != cur.get(2).getXO())
			return win;
		if(win == cur.get(2).getXO() && win == cur.get(3).getXO()
				&& win != cur.get(0).getXO())
			return win;

		// 8,9,10 or 9,10,11 in the last row but no 8,9,10,11
		win = cur.get(9).getXO();
		if(win == cur.get(8).getXO() && win == cur.get(10).getXO()
				&& win != cur.get(11).getXO())
			return win;
		if(win == cur.get(10).getXO() && win == cur.get(11).getXO()
				&& win != cur.get(8).getXO())
			return win;

		// 0, 4, 8 first column
		win = cur.get(4).getXO();
		if(win == cur.get(0).getXO() && win == cur.get(8).getXO())
			return win;

		// 3,7,11 last column
		win = cur.get(3).getXO();
		if(win == cur.get(7).getXO() && win == cur.get(11).getXO())
			return win;



		// no winner,
		// check if the game is duel
		for(int i = 0; i < cur.size(); i++){
			if('_' == cur.get(i).getXO())
				win = '_';
		}// if game is not end, return _
		if(win == '_'){
			return '_';
			// if game is end but no winner, return # as duel
		}else{
			return '#';
		}

	}
	

	/**min method
	 * 
	 * @param cur
	 * @param alpha
	 * @param beta
	 * 
	 * @return int
	 */	
	public int min(State<ABNode> cur, int alpha, int beta){
		int value = beta;
		Queue<State<ABNode>> q = new LinkedList<State<ABNode>>();
		// Does the game end right now?
		char win = checkWin(cur);
		if('O' == win){
			// Player O wins
			value = 1;
			printAr(cur, alpha, beta);
			return beta = value;
		}else if('#' == win){
			// It's duel
			value = 0;
			printAr(cur, alpha, beta);
			return beta = value;
		}


		// find all successors
		q.addAll(Succ(cur, 'X'));
		// put them in the queue

		// for each succ, call max with it.
		for(State<ABNode> child: q){

			//beta = Math.min(beta, max(child, alpha, beta ));
			// find the best choice here!
			
			int newBeta = max(child, alpha, beta );
			if(newBeta < beta){
				beta = newBeta;
				bestChoice = child;
			}else{
				
			}
			
						
			if(alpha >= beta){
				printAr(cur, alpha, beta);
				return alpha;
			}

		}
		printAr(cur, alpha, beta);
		return beta;
	}

	/**max method
	 * 
	 * @param cur
	 * @param alpha
	 * @param beta
	 * 
	 * @return int
	 */	
	public int max(State<ABNode> cur, int alpha, int beta){


		int value = alpha;
		Queue<State<ABNode>> q = new LinkedList<State<ABNode>>();
		// Does the game end right now?
		char win = checkWin(cur);
		if('X' == win){
			// Player X wins
			value = -1;
			printAr(cur, alpha, beta);
			return alpha = value;
		}else if('#' == win){
			// It's duel
			value = 0;
			printAr(cur, alpha, beta);
			return alpha = value;
		}
		// find all successors
		q.addAll(Succ(cur, 'O'));
		// put them in the queue

		// for each succ, call max with it.
		for(State<ABNode> child: q){

			alpha = Math.max(alpha, min(child, alpha, beta ));
			if(alpha >= beta){
				printAr(cur, alpha, beta);
				return beta;
			}

		}
		printAr(cur, alpha, beta);
		return alpha;

		// return 0;
	}


	/**Succ method
	 * Put all successors into a queue
	 * @param cur
	 * @param player
	 * @return LinkedList<State<ABNode>>
	 */	

	public LinkedList<State<ABNode>> Succ(State<ABNode> cur, char player){

		succList = new LinkedList<State<ABNode>>();

		for(int i = 0; i < cur.size(); i++){
			if(cur.get(i).getXO() == '_'){
				State<ABNode> child = new State<ABNode>();
				for(int j = 0; j < cur.size(); j++){
					char temp = cur.get(j).getXO();
					if(j == i)
						temp = player;
					child.add(new ABNode(j % 4, j /4 , temp));

				}
				/*printAr(child);
				System.out.println();*/
				succList.add(child);
			}
		}

		return succList;
	}



}
