package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/5/15.
 */
public class StringUtil {

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }else{
            return  false;
        }
    }

    /**
     * 判断是否不是空
     */
    public static boolean isNotEmpty(String str){
        if((str != null)&& !"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 过滤掉集合里面的空格
     */
    public static List<String> filterWhite(List<String> list){
        List<String> resultList = new ArrayList<String>();
        for(String l : list){
            if(isNotEmpty(l)){
                resultList.add(l);
            }
        }
        return resultList;
    }
}
