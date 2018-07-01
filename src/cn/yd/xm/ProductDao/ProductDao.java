package cn.yd.xm.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import cm.yd.xm.model.Product;
import cn.yd.xm.ProductDao.ProductDao;
import cn.yd.xm.utils.JdbcUtils;

//dao层数据访问层，JAVA中一个子类只有一个父类（super）
public class ProductDao extends Basedao {

	// main方法有侵入性，不应该在代码中存在，不能保留测试的痕迹
	// // alt+/
	// public static void main(String[] args) {
	// ProductDao dao = new ProductDao();
	// Product product=new Product();
	// product.setName("华为手机");
	// product.setPrice(3600.00);
	// product.setRemark("华为新款手机");
	// dao.save(product);
	// dao.update(product);
	// dao.delete(2);
	//
	// }
   
	   public ArrayList<Product> queryByName(String name){
		   Product product = null;   
       ArrayList<Product> proList =new ArrayList<Product>();
		// ?称为占位符
		String sql = "select * from product where name like ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
		PreparedStatement pre;// 对象，对象第一个字母大写
		try {
			pre = conn.prepareStatement(sql);// 方法，有括号，
			pre.setString(1, "%"+name+"%");
			// ResultSet：查询结果集，java中查询的结果保存在ResultSet对象中
			ResultSet rs = pre.executeQuery();
			// re对象具有指向其当前数据行的光标，最初，光标放在第一行之前
			// next方法将光标移到下一行，如果当前行有效则返回值为true;
			// 3: 对占位符进行赋值操作
			while (rs.next()) {
				// db中一条记录等于JAVA的一个对象
				product = new Product();
				product.setId(rs.getInt("id"));// 获取id列数据，并INT方式返回
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				//把查询出来的对象存储到集合里
				proList.add(product);
			}
			// 4: 执行SQL语句,返回int如果返回为1则代表更新1条数据
			// 返回查询的结果集；
			return proList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		// 5: 关闭Connection释放资源
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	   }
	
	
	
	// 编写一个方法,根据ID查询对象的方法
	public Product getById(Integer id) {
		Product product = null;
		// ?称为占位符
		String sql = "select * from product where id =?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
		PreparedStatement pre;// 对象，对象第一个字母大写
		try {
			pre = conn.prepareStatement(sql);// 方法，有括号，
			pre.setInt(1, id);
			// ResultSet：查询结果集，java中查询的结果保存在ResultSet对象中
			ResultSet rs = pre.executeQuery();
			// re对象具有指向其当前数据行的光标，最初，光标放在第一行之前
			// next方法将光标移到下一行，如果当前行有效则返回值为true;
			// 3: 对占位符进行赋值操作
			if (rs.next()) {
				// db中一条记录等于JAVA的一个对象
				product = new Product();
				product.setId(rs.getInt("id"));// 获取id列数据，并INT方式返回
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
			}
			// 4: 执行SQL语句,返回int如果返回为1则代表更新1条数据
			// 返回查询的结果集；
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		// 5: 关闭Connection释放资源

	}

	// 编写一个方法,完成数据的插入操作
	public void save(Product product) {
		// ?称为占位符
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		// // 1: 连接数据库
		// JdbcUtils utils = new JdbcUtils();
		// Connection conn = utils.getConnection();
		// try {
		// // 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
		// // ctrl + shift + o 可以导入导出包

		super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
		// // 3: 对占位符进行赋值操作
		// pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
		// pre.setDouble(2, product.getPrice());
		// pre.setString(3, product.getRemark());
		// // 4: 执行SQL语句,返回int如果返回为1则代表更新1条数据
		// int count = pre.executeUpdate();
		// System.out.println("count:" + count);
		// } catch (SQLException e) {
		// // 可以处理异常: 发送异常到管理员邮箱
		// // 直接把当前异常向上抛出
		// throw new RuntimeException(e);
		// }
		// // 5: 关闭Connection释放资源
	}

	// 编写一个方法,完成数据的更新操作
	public void update(Product product) {
		// ?称为占位符
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		// // 1: 连接数据库
		// JdbcUtils utils = new JdbcUtils();
		// Connection conn = utils.getConnection();
		// try {
		// // 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
		// // ctrl + shift + o 可以导入导出包
		super.executeUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
		// // 3: 对占位符进行赋值操作
		// pre.setString(1, product.getName()); // 把getName的值赋给第1个?问号
		// pre.setDouble(2, product.getPrice());
		// pre.setString(3, product.getRemark());
		// pre.setInt(4, product.getId());
		// // 4: 执行SQL语句,返回int如果返回为1则代表更新1条数据
		// int count = pre.executeUpdate();
		// System.out.println("count:" + count);
		// } catch (SQLException e) {
		// // 可以处理异常: 发送异常到管理员邮箱
		// // 直接把当前异常向上抛出
		// throw new RuntimeException(e);
		// }
		// // 5: 关闭Connection释放资源
		//
	}

	// 编写一个方法,完成数据的更新操作
	public void delete(Integer id) {
		// ?称为占位符
		String sql = "delete from product  where id =?";
		// // 1: 连接数据库
		//
		// JdbcUtils utils = new JdbcUtils();
		// Connection conn = utils.getConnection();
		//
		// //对象带方法，带括号，对象带属性，new肯定是创建对象，但是对象不一定是new的，utils对象的地址
		// try {
		// // 2: 预编译SQL(此处并未真正执行SQL,因为还有参数未赋值)
		// // ctrl + shift + o 可以导入导出包
		super.executeUpdate(sql, new Object[] { id });
		// // 3: 对占位符进行赋值操作
		// pre.setInt(1,id); // 把getName的值赋给第1个?问号
		//
		// // 4: 执行SQL语句,返回int如果返回为1则代表更新1条数据
		// int count = pre.executeUpdate();
		// System.out.println("count:" + count);
		// } catch (SQLException e) {
		// // 可以处理异常: 发送异常到管理员邮箱
		// // 直接把当前异常向上抛出
		// throw new RuntimeException(e);
		// }
		// // 5: 关闭Connection释放资源
	}

}
