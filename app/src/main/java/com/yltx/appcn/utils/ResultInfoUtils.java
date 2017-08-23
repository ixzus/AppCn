package com.yltx.appcn.utils;



/**
 * Author：Wq
 * Date：2017/4/21 10:54
 * Description： 接口返回数据的 的code判断
 */

public class ResultInfoUtils {
    public static boolean isSuccess(String code) {
        if (null!=code && "success".equals(code.trim())) {
            //返回正常数据
            return true;
        } else {
            return false;
        }

    }






    public static boolean isError(String code) {
        if (code != null && "error".equals(code.trim())) {
            return true;
        } else {
            return false;
        }

    }


}
