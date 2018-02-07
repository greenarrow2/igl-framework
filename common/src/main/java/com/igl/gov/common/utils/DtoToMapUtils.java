package com.igl.gov.common.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class DtoToMapUtils<T> {

    private static Logger logger = Logger.getLogger(DtoToMapUtils.class);

    private DtoToMapUtils() {

    }

    /**
     * 对象转化为map
     * @param dto 传入对象
     * @return
     */
    public static Map<String,Object> dtoToMap(Object dto){
        Field [] fields = dto.getClass().getDeclaredFields();
        Map<String,Object>  map = new HashMap<>(fields.length);
        try {
            for (Field field: fields) {
                field.setAccessible(true);
                if(field.get(dto) != null){
                    map.put(field.getName(),field.get(dto));
                }
            }
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(),e);
        }
        return map;
    }


    public static Map<String,Object> requestToMapPage(HttpServletRequest request){
        Map<String,Object>  map = requestToMap(request);
        if(map.get("page") != null && map.get("rows") != null){
            Integer page =Integer.parseInt(map.get("page").toString());
            Integer size = Integer.parseInt(map.get("rows").toString());
            Integer start;
            if(page <= 1){
                start = 0;
            }else {
                start = (page - 1) * size;
            }
            Integer offset = size;
            if (offset <= 0){
                offset = 20;
            }
           /* map.remove("page");
            map.remove("rows");*/
            map.put("start",start);
            map.put("offset",offset);
        }

        return map;
    }

    public static Map<String,Object> requestToMap(HttpServletRequest request){
        return requestToMap(request,null);
    }

    public static Map<String,Object> requestToMap(HttpServletRequest request,Map<String,Object> map){
        if(map == null){
            map = new HashMap<>();
        }
        Enumeration<String> enumeration = request.getParameterNames();
        if (enumeration != null){
            while (enumeration.hasMoreElements()){
               String param = enumeration.nextElement();
               String value = request.getParameter(param);
               if(!StringUtils.isEmpty(value)){
                   map.put(param,value);
               }
            }
        }
        return map;
    }


    public static Object requestToDto(HttpServletRequest request,Object dto){
        Enumeration<String> enumeration = request.getParameterNames();
        Field [] fields = dto.getClass().getDeclaredFields();
        if (enumeration != null){
            try {
            while (enumeration.hasMoreElements()){
                String param = enumeration.nextElement();
                for (Field field:fields
                     ) {
                    field.setAccessible(true);
                    if (param.equals(field.getName())){
                        String value = request.getParameter(param);
                        if(!StringUtils.isEmpty(value)){
                            field.set(dto,value);
                        }
                    }

                }

            }
            } catch (IllegalAccessException e) {
                logger.error(e.getMessage(),e);
            }
        }
        return dto;
    }

    public static Map<String,Object> paramToPageMap(Map<String,Object> param){
        if(param.get("page") != null && param.get("rows") != null){
            Integer page =Integer.parseInt(param.get("page").toString());
            Integer size = Integer.parseInt(param.get("rows").toString());
            Integer start;
            if(page <= 1){
                start = 0;
            }else {
                start = (page - 1) * size;
            }
            Integer offset = size;
            if (offset <= 0){
                offset = 20;
            }
            param.put("start",start);
            param.put("offset",offset);
        }

        return param;
    }


}
