package lyf.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import lyf.util.IOUtil;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//生成文件上传核心类
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		try {
			//利用文件上传核心类解析request
			@SuppressWarnings("unchecked")
			List<FileItem> list = fileUpload.parseRequest(request);
			//遍历所有的FileItem
			for(FileItem item : list){
				if(item.isFormField()){
					//当前是一个普通字段
					String name = item.getFieldName();
					String value = item.getString();
					System.out.println(name+":"+value);
				}else{
					//当前是一个文件上传项
					String filename = item.getName();
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(this.getServletContext().getRealPath("upload/"+filename));
					IOUtil.in2out(in, out);
					IOUtil.close(in, out);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
