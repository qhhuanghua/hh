package cn.yd.xm.hh;

import java.sql.Date;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

/*
 *  1: ��:�洢���������, 2�����������洢��(class�ļ�����)ͨ�������������,�Ҽ���һ��. 
 *  3: ���з������ö�����ջ(���Ϻ���ȳ�����)
 *  4: �ڷ����������ı����Ǿֲ�����(ԭʼ���ʹ洢���ݱ���,�������ʹ洢���Ƕ���ĵ�ַ),��ջʱ�ֲ���������ʧ
 *  5: ��ֻ������(��̬���Ǿ�̬)�ͷ���(��̬���Ǿ�̬) 
 *  6�� ��̬����ֻ��һ��������,����ÿ���������Լ��ķǾ�̬����(�Ǿ�̬��������󶼴洢�ڶ���)
 *  7: ���з���(��̬���Ǿ�̬)���Ǵ洢�ڷ�����������.���ǷǾ�̬�����Ƕ������(this��Զ��ָ��ǰ���ô˷����Ķ���)
 *  8: ��̬����ֻ�������.
 *  9����̬�����в����Բ�����ͨ���ԣ� ����ͨ�����п��Բ�����̬����(��̬����ֻ��һ��)
 *  10:�����̶߳����Ȼ�
 *  11��Ĭ��ջΪ1M
 * */
// ��: ���� +����
public class JVMHh {
	
	private String name;
	// static����ֻ��һ��������,�����ڶ���
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
	
	
	// 1: java --> class 2: classLoader����  JVMDemo.clss��ӵ�JVM��
	public static void main(String[] args) {
		int x = 100;
		// �����ഴ��һ������
		JVMHh demo = new JVMHh();
		System.out.println("1:" + demo);
		demo.setName("admin");
		// ����̬���Ը�ֵ
		JVMHh.num = 1000;
		// ������һ������demo02,���Ұ�demo��ֵ����demo02
		JVMHh demo2 = new JVMHh();; // û�������¶���
		demo2.setName("admin2");
		JVMHh.setNum(1000);
		System.out.println(x);
		demo.show();
		demo2.show();
		JVMHh.setNum(2000);
		System.out.println(JVMHh.num);
	}
}
