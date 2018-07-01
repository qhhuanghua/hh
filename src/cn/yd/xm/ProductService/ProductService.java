package cn.yd.xm.ProductService;

import cn.yd.xm.ProductDao.ProductDao;

//此类主要是用来实现业务逻辑代码
public class ProductService {
//业务逻辑完成功能之后数据 入库，因此类依赖ProductDao
	
	private ProductDao productDao = new ProductDao();
	public void save(Product product) {
		//此处为
		productDao.save(product);
	}
}
