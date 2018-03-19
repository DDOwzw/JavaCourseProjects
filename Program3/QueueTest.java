
public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> m= new Queue();
		System.out.println("size = " +m.size());
		System.out.println("start = " +m.start +" end = " + m.end);
		m.enqueue(1);
		System.out.println("start = " +m.start +" end = " + m.end);
		m.enqueue(2);
		System.out.println("start = " +m.start +" end = " + m.end);
		m.enqueue(5);
		System.out.println("start = " +m.start +" end = " + m.end);
		System.out.println(m);
		
		m.enqueue(6);
		System.out.println("start = " +m.start +" end = " + m.end);
		System.out.println("size = " + m.size());
		System.out.println(m);
		System.out.println("peek = "+ m.peek());
		System.out.println("start = " +m.start +" end = " + m.end);
		
		
		System.out.println("deque = "+ m.dequeue());
		System.out.println("start = " +m.start +" end = " + m.end);
		
		System.out.println("deque = "+ m.dequeue());
		System.out.println("start = " +m.start +" end = " + m.end);
		
		System.out.println("deque = "+ m.dequeue());
		System.out.println("start = " +m.start +" end = " + m.end);
		
		System.out.println("deque = "+ m.dequeue());
		System.out.println("start = " +m.start +" end = " + m.end);
		
		m.enqueue(10);
		m.enqueue(20);
		m.enqueue(30);
		m.enqueue(40);
		m.enqueue(50);
		m.enqueue(60);
		m.enqueue(70);
		System.out.println(m);
		System.out.println("start = " +m.start +" end = " + m.end);
		
		System.out.println("peek = "+ m.peek());
		
		/*
		
		System.out.println("dequ " + m.dequeue());
		System.out.println(m.size());
		System.out.println(m);
		
		System.out.println("dequ " + m.dequeue());
		System.out.println(m.size());
		System.out.println(m);
		
		System.out.println("dequ " + m.dequeue());
		System.out.println(m.size());
		System.out.println(m);
		
		System.out.println("dequ " + m.dequeue());
		System.out.println(m.size());
		System.out.println(m);
		
		*/
		
		
		
		
		//System.out.println("dequ " + m.dequeue());
		//System.out.println(m.size());
		//System.out.println(m);
		/*for(int i = 0; i < 10; i++){
			m.enqueue(i);
		}
		m.enqueue(1);
		
		System.out.println(m);
		
		while(!m.isEmpty()){
			System.out.println(m.dequeue());
		}*/
		
		
	}

}
