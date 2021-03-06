package com.yingjun.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yingjun.ssm.entity.Content;

public interface ContentDao {

    
    /**
     * 根据偏移量查询内容列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Content> queryAll(@Param("type") Integer type,@Param("offset") int offset, @Param("limit") int limit);
    
    /**
     * 获取详情
     * @param id
     * @return
     */
    Content queryById(@Param("id") Integer id);
}
