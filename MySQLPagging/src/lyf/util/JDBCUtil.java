package lyf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	private static String driver = ConfigManage.getProperty("driverClass");
	private static String url = ConfigManage.getProperty("url");
	private static String username = ConfigManage.getProperty("username");
	private static String password = ConfigManage.getProperty("password");
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭连接
	public static void closeAll(Connection con, Statement stmt, ResultSet rs){
		
		try {
			if(con != null && !con.isClosed()){
				con.close();
			}
			if(stmt != null && !stmt.isClosed()){
				stmt.close();
			}
			if(rs != null && !rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
