import java.util.Iterator;

public class PQIteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();

		PriorityQueueItem<Integer> item = new PriorityQueueItem<Integer>(1);
		item.add(1);
		p.enqueue(item);

		PriorityQueueItem<Integer> item2 = new PriorityQueueItem<Integer>(2);
		item2.add(2);
		p.enqueue(item2);

		PriorityQueueItem<Integer> item3 = new PriorityQueueItem<Integer>(3);
		item3.add(3);
		p.enqueue(item3);

		PriorityQueueItem<Integer> item4 = new PriorityQueueItem<Integer>(4);
		item4.add(4);
		p.enqueue(item4);

		PriorityQueueItem<Integer> item5 = new PriorityQueueItem<Integer>(5);
		item5.add(5);
		p.enqueue(item5);

		PriorityQueueItem<Integer> item6 = new PriorityQueueItem<Integer>(4);
		item6.add(6);
		p.enqueue(item6);

		Iterator i = p.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}




	}

}
