package com.igl.gov.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;

public class JacksonUtil {

	private static final Logger log = LoggerFactory.getLogger(JacksonUtil.class);

	public static final ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 将对象序列化成JSON字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String serializeObjectToJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("serialize object to json", e);
			return null;
		}
	}

	/**
	 * 将对象序列化到文件
	 * 
	 * @param obj
	 *            要序列化的对象
	 * @param file
	 *            要写入的文件
	 */
	public static void serializeObjectToFile(Object obj, File file) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(file, obj);
		} catch (Exception e) {
			log.error("Serialize Object To Json", e);
		}
	}

	/**
	 * 从文件读取JSON
	 * 
	 * @param file
	 *            来源文件
	 * @param clazz
	 *            反序列化成的类
	 * @return
	 */
	public static <T> T deserializeFormFile(File file, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(file, clazz);
		} catch (Exception e) {
			log.error("Deserialize Json Form File", e);
		}
		return null;
	}

	/**
	 * 将JSON字符串反序列化成对象
	 * 
	 * @param json
	 *            要反序列化JSON字符串
	 * @param typeReference
	 *            类型帮助类(带泛型类T为List,Map等泛型类)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserializeJsonToObject(String json, TypeReference<T> typeReference) {
		try {
			return (T) mapper.readValue(json, typeReference);
		} catch (Exception e) {
			log.error("Deserialize Json to Object", e);
			return null;
		}
	}

	/**
	 * 将JSON字符串反序列化成对象
	 * 
	 * @param json
	 *            要反序列化JSON字符串
	 * @param clazz
	 *            普通对象类型
	 * @return
	 */
	public static <T> T deserializeJsonToObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			log.error("Deserialize Json to Object", e);
			return null;
		}
	}

	/**
	 * 将JSON字符串反序列化成对象
	 * 
	 * @param json
	 *            要反序列化JSON字符串
	 * @param javaType
	 *            JavaType表示的对象
	 * @return
	 */
	public static Object deserializeJsonToObject(String json, JavaType javaType) {
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			log.error("Deserialize Json to Object", e);
			return null;
		}
	}

	/**
	 * 获取List类型的JavaType对象
	 * 
	 * @param clazz
	 *            List内部对象类型
	 * @return
	 */
	public static <T> JavaType getListJavaType(Class<T> clazz) {
		TypeFactory typeFactory = mapper.getTypeFactory();
		return typeFactory.constructCollectionType(List.class, typeFactory.constructType(clazz));
	}

	/**
	 * 将JSON字符串反序列化成List
	 * 
	 * @param json
	 *            JSON字符串
	 * @param clazz
	 *            List内部类型
	 * @return
	 */
	public static <T> List<T> deserializeJsonToList(String json, Class<T> clazz) {
		JavaType javaType = getListJavaType(clazz);
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			log.error("Deserialize Json to List", e);
			return Collections.emptyList();
		}
	}

	/**
	 * 获取Map类型的JavaType对象
	 * 
	 * @param clazzKey
	 *            Map key Type
	 * @param clazzValue
	 *            Map value Type
	 * @return Map类型的JavaType对象
	 */
	public static <K, V> JavaType getMapJavaType(Class<K> clazzKey, Class<V> clazzValue) {
		TypeFactory typeFactory = mapper.getTypeFactory();
		return typeFactory.constructMapType(Map.class, typeFactory.constructType(clazzKey),
				typeFactory.constructType(clazzValue));
	}

	/**
	 * 将JSON字符串反序列化成Map
	 * 
	 * @param <K>
	 * @param <V>
	 * @param json
	 *            JSON字符串
	 * @param clazzKey
	 *            Map key Type
	 * @param clazzValue
	 *            Map value Type
	 * @return Map<K,V>对象
	 */
	public static <K, V> Map<K, V> deserializeJsonToMap(String json, Class<K> clazzKey, Class<V> clazzValue) {
		JavaType javaType = getMapJavaType(clazzKey, clazzValue);
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			log.error("Deserialize Json to Map", e);
			return null;
		}
	}

	/**
	 * 将JSON字符串反序列化成List<Map>
	 * 
	 * @param json
	 *            JSON字符串
	 * @param clazzKey
	 *            key Type
	 * @param clazzValue
	 *            value Type
	 * @return
	 */
	public static <K, V> List<Map<K, V>> deserializeJsonToListMap(String json, Class<K> clazzKey, Class<V> clazzValue) {
		JavaType mapType = getMapJavaType(clazzKey, clazzValue);
		TypeFactory typeFactory = mapper.getTypeFactory();
		JavaType javaType = typeFactory.constructCollectionType(List.class, mapType);
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			log.error("Deserialize Json to List<Map>", e);
			return Collections.emptyList();
		}
	}
	
	/**
	 * 将 LinkedHashMap 转换为正常 JSON 字符串
	 * @param map
	 * @param charset
	 * @return
	 */
    public static String hashMapToJson(HashMap<?, ?> map,Charset charset) {
        String jsonString = "{";
        for (Iterator<?> it = map.entrySet().iterator(); it.hasNext();) {
            Entry<?, ?> e = (Entry<?, ?>) it.next();
            jsonString += "\"" + e.getKey() + "\"" + ":";
            jsonString += "\"" + e.getValue() + "\"" +",";
        }
        jsonString = jsonString.substring(0, jsonString.lastIndexOf(","));  
        jsonString += "}";
        
        byte[] body = jsonString.getBytes(charset);
        String json = new String(body,charset);
        return json;
    } 
}
