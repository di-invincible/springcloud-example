package com.example.common.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author aaron
 * @version 1.0
 * @since 2020-07-09 11:42
 */
public class ObjectConvert {

    /**
     * vo 集合 转换
     * @param sourceList 源集合
     * @param targetClazz 目标 class
     * @param <T> 目标泛型
     * @param <S> 源泛型
     * @return List<T>
     */
    public static <T,S> List<T> toTargetList(List<S> sourceList, Class<T> targetClazz) {
        List<T> result = Lists.newArrayList();
        if(sourceList == null || sourceList.isEmpty()){
            return result;
        }
        sourceList.forEach(x -> {
            result.add(toTarget(x,targetClazz));
        });
        return result;
    }

    /**
     * vo 转换
     * @param source 源
     * @param targetClazz 目标 class
     * @param <T> 目标泛型
     * @return T
     */
    public static <T> T toTarget(Object source , Class<T> targetClazz){
        T target =  BeanUtils.instantiateClass(targetClazz);
        if(source == null){
            return target;
        }
        BeanUtils.copyProperties(source,target);
        return target;
    }

}
