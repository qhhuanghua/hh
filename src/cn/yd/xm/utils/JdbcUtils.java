package cn.yd.xm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// 主要用来完成数据库连接(资源释放)
public class JdbcUtils {
	public static void main(String[] args) {
		JdbcUtils utils =new JdbcUtils();
		utils.getConnection();
	}
	
	public Connection getConnection() {
		try {
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","123");
		  return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//以下异常往上抛
			throw new RuntimeException(e);
			}
	}
	
	static {
		System.out.println("加载驱动");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
}
