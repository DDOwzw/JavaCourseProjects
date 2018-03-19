
public class test{
	public static void main (String[] argu){
		
		Listnode<Integer> head = new Listnode(1);
		for(int i = 0; i < 10; i++){
			Listnode<Integer> next = new Listnode(i);
			head.setNext(next);
		}
		while(head != null){
			System.out.println(head.getData());
			head = head.getNext();
		}
		
		System.out.println("Over");
		int  x = 1;
		head = methodC(head, x); //initial methodC call
		System.out.println(head.getData());

	}

	
	public static Listnode<Integer> methodC(Listnode<Integer> curr, Integer x) {
	    if (curr == null) return null;
	    if (curr.getData() == x)
	        return methodC(curr.getNext(), x);
	    curr.setNext(methodC(curr.getNext(), x));
	    return curr;
	}
}
