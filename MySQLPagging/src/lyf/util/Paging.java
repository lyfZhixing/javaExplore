package lyf.util;

import java.util.List;

public class Paging {

	//页码
	private int pageindex;
	//页面显示数据记录数
	private int pagesize;
	//总页码 
	private int pagemax;
	//总记录数
	private int recordmax;
	//要查询的对象集合
	private List<?> list;
	
	
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagemax() {
		return pagemax;
	}
	public void setPagemax(int pagesize,int recordmax) {
		this.pagemax = (recordmax%pagesize == 0)?(recordmax/pagesize):(recordmax/pagesize+1);
	}
	public int getRecordmax() {
		return recordmax;
	}
	public void setRecordmax(int recordmax) {
		this.recordmax = recordmax;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Paging(int pageindex, int pagesize) {
		super();
		this.pageindex = pageindex;
		this.pagesize = pagesize;
	}
	public Paging() {
		super();
	}
	
}
