package http;

import java.io.OutputStream;
/**
 * 
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public class MyResponse {
	private OutputStream out;

	public MyResponse() {
		super();
	}

	public MyResponse(OutputStream out) {
		super();
		this.out = out;
	}
	
	public void write(String outStr)throws Exception{
		out.write(outStr.getBytes());
		out.close();
	}
	
}
