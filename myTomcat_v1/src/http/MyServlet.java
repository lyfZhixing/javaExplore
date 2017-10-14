package http;
/**
 * 
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public abstract class MyServlet {

	public void service(MyRequest request,MyResponse response)throws Exception{
		if("GET".equalsIgnoreCase(request.getMethod())){
			doGet(request,response);
		}else if("POST".equalsIgnoreCase(request.getMethod())){
			doPost(request,response);
		}
	}
	
	public abstract void doGet(MyRequest request,MyResponse response)throws Exception;
	public abstract void doPost(MyRequest request,MyResponse response)throws Exception;
}
