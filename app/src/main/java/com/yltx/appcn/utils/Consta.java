package com.yltx.appcn.utils;

/**
 * Author：Wq
 * Date：2017/8/23 13:43
 * Description：//todo
 */

public class Consta {

    public class sendSmsData {
        public static final String businessType = "mobliephone";//不可以代缴

        public static final String ModifyType = "toModifyType";

        public static final int ModifyType_Modify = 2;//修改密码

        public static final int ModifyType_ReSet = 1;//重置


        public static final String PHONE = "phone";//电话号码
        public static final String Sms_Code = "smsCode";//验证码

    }

    //ACache.get(getActivity()).put("key","userid");
    //ACache.get(getActivity()).getAsString("key");

    public class SP_PARAMS {
        public static final String USERID = "userId";
        public static final String USERNAME = "userName";
    }


    public class INTENT_KEY_PARAMS {
        public static final String CARID = "carId";
    }
}
