package cn.yd.xm.ProductService;

import cn.yd.xm.ProductDao.ProductDao;

//������Ҫ������ʵ��ҵ���߼�����
public class ProductService {
//ҵ���߼���ɹ���֮������ ��⣬���������ProductDao
	
	private ProductDao productDao = new ProductDao();
	public void save(Product product) {
		//�˴�Ϊ
		productDao.save(product);
	}
}
