package com.yingjun.ssm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yingjun.ssm.cache.RedisCache;
import com.yingjun.ssm.common.constants.RedisConstant;
import com.yingjun.ssm.dao.TitleDao;
import com.yingjun.ssm.entity.Title;
import com.yingjun.ssm.service.TitleService;

@Service
public class TitleServiceImpl implements TitleService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TitleDao TitleDao;
	@Autowired
	private RedisCache cache;
	
	
	@Override
	public List<Title> getTitleList(int offset, int limit) {
		String cache_key=RedisConstant.CAHCENAME+"|getTitleList|"+offset+"|"+limit;
		//先去缓存中取
		List<Title> result_cache=cache.getListCache(cache_key, Title.class);
		if(result_cache==null){
			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache=TitleDao.queryAll(offset, limit);
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisConstant.CAHCETIME);
			LOG.info("put cache with key:"+cache_key);
		}else{
			LOG.info("get cache with key:"+cache_key);
		}
		return result_cache;
	}
	
	

}
