package com.yingjun.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yingjun.ssm.entity.Title;

public interface TitleDao {

	
    
    /**
     * 根据偏移量查询内容列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Title> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    
    
}
