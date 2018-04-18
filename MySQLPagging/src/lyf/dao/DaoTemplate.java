package lyf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoTemplate {

	private Connection conn;

	public DaoTemplate(Connection conn) {
		super();
		this.conn = conn;
	}
	/**
	 * Query template
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object...params){
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			if(params != null){
				for(int i = 0; i < params.length; i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
