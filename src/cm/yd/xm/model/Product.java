package cm.yd.xm.model;
import java.util.Date;

//类-->表   对象-->记录   属性 ---> 字段
public class Product {
	
	//与类同名的方法的成为称为构造方法（函数），默认有一个缺省的无参构造函数
	//可以通过构造方法赋值，如果显示声明构造方法，则缺省构造会消失
	
	//此方法重写父类的某个方法

	
 // 属性是私有的,不能直接访问.
	private Integer id;
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", date=" + date
				+ "]";
	}
	private String name;
	private Double price;
	private String remark;
	private Date date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
