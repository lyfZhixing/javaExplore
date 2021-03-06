package myTomcat.catalina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import myTomcat.http.MyRequest;
import myTomcat.http.MyResponse;
import myTomcat.http.MyServlet;

public class MyTomcat {

	private int port = 8089;
	private ServerSocket server = null;
	//读取配置文件
	private Properties pro = null;
	//存放servlet的url与ClassName的映射
	private Map<String,Class<?>> servletMaping = new HashMap<String, Class<?>>();
	
	public MyTomcat(){
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("web.properties");
		BufferedReader bfReader = null;
		pro = new Properties();
		try {
			bfReader = new BufferedReader(new InputStreamReader(in,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			pro.load(bfReader);
			//取出key集合
			for(Object x : pro.keySet()){
				String key = x.toString();
				if(key.endsWith(".url")){
					String name = key.replaceAll("\\.url", "");
					String url = pro.getProperty(key);
					String className = pro.getProperty(name+".name");
					System.out.println("name:"+name+"\n"+"url:"+url+"\n"+"className:"+className);
					try {
						servletMaping.put(url, Class.forName(className));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.out.println("找不到类");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bfReader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("流关闭异常");
			}
		}
	}
	public MyTomcat(int port){
		this.port = port;
	}
	
	public void start(){
		try {
			server = new ServerSocket(port);
			System.out.println("服务器启动成功，端口号："+port);
			while(true){
				Socket client = server.accept();
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();
				
				MyRequest request = new MyRequest(in);
				MyResponse response = new MyResponse(out);
				//从servletMaping中取出key和value
				String url = request.getUrl();
				System.out.println(url);
				//判断url是否匹配上
				boolean isExist = false;
				
				try {
					for(Entry<String, Class<?>> entry : servletMaping.entrySet()){
						//判断url是否匹配上
						if(entry.getKey().equals(url)){
							MyServlet myservlet = (MyServlet)entry.getValue().newInstance();
							myservlet.service(request, response);
							isExist = true;
							break;
						}
					}
				} catch (Exception e) {
					response.write("\n 500 错误 \n" +Arrays.toString(e.getStackTrace()));
				}
				
				if(isExist == false){
					response.write("\n 404 not found  \n");
				}
				
				Map<String,String> params = request.getParamsMap();
				for(Entry<String,String> entry : params.entrySet()){
					System.out.println(entry.getKey()+"-----"+entry.getValue());
				}
				
				client.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("端口启动失败");
		}
	}
	
	public static void main(String[] args) {
		new MyTomcat().start();
	}
}