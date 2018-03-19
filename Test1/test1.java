import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wzwfa
 *
 */
public class test1 {

	/**
	 * @param args
	 */
	public int myAtoi(String str) {
        
        if(str.length() == 0)
            return 0;
        
        while((str.charAt(0) == ' ' || str.charAt(0) == '\t' || str.charAt(0) == '\n') && str.length() >= 2){
            str = str.substring(1, str.length());
        }
            
        
        
        if(str.length() == 0)
            return 0;
        
        ArrayList<Integer> buff = new ArrayList<Integer>();
        
        boolean sign = false;
        if(str.charAt(0) == '+'){
            buff.add( 0);
        }else if(str.charAt(0) == '-'){
            buff.add( 0);
            sign = true;
        }else if(str.charAt(0) >= 48 && str.charAt(0) <= 57){
            buff.add( str.charAt(0) - 48);
        }else{
            return 0;
        }
        
        
        for(int i = 1; i< str.length(); i++){
            if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                buff.add( str.charAt(i) - 48 );
            }
            else
                break;
        }
        double ret = 0;
        for(int i = 0; i < buff.size(); i++){
            ret = ret * 10 + buff.get(i);
        }
        
        if(sign){
            ret *= -1;
        }
        
        if(ret >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(ret <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)ret;
        }
    }
	
	public static void main(String[] args){
		test1 t = new test1();
		int temp = t.myAtoi("2147483648");
		System.out.println(temp);
	}

}
