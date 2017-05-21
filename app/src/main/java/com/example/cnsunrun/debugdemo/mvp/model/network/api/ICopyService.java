package com.example.cnsunrun.debugdemo.mvp.model.network.api;

import com.example.cnsunrun.debugdemo.mvp.model.bean.CopyDetailsInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.CopyInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.base.BaseResponseInfo;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by cnsunrun on 2017/4/19.
 * <p>
 * http://server.juju.la/activityo/activityolist?pageid=1&form=1&sid=d89a68bddc0784e750f6f841eeb61647#
 */

public interface ICopyService {

    /**
     * 获取副本列表
     *
     * @param pageId
     * @param form
     * @param sid
     * @return
     */
    @Headers({"Juju-Token: e2768897c0e5b4ba9e13ed7edf1ef8da", "Juju-Banben: A262", "User-Agent: Juju Android Client"})
    @GET("activityo/activityolist")
    Flowable<BaseResponseInfo<CopyInfo>> getCopys(@Query("pageid") int pageId,
                                                  @Query("form") int form,
                                                  @Query("sid") String sid);

    /**
     * 获取副本详情
     *
     * @param activityid
     * @param sid
     * @return
     */
    @Headers({"Juju-Token: e2768897c0e5b4ba9e13ed7edf1ef8da", "Juju-Banben: A262", "User-Agent: Juju Android Client"})
    @GET("activityo/activityodetail")
    Flowable<CopyDetailsInfo> getCopyDetails(@Query("activityid") String activityid,
                                             @Query("sid") String sid);
}

