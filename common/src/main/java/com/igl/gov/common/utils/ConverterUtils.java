package com.igl.gov.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 拷贝对象
 * 
 * @author YuZhong.Jiang
 * 
 */
public class ConverterUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConverterUtils.class);
	private static final Map<String, BeanCopier> CACHED_COPIER_MAP = new ConcurrentHashMap<String, BeanCopier>();
	private static final Map<String, CustomConverter> CACHED_CUSTOM_CONVERTER_MAP = new ConcurrentHashMap<String, CustomConverter>();

	/**
	 * 拷贝一个对象
	 * 
	 * @param sourceObj
	 * @param targetObj
	 * @param converter
	 * @param customerConverterClass
	 * @return
	 */
	public static <S, T> T convertOne(S sourceObj, T targetObj,
			Class<? extends CustomConverter> customerConverterClass, Converter converter) {
		if (sourceObj == null || targetObj == null) {
			return null;
		}
		copy(sourceObj, targetObj, converter, customerConverterClass);
		return targetObj;
	}

	/**
	 * 拷贝一个对象
	 * 
	 * @param sourceObj
	 * @param targetObj
	 * @return
	 */
	public static <S, T> T convertOne(S sourceObj, T targetObj) {
		return convertOne(sourceObj, targetObj, null, null);
	}

	/**
	 * 拷贝一个对象
	 *
	 * @param sourceObj
	 * @param targetClass
	 * @return
	 */
	public static <S, T> T convertOne(S sourceObj, Class<T> targetClass) {
		T targetObj = null;
		try {
			targetObj = targetClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return convertOne(sourceObj, targetObj, null, null);
	}
	/**
	 * 拷贝一个对象
	 * 
	 * @param sourceObj
	 * @param targetObj
	 * @return
	 */
	public static <S, T> T convertOne(S sourceObj, T targetObj, CustomConverter converter) {
		if (sourceObj == null || targetObj == null) {
			return null;
		}
		copy(sourceObj, targetObj, null, converter);
		return targetObj;
	}

	/**
	 * 拷贝一个对象
	 * 
	 * @param sourceObj
	 * @param targetObj
	 * @return
	 */
	public static <S, T> T convertOne(S sourceObj, T targetObj,
			Class<? extends CustomConverter> customerConverterClass) {
		if (sourceObj == null || targetObj == null) {
			return null;
		}
		copy(sourceObj, targetObj, null, customerConverterClass);
		return targetObj;
	}

	/**
	 * 拷贝集合
	 * 
	 * @param sourceObjList
	 * @param targetClass
	 * @param converter
	 * @param converterClass
	 * @return
	 */
	public static <S, T> List<T> convertList(List<S> sourceObjList, Class<T> targetClass, Converter converter,
			Class<? extends CustomConverter> converterClass) {
		if (sourceObjList == null) {
			return null;
		}
		List<T> targetObjList = new ArrayList<T>();
		for (S sourceObj : sourceObjList) {
			try {
				T TargetObj = targetClass.newInstance();
				copy(sourceObj, TargetObj, converter, converterClass);
				targetObjList.add(TargetObj);
			} catch (Exception e) {
				LOGGER.error("创建target对象失败", e);
			}
		}
		return targetObjList;
	}

	/**
	 * 拷贝集合
	 * 
	 * @param sourceObjList
	 * @param targetClass
	 * @return
	 */
	public static <S, T> List<T> convertList(List<S> sourceObjList, Class<T> targetClass) {
		return convertList(sourceObjList, targetClass, null, null);
	}

	/**
	 * 拷贝Map,key不变,value拷贝
	 * 
	 * @param sourceObjMap
	 * @param targetClass
	 * @param converter
	 * @param converterClass
	 * @return
	 */
	public static <K, S, T> Map<K, T> convertMap(Map<K, S> sourceObjMap, Class<T> targetClass, Converter converter,
			Class<? extends CustomConverter> converterClass) {
		if (sourceObjMap == null) {
			return null;
		}
		Map<K, T> targetObjMap = new HashMap<K, T>();
		for (K key : sourceObjMap.keySet()) {
			S sourceObj = sourceObjMap.get(key);
			try {
				T TargetObj = targetClass.newInstance();
				copy(sourceObj, TargetObj, converter, converterClass);
				targetObjMap.put(key, TargetObj);
			} catch (Exception e) {
				LOGGER.error("创建target对象失败" + e);
			}
		}
		return targetObjMap;
	}

	/**
	 * 拷贝Map,key不变,value拷贝
	 * 
	 * @param sourceObjMap
	 * @param targetClass
	 * @return
	 */
	public static <K, S, T> Map<K, T> convertMap(Map<K, S> sourceObjMap, Class<T> targetClass) {
		return convertMap(sourceObjMap, targetClass, null, null);
	}

	/**
	 * 取得BeanCopier,有缓存先找缓存
	 * 
	 * @param sourceClass
	 * @param targetClass
	 * @param converter
	 * @return
	 */
	private static <S, T> BeanCopier getBeanCopier(Class<S> sourceClass, Class<T> targetClass, Converter converter) {
		String key = sourceClass.getName() + targetClass.getName();
		BeanCopier copier = CACHED_COPIER_MAP.get(key);
		if (copier == null) {
			copier = BeanCopier.create(sourceClass, targetClass, converter != null);
			CACHED_COPIER_MAP.put(key, copier);
		}
		return copier;
	}

	/**
	 * 取得自定义converter,有缓存先找缓存
	 * 
	 * @param converterClass
	 * @return
	 * @author jiangyz
	 */
	private static CustomConverter getCustomerConverter(Class<? extends CustomConverter> converterClass) {
		if (converterClass == null) {
			return null;
		}
		String key = converterClass.getName();
		CustomConverter converter = CACHED_CUSTOM_CONVERTER_MAP.get(key);
		if (converter == null) {
			try {
				converter = converterClass.newInstance();
			} catch (Exception e) {
				LOGGER.error("创建converter失败" + e);
			}
			CACHED_CUSTOM_CONVERTER_MAP.put(key, converter);
		}
		return converter;
	}

	/**
	 * 从source复制到target
	 * 
	 * @param source
	 * @param target
	 * @param converter
	 * @param customerConverterClass
	 */
	private static <S, T> void copy(S source, T target, Converter converter,
			Class<? extends CustomConverter> customerConverterClass) {
		BeanCopier copier = getBeanCopier(source.getClass(), target.getClass(), converter);
		copier.copy(source, target, converter);
		CustomConverter customerConverter = getCustomerConverter(customerConverterClass);
		if (customerConverter != null) {
			customerConverter.convert(source, target);
		}
	}

	private static <S, T> void copy(S source, T target, Converter converter, CustomConverter customerConverter) {
		BeanCopier copier = getBeanCopier(source.getClass(), target.getClass(), converter);
		copier.copy(source, target, converter);
		if (customerConverter != null) {
			customerConverter.convert(source, target);
		}
	}
}