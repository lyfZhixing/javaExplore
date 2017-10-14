package myTomcat.servlet;

import java.io.IOException;

import myTomcat.http.MyRequest;
import myTomcat.http.MyResponse;
import myTomcat.http.MyServlet;

public class FirstServlet extends MyServlet{

	@Override
	public void doGet(MyRequest request, MyResponse response) throws IOException {
		response.write("first servlet doGet");
	}

	@Override
	public void doPost(MyRequest request, MyResponse response) throws IOException {
		response.write("first servlet doPost");		
	}

}
