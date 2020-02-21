package com.example.demo.server.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.util.Objects;

public class JsonUtils {
    private static final ObjectMapper objectMapperWriteDateAsTimestamps;
    private static final ObjectMapper objectMapperContainsNull;
    private static final ObjectMapper objectMapperContainsNullUseAnnotation;

    private static final ObjectMapper objectMapperContainsNotNull;
    private static final ObjectMapper objectMapperContainsNotNullUseAnnotation;

    static {
        objectMapperWriteDateAsTimestamps = new ObjectMapper();
        objectMapperWriteDateAsTimestamps.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapperWriteDateAsTimestamps.configure(MapperFeature.USE_ANNOTATIONS, false);

        objectMapperContainsNull = new ObjectMapper();
        objectMapperContainsNull.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapperContainsNull.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapperContainsNull.configure(MapperFeature.USE_ANNOTATIONS, false);

        objectMapperContainsNullUseAnnotation = new ObjectMapper();
        objectMapperContainsNullUseAnnotation.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapperContainsNullUseAnnotation.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapperContainsNullUseAnnotation.configure(MapperFeature.USE_ANNOTATIONS, true);

        objectMapperContainsNotNull = new ObjectMapper();
        objectMapperContainsNotNull.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapperContainsNotNull.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapperContainsNotNull.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapperContainsNotNull.configure(MapperFeature.USE_ANNOTATIONS, false);

        objectMapperContainsNotNullUseAnnotation = new ObjectMapper();
        objectMapperContainsNotNullUseAnnotation.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapperContainsNotNullUseAnnotation.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapperContainsNotNullUseAnnotation.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapperContainsNotNullUseAnnotation.configure(MapperFeature.USE_ANNOTATIONS, true);
    }
    public static String object2Json(Object object, boolean containNull) {
        if (Objects.isNull(object)) {
            return "";
        }
        ObjectMapper objectMapper = Objects.equals(containNull, Boolean.TRUE) ?
                objectMapperContainsNull : objectMapperContainsNotNull;
        return jsonSerialize(objectMapper, object, containNull);
    }

    private static String jsonSerialize(ObjectMapper objectMapper, Object object, boolean containNull) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
