package cn.yd.xm.ProductDao;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cm.yd.xm.model.Product;



public class ProductDaoTest {
  
	//��̬����ֻ�ܲ�����̬���ԣ����ܲ����Ǿ�̬���ԣ��Ǿ�̬�������Բ�����̬����
	private static ProductDao productDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("�˷����ڲ��Է���֮ǰִ��,ͨ��������ʼ�����Զ���");
		productDao = new ProductDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("�˷����ڲ��Է���֮��ִ��,ͨ�������ͷ���Դ");
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
		// Ĭ�ϵ��õ���ϵͳ��toString����
//		System.out.println(product.toString());
	}
	
	
	
	@Test
	public void testDelete() {
		productDao.delete(2);
	}

	@Test
	public void testUpdate() {
		System.out.println("����");
		Product p=new Product();
		p.setName("��Ϊ�ֻ�");
		p.setPrice(3600.00);
		p.setId(1);
		p.setRemark("��Ϊ�¿��ֻ�");
		productDao.update(p);
		
	}

	@Test
	//ֻ�������ע��@Test���ǲ�������
	public void testSave() {
		System.out.println("testSave......");
		//�����ڴ�����ʱ��100%����ù��캯��
		Product p=new Product();
		p.setName("��Ϊ�ֻ�");
		p.setPrice(3600.00);
		p.setRemark("��Ϊ�¿��ֻ�");
		productDao.save(p);
	}
}
