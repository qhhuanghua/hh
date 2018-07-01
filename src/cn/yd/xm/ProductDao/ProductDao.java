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

//dao�����ݷ��ʲ㣬JAVA��һ������ֻ��һ�����ࣨsuper��
public class ProductDao extends Basedao {

	// main�����������ԣ���Ӧ���ڴ����д��ڣ����ܱ������Եĺۼ�
	// // alt+/
	// public static void main(String[] args) {
	// ProductDao dao = new ProductDao();
	// Product product=new Product();
	// product.setName("��Ϊ�ֻ�");
	// product.setPrice(3600.00);
	// product.setRemark("��Ϊ�¿��ֻ�");
	// dao.save(product);
	// dao.update(product);
	// dao.delete(2);
	//
	// }
   
	   public ArrayList<Product> queryByName(String name){
		   Product product = null;   
       ArrayList<Product> proList =new ArrayList<Product>();
		// ?��Ϊռλ��
		String sql = "select * from product where name like ?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
		PreparedStatement pre;// ���󣬶����һ����ĸ��д
		try {
			pre = conn.prepareStatement(sql);// �����������ţ�
			pre.setString(1, "%"+name+"%");
			// ResultSet����ѯ�������java�в�ѯ�Ľ��������ResultSet������
			ResultSet rs = pre.executeQuery();
			// re�������ָ���䵱ǰ�����еĹ�꣬����������ڵ�һ��֮ǰ
			// next����������Ƶ���һ�У������ǰ����Ч�򷵻�ֵΪtrue;
			// 3: ��ռλ�����и�ֵ����
			while (rs.next()) {
				// db��һ����¼����JAVA��һ������
				product = new Product();
				product.setId(rs.getInt("id"));// ��ȡid�����ݣ���INT��ʽ����
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				//�Ѳ�ѯ�����Ķ���洢��������
				proList.add(product);
			}
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
			// ���ز�ѯ�Ľ������
			return proList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		// 5: �ر�Connection�ͷ���Դ
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	   }
	
	
	
	// ��дһ������,����ID��ѯ����ķ���
	public Product getById(Integer id) {
		Product product = null;
		// ?��Ϊռλ��
		String sql = "select * from product where id =?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
		PreparedStatement pre;// ���󣬶����һ����ĸ��д
		try {
			pre = conn.prepareStatement(sql);// �����������ţ�
			pre.setInt(1, id);
			// ResultSet����ѯ�������java�в�ѯ�Ľ��������ResultSet������
			ResultSet rs = pre.executeQuery();
			// re�������ָ���䵱ǰ�����еĹ�꣬����������ڵ�һ��֮ǰ
			// next����������Ƶ���һ�У������ǰ����Ч�򷵻�ֵΪtrue;
			// 3: ��ռλ�����и�ֵ����
			if (rs.next()) {
				// db��һ����¼����JAVA��һ������
				product = new Product();
				product.setId(rs.getInt("id"));// ��ȡid�����ݣ���INT��ʽ����
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
			}
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
			// ���ز�ѯ�Ľ������
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		// 5: �ر�Connection�ͷ���Դ

	}

	// ��дһ������,������ݵĲ������
	public void save(Product product) {
		// ?��Ϊռλ��
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		// // 1: �������ݿ�
		// JdbcUtils utils = new JdbcUtils();
		// Connection conn = utils.getConnection();
		// try {
		// // 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
		// // ctrl + shift + o ���Ե��뵼����

		super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
		// // 3: ��ռλ�����и�ֵ����
		// pre.setString(1, product.getName()); // ��getName��ֵ������1��?�ʺ�
		// pre.setDouble(2, product.getPrice());
		// pre.setString(3, product.getRemark());
		// // 4: ִ��SQL���,����int�������Ϊ1��������1������
		// int count = pre.executeUpdate();
		// System.out.println("count:" + count);
		// } catch (SQLException e) {
		// // ���Դ����쳣: �����쳣������Ա����
		// // ֱ�Ӱѵ�ǰ�쳣�����׳�
		// throw new RuntimeException(e);
		// }
		// // 5: �ر�Connection�ͷ���Դ
	}

	// ��дһ������,������ݵĸ��²���
	public void update(Product product) {
		// ?��Ϊռλ��
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		// // 1: �������ݿ�
		// JdbcUtils utils = new JdbcUtils();
		// Connection conn = utils.getConnection();
		// try {
		// // 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
		// // ctrl + shift + o ���Ե��뵼����
		super.executeUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
		// // 3: ��ռλ�����и�ֵ����
		// pre.setString(1, product.getName()); // ��getName��ֵ������1��?�ʺ�
		// pre.setDouble(2, product.getPrice());
		// pre.setString(3, product.getRemark());
		// pre.setInt(4, product.getId());
		// // 4: ִ��SQL���,����int�������Ϊ1��������1������
		// int count = pre.executeUpdate();
		// System.out.println("count:" + count);
		// } catch (SQLException e) {
		// // ���Դ����쳣: �����쳣������Ա����
		// // ֱ�Ӱѵ�ǰ�쳣�����׳�
		// throw new RuntimeException(e);
		// }
		// // 5: �ر�Connection�ͷ���Դ
		//
	}

	// ��дһ������,������ݵĸ��²���
	public void delete(Integer id) {
		// ?��Ϊռλ��
		String sql = "delete from product  where id =?";
		// // 1: �������ݿ�
		//
		// JdbcUtils utils = new JdbcUtils();
		// Connection conn = utils.getConnection();
		//
		// //����������������ţ���������ԣ�new�϶��Ǵ������󣬵��Ƕ���һ����new�ģ�utils����ĵ�ַ
		// try {
		// // 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
		// // ctrl + shift + o ���Ե��뵼����
		super.executeUpdate(sql, new Object[] { id });
		// // 3: ��ռλ�����и�ֵ����
		// pre.setInt(1,id); // ��getName��ֵ������1��?�ʺ�
		//
		// // 4: ִ��SQL���,����int�������Ϊ1��������1������
		// int count = pre.executeUpdate();
		// System.out.println("count:" + count);
		// } catch (SQLException e) {
		// // ���Դ����쳣: �����쳣������Ա����
		// // ֱ�Ӱѵ�ǰ�쳣�����׳�
		// throw new RuntimeException(e);
		// }
		// // 5: �ر�Connection�ͷ���Դ
	}

}
