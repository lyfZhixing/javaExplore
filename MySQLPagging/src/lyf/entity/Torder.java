package lyf.entity;

import java.io.Serializable;

public class Torder implements Serializable{

	/**
	 * id
oid
name
price
num

	 */
	private static final long serialVersionUID = 1L;
	
	private int oid ;
	private String name;
	private double price;
	private int num;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Torder() {
		super();
	}
	public Torder(int oid, String name, double price, int num) {
		super();
		this.oid = oid;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
	

}
