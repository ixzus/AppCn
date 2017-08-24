package com.yltx.appcn.net;

import com.yltx.appcn.bean.CarServiceOrderRsObj;
import com.yltx.appcn.bean.CartMemberBean;
import com.yltx.appcn.bean.GetCarDetailRsBean;
import com.yltx.appcn.bean.GetUserInfoRsBean;
import com.yltx.appcn.bean.HandleNum;
import com.yltx.appcn.bean.LoginBean;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.LoginRsBean;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.bean.ResetPwdBean;
import com.yltx.appcn.bean.ResetPwdRsBean;
import com.yltx.appcn.bean.SendSmsRsBean;
import com.yltx.appcn.bean.WeatherInfo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.LifeCache;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * 功能描述:
 * Created by ixzus on 2017/8/7.
 */

public interface ApiService {
//    private final static String BASEURL = "http://192.168.3.49:21014/mdm-rs/";
//    private final static String LOGINURL = BASEURL + "member/login";

//    public static Observable<Response<Member>> login(String json) {
////        return OkGo.<String>post("http://192.168.3.49:11012/mdm-rs/member/login")
//        return OkGo.<Member>post(LOGINURL)
//                .upJson(json)
//                .converter(new JsonC())
//                .adapt(new ObservableBody<String>());
//}

    //    public static Observable<Response<String>> getMember(String memgerId){
//        return OkGo.get(BASEURL+"member/getMember")
//                .params("memgerId",memgerId)
//                .converter(new StringConvert())
//                .adapt(new ObservableResponse<String>());
//
//    }
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)

    //http://192.168.X.X:XX/api/user/login
    @POST("member/login")
    Observable<Member> login(@Body LoginInfo loginInfo);


    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("member/getMember")
    Observable<CartMemberBean> getMemger(@Query("memgerId") String memgerId);


    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("data/cityinfo/101010100.html")
    Observable<WeatherInfo> getWeather();


    //http://192.168.X.X:XX/api/user/login   登录
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @POST("user/login")
    Observable<LoginRsBean> login(@Body LoginBean mLoginBean);


    //http://192.168.X.X:XX/api/user/sendMsgByPhone
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("user/sendMsgByPhone")
    Observable<SendSmsRsBean> sendMsgByPhone(@Query("mobilePhone") String mobilePhone, @Query("businessType") String businessType);

    //http://192.168.X.X:XX/api/user/resetnewPassword 重置密码
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @POST("user/resetnewPassword")
    Observable<ResetPwdRsBean> resetnewPassword(@Body ResetPwdBean mResetPwdBean);


    //http://192.168.X.X:XX/api/user/getUserInfoByUserId
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("user/getUserInfoByUserId")
    Observable<GetUserInfoRsBean> getUserInfoByUserId(@Query("userId") String userId);


    //http://192.168.X.X:XX/api/user/updatePassword  修改密码
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @POST("user/updatePassword")
//    Observable<String> updatePassword(@Body ModifyPwdBean mModifyPwdBean);
    Observable<ResetPwdRsBean> updatePassword(@Query("userId") String userId, @Query("oldPassword") String oldPassword, @Query("newPassword") String newPassword);

    //首页
    @GET("carServiceOrder/getToBeHandleNum")
    Observable<HandleNum> getToBeHandleNum(@Query("userId") String userId);

    //派单列表
    @GET("carServiceOrder/dispatchList")
    Observable<CarServiceOrderRsObj> getDispatchList(@Query("memberId") String memberId, @Query("status") String status, @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);


    //http://192.168.X.X:XX/api/message/getMessages

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("message/getMessages")
    Observable<GetUserInfoRsBean> getMessages(@Query("userId") String userId, @Query("page") String page);



    //http://192.168.X.X:XX/api/message/getMessage
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("message/getMessage")
    Observable<GetUserInfoRsBean> getMessage(@Query("messageId") String messageId);


    //http://192.168.X.X:XX/api/carServiceOrder/getCarInfoById
    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    @GET("carServiceOrder/getCarInfoById")
    Observable<GetCarDetailRsBean> getCarInfoById(@Query("carId") String carId);


}
