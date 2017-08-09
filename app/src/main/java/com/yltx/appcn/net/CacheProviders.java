package com.yltx.appcn.net;

import com.yltx.appcn.bean.LoginInfo;
import com.yltx.appcn.bean.Member;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import retrofit2.http.Body;

public interface CacheProviders {

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<Member> login(@Body LoginInfo loginInfo, EvictProvider evictProvider);

}