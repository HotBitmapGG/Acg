package com.example.cnsunrun.debugdemo.mvp.model.network.api;

import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziDetailsInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.QuanziInfo;
import com.example.cnsunrun.debugdemo.mvp.model.bean.base.BaseResponseInfo;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by cnsunrun on 2017/3/11.
 * <p>
 * lastid=-1&activityid=-1&hotlastid=-1&type=1&userid=-1&dynamicuserids=1111&sid=dbe5b18fe665dbc25d22cdeb2d5cc436#
 */

public interface IQuanziService {

    /**
     * 获取圈子列表数据
     *
     * @param lastid
     * @param activityid
     * @param hotlastid
     * @param type
     * @param userid
     * @param dynamicuserids
     * @param sid
     * @return
     */
    @Headers({"Juju-Token: e2768897c0e5b4ba9e13ed7edf1ef8da", "Juju-Banben: A262", "User-Agent: Juju Android Client"})
    @GET("newblog/bloglist")
    Flowable<BaseResponseInfo<QuanziInfo>> getQuanziInfos(@Query("lastid") long lastid,
                                                          @Query("activityid") long activityid,
                                                          @Query("hotlastid") long hotlastid,
                                                          @Query("type") int type,
                                                          @Query("userid") int userid,
                                                          @Query("dynamicuserids") int dynamicuserids,
                                                          @Query("sid") String sid);


    /**
     * 获取圈子详情数据
     *
     * @param blogid
     * @param sid
     * @return
     */
    @Headers({"Juju-Token: e2768897c0e5b4ba9e13ed7edf1ef8da", "Juju-Banben: A262", "User-Agent: Juju Android Client"})
    @GET("newblog/blogview")
    Flowable<BaseResponseInfo<QuanziDetailsInfo>> getQuanziDetailsInfo(@Query("blogid") String blogid,
                                                                       @Query("sid") String sid);

}
