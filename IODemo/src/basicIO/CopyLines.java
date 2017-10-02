package basicIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 面向行的I/O
 * @author lyf
 *
 */
public class CopyLines {

	public static void main(String[] args) throws IOException{
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		
		inputStream = new BufferedReader(new FileReader("xanadu.txt"));
		outputStream = new PrintWriter(new FileWriter("out.txt"));
		
		try {
			String l = "";
			while((l = inputStream.readLine()) != null){
				outputStream.println(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(inputStream != null){
				inputStream.close();
			}
			if(outputStream != null){
				outputStream.close();
			}
		}
	}

}
