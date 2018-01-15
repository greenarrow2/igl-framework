package com.igl.gov.common.serialize.support;

import com.fasterxml.jackson.core.type.TypeReference;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReferenceWrapper<T> {
    protected final Type type;

    public TypeReferenceWrapper() {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        } else {
            this.type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
        }
    }

    public TypeReference<T> getTypeReferenceForJackson() {
        return new TypeReferenceWrapper.JacksonTypeReference<T>(this.type) {
        };
    }

    static class JacksonTypeReference<T> extends TypeReference<T> {
        protected final Type typeWrapper;

        protected JacksonTypeReference(Type type) {
            this.typeWrapper = type;
        }

        @Override
        public Type getType() {
            return this.typeWrapper;
        }

        @Override
        public int compareTo(TypeReference<T> o) {
            return super.compareTo(o);
        }
    }
}
