package basicIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 面向行的I/O
 * 缓冲流：程序可以用包装的做法把未缓冲流转换为缓冲流
 * 包装未缓冲流可以用四个缓冲流类：BufferedInputStream和BufferedOutputStream用以创建缓冲字节流
 * 而BufferedReader和BufferedWriter用以创建缓冲字符流
 * 调用flush方法手动刷新缓冲流
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
