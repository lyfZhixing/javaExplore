package myTomcat.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * http请求封装
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public class MyRequest {
	//请求方法
	private String method;
	//请求url，不包含参数
	private String url;
	//请求参数字符串可能含有&
	private String params;
	//将参数映射成Map
	private Map<String,String> paramsMap;
	//接受浏览器发送的请求输入流
	private InputStream in;
	
	public MyRequest(){}
	
	public MyRequest(InputStream in){
		this.in = in;
		//设置一个1024字节的字节缓冲区数组
		byte[] buffer = new byte[1024];
		//返回读取的实际字节数
		int length = 0;
		//接受请求头字符串
		String content = null;
		try {
			if((length = in.read(buffer)) > 0){
				content = new String(buffer,0,length);
			}
			System.out.println(content);
			//输出第一行
			String firstline = content.split("\\n")[0];
			System.out.println(firstline);
			//输出请求方法
			this.method = firstline.split("\\s")[0];
			System.out.println("方法："+method);
			//输出请求url
			String[] urls = firstline.split("\\s")[1].split("\\?");
			this.url = urls[0];
			//输出请求参数
			if(urls.length == 2){
				this.params = urls[1];
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String,String> getParamsMap(){
		paramsMap = new HashMap<String, String>(); 
		
		if(this.params != null){
			//解析get方法穿来的值
			if(this.method.equalsIgnoreCase("get")){
				if(this.params.indexOf("&") != -1){
					String[] param = params.split("\\&");
					for(String x : param){
						paramsMap.put(x.split("=")[0], x.split("=")[1]);
					}
				}else{
					paramsMap.put(params.split("=")[0], params.split("=")[1]);
				}
				//解析post方法穿来的值
			}else if(this.method.equalsIgnoreCase("post")){
				//未完待续
			}
		}
		
		return this.paramsMap;
	}
	
	public String getMethod(){
		return this.method;
	}
	public String getUrl(){
		return this.url;
	}
}
