import java.io.File;
import java.util.*;

public class Search{
	private ArrayList<Search> closed;
	private ArrayList<Search> open;
	private int m;
	private int n;
	private int d;
	private int p1;
	private int p2;
	private Queue<Search> q;
	private Stack<Search> stk;
	private String nextLine;
	private Search pap;

	private Search(int p1, int p2, Search pap){
		this.p1 = p1;
		this.p2 = p2;
		this.pap = pap;
	}

	private int getP1(){
		return p1;
	}

	private int getP2(){
		return p2;
	}

	private Search getPap(){
		return pap;
	}

	private void initial(String s1, String s2, String s3){
		

		m = Integer.parseInt(s1);
		n = Integer.parseInt(s2);
		d = Integer.parseInt(s3);
		
		
		/*
		Scanner scr = new Scanner(System.in);
		//System.out.println("Please enter 3 integers m, n, and d where m >= n");
		//System.out.print("m = ");
		if(scr.hasNext()){
			nextLine = scr.next();
			m = Integer.parseInt(nextLine);

			// need to check m >= n;
			//System.out.print('\n'+"n = ");
			nextLine = scr.next();
			n = Integer.parseInt(nextLine);

			//System.out.print('\n'+"d = ");
			nextLine = scr.next();
			d = Integer.parseInt(nextLine);

		}
		scr.close();
		//System.out.println("m = "+ m +" n = "+ n +" d = " + d );
		 */ 






	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Search firstState = new Search(0,0, null);
		firstState.initial(args[3],args[4],args[5]);

		int t1 = firstState.BFS();
		int t2 = firstState.DFS();
		if(t1 == -1 && t2 == -1){
			System.out.println('\n'+"Unsolvable");
		}

	}

	private boolean isClosed(Search s){

		int len = closed.size();
		for(int i = 0; i < len; i++){
			if(s.getP1() == closed.get(i).getP1()  &&
					s.getP2() == closed.get(i).getP2())  {
				return true;
			}
		}

		return false;

	}

	private void route(Search s){
		if(s.getPap() == null){
			System.out.print("(" + s.getP1() + ", " + s.getP2() + ") ");
		}else{
			route(s.getPap());
			System.out.print("(" + s.getP1() + ", " + s.getP2() + ") ");
		}
	}

	private int BFS(){
		Search s = new Search(0,0, null);
		closed = new ArrayList<Search>();
		q = new LinkedList<Search>();
		q.add(s);
		int count = 0;
		System.out.println("BFS");
		System.out.print("Iteration:");
		while(!q.isEmpty()){
			s = q.poll();
			// check if s is in the closed
			// if not
			if(isClosed(s)){

			}else{
				// put s into closed

				closed.add(s);
				// check if s is the goal state
				if(isGoal(s)){
					System.out.println();
					System.out.println("Result:");
					//System.out.println("I think I need a back pointer!");
					route(s);
					return 0;
				}else{
					System.out.println();
					System.out.println(count);
					count++;

					for(int i = 0 ; i < closed.size(); i++){
						System.out.print(
								"(" + closed.get(i).getP1() + ", " + closed.get(i).getP2() + ") ");
					}
					System.out.println();
					Succs(s);
					for(int  i= 0; i < open.size(); i++){
						q.add(open.get(i));
					}

				}
			}// end of else

		}// end while
		return -1;
	}

	private int DFS(){
		Search s = new Search(0,0, null);
		closed = new ArrayList<Search>();
		stk = new Stack<Search>();
		stk.push(s);
		int count = 0;
		System.out.println();
		System.out.println("DFS");
		System.out.print("Iteration:");
		while(!stk.isEmpty()){
			s = stk.pop();
			// check if s is in the closed
			// if not
			if(isClosed(s)){

			}else{
				// put s into closed

				closed.add(s);
				// check if s is the goal state
				if(isGoal(s)){
					System.out.println();
					System.out.println("Result:");
					//System.out.println("I think I need a back pointer!");
					route(s);
					return 0;
				}else{
					System.out.println();
					System.out.println(count);
					count++;

					for(int i = 0 ; i < closed.size(); i++){
						System.out.print(
								"(" + closed.get(i).getP1() + ", " + closed.get(i).getP2() + ") ");
					}
					System.out.println();
					Succs(s);
					for(int  i= 0; i < open.size(); i++){
						stk.push(open.get(i));
					}

				}
			}// end of else

		}
		return -1;
	}




	private boolean isGoal(Search s){
		if(s.getP1() == this.d && s.getP2() == 0){
			return true;
		}

		return false;
	}

	private void Succs(Search s){
		// keep everything in order!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		int p1 = s.getP1();
		int p2 = s.getP2();
		open = new ArrayList<Search>();
		if(p1 < this.m){
			// ¡°(1 first) m fill
			open.add(new Search(this.m, p2, s));
			System.out.print("(" + this.m + ", " + p2 + ") ");
			//System.out.println("(1 first) m fill");
		}if(p2 < this.n){
			// (2) n fill
			open.add(new Search(p1, this.n, s));
			System.out.print("(" + p1 + ", " + this.n + ") ");
			//System.out.println("(2) n fill");
		}if(p1 > 0){
			// (3) m empty
			open.add(new Search(0, p2, s));
			System.out.print("(" + 0 + ", " + p2 + ") ");
			//System.out.println("(3) m empty");
		}if(p2 > 0){
			// (4) n empty
			open.add(new Search(p1, 0, s));
			System.out.print("(" + p1 + ", " + 0 + ") ");
			//System.out.println("(4) n empty");
		}if( (this.n - p2) > 0 && p1 > 0){
			// (5) m pour
			int temp1 = p1 - n + p2;
			if(temp1 >= 0){
				open.add(new Search(temp1, n, s));
				System.out.print("(" + temp1 + ", " + n + ") ");
				//System.out.println("(5-1) m pour");
			}else if(temp1 < 0){
				open.add(new Search(0, p1 + p2, s));
				System.out.print("(" + 0 + ", " + (p1+p2) + ") ");
				//System.out.println("(5-2) m pour");
			}

		}if((this.m - p1) > 0 && p2 > 0){
			// (6 last) n pour
			if(p1 + p2 > this.m){
				open.add(new Search(this.m, p2- m + p1, s));
				System.out.print("(" + this.m + ", " + (p2- m + p1) + ") ");
				//System.out.println("(6-1 last) n pour");
			}else if(p1 + p2 <= this.m){
				open.add(new Search(p1+p2, 0, s));
				System.out.print("(" + (p1+p2) + ", " + 0 + ") ");
				//System.out.println("(6-2 last) n pour");
			}

		}

	}



}// end of Search
