import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//run-->run configuration-->Arguments-->program Arguments-->
	// �Կո�Ϊ�ֽ磬һ���ո�ǰ��������������ֻ�ܶ���string��Ȼ�����½���file���ӵ����������string name�ϣ���file���ļ���
public class CommandLineTrial {

	public static void main (String[] args) throws FileNotFoundException{
		for(String a : args){
			//System.out.println(a);
			File file = new File(a);
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()){
				System.out.println(readFile.nextLine());
			}
		}
	}
	
	
	
	
}
