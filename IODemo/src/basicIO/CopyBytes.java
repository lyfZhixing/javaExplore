package basicIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 程序用字节流来实现8位（8-bit）字节的输入和输出。所有字节流类都是从InputStream和OutputStream继承来的。
 *字节流的种类有很多，为了说明字节流是如何工作的，我们将聚焦文件IO字节流，FileInputStream和FileOutputStream
 *所有其他流类型都是建立在字节流之上的。字节流可以处理所有类型的文件，但是有乱码的风险。
 *在该程序中使用int变量读取和存入，字节流中在int变量的后8位存放字符值。
 *CopyBytes看起来像一个正常的程序，但实际上它表述了一种应该避免使用的低级别I/O。
 *字节流应该只用于最基本（primitive）I/O.
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
