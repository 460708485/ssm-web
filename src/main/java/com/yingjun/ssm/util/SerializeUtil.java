package com.yingjun.ssm.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列化工具
 * 
 * @author wangjq
 *
 */
public class SerializeUtil {

	private static final Logger logger = LoggerFactory.getLogger(SerializeUtil.class);
	
	/**
	 * 序列化
	 * @param val
	 * @return
	 */
	public static byte[] serialize(Object val) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream bos = null;
		try{
			//序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			//写进流
			oos.writeObject(val);
			byte[] bs = bos.toByteArray();
			return  bs;
			
		}catch(Exception e){
			logger.error("BUSINESS|SerializeUtil->serialize Exception", e);
		}finally{
			//关闭流
			try{
				oos.close();
				bos.close();
			}catch(Exception e){
				logger.error("BUSINESS|SerializeUtil->serialize->close Exception", e);
			}
		}
		return null;
	}

	
	/**
	 * 反序列化
	 * @param val
	 * @param clz
	 * @return
	 */
	public static <T> T unSerialize(byte[] val,Class<T> clz) {
		ObjectInputStream ois = null;
		ByteArrayInputStream bis = null;
		try{
			//序列化
			bis = new ByteArrayInputStream(val);
			ois = new ObjectInputStream(bis);
			return  clz.cast(ois.readObject());
			
		}catch(Exception e){
			logger.error("BUSINESS|SerializeUtil->unSerialize Exception", e);
		}finally{
			//关闭流
			try{
				bis.close();
				ois.close();
			}catch(Exception e){
				logger.error("BUSINESS|SerializeUtil->unSerialize->close Exception", e);
			}
		}
		return null;
	}

	
}
