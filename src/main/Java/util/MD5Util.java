package util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by lenovo on 2018/6/20.
 */
public class MD5Util {
    /**
     * 使用shiro中的MD5加密
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }
}
