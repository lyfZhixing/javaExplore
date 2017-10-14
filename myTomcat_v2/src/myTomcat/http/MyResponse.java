package myTomcat.http;

import java.io.IOException;
import java.io.OutputStream;
/**
 * http响应封装
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public class MyResponse {

	private OutputStream out = null;
	
	public MyResponse(){};
	
	public MyResponse(OutputStream out){
		this.out = out;
	}
	
	public void write(String outStr)throws IOException{
		out.write(outStr.getBytes());
		
	}
}
