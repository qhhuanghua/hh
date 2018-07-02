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

//HttpServlet可以接受HTTP请求信息，请求的地址：/ProductServlet
@WebServlet("/ProductServlet")
//可以将访问地址配置在web.XML中
public class ProductServlet extends HttpServlet {
	
	// JSP --> Servlet --> Service ---> Dao ---> DB
		private ProductService productService = new ProductService();
	  
		// 处理:method="get"
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		//1.获取前端输入查询关键字
		String keyword=request.getParameter("goodle");
		
		//把当前查询关键字存储到session中，这样能要浏览器不关闭/30分钟内交换交互，则在页面显示此关键字
		
		
		//2.调用业务逻辑
		ArrayList<Product> proList =productService.queryByName(keyword);
//		for(Product temp: proList) {
//			System.out.println(temp);
//		}
		System.out.println(proList.size());
		//此数据要交给query.jsp页面显示
		request.setAttribute("proList", proList);
		//若果数据存储到SESSION中只能浏览器不关闭，或30分钟内交互则数据会一直存在
		request.getSession().setAttribute("proList", proList);
		//当前页面跳转到query.jsp
		//每一个超链接请求及时一个Request
		//返回方式：页面返回，查询结果返回
		//此方式称为重定向，会产生新的request对象
		//跳转方法：不共享，可跳转至外部资源
//		response.sendRedirect("/hh/query.jsp");
		//如果servley与JSP存在数据的共享，建议使用转发（转发只能访问项目的资源，默认添加了工程名）
		RequestDispatcher dispatcher =request.getRequestDispatcher("/query.jsp");
		//在转发此请求的时候，会把上一次request response提交，转发一次
		dispatcher.forward(request, response);
		}
		
		// 处理:method="post"
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("request："+request);
			System.out.println("response："+response);
			// 1: 获取前端数据(java web中客户端返回的数据都被封装到request对象)
			Product product = new Product();
			product.setName(request.getParameter("name")); // <input name="name" />
			product.setRemark(request.getParameter("remark"));
			Double price = Double.parseDouble(request.getParameter("price"));
			product.setPrice(price);
			// 2: 调用业务逻辑
			productService.save(product);
			// 返回结果页面(客户端发送请求：request，返回给客户端的响应：response)
			//3、跳转到查询页面，在JAVA开发中所有的资源访问都要从工程名开始（query.jsp）
			response.sendRedirect("/hh/query.jsp");
			
			
		}

}
