package com.yingjun.ssm.entity;

import java.io.Serializable;

/**
 * 内容
 * 
 * @author
 *
 */
public class Content implements Serializable {

	private static final long serialVersionUID = 12212154121L;

	private Integer id;

	private String content;

	private Integer sortNo;

	private Integer type;// 0普通，1.热门

	private String title;
	
	private Integer count;//点击次数

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	
}
