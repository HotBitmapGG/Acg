package com.example.cnsunrun.debugdemo.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cnsunrun on 2017/3/15.
 */

public class QuanziDetailsInfo {


    /**
     * user : {"user_id":"14819848","nicename":"林昱卿","headpic":"http://juheadpic.juju.la//2efae19cd0c05875514319a574117384.jpg","tf_star":"-1","rel":0,"hx_id":"f04048dfb1211ed0752d13b904d6b217"}
     * blog : {"blog_id":13490325,"user_id":"14819848","picture":"http://jublogpic.juju.la//35ac6aecda96f5de9fe5a8455fecf0f8.jpeg","pic_x":"360","pic_y":"640","content":"为什么别人的侧脸都好看，我的这么呆冷漠","tagnames":[{"tagid":"46041","name":"试妆"}],"comment_counter":"2","favour_counter":"60","share_counter":"0","read_counter":"22","zhuanfa_counter":"0","tf_top":"-1","tf_hot":"-1","tf_star":"-1","tf_report":"-1","original":"-1","picturelist":["http://jublogpic.juju.la//35ac6aecda96f5de9fe5a8455fecf0f8.jpeg","http://jublogpic.juju.la//04c5c071d0905e9824dadd442db3186c.gif"],"picturecounter":"2","otherurl":"-1","blogtype":"1","julink":[],"blogbg":"","blogcollect":-1,"blogfavour":-1,"favouruserlist":[{"user_id":"10363092","headpic":"http://juheadpic.juju.la//c14d4a4b21127380842d43fa86216cb6.jpg","tf_star":"-1"},{"user_id":"11381735","headpic":"http://juheadpic.juju.la//2014/10/16/2e586ba7d2a2d149042b0813de7a7ed0.jpg","tf_star":"-1"},{"user_id":"11378236","headpic":"http://juheadpic.juju.la//2014/10/16/1eaa445303477cfff6c4c11fd6870ba0.jpg","tf_star":"-1"},{"user_id":"11380222","headpic":"http://juheadpic.juju.la//2014/10/17/ecaca3736860dde2f9affed50e68b418.png","tf_star":"-1"},{"user_id":"11381965","headpic":"http://juheadpic.juju.la//2014/11/05/250a6d3dd0c11d4b5cdcdd6957cbaf49.jpg","tf_star":"-1"}],"blogactivity":null,"jointime":"2017-03-15 00:15:06","sourceblog":null}
     * comment.favourcount : 0
     * comment.list : [{"id":"16540443","blog_id":"13490325","blog_userid":"14819848","user_id":"10363092","nicename":"瘟桑","re_comment_id":null,"re_user_id":null,"re_nicename":null,"headpic":"http://juheadpic.juju.la//c14d4a4b21127380842d43fa86216cb6.jpg","picture":"","re_content":null,"content":"不错，这感觉很好，喜欢","favour_counter":"0","tf_report":"-1","tf_star":"-1","jointime":"2017-03-15 14:45:51","commentfavour":-1},{"id":"16540411","blog_id":"13490325","blog_userid":"14819848","user_id":"10323427","nicename":"NiwaDaisuke","re_comment_id":null,"re_user_id":null,"re_nicename":null,"headpic":"http://juheadpic.juju.la/2016/05/23/94e785821d1c37be131e67d2bfe23982.jpg","picture":"","re_content":null,"content":"明明很好看啊w","favour_counter":"0","tf_report":"-1","tf_star":"-1","jointime":"2017-03-15 11:14:23","commentfavour":-1}]
     */

    private UserBean user;
    private BlogBean blog;
    @SerializedName("comment.favourcount")
    private int commentFavourcount; // FIXME check this code
    @SerializedName("comment.list")
    private List<CommentListBean> commentList; // FIXME check this code

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public BlogBean getBlog() {
        return blog;
    }

    public void setBlog(BlogBean blog) {
        this.blog = blog;
    }

    public int getCommentFavourcount() {
        return commentFavourcount;
    }

