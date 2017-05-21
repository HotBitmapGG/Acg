package com.example.cnsunrun.debugdemo.mvp.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cnsunrun on 2017/4/20.
 */

public class CopyDetailsInfo {

    /**
     * code : 10000
     * message : SearchList ok
     * result : {"activity.detail":{"activityid":"1002519","name":"丝足控福利社","content":"嘿嘿～各种丝足控福利这里都有喔！","picture":"http://juheadpic.juju.la/group/a03886fd5c9fe0a3839bbb616fda9233.png","timestr":"","user_id":"10277337","user_headpic":"http://juheadpic.juju.la/2014/11/05/39BA4BCE823F75D906C7B37CF7407E6E.png","user_name":"灼眼の馒头叔","user_star":"-1","user_vipinfo":"未填写","counter":"1185","form":"兴趣组","taglist":[{"tagid":"301843","tag":"白丝"},{"tagid":"307855","tag":"黑丝"},{"tagid":"388881","tag":"丝袜控"}],"blogdynamics":[{"blog_id":"13492052","picture":"http://jublogpic.juju.la/2017/03/31/b7557a33c2356f19af5fa932888b43ea0.jpg","blogtype":"1","nicename":"灼眼の馒头叔","content":"找CP，企鹅：874383545，坐标：广西桂林或广州"},{"blog_id":"13489617","picture":"http://jublogpic.juju.la/2017/03/08/e73b9e9239809f0548113e9b8e1e2c430.jpg","blogtype":"1","nicename":"灼眼の馒头叔","content":"欢迎二次元小姐姐扩列，874383545\u2044(\u2044 \u2044 \u2044ω\u2044 \u2044 \u2044)\u2044"}],"memberlist":[{"userid":"10277337","nicename":"灼眼の馒头叔","headpic":"2017/02/08/68974ed213256f214e76a8e9defe4972.jpg"},{"userid":"14818873","nicename":"추태","headpic":"/defaulthead/2.jpg"},{"userid":"14818875","nicename":"那个女孩叫安琪","headpic":"/defaulthead/5.jpg"},{"userid":"14792624","nicename":"安静安静安静","headpic":"/defaulthead/5.jpg"}],"memberhasnotice":"-1","picturemoduleid":"5170","picturemodulecount":"151","picturemodules":["http://jublogpic.juju.la//64c06198f46a4b9aef89cbdf177a48e0.jpg","http://jublogpic.juju.la//c4b2b6611a117b997d954ddefcbd0e39.jpg","http://jublogpic.juju.la/2017/04/12/c6678484ed14f4889615d671ef925f2b0.jpg","http://jublogpic.juju.la//efccd3e362f97721302f31c27d8f4c6e.jpg","http://jublogpic.juju.la//b0ec3c4bdc59f1112127dabdaf94c053.jpg","http://jublogpic.juju.la//39945e0ad2f8d169055efbb98bdc7873.jpeg","http://jublogpic.juju.la//489d38de33999bd5a1e3444864883d37.jpeg","http://jublogpic.juju.la//439068ffedb8e9b8142679ebe7391b72.jpeg"],"picturemoduleright":2,"picturehasnotice":"1","votemoduleid":"5172","votemodulecount":"1","votemodules":{"title":"你是黑丝党还是白丝党？","picture":"","options":[{"optionid":"935","vote_id":"217","content":"黑丝党","counter":"134","createtime":"1486551405","updatetime":"1492542177"},{"optionid":"936","vote_id":"217","content":"白丝党","counter":"130","createtime":"1486551405","updatetime":"1492673250"}],"isvote":"-1","vote_option_id":"0"},"votehasnotice":"1","messagemoduleid":"5171","messagemodulecount":"11","messagemodules":[{"user_name":"王權富貴","user_headpic":"http://juheadpic.juju.la//defaulthead/1.jpg","content":"恩应该是男孩子","floor":"11"},{"user_name":"智商没有梧桐高","user_headpic":"http://juheadpic.juju.la//d7667f9959862246529a358badf7e153.jpg","content":"哟呵","floor":"10"},{"user_name":"\u202d大脑花","user_headpic":"http://juheadpic.juju.la/2017/01/04/302f00fe5111dc229cb8b6e984d53b8d.jpg","content":"加一波好友palengdehaizi","floor":"9"},{"user_name":"雪夜の羽尊","user_headpic":"http://juheadpic.juju.la//dab6c6aa781c170f2521a30fe0cc301f.jpg","content":"用艺术的眼光看","floor":"8"},{"user_name":"咻咻休","user_headpic":"http://juheadpic.juju.la//defaulthead/2.jpg","content":"不错喜欢","floor":"7"}],"messagehasnotice":"1","grouplist":[{"groupid":"2321508","grouphx_id":"7471757328387","name":"丝足控福利社","counter":"495","isjoin":-1}],"state":2,"announcement":"欢迎各位丝足控加入，没有什么特别的要求，但请不要发广告。","announcementhasnotice":"-1","bloghasnotice":"-1"}}
     * sid : 5d97409c5f8381420d0ae694d19fb1f2
     */

