import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Str implements Iterable<Str>{

	@Override
	public Iterator<Str> iterator() {
		// TODO Auto-generated method stub
		return null;
	}




	public static int removeAll(String target, LinkedList<String> chain) {
		//if target is null, throw an IllegalArgumentException
		if(target == null){
			throw new IllegalArgumentException();
		}
		int count = 0;
		LinkedList<String> curr = chain;

		while(curr != null){
			if(target.equals(curr.peek())){
				curr.pop();
				count ++;
			}
			curr.pop();

		}

		return count;
	}

}
