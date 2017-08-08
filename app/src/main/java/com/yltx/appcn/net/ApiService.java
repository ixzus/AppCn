package com.yltx.appcn.net;

import com.yltx.appcn.bean.CartMemberBean;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;

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
    @POST("member/login")
    Observable<Member> login(@Body LoginInfo loginInfo);

    @GET("member/getMember")
    Observable<CartMemberBean> getMemger(@Query("memgerId") String memgerId);

}
