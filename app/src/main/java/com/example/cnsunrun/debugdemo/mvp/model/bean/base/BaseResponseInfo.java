package com.example.cnsunrun.debugdemo.mvp.model.bean.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cnsunrun on 2017/3/15.
 */

public class BaseResponseInfo<T> {

    @SerializedName("code")
    public String code;
    @SerializedName("message")
    public String message;
    @SerializedName("result")
    public T result;
    @SerializedName("sid")
    public String sid;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public T getBaseResult() {
        return result;
    }


    public String getSid() {
        return sid;
    }

}
