package cm.yd.xm.model;
import java.util.Date;

//��-->��   ����-->��¼   ���� ---> �ֶ�
public class Product {
	
	//����ͬ���ķ����ĳ�Ϊ��Ϊ���췽������������Ĭ����һ��ȱʡ���޲ι��캯��
	//����ͨ�����췽����ֵ�������ʾ�������췽������ȱʡ�������ʧ
	
	//�˷�����д�����ĳ������

	
 // ������˽�е�,����ֱ�ӷ���.
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
