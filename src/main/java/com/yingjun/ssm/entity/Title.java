package com.yingjun.ssm.entity;

import java.util.Date;


/**
 * 用户
 * @author  
 *
 */
public class Title {
	
	private Integer id;
	
	private String content;
	
	private Integer sortNo;
	
	private String  url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		
		return "id:"+id+",content:"+content+",sortNo:"+sortNo+",url:"+url;
	}
	
	
	

}
