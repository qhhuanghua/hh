package cn.yd.xm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



// ��Ҫ����������ݿ�����(��Դ�ͷ�)
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
			//�����쳣������
			throw new RuntimeException(e);
			}
	}
	
	static {
		System.out.println("��������");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
}
