
public class main {
	public static void main(String[] args){
		ListADT<String> myList = new SimpleArrayList<String>();
		//items added to myList...
		for(int i = 0; i < 10; i++)
			myList.add(i+"");


		int pos = 0;
		String[] list = myList.get();
		for(int i = 0; i < 10; i ++){
			System.out.print(list [pos]);
			pos++;
		}
		System.out.println();
		pos = 0;
		for(int i = 0; i < 10; i ++){
			System.out.print(myList.get()[pos]);
			pos++;
		}

	}


	public static <E> ListADT<E> intersection( ListADT<E> list1, ListADT<E> list2 ) throws NullListException {
		SimpleArrayList<E> newList = new SimpleArrayList<E>();
		
		if((list1 == null) || (list2 == null))
			throw new NullListException();
		
		if(list1.isEmpty() || list2.isEmpty())
			return newList;
		
		else{
			
			Iterator<E> iter1 = list1.iterator();
			Iterator<E> iter2 = list2.iterator();
			while(iter1.hasNext()){
				E item1 = iter1.next();
				while(iter2.hasNext()){
					E item2 = (E) iter2.next();
					if(item2.equals(item1)){
						newList.add(item1);
					}
				}
				iter2 = list2.iterator();
			}
			return newList;
		}
		
	}















}
