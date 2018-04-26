package sy.frame;

import java.util.List;

public class BaseData<T>{

	private long pageTotal;//总页数
	private int pageRows=10;//每页多少行
	private int pageNumber=1;//当前第几页
	private int pageCountRows;//总行数
	
	private List<T> baseList;//controller传参不分页实体集合
	private List<T> pageList;//分页实体集合
	
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public List<T> getBaseList() {
		return baseList;
	}
	public void setBaseList(List<T> baseList) {
		this.baseList = baseList;
	}
	public long getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageCountRows() {
		return pageCountRows;
	}
	public void setPageCountRows(int pageCountRows) {
		this.pageCountRows = pageCountRows;
	}
}
