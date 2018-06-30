package cn.yd.xm.hh;

import java.sql.Date;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

/*
 *  1: 堆:存储对象的区域, 2：方法区：存储类(class文件区域)通过类加载器加载,且加载一次. 
 *  3: 所有方法调用都会入栈(符合后进先出规则)
 *  4: 在方法中声明的变量是局部变量(原始类型存储数据本身,引用类型存储的是对象的地址),出栈时局部变量会消失
 *  5: 类只有属性(静态、非静态)和方法(静态、非静态) 
 *  6： 静态属性只有一份属于类,但是每个对象都有自己的非静态属性(非静态属性与对象都存储在堆中)
 *  7: 所有方法(静态、非静态)都是存储在方法区的类中.但是非静态属性是对象调用(this永远都指向当前调用此方法的对象)
 *  8: 静态方法只能类调用.
 *  9：静态方法中不可以操作普通属性， 在普通方法中可以操作静态属性(静态属性只有一份)
 *  10:蓝白线程独享，橙黄
 *  11：默认栈为1M
 * */
// 类: 属性 +方法
public class JVMHh {
	
	private String name;
	// static属性只有一份属于类,不属于对象
	private static int num;
	
	public static int getNum() {
		return num;
	}
	// 
	public static void setNum(int num) {
		JVMHh.num = num;
	}

	public String getName() {
		num = 1000;
		return name;
	}

	public void setName(String name) {
		System.out.println("2:" + this);
		this.name = name;
	}

	public void show() {
		int xyz = 50;
		System.out.println(name);
	}
	
	
	// 1: java --> class 2: classLoader加载  JVMDemo.clss添加到JVM中
	public static void main(String[] args) {
		int x = 100;
		// 根据类创建一个对象
		JVMHh demo = new JVMHh();
		System.out.println("1:" + demo);
		demo.setName("admin");
		// 给静态属性赋值
		JVMHh.num = 1000;
		// 声明了一个变量demo02,并且把demo的值赋给demo02
		JVMHh demo2 = new JVMHh();; // 没有生成新对象
		demo2.setName("admin2");
		JVMHh.setNum(1000);
		System.out.println(x);
		demo.show();
		demo2.show();
		JVMHh.setNum(2000);
		System.out.println(JVMHh.num);
	}
}