    public void setCommentFavourcount(int commentFavourcount) {
        this.commentFavourcount = commentFavourcount;
    }

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class UserBean {
        /**
         * user_id : 14819848
         * nicename : 林昱卿
         * headpic : http://juheadpic.juju.la//2efae19cd0c05875514319a574117384.jpg
         * tf_star : -1
         * rel : 0
         * hx_id : f04048dfb1211ed0752d13b904d6b217
         */

        private String user_id;
        private String nicename;
        private String headpic;
        private String tf_star;
        private int rel;
        private String hx_id;

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

        public String getTf_star() {
            return tf_star;
        }

        public void setTf_star(String tf_star) {
            this.tf_star = tf_star;
        }

        public int getRel() {
            return rel;
        }

        public void setRel(int rel) {
            this.rel = rel;
        }

        public String getHx_id() {
            return hx_id;
        }

        public void setHx_id(String hx_id) {
            this.hx_id = hx_id;
        }
    }

    public static class BlogBean {
        /**
         * blog_id : 13490325
         * user_id : 14819848
         * picture : http://jublogpic.juju.la//35ac6aecda96f5de9fe5a8455fecf0f8.jpeg
         * pic_x : 360
         * pic_y : 640
         * content : 为什么别人的侧脸都好看，我的这么呆冷漠
         * tagnames : [{"tagid":"46041","name":"试妆"}]
         * comment_counter : 2
         * favour_counter : 60
         * share_counter : 0
         * read_counter : 22
         * zhuanfa_counter : 0
         * tf_top : -1
         * tf_hot : -1
         * tf_star : -1
         * tf_report : -1
         * original : -1
         * picturelist : ["http://jublogpic.juju.la//35ac6aecda96f5de9fe5a8455fecf0f8.jpeg","http://jublogpic.juju.la//04c5c071d0905e9824dadd442db3186c.gif"]
         * picturecounter : 2
         * otherurl : -1
         * blogtype : 1
         * julink : []
         * blogbg :
         * blogcollect : -1
         * blogfavour : -1
         * favouruserlist : [{"user_id":"10363092","headpic":"http://juheadpic.juju.la//c14d4a4b21127380842d43fa86216cb6.jpg","tf_star":"-1"},{"user_id":"11381735","headpic":"http://juheadpic.juju.la//2014/10/16/2e586ba7d2a2d149042b0813de7a7ed0.jpg","tf_star":"-1"},{"user_id":"11378236","headpic":"http://juheadpic.juju.la//2014/10/16/1eaa445303477cfff6c4c11fd6870ba0.jpg","tf_star":"-1"},{"user_id":"11380222","headpic":"http://juheadpic.juju.la//2014/10/17/ecaca3736860dde2f9affed50e68b418.png","tf_star":"-1"},{"user_id":"11381965","headpic":"http://juheadpic.juju.la//2014/11/05/250a6d3dd0c11d4b5cdcdd6957cbaf49.jpg","tf_star":"-1"}]
         * blogactivity : null
         * jointime : 2017-03-15 00:15:06
         * sourceblog : null
         */

        private int blog_id;
        private String user_id;
        private String picture;
        private String pic_x;
        private String pic_y;
        private String content;
        private String comment_counter;
        private String favour_counter;
        private String share_counter;
        private String read_counter;
        private String zhuanfa_counter;
        private String tf_top;
        private String tf_hot;
        private String tf_star;
        private String tf_report;
        private String original;
        private String picturecounter;
        private String otherurl;
        private String blogtype;
        private String blogbg;
        private int blogcollect;
        private int blogfavour;
        private Object blogactivity;
        private String jointime;
        private Object sourceblog;
        private List<TagnamesBean> tagnames;
        private List<String> picturelist;
        private List<?> julink;
        private List<FavouruserlistBean> favouruserlist;

        public int getBlog_id() {
            return blog_id;
        }

