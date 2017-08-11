package com.yltx.appcn.net;

import android.text.TextUtils;

import com.ixzus.applibrary.net.HttpLogger;
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
    private static RxRetrofit instance;

    private String BASE_URL = "http://192.168.3.49:11012/mdm-rs/";
    private int DEFAULT_TIMEOUT = 3;
    private static int change = 0;

    private Retrofit retrofit;
    private CacheProviders cacheProviders;
    private ApiService apiService;

    public RxRetrofit() {
        create();
    }

    public RxRetrofit(String baseurl, int timeout) {
        create(baseurl, timeout);
    }


    public static RxRetrofit getInstance() {
        if (1 != change) {
            instance = null;
        }
        if (instance == null) {
            synchronized (RxRetrofit.class) {
                if (instance == null) {
                    change = 1;
                    instance = new RxRetrofit();
                }
            }
        }
        return instance;
    }

    public static RxRetrofit getInstance(String baseurl, int timeout) {
        if (2 != change) {
            instance = null;
        }
        if (instance == null) {
            synchronized (RxRetrofit.class) {
                if (instance == null) {
                    change = 2;
                    instance = new RxRetrofit(baseurl, timeout);
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

    private OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            loggingInterceptor.setLevel(level);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }

    private OkHttpClient okHttpClient(String baseurl, int timeout) {
        if (TextUtils.isEmpty(baseurl) && 0 == timeout) {
            return okHttpClient();
        } else {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (timeout > 0) {
                DEFAULT_TIMEOUT = timeout;
//                builder.readTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
//                builder.writeTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
//                builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                builder.readTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.MILLISECONDS);
                builder.writeTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.MILLISECONDS);
                builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
            }
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
                loggingInterceptor.setLevel(level);
                builder.addInterceptor(loggingInterceptor);
            }
            return builder.build();
        }
    }

    public void create() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient())
                .build();

        cacheProviders = new RxCache.Builder()
                .persistence(App.getApplication().getFilesDir(), new GsonSpeaker())
                .using(CacheProviders.class);

        apiService = retrofit.create(ApiService.class);

    }

    public void create(String baseurl, int timeout) {
        if (TextUtils.isEmpty(baseurl)) {
            baseurl = BASE_URL;
        }
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseurl)
                .client(okHttpClient(baseurl, timeout))
                .build();

        cacheProviders = new RxCache.Builder()
                .persistence(App.getApplication().getFilesDir(), new GsonSpeaker())
                .using(CacheProviders.class);

        apiService = retrofit.create(ApiService.class);

    }
}
