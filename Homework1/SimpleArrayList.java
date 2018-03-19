import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements ListADT<E>, Iterable<E>{
	private E[] items;
	private int numItem;
	private Iterator<E> iterator;

	public SimpleArrayList ()throws ClassCastException{
		numItem = 0;
		items = (E[]) new Object[100]; 
	}

	public E[] get() {
		return items;
	}

	public E get(int pos){
		return items[pos];
	}

	public void add(E newItem){
		items[numItem] = newItem;
		numItem++;
	}
	public void add(int pos, E newItem){

	}

	public E remove(int pos){
		return items[pos];

	}

	public int size(){
		return numItem;
	}
	
	public boolean isEmpty(){
		if(numItem == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public Iterator<E> iterator(){
		return iterator;
	}

	
	
	private SimpleArrayList<E> myList;
	private int currPos;
	
	public SimpleArrayList(SimpleArrayList <E> list){
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





