package com.igl.gov.common.serialize;

import com.igl.gov.common.exception.SerializeException;

public interface ISerializer {
    byte[] serialize(Object var1) throws SerializeException;

    <T> T deserialize(byte[] var1, Class<T> var2) throws SerializeException;
}
