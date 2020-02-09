package com.bigguy.spring.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/9
 **/
public class CommonUtils {

    public static List<String> setToList(Set<String> setValues){
        if( null == setValues){
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>(setValues.size());
        setValues.forEach(list::add);
        return list;
    }

}
