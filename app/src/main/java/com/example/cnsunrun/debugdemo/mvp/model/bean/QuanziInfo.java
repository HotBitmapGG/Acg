package com.example.cnsunrun.debugdemo.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cnsunrun on 2017/3/11.
 */

public class QuanziInfo {


    @SerializedName("blog.list")
    private List<BlogListBean> blogList;
    @SerializedName("dynamic.list")
    private List<?> dynamicList;
    @SerializedName("dynamic.idlist")
    private List<?> dynamicIdList;

    public List<BlogListBean> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<BlogListBean> blogList) {
        this.blogList = blogList;
    }

    public List<?> getDynamicList() {
        return dynamicList;
    }

    public void setDynamicList(List<?> dynamicList) {
        this.dynamicList = dynamicList;
    }

    public List<?> getDynamicIdList() {
        return dynamicIdList;
    }

    public void setDynamicIdList(List<?> dynamicIdList) {
        this.dynamicIdList = dynamicIdList;
    }

    public static class BlogListBean {
        /**
         * blog_id : 13489874
         * user_id : 10305705
         * nicename : 米饭哇
         * headpic : http://juheadpic.juju.la//86a92279b7c8454a2ffdaef6df2c2138.jpg
         * picture : http://jublogpic.juju.la//c684ef9b35a4d840cc0966fbb836ce1d.jpg
         * pic_x : 1500
         * pic_y : 1500
         * content : 骚一波(*´艸`)、
         * tagnames : [{"tagid":"257480","name":"日常"}]
         * comment_counter : 0
         * favour_counter : 1
         * zhuanfa_counter : 0
         * tf_hot : 0
         * tf_star : 63
         * original : -1
         * jointime : 2017-03-11 13:38:09
         * picturelist : ["http://jublogpic.juju.la//c684ef9b35a4d840cc0966fbb836ce1d.jpg","http://jublogpic.juju.la//ecdb39e6e293de415333251fd2ede963.jpg","http://jublogpic.juju.la//f9bead70a81da86c4c56263375919ed0.jpg","http://jublogpic.juju.la//de2f8b6c5a888f94eeeb8d528ec9812e.jpg","http://jublogpic.juju.la//96570e31393fb08cafeddf8cbabe1dfd.jpg","http://jublogpic.juju.la//6c7da024089a89f3c3329178f6f9e761.jpg","http://jublogpic.juju.la//4d1ce5f9269b9b77cf02f0901eba3e26.jpg"]
         * picturecounter : 7
         * otherurl : -1
         * blogtype : 1
         * julink : []
         * blogbg :
         * blogactivity : null
         * blogfavour : -1
         * sourceblog : null
         * otherdetail : null
         * commentlist : []
         * blogcollect : -1
         */

        private String blog_id;
        private String user_id;
        private String nicename;
        private String headpic;
        private String picture;
        private String pic_x;
        private String pic_y;
        private String content;
        private String comment_counter;
        private String favour_counter;
        private String zhuanfa_counter;
        private int tf_hot;
        private String tf_star;
        private String original;
        private String jointime;
        private String picturecounter;
        private String otherurl;
        private String blogtype;
        private String blogbg;
        private Object blogactivity;
        private int blogfavour;
        private Object sourceblog;
        private Object otherdetail;
        private int blogcollect;
        private List<TagnamesBean> tagnames;
        private List<String> picturelist;
        private List<?> julink;
        private List<CommentBean> commentlist;

        public String getBlog_id() {
            return blog_id;
        }

        public void setBlog_id(String blog_id) {
            this.blog_id = blog_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNicename() {
            return nicename;
        }

        public void setNicename(String nicename) {
            this.nicename = nicename;
        }

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPic_x() {
            return pic_x;
        }

        public void setPic_x(String pic_x) {
            this.pic_x = pic_x;
        }

        public String getPic_y() {
            return pic_y;
        }

        public void setPic_y(String pic_y) {
            this.pic_y = pic_y;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getComment_counter() {
            return comment_counter;
        }

        public void setComment_counter(String comment_counter) {
            this.comment_counter = comment_counter;
        }

        public String getFavour_counter() {
            return favour_counter;
        }

        public void setFavour_counter(String favour_counter) {
            this.favour_counter = favour_counter;
        }

        public String getZhuanfa_counter() {
            return zhuanfa_counter;
        }

        public void setZhuanfa_counter(String zhuanfa_counter) {
            this.zhuanfa_counter = zhuanfa_counter;
        }

        public int getTf_hot() {
            return tf_hot;
        }

        public void setTf_hot(int tf_hot) {
            this.tf_hot = tf_hot;
        }

        public String getTf_star() {
            return tf_star;
        }

        public void setTf_star(String tf_star) {
            this.tf_star = tf_star;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public String getJointime() {
            return jointime;
        }

        public void setJointime(String jointime) {
            this.jointime = jointime;
        }

        public String getPicturecounter() {
            return picturecounter;
        }

        public void setPicturecounter(String picturecounter) {
            this.picturecounter = picturecounter;
        }

        public String getOtherurl() {
            return otherurl;
        }

        public void setOtherurl(String otherurl) {
            this.otherurl = otherurl;
        }

        public String getBlogtype() {
            return blogtype;
        }

        public void setBlogtype(String blogtype) {
            this.blogtype = blogtype;
        }

        public String getBlogbg() {
            return blogbg;
        }

        public void setBlogbg(String blogbg) {
            this.blogbg = blogbg;
        }

        public Object getBlogactivity() {
            return blogactivity;
        }

        public void setBlogactivity(Object blogactivity) {
            this.blogactivity = blogactivity;
        }

        public int getBlogfavour() {
            return blogfavour;
        }

        public void setBlogfavour(int blogfavour) {
            this.blogfavour = blogfavour;
        }

        public Object getSourceblog() {
            return sourceblog;
        }

        public void setSourceblog(Object sourceblog) {
            this.sourceblog = sourceblog;
        }

        public Object getOtherdetail() {
            return otherdetail;
        }

        public void setOtherdetail(Object otherdetail) {
            this.otherdetail = otherdetail;
        }

        public int getBlogcollect() {
            return blogcollect;
        }

        public void setBlogcollect(int blogcollect) {
            this.blogcollect = blogcollect;
        }

        public List<TagnamesBean> getTagnames() {
            return tagnames;
        }

        public void setTagnames(List<TagnamesBean> tagnames) {
            this.tagnames = tagnames;
        }

        public List<String> getPicturelist() {
            return picturelist;
        }

        public void setPicturelist(List<String> picturelist) {
            this.picturelist = picturelist;
        }

        public List<?> getJulink() {
            return julink;
        }

        public void setJulink(List<?> julink) {
            this.julink = julink;
        }

        public List<CommentBean> getCommentlist() {
            return commentlist;
        }

        public void setCommentlist(List<CommentBean> commentlist) {
            this.commentlist = commentlist;
        }

        public static class TagnamesBean {
            /**
             * tagid : 257480
             * name : 日常
             */

            private String tagid;
            private String name;

            public String getTagid() {
                return tagid;
            }

            public void setTagid(String tagid) {
                this.tagid = tagid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }


        public static class CommentBean {


            /**
             * comment_id : 16545967
             * blog_id : 13494238
             * blog_userid : 10090500
             * user_id : 10082678
             * nicename : 烫火锅么
             * re_user_id : null
             * re_nicename :
             * headpic : /6c219c458cb9aac9ecdb373f934444e1.jpg
             * picture :
             * re_content :
             * content : 是不是看脸就趴了。。。
             * favour_counter : 0
             * tf_report : -1
             * tf_star : 49
             * jointime : 2017-04-20 13:07:45
             */

            private String comment_id;
            private String blog_id;
            private String blog_userid;
            private String user_id;
            private String nicename;
            private Object re_user_id;
            private String re_nicename;
            private String headpic;
            private String picture;
            private String re_content;
            private String content;
            private String favour_counter;
            private String tf_report;
            private String tf_star;
            private String jointime;

            public String getComment_id() {
                return comment_id;
            }

            public void setComment_id(String comment_id) {
                this.comment_id = comment_id;
            }

            public String getBlog_id() {
                return blog_id;
            }

            public void setBlog_id(String blog_id) {
                this.blog_id = blog_id;
            }

            public String getBlog_userid() {
                return blog_userid;
            }

            public void setBlog_userid(String blog_userid) {
                this.blog_userid = blog_userid;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getNicename() {
                return nicename;
            }

            public void setNicename(String nicename) {
                this.nicename = nicename;
            }

            public Object getRe_user_id() {
                return re_user_id;
            }

            public void setRe_user_id(Object re_user_id) {
                this.re_user_id = re_user_id;
            }

            public String getRe_nicename() {
                return re_nicename;
            }

            public void setRe_nicename(String re_nicename) {
                this.re_nicename = re_nicename;
            }

            public String getHeadpic() {
                return headpic;
            }

            public void setHeadpic(String headpic) {
                this.headpic = headpic;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getRe_content() {
                return re_content;
            }

            public void setRe_content(String re_content) {
                this.re_content = re_content;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFavour_counter() {
                return favour_counter;
            }

            public void setFavour_counter(String favour_counter) {
                this.favour_counter = favour_counter;
            }

            public String getTf_report() {
                return tf_report;
            }

            public void setTf_report(String tf_report) {
                this.tf_report = tf_report;
            }

            public String getTf_star() {
                return tf_star;
            }

            public void setTf_star(String tf_star) {
                this.tf_star = tf_star;
            }

            public String getJointime() {
                return jointime;
            }

            public void setJointime(String jointime) {
                this.jointime = jointime;
            }
        }
    }

}
