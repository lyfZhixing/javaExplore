package lyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import lyf.entity.Torder;
import lyf.service.PaggingService;
import lyf.util.Paging;

/**
 * Servlet implementation class PaggingServlet
 */
@WebServlet("/PaggingServlet")
public class PaggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PaggingServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json,charset=utf-8");
		
		String pageindexstr = request.getParameter("pageindex");
		String pagesizestr = request.getParameter("pagesize");
		int pageindex = 1;
		int pagesize = 3;
		if(pageindexstr != null && !pageindexstr.equals("")){
			pageindex = Integer.parseInt(pageindexstr.trim());
		}
		if(pagesizestr != null && !pagesizestr.equals("")){
			pagesize = Integer.parseInt(pagesizestr.trim());
		}
		
		Paging paging = new Paging();
		paging.setPageindex(pageindex);
		paging.setPagesize(pagesize);
		
		PaggingService pq = new PaggingService();
		PrintWriter out = response.getWriter();
		try {
			//paggingOut������յ�ǰҳ����Ϣ
			Paging paggingOut = new Paging();
			
			//��ȡ��ǰҳ�е�Torder�б��������paggingOut�����У�ת����json���ͷ�����ҳ��
			List<Torder> list = pq.queryTorder(paging);
			paggingOut.setList(list);
			//��ȡ���ݿ����ܼ�¼��
			int recordmax = pq.countRows();
			paggingOut.setRecordmax(recordmax);
			
			paggingOut.setPageindex(pageindex);
			paggingOut.setPagesize(pagesize);
			paggingOut.setPagemax(pagesize, recordmax);
			
			String json = JSON.toJSONString(paggingOut);
			out.print(json);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}


}
