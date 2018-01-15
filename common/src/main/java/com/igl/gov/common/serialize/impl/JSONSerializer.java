package com.igl.gov.common.serialize.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.igl.gov.common.exception.SerializeException;
import com.igl.gov.common.serialize.ISerializer;
import com.igl.gov.common.serialize.support.TypeReferenceWrapper;
import com.igl.gov.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class JSONSerializer implements ISerializer {
    private static final Logger logger = LoggerFactory.getLogger(JSONSerializer.class);
    private static final JSONSerializer DEFAULT_INSTANCE = new JSONSerializer();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private String charset = "utf-8";
    private boolean slowSerializeHappened = false;

    public JSONSerializer() {
    }

    public static final JSONSerializer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public byte[] serialize(Object o) throws SerializeException {
        if (o == null) {
            return new byte[0];
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter writer = null;

            try {
                writer = new OutputStreamWriter(baos, this.charset);
                objectMapper.writeValue(writer, o);
            } catch (Exception var8) {
                throw new SerializeException(var8.getMessage(), var8);
            }

            byte[] data = baos.toByteArray();

            try {
                baos.close();
            } catch (IOException var7) {
                logger.error(var7.getMessage(), var7);
            }

            long end = System.currentTimeMillis();
            return data;
        }
    }

    public <T> T deserialize(byte[] data, Class<T> tpl) throws SerializeException {
        if (data != null && data.length != 0) {
            Object object = null;
            String s = null;

            try {
                s = new String(data, this.charset);
            } catch (UnsupportedEncodingException var8) {
                throw new SerializeException(var8.getMessage(), var8);
            }

            try {
                object = objectMapper.readValue(s, TypeFactory.rawClass(tpl));
            } catch (Exception var7) {
                throw new SerializeException("error while parsing json character -> " + s.replaceAll("\\r\\n", ""), var7);
            }

            long end = System.currentTimeMillis();
            return (T) object;
        } else {
            return null;
        }
    }

    public <T> T deserialize(String json, Class<T> tpl) throws SerializeException {
        if (!StringUtil.hasText(json)) {
            return null;
        } else {
            try {
                return this.deserialize(json.getBytes(this.charset), tpl);
            } catch (UnsupportedEncodingException var4) {
                throw new SerializeException(var4.getMessage(), var4);
            }
        }
    }

    public <T> T deserialize(String json, TypeReferenceWrapper<T> tpr) throws SerializeException {
        if (!StringUtil.hasText(json)) {
            return null;
        } else {
            try {
                return objectMapper.readValue(json, tpr.getTypeReferenceForJackson());
            } catch (UnsupportedEncodingException var4) {
                throw new SerializeException(var4.getMessage(), var4);
            } catch (JsonParseException var5) {
                throw new SerializeException(var5.getMessage(), var5);
            } catch (JsonMappingException var6) {
                throw new SerializeException(var6.getMessage(), var6);
            } catch (IOException var7) {
                throw new SerializeException(var7.getMessage(), var7);
            }
        }
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String serialize2JSON(Object o) throws SerializeException {
        try {
            return new String(this.serialize(o), this.charset);
        } catch (UnsupportedEncodingException var3) {
            throw new SerializeException(var3.getMessage(), var3);
        }
    }

    static {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
        objectMapper.configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
