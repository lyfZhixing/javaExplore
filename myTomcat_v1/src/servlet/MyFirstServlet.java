package servlet;

import http.MyRequest;
import http.MyResponse;
import http.MyServlet;
/**
 * 
 * @author 	lyf
 * 日期：		2017年10月14日
 */
public class MyFirstServlet extends MyServlet {

	@Override
	public void doGet(MyRequest request, MyResponse response) throws Exception {
		response.write("this is doGet");
	}

	@Override
	public void doPost(MyRequest request, MyResponse response) throws Exception {
		response.write("this is doPost");
	}

}
