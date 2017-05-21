package com.example.cnsunrun.debugdemo.mvp.model.network;

import com.example.cnsunrun.debugdemo.DebugDemoApp;
import com.example.cnsunrun.debugdemo.mvp.model.network.api.ICopyService;
import com.example.cnsunrun.debugdemo.mvp.model.network.api.IQuanziService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cnsunrun on 2017/3/11.
 */

public class RetrofitHelper {

    private static OkHttpClient mOkHttpClient;

    public static final String BASE_URL = "http://server.juju.la/";

    static {
        initOkHttpClient();
    }

    /**
     * 创建圈子网络请求
     *
     * @return
     */
    public static IQuanziService createQuanziService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuanziService.class);
    }


    /**
     * 创建副本网络请求
     *
     * @return
     */
    public static ICopyService createCopyService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ICopyService.class);
    }


    /**
     * 初始化OKHttpClient
     */
    private static void initOkHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {
                    //设置Http缓存
                    Cache cache = new Cache(
                            new File(DebugDemoApp.getAppContext().getCacheDir(), "HttpCache"),
                            1024 * 1024 * 100);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            // .addNetworkInterceptor(new CacheInterceptor())
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }


//    /**
//     * 添加Okhttp缓存拦截器
//     */
//    private static class CacheInterceptor implements Interceptor {
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//
//            // 有网络时 设置缓存超时时间1个小时
//            int maxAge = 60 * 60;
//            // 无网络时，设置超时为1天
//            int maxStale = 60 * 60 * 24;
//            Request request = chain.request();
//            if (NetWorkUtil.isNetworkConnected()) {
//                //有网络时只从网络获取
//                request = request.newBuilder()
//                        .cacheControl(CacheControl.FORCE_NETWORK)
//                        .build();
//            } else {
//                //无网络时只从缓存中读取
//                request = request.newBuilder()
//                        .cacheControl(CacheControl.FORCE_CACHE)
//                        .build();
//            }
//            Response response = chain.proceed(request);
//            if (NetWorkUtil.isNetworkConnected()) {
//                response = response.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public, max-age=" + maxAge)
//                        .build();
//            } else {
//                response = response.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                        .build();
//            }
//            return response;
//        }
//    }

}
