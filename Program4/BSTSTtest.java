import java.util.Iterator;
import java.util.List;

public class BSTSTtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTreeSetTester<Integer> a = new BSTreeSetTester<Integer>(10);
		a.add(2);
		//a.add(1);
		a.add(3);
		a.add(5);
		//a.add(4);
		a.add(10);
		System.out.println(a);
		a.displayTree(4);
		//System.out.println(a.isBalanced);





		//subset test
		List<Integer> l = a.subSet(4,6);
		for(int i  = 0; i < l.size(); i++){
			
			System.out.println(l.get(i));
			if(l.get(i) == null)
				System.out.println("null");
		}
			




		/*
		// size test
		System.out.println(a.size());
		 */
		/*
		// clear test
		a.clear();
		a.displayTree(4);
		 */

		/*
		//contain test
		System.out.print(a.contains(10));
		*/


		/*
		// sortArrayTest
		Integer[] n = new Integer[10];
		for(int i = 0; i< 10; i++)
		n[i] = i;
		a.sortedArrayToBST(n,0,9);
		 */

		//Iterator test

		
		Iterator<Integer> itr = new BSTIterator<Integer>(a.root);
		while(itr.hasNext()){
			System.out.print(itr.next());
		}







	}

}
