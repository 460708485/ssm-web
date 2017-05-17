package com.yingjun.ssm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yingjun.ssm.cache.RedisCache;
import com.yingjun.ssm.common.constants.RedisConstant;
import com.yingjun.ssm.dao.ContentDao;
import com.yingjun.ssm.entity.Content;
import com.yingjun.ssm.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ContentDao ContentDao;
	@Autowired
	private RedisCache cache;
	
	
	@Override
	public List<Content> getContentList(Integer type,int offset, int limit) {
		String cache_key=RedisConstant.CAHCENAME+"|getContentList|"+offset+"|"+limit;
		//先去缓存中取
		List<Content> result_cache=cache.getListCache(cache_key, Content.class);
		if(result_cache==null){
			//缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
			result_cache=ContentDao.queryAll(type, offset, limit);
			cache.putListCacheWithExpireTime(cache_key, result_cache, RedisConstant.CAHCETIME);
			LOG.info("put cache with key:"+cache_key);
		}else{
			LOG.info("get cache with key:"+cache_key);
		}
		for(Content c : result_cache){
			String key = RedisConstant.SEQ_CHANCE_NAME + String.valueOf(c.getId());
			c.setCount((Integer)cache.get(key));
		}
		return result_cache;
	}


	@Override
	public Content queryById(Integer id) {
		if(null == id ){
			LOG.info("参数不能空");
			return null;
		}
		return ContentDao.queryById(id);
	}

	//缓存+1
	@Override
	public void addCount(Integer id) {
		String key = RedisConstant.SEQ_CHANCE_NAME+id;
		if(null == cache.existsKey(key)){
			//如果为空，初始化为0
			cache.set(key, 0);
		}
		cache.incrBy(RedisConstant.SEQ_CHANCE_NAME+id);
		
	}
	
	

}
