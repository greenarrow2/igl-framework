package com.igl.gov.common.util;

import com.igl.gov.common.exception.SerializeException;
import com.igl.gov.common.serialize.ISerializer;
import com.igl.gov.common.serialize.impl.JSONSerializer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 序列话工具
 *
 * @author ldc 2016-10-25
 */
public class ProtoStuffSerializerUtil {

	private static final ISerializer serializer = new JSONSerializer();

	/**
	 * 序列化对象
	 *
	 * @param obj
	 * @return
	 */
	public static <T> byte[] serialize(T obj) {
		try {
			return serializer.serialize(obj);
		} catch (SerializeException e) {
			throw new RuntimeException("序列化(" + obj.getClass() + ")对象(" + obj + ")发生异常!", e);
		}
	}

	/**
	 * 反序列化对象
	 *
	 * @param paramArrayOfByte
	 * @param targetClass
	 * @return
	 */
	public static <T> T deserialize(byte[] paramArrayOfByte, Class<T> targetClass) {
		try {
			return serializer.deserialize(paramArrayOfByte, targetClass);
		} catch (SerializeException e) {
			throw new RuntimeException("反序列化过程中依据类型创建对象失败!", e);
		}
	}

	/**
	 * 序列化列表
	 *
	 * @param objList
	 * @return
	 */
	public static <T> byte[] serializeList(List<T> objList) {
		return serialize(objList);
	}

	/**
	 * 反序列化列表
	 * 
	 * @param paramArrayOfByte>
	 *
	 * @param targetClass
	 * @param targetClass
	 * @return
	 */
	public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
		String message = new String(paramArrayOfByte, Charset.forName("utf-8"));
		return JacksonUtil.deserializeJsonToList(message, targetClass);
	}

}