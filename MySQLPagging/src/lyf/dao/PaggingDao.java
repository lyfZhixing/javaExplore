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
	 * 查询总记录数	
	 * 
	 * @return	返回Pagging对象的recordmax属性，即数据库中的总记录数，由总记录数和每页显示的记录数pagesize可求出总页数
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
	 * 分页
	 * @param paging对象	在此方法中需要用到Pagging对象中的pageindex和pagesize，由这两个属性可得到当前页第一行数据的行数和每页显示的数据量
	 * @return	返回paging对象的list属性，
	 * 			（接收list的paging对象和方法参数paging不是同一对象）
	 * @throws SQLException
	 */
	public List<Torder> queryTorder(Paging paging) throws SQLException {
		List<Torder> list = new ArrayList<Torder>();
		ResultSet rs = null;
		String sql = "select * from torder limit ?,?";
		Torder order = null;
		
		//当前页的第一条数据的下标
		int index = (paging.getPageindex()-1)*paging.getPagesize();	
		//每页显示的数据量
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
