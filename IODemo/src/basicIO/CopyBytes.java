package basicIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *字节流的种类有很多，为了说明字节流是如何工作的，我们将聚焦文件IO字节流，FileInputStream和FileOutputStream
 *所有其他流类型都是建立在字节流之上的。
 * 通过实例程序CopyBytes来用字节流实现复制xanadu.txt,一次一个字节
 */
public class CopyBytes {

	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("xanadu.txt");
			out = new FileOutputStream("out.txt");
			int c = 0;
			while((c = in.read()) != -1){		//-1表示已经达到了流末尾
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{							//在finally块中关闭流 
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
