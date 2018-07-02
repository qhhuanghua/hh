package cn.yd.xm.ProductService;

import java.util.ArrayList;

import cm.yd.xm.model.Product;
import cn.yd.xm.ProductDao.ProductDao;

//此类主要是用来实现业务逻辑代码
public class ProductService {
	//
	//NEW对象的缺点：
	//1.不能控制productDao数量，在项目中我们的servlet,service,dao都是单例模式，mode必须是多例模式；
	//2.不能控制类型，项目编码的的目标：高内聚、低耦合
	
	//
	// 业务逻辑完成功能之后数据将入库,因此此类依赖ProductDao
		private ProductDao productDao = new ProductDao();
		
		public void save(Product product) {
			// 此处用来实现业务逻辑代码
			productDao.save(product);
		}
		public ArrayList<Product> queryByName(String keyword){
			return productDao.queryByName(keyword);
		}
}
