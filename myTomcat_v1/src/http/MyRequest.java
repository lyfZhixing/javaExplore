package http;

import java.io.IOException;
import java.io.InputStream;

/**
 * http请求封装
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public class MyRequest {
	
	private String method;	//请求方法
	private String params;	//请求参数
	private String url;		//请求地址
	private InputStream in;	//
	
	public MyRequest(){}
	
	public MyRequest(InputStream in){
		//解析http
		this.in = in;
		
		byte[] buffer = new byte[1024];
		int len = 0;
		String content = null;
		try {
			if((len = in.read(buffer)) > 0){
				//ͨ通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String
				content = new String(buffer,0,len);
			}
			System.out.println(content);
			//取出第一行
			String line = content.split("\n")[0];
			System.out.println(line);
			//
			String[] arr = line.split("\\s");
			//取方法
			this.method = arr[0];
			//取url
			String[] urls = arr[1].split("\\?");
			this.url = urls[0];
			if(urls.length == 2){
				this.params = urls[1];
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getMethod() {
		return method;
	}


	public String getParams() {
		return params;
	}


	public String getUrl() {
		return url;
	}

	
	
	
}
