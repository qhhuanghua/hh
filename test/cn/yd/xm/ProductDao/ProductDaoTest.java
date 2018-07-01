package cn.yd.xm.ProductDao;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cm.yd.xm.model.Product;



public class ProductDaoTest {
  
	//静态方法只能操作静态属性，不能操作非静态属性，非静态方法可以操作静态属性
	private static ProductDao productDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("此方法在测试方法之前执行,通常用来初始化测试对象");
		productDao = new ProductDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("此方法在测试方法之后执行,通常用来释放资源");
		productDao = null;
	}

	@Test
	public void testqueryByName() {

		ArrayList<Product> proList = productDao.queryByName("%%");
//		for(int i=0;i<proList.size();i++) {
//			
//		}
		for(Product temp:proList) {
			System.out.println(temp);
		}
	
	}
	
	@Test
	public void testGetById() {
		Product product = productDao.getById(2);
		if(product!=null) {
			System.out.println(product.getId() + "," + product.getName()+"," + product.getDate());
		}
		// 默认调用的是系统的toString方法
//		System.out.println(product.toString());
	}
	
	
	
	@Test
	public void testDelete() {
		productDao.delete(2);
	}

	@Test
	public void testUpdate() {
		System.out.println("更新");
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setId(1);
		p.setRemark("华为新款手机");
		productDao.update(p);
		
	}

	@Test
	//只有添加了注解@Test的是测试用例
	public void testSave() {
		System.out.println("testSave......");
		//对象在创建的时候100%会调用构造函数
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setRemark("华为新款手机");
		productDao.save(p);
	}
}
