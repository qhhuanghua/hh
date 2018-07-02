package cn.yd.xm.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.yd.xm.model.Product;
import cn.yd.xm.ProductService.ProductService;

//HttpServlet���Խ���HTTP������Ϣ������ĵ�ַ��/ProductServlet
@WebServlet("/ProductServlet")
//���Խ����ʵ�ַ������web.XML��
public class ProductServlet extends HttpServlet {
	
	// JSP --> Servlet --> Service ---> Dao ---> DB
		private ProductService productService = new ProductService();
	  
		// ����:method="get"
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		//1.��ȡǰ�������ѯ�ؼ���
		String keyword=request.getParameter("goodle");
		
		//�ѵ�ǰ��ѯ�ؼ��ִ洢��session�У�������Ҫ��������ر�/30�����ڽ�������������ҳ����ʾ�˹ؼ���
		
		
		//2.����ҵ���߼�
		ArrayList<Product> proList =productService.queryByName(keyword);
//		for(Product temp: proList) {
//			System.out.println(temp);
//		}
		System.out.println(proList.size());
		//������Ҫ����query.jspҳ����ʾ
		request.setAttribute("proList", proList);
		//�������ݴ洢��SESSION��ֻ����������رգ���30�����ڽ��������ݻ�һֱ����
		request.getSession().setAttribute("proList", proList);
		//��ǰҳ����ת��query.jsp
		//ÿһ������������ʱһ��Request
		//���ط�ʽ��ҳ�淵�أ���ѯ�������
		//�˷�ʽ��Ϊ�ض��򣬻�����µ�request����
		//��ת����������������ת���ⲿ��Դ
//		response.sendRedirect("/hh/query.jsp");
		//���servley��JSP�������ݵĹ�������ʹ��ת����ת��ֻ�ܷ�����Ŀ����Դ��Ĭ������˹�������
		RequestDispatcher dispatcher =request.getRequestDispatcher("/query.jsp");
		//��ת���������ʱ�򣬻����һ��request response�ύ��ת��һ��
		dispatcher.forward(request, response);
		}
		
		// ����:method="post"
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("request��"+request);
			System.out.println("response��"+response);
			// 1: ��ȡǰ������(java web�пͻ��˷��ص����ݶ�����װ��request����)
			Product product = new Product();
			product.setName(request.getParameter("name")); // <input name="name" />
			product.setRemark(request.getParameter("remark"));
			Double price = Double.parseDouble(request.getParameter("price"));
			product.setPrice(price);
			// 2: ����ҵ���߼�
			productService.save(product);
			// ���ؽ��ҳ��(�ͻ��˷�������request�����ظ��ͻ��˵���Ӧ��response)
			//3����ת����ѯҳ�棬��JAVA���������е���Դ���ʶ�Ҫ�ӹ�������ʼ��query.jsp��
			response.sendRedirect("/hh/query.jsp");
			
			
		}

}
