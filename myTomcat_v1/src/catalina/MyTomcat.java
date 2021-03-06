package catalina;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import http.MyRequest;
import http.MyResponse;
import http.MyServlet;
import servlet.MyFirstServlet;
/**
 * 启动入口
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public class MyTomcat {

	private int port = 8080;
	ServerSocket server = null;
	
	public MyTomcat(){
		super();
	}
	
	public MyTomcat(int port){
		super();
		this.port = port;
	}
	
	public void start(){
		try {
			server = new ServerSocket(port);
			System.out.println("服务器启动成功,端口号="+this.port);
			while(true){
				Socket client = server.accept();
				InputStream in = client.getInputStream();
				OutputStream out = client.getOutputStream();
				
				MyRequest request = new MyRequest(in);
				MyResponse response = new MyResponse(out);
				MyServlet servlet = new MyFirstServlet();
				servlet.service(request, response);
				
				response.write("hello,world");
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("分发器异常");
		}
	}
	
	public static void main(String[] args){
		new MyTomcat().start();
	}
}
