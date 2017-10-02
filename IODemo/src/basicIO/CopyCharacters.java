package basicIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 用字符流代替字节流的程序，能自动适应本地字符集，并做好国际化准备，这些都不需要程序员做额外的努力
 * 所有的字符流都是从Reader和Writer继承来的，FileReader和FileWrite专用于处理文件
 * 字符流使用int变量进行读取和存入时，在这个int变量的后16位存放字符值
 * 字节到字符"桥"流：InputStreamReader和OutputStreamWriter
 * 
 * @author lyf
 *
 */
public class CopyCharacters {

	public static void main(String[] args) throws IOException {
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		try {
			inputStream = new FileReader("xanadu.txt");
			outputStream = new FileWriter("out.txt");
			
			int c = 0;
			while((c = inputStream.read()) != -1){	//在c的后16位存放字符值
				outputStream.write(c);
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
                             