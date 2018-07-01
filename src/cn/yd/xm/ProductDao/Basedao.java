package cn.yd.xm.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.xm.utils.JdbcUtils;



//ctrl+/ ע�ʹ��룬ctrl+shift+F��ʽ������
//�������ڴ洢�������ݿ⹲�Դ��룬��Щ���������Ҫ�̳и�����
public class Basedao {

	// �������ɾ�����޸����ݣ������Ϊ���¡�
	//��������ܴ���N>=0����������������
	public void executeUpdate(String sql,Object[]param) {
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
			// ctrl + shift + o ���Ե��뵼����
			PreparedStatement pre = conn.prepareStatement(sql);
			// 3: ��ռλ�����и�ֵ����
			// pre.setString(1, product.getName()); // ��getName��ֵ������1��?�ʺ�
			// pre.setDouble(2, product.getPrice());
			// pre.setString(3, product.getRemark());
			// 4: ִ��SQL���,����int�������Ϊ1��������1������
			//�������Ǵ�0��ʼ���ֶ��Ƕ�1��ʼ�ģ�������Ҫi+1
			for (int i = 0; i < param.length; i++) {
				pre.setObject(i+1,param[i]);								
			}
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
			
		} catch (SQLException e) {
			// ���Դ����쳣: �����쳣������Ա����
			// ֱ�Ӱѵ�ǰ�쳣�����׳�
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
		// 5: �ر�Connection�ͷ���Դ
	}
}
