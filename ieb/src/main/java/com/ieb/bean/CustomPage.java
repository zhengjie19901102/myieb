package com.ieb.bean;

import java.util.Map;

public class CustomPage {
	private Integer currentPage; 		// 当前页数
	private Integer totalPage;				// 总页数
	private Integer totalNum;				// 数据总数
	private Integer pageNum;				// 每页显示数量
	private Map<String,String> searchWord;				//查询条件:loginname-companyId-status
	private String orderBy;
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Map<String, String> getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(Map<String, String> searchWord) {
		this.searchWord = searchWord;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		return "CustomPage [currentPage=" + currentPage + ", totalPage=" + totalPage + ", totalNum=" + totalNum
				+ ", pageNum=" + pageNum + ", searchWord=" + searchWord + ", orderBy=" + orderBy + "]";
	}
}
