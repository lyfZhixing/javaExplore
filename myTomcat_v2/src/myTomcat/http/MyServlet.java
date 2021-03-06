package myTomcat.http;

import java.io.IOException;

public abstract class MyServlet {

	public void service(MyRequest request,MyResponse response) throws IOException{
		if("get".equalsIgnoreCase(request.getMethod())){
			doGet(request,response);
		}
		if("post".equalsIgnoreCase(request.getMethod())){
			doPost(request,response);
		}
	}
	
	public abstract void doGet(MyRequest request,MyResponse response) throws IOException;
	
	public abstract void doPost(MyRequest request,MyResponse response)throws IOException;
}
