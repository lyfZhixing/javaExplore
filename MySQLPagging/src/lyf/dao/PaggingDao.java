package lyf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lyf.entity.Torder;
import lyf.util.JDBCUtil;
import lyf.util.Paging;

public class PaggingDao extends DaoTemplate{

	public PaggingDao(Connection conn) {
		super(conn);
	}

	/**
	 * ��ѯ�ܼ�¼��	
	 * 
	 * @return	����Pagging�����recordmax���ԣ������ݿ��е��ܼ�¼�������ܼ�¼����ÿҳ��ʾ�ļ�¼��pagesize�������ҳ��
	 * @throws SQLException
	 */
	public int countRows() throws SQLException{
		int result = 0;
		ResultSet rs = null;
		String sql = "select count(1) num from torder";
		
		try {
			rs = executeQuery(sql);
			if(rs.next()){
				result = rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		
		return result;
	}

	/**
	 * ��ҳ
	 * @param paging����	�ڴ˷�������Ҫ�õ�Pagging�����е�pageindex��pagesize�������������Կɵõ���ǰҳ��һ�����ݵ�������ÿҳ��ʾ��������
	 * @return	����paging�����list���ԣ�
	 * 			������list��paging����ͷ�������paging����ͬһ����
	 * @throws SQLException
	 */
	public List<Torder> queryTorder(Paging paging) throws SQLException {
		List<Torder> list = new ArrayList<Torder>();
		ResultSet rs = null;
		String sql = "select * from torder limit ?,?";
		Torder order = null;
		
		//��ǰҳ�ĵ�һ�����ݵ��±�
		int index = (paging.getPageindex()-1)*paging.getPagesize();	
		//ÿҳ��ʾ��������
		int size = paging.getPagesize();
		Integer[] params = {index,size};
		
		try {
			rs = executeQuery(sql,params);
			while(rs.next()){
				order = new Torder(rs.getInt("oid"), rs.getString("name"), rs.getDouble("price"), rs.getInt("num"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		
		return list;
	}
}
