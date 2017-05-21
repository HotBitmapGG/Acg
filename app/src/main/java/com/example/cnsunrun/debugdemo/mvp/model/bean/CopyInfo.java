package com.example.cnsunrun.debugdemo.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cnsunrun on 2017/4/19.
 * <p>
 * 副本列表模型类
 */

public class CopyInfo {


    @SerializedName("activityo.hasnotice")
    private String activityoHasnotice;
    @SerializedName("activityo.list")
    private List<ActivityoListBean> activityoListBeans;

    public String getActivityoHasnotice() {
        return activityoHasnotice;
    }

    public void setActivityoHasnotice(String activityoHasnotice) {
        this.activityoHasnotice = activityoHasnotice;
    }

    public List<ActivityoListBean> getActivityoListBeans() {
        return activityoListBeans;
    }

    public void setActivityoListBeans(List<ActivityoListBean> activityoListBeans) {
        this.activityoListBeans = activityoListBeans;
    }

    public static class ActivityoListBean {
        /**
         * activityid : 1002549
         * picture : http://juheadpic.juju.la/group/cc10a9ad5460f3715d6baaf76bd91065.png
         * name : 刀剑乱舞国服
         * user_name : JUJU审核菌
         * timestr : null
         * form : 其他
         * counter : 132
         * iscreate : -1
         */

        private String activityid;
        private String picture;
        private String name;
        private String user_name;
        private Object timestr;
        private String form;
        private String counter;
        private int iscreate;

        public String getActivityid() {
            return activityid;
        }

        public void setActivityid(String activityid) {
            this.activityid = activityid;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public Object getTimestr() {
            return timestr;
        }

        public void setTimestr(Object timestr) {
            this.timestr = timestr;
        }

        public String getForm() {
            return form;
        }

        public void setForm(String form) {
            this.form = form;
        }

        public String getCounter() {
            return counter;
        }

        public void setCounter(String counter) {
            this.counter = counter;
        }

        public int getIscreate() {
            return iscreate;
        }

        public void setIscreate(int iscreate) {
            this.iscreate = iscreate;
        }

    }
}
