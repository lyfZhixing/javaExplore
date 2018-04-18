package lyf.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lyf.dao.PaggingDao;
import lyf.entity.Torder;
import lyf.util.JDBCUtil;
import lyf.util.Paging;

public class PaggingService {

	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public int countRows(){
		int result = 0;
		Connection con = null;
		
		try {
			con = JDBCUtil.getConnection();
			PaggingDao pqd = new PaggingDao(con);
			result = pqd.countRows();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(con, null, null);
		}
		
		return result ;
	}
	/**
	 * ��ҳ��ѯ
	 * @param paging
	 * @return
	 * @throws SQLException
	 */
	public List<Torder> queryTorder(Paging paging) throws SQLException{
		List<Torder> list = new ArrayList<Torder>();
		Connection con = null;
		
		try {
			con = JDBCUtil.getConnection();
			PaggingDao pqd = new PaggingDao(con);
			list = pqd.queryTorder(paging);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(con, null, null);
		}
		
		return list;
	}
}