        public void setBlog_id(int blog_id) {
            this.blog_id = blog_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
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

        public String getShare_counter() {
            return share_counter;
        }

        public void setShare_counter(String share_counter) {
            this.share_counter = share_counter;
        }

        public String getRead_counter() {
            return read_counter;
        }

        public void setRead_counter(String read_counter) {
            this.read_counter = read_counter;
        }

        public String getZhuanfa_counter() {
            return zhuanfa_counter;
        }

        public void setZhuanfa_counter(String zhuanfa_counter) {
            this.zhuanfa_counter = zhuanfa_counter;
        }

        public String getTf_top() {
            return tf_top;
        }

        public void setTf_top(String tf_top) {
            this.tf_top = tf_top;
        }

        public String getTf_hot() {
            return tf_hot;
        }

        public void setTf_hot(String tf_hot) {
            this.tf_hot = tf_hot;
        }

        public String getTf_star() {
            return tf_star;
        }

        public void setTf_star(String tf_star) {
            this.tf_star = tf_star;
        }

        public String getTf_report() {
            return tf_report;
        }

        public void setTf_report(String tf_report) {
            this.tf_report = tf_report;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
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

        public int getBlogcollect() {
            return blogcollect;
        }

        public void setBlogcollect(int blogcollect) {
            this.blogcollect = blogcollect;
        }

        public int getBlogfavour() {
            return blogfavour;
        }

        public void setBlogfavour(int blogfavour) {
            this.blogfavour = blogfavour;
        }

        public Object getBlogactivity() {
            return blogactivity;
        }

        public void setBlogactivity(Object blogactivity) {
            this.blogactivity = blogactivity;
        }

        public String getJointime() {
            return jointime;
        }

        public void setJointime(String jointime) {
            this.jointime = jointime;
        }

        public Object getSourceblog() {
            return sourceblog;
        }

        public void setSourceblog(Object sourceblog) {
            this.sourceblog = sourceblog;
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

        public List<FavouruserlistBean> getFavouruserlist() {
            return favouruserlist;
        }

        public void setFavouruserlist(List<FavouruserlistBean> favouruserlist) {
            this.favouruserlist = favouruserlist;
        }

        public static class TagnamesBean {
            /**
             * tagid : 46041
             * name : 试妆
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

        public static class FavouruserlistBean {
            /**
             * user_id : 10363092
             * headpic : http://juheadpic.juju.la//c14d4a4b21127380842d43fa86216cb6.jpg
             * tf_star : -1
             */

            private String user_id;
            private String headpic;
            private String tf_star;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getHeadpic() {
                return headpic;
            }

            public void setHeadpic(String headpic) {
                this.headpic = headpic;
            }

            public String getTf_star() {
                return tf_star;
            }

            public void setTf_star(String tf_star) {
                this.tf_star = tf_star;
            }
        }
    }

    public static class CommentListBean {
        /**
         * id : 16540443
         * blog_id : 13490325
         * blog_userid : 14819848
         * user_id : 10363092
         * nicename : 瘟桑
         * re_comment_id : null
         * re_user_id : null
         * re_nicename : null
         * headpic : http://juheadpic.juju.la//c14d4a4b21127380842d43fa86216cb6.jpg
         * picture :
         * re_content : null
         * content : 不错，这感觉很好，喜欢
         * favour_counter : 0
         * tf_report : -1
         * tf_star : -1
         * jointime : 2017-03-15 14:45:51
         * commentfavour : -1
         */

        private String id;
        private String blog_id;
        private String blog_userid;
        private String user_id;
        private String nicename;
        private Object re_comment_id;
        private Object re_user_id;
        private Object re_nicename;
        private String headpic;
        private String picture;
        private Object re_content;
        private String content;
        private String favour_counter;
        private String tf_report;
        private String tf_star;
        private String jointime;
        private int commentfavour;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public Object getRe_comment_id() {
            return re_comment_id;
        }

        public void setRe_comment_id(Object re_comment_id) {
            this.re_comment_id = re_comment_id;
        }

        public Object getRe_user_id() {
            return re_user_id;
        }

        public void setRe_user_id(Object re_user_id) {
            this.re_user_id = re_user_id;
        }

        public Object getRe_nicename() {
            return re_nicename;
        }

        public void setRe_nicename(Object re_nicename) {
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

        public Object getRe_content() {
            return re_content;
        }

        public void setRe_content(Object re_content) {
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

        public int getCommentfavour() {
            return commentfavour;
        }

        public void setCommentfavour(int commentfavour) {
            this.commentfavour = commentfavour;
        }
    }

}
