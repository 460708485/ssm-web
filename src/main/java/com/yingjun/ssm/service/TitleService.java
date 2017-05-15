package com.yingjun.ssm.service;

import java.util.List;

import com.yingjun.ssm.entity.Title;

public interface TitleService {

	List<Title> getTitleList(int offset, int limit);
	 
}
