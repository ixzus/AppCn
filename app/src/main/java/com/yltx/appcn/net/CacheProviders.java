package com.yltx.appcn.net;

import com.yltx.appcn.bean.CartMemberBean;
import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;
import com.yltx.appcn.bean.WeatherInfo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CacheProviders {

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<Member> login(@Body LoginInfo loginInfo, EvictProvider evictProvider);

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<CartMemberBean> getMemger(@Query("memgerId") String memgerId);

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<WeatherInfo> getWeather(Observable<WeatherInfo> weatherInfo, EvictProvider evictDynamicKey);
}