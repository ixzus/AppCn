package com.yltx.appcn.net;

import android.util.Log;

import com.yltx.appcn.BuildConfig;
import com.yltx.appcn.base.App;

import java.util.concurrent.TimeUnit;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/7.
 */

public class RxRetrofit {
    private String BASE_URL = "http://192.168.3.49:11012/mdm-rs/";
//    private String BASE_URL = "http://www.weather.com.cn/";
    private int DEFAULT_TIMEOUT = 3;
    private Retrofit retrofit;
    private CacheProviders cacheProviders;
    private ApiService apiService;
    private static RxRetrofit instance;

    public RxRetrofit() {
        doHttp();
    }

    public static RxRetrofit getInstance() {
        if (instance == null) {
            synchronized (RxRetrofit.class) {
                if (instance == null) {
                    instance = new RxRetrofit();
                }
            }
        }
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }

    public CacheProviders getCacheProviders() {
        return cacheProviders;
    }

    public void doHttp() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//        builder.retryOnConnectionFailure(true); //失败重试

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("retrofit>>", message);
                }
            });
            loggingInterceptor.setLevel(level);
            builder.addInterceptor(loggingInterceptor);
        }

        OkHttpClient okHttpClient = builder.build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();


        cacheProviders = new RxCache.Builder()
                .persistence(App.getApplication().getFilesDir(), new GsonSpeaker())
                .using(CacheProviders.class);

        apiService = retrofit.create(ApiService.class);

    }
}
