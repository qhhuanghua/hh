package cm.yd.xm.demo;

import java.util.Date;

public class ExtendDemo {
	public static void main(String[] args) {
		// 父类的引用可以存储子类对象
		Object demo = new Date();
		// 打印对象地址
		System.out.println(demo);
		System.out.println(demo.toString());
		int i=0;
		
		System.out.println(i+1);
		System.out.println(i);
				
	}

}
