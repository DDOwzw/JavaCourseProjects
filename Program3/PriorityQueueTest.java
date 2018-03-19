
public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		// test for PQI
		PriorityQueueItem<Integer> item = new PriorityQueueItem<Integer>(233);
		PriorityQueueItem<Integer> item2 = new PriorityQueueItem<Integer>(234);
		System.out.println();
		for(int i = 0; i < 11 ; i++)
		item.add(i);
		System.out.println(item.getList());
		System.out.println(item);*/
		
		
		
		
		
		//test for PQ
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		
		
		
		System.out.println("PQ's size = "+p.size());
		//System.out.println(p.isEmpty());
		PriorityQueueItem<Integer> item = new PriorityQueueItem<Integer>(1);
		item.add(null);
		item.add(1);
		item.add(1);
		
		
		//item.add(20);
		//item.add(30);
		//item.add(40);
		//System.out.println("QI = "+item.getList());
		p.enqueue(item);
		
		PriorityQueueItem<Integer> item2 = new PriorityQueueItem<Integer>(2);
		item2.add(2);
		//item2.add(2);
		
		p.enqueue(item2);
		//System.out.println(p.isEmpty());
		
		PriorityQueueItem<Integer> item3 = new PriorityQueueItem<Integer>(3);
		item3.add(3);
		p.enqueue(item3);
		
		PriorityQueueItem<Integer> item4 = new PriorityQueueItem<Integer>(4);
		item4.add(4);
		p.enqueue(item4);
		
		PriorityQueueItem<Integer> item5 = new PriorityQueueItem<Integer>(5);
		item5.add(5);
		p.enqueue(item5);
		
		PriorityQueueItem<Integer> item6 = new PriorityQueueItem<Integer>(1);
		item6.add(6);
		item6.add(7);
		item6.add(8);
		p.enqueue(item6);
		
		System.out.println(p);
		//System.out.println(p.dequeue());
		//System.out.println("new PQ is" + p);
		
		
		//System.out.println("peek = " +p.peek().getList());
	}

}