    private String code;
    private String message;
    private ResultBean result;
    private String sid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public static class ResultBean {
        @SerializedName("activity.detail")
        private ActivityDetailBean activityDetail;

        public ActivityDetailBean getActivityDetail() {
            return activityDetail;
        }

        public void setActivityDetail63(ActivityDetailBean activityDetail) {
            this.activityDetail = activityDetail;
        }

        public static class ActivityDetailBean {

            public static class VotemodulesBean {
                /**
                 * title : 你是黑丝党还是白丝党？
                 * picture :
                 * options : [{"optionid":"935","vote_id":"217","content":"黑丝党","counter":"134","createtime":"1486551405","updatetime":"1492542177"},{"optionid":"936","vote_id":"217","content":"白丝党","counter":"130","createtime":"1486551405","updatetime":"1492673250"}]
                 * isvote : -1
                 * vote_option_id : 0
                 */

                private String title;
                private String picture;
                private String isvote;
                private String vote_option_id;
                private List<OptionsBean> options;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public String getIsvote() {
                    return isvote;
                }

                public void setIsvote(String isvote) {
                    this.isvote = isvote;
                }

                public String getVote_option_id() {
                    return vote_option_id;
                }

                public void setVote_option_id(String vote_option_id) {
                    this.vote_option_id = vote_option_id;
                }

                public List<OptionsBean> getOptions() {
                    return options;
                }

                public void setOptions(List<OptionsBean> options) {
                    this.options = options;
                }

                public static class OptionsBean {
                    /**
                     * optionid : 935
                     * vote_id : 217
                     * content : 黑丝党
                     * counter : 134
                     * createtime : 1486551405
                     * updatetime : 1492542177
                     */

                    private String optionid;
                    private String vote_id;
                    private String content;
                    private String counter;
                    private String createtime;
                    private String updatetime;

                    public String getOptionid() {
                        return optionid;
                    }

                    public void setOptionid(String optionid) {
                        this.optionid = optionid;
                    }

                    public String getVote_id() {
                        return vote_id;
                    }

                    public void setVote_id(String vote_id) {
                        this.vote_id = vote_id;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }

                    public String getCounter() {
                        return counter;
                    }

                    public void setCounter(String counter) {
                        this.counter = counter;
                    }

                    public String getCreatetime() {
                        return createtime;
                    }

                    public void setCreatetime(String createtime) {
                        this.createtime = createtime;
                    }

                    public String getUpdatetime() {
                        return updatetime;
                    }

                    public void setUpdatetime(String updatetime) {
                        this.updatetime = updatetime;
                    }
                }
            }

            public static class TaglistBean {
                /**
                 * tagid : 301843
                 * tag : 白丝
                 */

                private String tagid;
                private String tag;

                public String getTagid() {
                    return tagid;
                }

                public void setTagid(String tagid) {
                    this.tagid = tagid;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }
            }

            public static class BlogdynamicsBean {
                /**
                 * blog_id : 13492052
                 * picture : http://jublogpic.juju.la/2017/03/31/b7557a33c2356f19af5fa932888b43ea0.jpg
                 * blogtype : 1
                 * nicename : 灼眼の馒头叔
                 * content : 找CP，企鹅：874383545，坐标：广西桂林或广州
                 */

                private String blog_id;
                private String picture;
                private String blogtype;
                private String nicename;
                private String content;

                public String getBlog_id() {
                    return blog_id;
                }

                public void setBlog_id(String blog_id) {
                    this.blog_id = blog_id;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public String getBlogtype() {
                    return blogtype;
                }

                public void setBlogtype(String blogtype) {
                    this.blogtype = blogtype;
                }

                public String getNicename() {
                    return nicename;
                }

                public void setNicename(String nicename) {
                    this.nicename = nicename;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }
            }

            public static class MemberlistBean {
                /**
                 * userid : 10277337
                 * nicename : 灼眼の馒头叔
                 * headpic : 2017/02/08/68974ed213256f214e76a8e9defe4972.jpg
                 */

                private String userid;
                private String nicename;
                private String headpic;

                public String getUserid() {
                    return userid;
                }

                public void setUserid(String userid) {
                    this.userid = userid;
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
            }

            public static class MessagemodulesBean {
                /**
                 * user_name : 王權富貴
                 * user_headpic : http://juheadpic.juju.la//defaulthead/1.jpg
                 * content : 恩应该是男孩子
                 * floor : 11
                 */

                private String user_name;
                private String user_headpic;
                private String content;
                private String floor;

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public String getUser_headpic() {
                    return user_headpic;
                }

                public void setUser_headpic(String user_headpic) {
                    this.user_headpic = user_headpic;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getFloor() {
                    return floor;
                }

                public void setFloor(String floor) {
                    this.floor = floor;
                }
            }

            public static class GrouplistBean {
                /**
                 * groupid : 2321508
                 * grouphx_id : 7471757328387
                 * name : 丝足控福利社
                 * counter : 495
                 * isjoin : -1
                 */

                private String groupid;
                private String grouphx_id;
                private String name;
                private String counter;
                private int isjoin;

                public String getGroupid() {
                    return groupid;
                }

                public void setGroupid(String groupid) {
                    this.groupid = groupid;
                }

                public String getGrouphx_id() {
                    return grouphx_id;
                }

                public void setGrouphx_id(String grouphx_id) {
                    this.grouphx_id = grouphx_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCounter() {
                    return counter;
                }

                public void setCounter(String counter) {
                    this.counter = counter;
                }

                public int getIsjoin() {
                    return isjoin;
                }

                public void setIsjoin(int isjoin) {
                    this.isjoin = isjoin;
                }
            }

            /**
             * activityid : 1002519
             * name : 丝足控福利社
             * content : 嘿嘿～各种丝足控福利这里都有喔！
             * picture : http://juheadpic.juju.la/group/a03886fd5c9fe0a3839bbb616fda9233.png
             * timestr :
             * user_id : 10277337
             * user_headpic : http://juheadpic.juju.la/2014/11/05/39BA4BCE823F75D906C7B37CF7407E6E.png
             * user_name : 灼眼の馒头叔
             * user_star : -1
             * user_vipinfo : 未填写
             * counter : 1185
             * form : 兴趣组
             * taglist : [{"tagid":"301843","tag":"白丝"},{"tagid":"307855","tag":"黑丝"},{"tagid":"388881","tag":"丝袜控"}]
             * blogdynamics : [{"blog_id":"13492052","picture":"http://jublogpic.juju.la/2017/03/31/b7557a33c2356f19af5fa932888b43ea0.jpg","blogtype":"1","nicename":"灼眼の馒头叔","content":"找CP，企鹅：874383545，坐标：广西桂林或广州"},{"blog_id":"13489617","picture":"http://jublogpic.juju.la/2017/03/08/e73b9e9239809f0548113e9b8e1e2c430.jpg","blogtype":"1","nicename":"灼眼の馒头叔","content":"欢迎二次元小姐姐扩列，874383545\u2044(\u2044 \u2044 \u2044ω\u2044 \u2044 \u2044)\u2044"}]
             * memberlist : [{"userid":"10277337","nicename":"灼眼の馒头叔","headpic":"2017/02/08/68974ed213256f214e76a8e9defe4972.jpg"},{"userid":"14818873","nicename":"추태","headpic":"/defaulthead/2.jpg"},{"userid":"14818875","nicename":"那个女孩叫安琪","headpic":"/defaulthead/5.jpg"},{"userid":"14792624","nicename":"安静安静安静","headpic":"/defaulthead/5.jpg"}]
             * memberhasnotice : -1
             * picturemoduleid : 5170
             * picturemodulecount : 151
             * picturemodules : ["http://jublogpic.juju.la//64c06198f46a4b9aef89cbdf177a48e0.jpg","http://jublogpic.juju.la//c4b2b6611a117b997d954ddefcbd0e39.jpg","http://jublogpic.juju.la/2017/04/12/c6678484ed14f4889615d671ef925f2b0.jpg","http://jublogpic.juju.la//efccd3e362f97721302f31c27d8f4c6e.jpg","http://jublogpic.juju.la//b0ec3c4bdc59f1112127dabdaf94c053.jpg","http://jublogpic.juju.la//39945e0ad2f8d169055efbb98bdc7873.jpeg","http://jublogpic.juju.la//489d38de33999bd5a1e3444864883d37.jpeg","http://jublogpic.juju.la//439068ffedb8e9b8142679ebe7391b72.jpeg"]
             * picturemoduleright : 2
             * picturehasnotice : 1
             * votemoduleid : 5172
             * votemodulecount : 1
             * votemodules : {"title":"你是黑丝党还是白丝党？","picture":"","options":[{"optionid":"935","vote_id":"217","content":"黑丝党","counter":"134","createtime":"1486551405","updatetime":"1492542177"},{"optionid":"936","vote_id":"217","content":"白丝党","counter":"130","createtime":"1486551405","updatetime":"1492673250"}],"isvote":"-1","vote_option_id":"0"}
             * votehasnotice : 1
             * messagemoduleid : 5171
             * messagemodulecount : 11
             * messagemodules : [{"user_name":"王權富貴","user_headpic":"http://juheadpic.juju.la//defaulthead/1.jpg","content":"恩应该是男孩子","floor":"11"},{"user_name":"智商没有梧桐高","user_headpic":"http://juheadpic.juju.la//d7667f9959862246529a358badf7e153.jpg","content":"哟呵","floor":"10"},{"user_name":"\u202d大脑花","user_headpic":"http://juheadpic.juju.la/2017/01/04/302f00fe5111dc229cb8b6e984d53b8d.jpg","content":"加一波好友palengdehaizi","floor":"9"},{"user_name":"雪夜の羽尊","user_headpic":"http://juheadpic.juju.la//dab6c6aa781c170f2521a30fe0cc301f.jpg","content":"用艺术的眼光看","floor":"8"},{"user_name":"咻咻休","user_headpic":"http://juheadpic.juju.la//defaulthead/2.jpg","content":"不错喜欢","floor":"7"}]
             * messagehasnotice : 1
             * grouplist : [{"groupid":"2321508","grouphx_id":"7471757328387","name":"丝足控福利社","counter":"495","isjoin":-1}]
             * state : 2
             * announcement : 欢迎各位丝足控加入，没有什么特别的要求，但请不要发广告。
             * announcementhasnotice : -1
             * bloghasnotice : -1
             */

            private String activityid;
            private String name;
            private String content;
            private String picture;
            private String timestr;
            private String user_id;
            private String user_headpic;
            private String user_name;
            private String user_star;
            private String user_vipinfo;
            private String counter;
            private String form;
            private String memberhasnotice;
            private String picturemoduleid;
            private String picturemodulecount;
            private int picturemoduleright;
            private String picturehasnotice;
            private String votemoduleid;
            private String votemodulecount;
            private VotemodulesBean votemodules;
            private String votehasnotice;
            private String messagemoduleid;
            private String messagemodulecount;
            private String messagehasnotice;
            private int state;
            private String announcement;
            private String announcementhasnotice;
            private String bloghasnotice;
            private List<TaglistBean> taglist;
            private List<BlogdynamicsBean> blogdynamics;
            private List<MemberlistBean> memberlist;
            private List<String> picturemodules;
            private List<MessagemodulesBean> messagemodules;
            private List<GrouplistBean> grouplist;

            public String getActivityid() {
                return activityid;
            }

            public void setActivityid(String activityid) {
                this.activityid = activityid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getTimestr() {
                return timestr;
            }

            public void setTimestr(String timestr) {
                this.timestr = timestr;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_headpic() {
                return user_headpic;
            }

            public void setUser_headpic(String user_headpic) {
                this.user_headpic = user_headpic;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getUser_star() {
                return user_star;
            }

            public void setUser_star(String user_star) {
                this.user_star = user_star;
            }

            public String getUser_vipinfo() {
                return user_vipinfo;
            }

            public void setUser_vipinfo(String user_vipinfo) {
                this.user_vipinfo = user_vipinfo;
            }

            public String getCounter() {
                return counter;
            }

            public void setCounter(String counter) {
                this.counter = counter;
            }

            public String getForm() {
                return form;
            }

            public void setForm(String form) {
                this.form = form;
            }

            public String getMemberhasnotice() {
                return memberhasnotice;
            }

            public void setMemberhasnotice(String memberhasnotice) {
                this.memberhasnotice = memberhasnotice;
            }

            public String getPicturemoduleid() {
                return picturemoduleid;
            }

            public void setPicturemoduleid(String picturemoduleid) {
                this.picturemoduleid = picturemoduleid;
            }

            public String getPicturemodulecount() {
                return picturemodulecount;
            }

            public void setPicturemodulecount(String picturemodulecount) {
                this.picturemodulecount = picturemodulecount;
            }

            public int getPicturemoduleright() {
                return picturemoduleright;
            }

            public void setPicturemoduleright(int picturemoduleright) {
                this.picturemoduleright = picturemoduleright;
            }

            public String getPicturehasnotice() {
                return picturehasnotice;
            }

            public void setPicturehasnotice(String picturehasnotice) {
                this.picturehasnotice = picturehasnotice;
            }

            public String getVotemoduleid() {
                return votemoduleid;
            }

            public void setVotemoduleid(String votemoduleid) {
                this.votemoduleid = votemoduleid;
            }

            public String getVotemodulecount() {
                return votemodulecount;
            }

            public void setVotemodulecount(String votemodulecount) {
                this.votemodulecount = votemodulecount;
            }

            public VotemodulesBean getVotemodules() {
                return votemodules;
            }

            public void setVotemodules(VotemodulesBean votemodules) {
                this.votemodules = votemodules;
            }

            public String getVotehasnotice() {
                return votehasnotice;
            }

            public void setVotehasnotice(String votehasnotice) {
                this.votehasnotice = votehasnotice;
            }

            public String getMessagemoduleid() {
                return messagemoduleid;
            }

            public void setMessagemoduleid(String messagemoduleid) {
                this.messagemoduleid = messagemoduleid;
            }

            public String getMessagemodulecount() {
                return messagemodulecount;
            }

            public void setMessagemodulecount(String messagemodulecount) {
                this.messagemodulecount = messagemodulecount;
            }

            public String getMessagehasnotice() {
                return messagehasnotice;
            }

            public void setMessagehasnotice(String messagehasnotice) {
                this.messagehasnotice = messagehasnotice;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public String getAnnouncementhasnotice() {
                return announcementhasnotice;
            }

            public void setAnnouncementhasnotice(String announcementhasnotice) {
                this.announcementhasnotice = announcementhasnotice;
            }

            public String getBloghasnotice() {
                return bloghasnotice;
            }

            public void setBloghasnotice(String bloghasnotice) {
                this.bloghasnotice = bloghasnotice;
            }

            public List<TaglistBean> getTaglist() {
                return taglist;
            }

            public void setTaglist(List<TaglistBean> taglist) {
                this.taglist = taglist;
            }

            public List<BlogdynamicsBean> getBlogdynamics() {
                return blogdynamics;
            }

            public void setBlogdynamics(List<BlogdynamicsBean> blogdynamics) {
                this.blogdynamics = blogdynamics;
            }

            public List<MemberlistBean> getMemberlist() {
                return memberlist;
            }

            public void setMemberlist(List<MemberlistBean> memberlist) {
                this.memberlist = memberlist;
            }

            public List<String> getPicturemodules() {
                return picturemodules;
            }

            public void setPicturemodules(List<String> picturemodules) {
                this.picturemodules = picturemodules;
            }

            public List<MessagemodulesBean> getMessagemodules() {
                return messagemodules;
            }

            public void setMessagemodules(List<MessagemodulesBean> messagemodules) {
                this.messagemodules = messagemodules;
            }

            public List<GrouplistBean> getGrouplist() {
                return grouplist;
            }

            public void setGrouplist(List<GrouplistBean> grouplist) {
                this.grouplist = grouplist;
            }
        }
    }
}
