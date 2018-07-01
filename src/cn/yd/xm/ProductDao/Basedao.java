package cn.yd.xm.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.xm.utils.JdbcUtils;



//ctrl+/ 注释代码，ctrl+shift+F格式化代码
//此类用于存储访问数据库共性代码，这些代码代码需要继承给子类
public class Basedao {

	// 插入更新删除都修改数据，因理解为更新。
	//因子类可能存在N>=0个参数，设置数组
	public void executeUpdate(String sql,Object[]param) {
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
			// ctrl + shift + o 可以导入导出包
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: 对占位符进行赋值操作
			// pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
			// pre.setDouble(2, product.getPrice());
			// pre.setString(3, product.getRemark());
			// 4: 执行SQL语句,返回int如果返回为1则代表更新1条数据
			//因数据是从0开始，字段是多1开始的，所以需要i+1
			for (int i = 0; i < param.length; i++) {
				pre.setObject(i+1,param[i]);								
			}
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
			
		} catch (SQLException e) {
			// 可以处理异常: 发送异常到管理员邮箱
			// 直接把当前异常向上抛出
			throw new RuntimeException(e);
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
		// 5: 关闭Connection释放资源
	}
}
