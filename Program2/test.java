import java.util.Iterator;
import java.util.Scanner;


public class test {
	public static void main(String[] args){
		//System.out.println("sssss");
		PacketLinkedList<String> list = new PacketLinkedList<String>();
		System.out.println(list.isEmpty());
		//System.out.println("after instantiation");
		list.add("a");
		/*list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");*/
		
		//System.out.println("after add a");
		list.add(0,"b");
		//System.out.println("after add b");
		list.add(2,"c");
		//System.out.println("after add c");
		list.add(3,"d");
		//System.out.println("after add d");
		list.add(1,"e");
		//System.out.println("after add e");
		PacketLinkedListIterator<String> itr = list.iterator();
		while(itr.hasNext()){
			//System.out.println("in the loop");
			System.out.print(itr.next());
			
		}
		/*String s = list.get(0);//
		System.out.println(s);
		boolean b = list.contains("/n");
		System.out.println();
		
		System.out.println(b);
		System.out.println(list.isEmpty());*/
		
		list.remove(1);
		//System.out.println("after loop");
		System.out.println();
		itr = list.iterator();
		while(itr.hasNext()){
			//System.out.println("in the loop");
			System.out.print(itr.next());
			
		}
		
		
		
	}
	
	
	
	
	
	
	


	// ONLY FOR TEST USE!
	//DELETE THIS!

	private SimplePacket askForNextPacket1() {

		int i;
		boolean b = true;
		byte[] by = {1};
		Scanner s = new Scanner(System.in);
		System.out.println("nextInt");
		i = s.nextInt();
		/*System.out.println("nextboolean");
		b = s.nextBoolean();*/


		SimplePacket a = new SimplePacket(i,b,by);
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
