import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//run-->run configuration-->Arguments-->program Arguments-->
	// 以空格为分界，一个空格前后是两个变量。只能读成string型然后重新建立file链接到这个读到的string name上，打开file读文件！
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
