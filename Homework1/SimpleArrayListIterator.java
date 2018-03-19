import java.util.*;

public class SimpleArrayListIterator<E> implements Iterator<E>{
	private SimpleArrayList<E> myList;
	private int currPos;
	
	public SimpleArrayListIterator(SimpleArrayList<E> list){
		myList = list;
		currPos = 0;
		
	}
	
	public boolean hasNext(){
		return currPos < myList.size();
	}
	
	public E next(){
		if(currPos >= myList.size())
			throw new NoSuchElementException();
		E result = myList.get(currPos);
		currPos++;
		return result;
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
	
	
	
}
