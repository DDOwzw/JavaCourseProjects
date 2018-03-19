
import java.util.ArrayList;

public class nephe<E> {
	public static int n1;
	public static final int n2 = 0;
	public final int n3;
	
	public nephe(){
		n3= 100;
	}
	public nephe(int a){
		n3 = a;
	}
	
	
	@SuppressWarnings("finally")
	
	public void hen(ArrayList <Integer> a) throws NullPointerException {
		try{
			a.add(1);
		}catch(NullPointerException e){
			throw new NullPointerException();
		}finally{
			throw new IndexOutOfBoundsException();
		}
		
	}
}
