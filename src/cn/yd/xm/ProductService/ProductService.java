package cn.yd.xm.ProductService;

import java.util.ArrayList;

import cm.yd.xm.model.Product;
import cn.yd.xm.ProductDao.ProductDao;

//������Ҫ������ʵ��ҵ���߼�����
public class ProductService {
	//
	//NEW�����ȱ�㣺
	//1.���ܿ���productDao����������Ŀ�����ǵ�servlet,service,dao���ǵ���ģʽ��mode�����Ƕ���ģʽ��
	//2.���ܿ������ͣ���Ŀ����ĵ�Ŀ�꣺���ھۡ������
	
	//
	// ҵ���߼���ɹ���֮�����ݽ����,��˴�������ProductDao
		private ProductDao productDao = new ProductDao();
		
		public void save(Product product) {
			// �˴�����ʵ��ҵ���߼�����
			productDao.save(product);
		}
		public ArrayList<Product> queryByName(String keyword){
			return productDao.queryByName(keyword);
		}
}
