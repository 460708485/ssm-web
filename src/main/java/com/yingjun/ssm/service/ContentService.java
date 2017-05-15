package com.yingjun.ssm.service;

import java.util.List;

import com.yingjun.ssm.entity.Content;

public interface ContentService {

	List<Content> getContentList(int type,int offset, int limit);
	 
}
