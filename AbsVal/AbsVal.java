/**
 * 
 */

/**
 * @author wzwfa
 *
 */
public class AbsVal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double c = 0;
		double y, glmin = 100;
		double gX = 0;
		while(c < 10){
			y = Math.abs(1.5-c)+Math.abs(4.8-c)+
					Math.abs(5.4-c)+Math.abs(9.5-c)+
					Math.abs(9.5-c)+Math.abs(9.6-c)+Math.abs(9.7-c);
			//System.out.print(y+"  ");
			if(glmin > y){
				glmin = y;
				gX = c;
			}
			if (y <= 17.16 && y >= 17.09){
				System.out.println(c + "  "+ y);
			}
			c = c + 0.001;
		}
		System.out.println();
		System.out.println("global min = "+glmin);
		System.out.println("C = "+gX);
	}

}
