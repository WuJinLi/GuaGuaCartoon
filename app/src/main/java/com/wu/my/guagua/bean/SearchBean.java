package com.wu.my.guagua.bean;

import java.util.List;

/**
 * Created by My on 2016/8/11.
 */
public class SearchBean {

    /**
     * status : 0
     * data : [{"title":"热血江湖","thumb":"http://csimg.dm300
     * .com/images/spider/20150324/14271837866662.jpg","comicId":"12","authorName":"梁载贤,全克瑨",
     * "comicType":"冒险,武侠格斗","lastCharpter":{"id":"1974754","title":"CH504"}},{"title":"热血老师",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271846774459.jpg",
     * "comicId":"245","authorName":"森田正则","comicType":"竞技","lastCharpter":{"id":"455544",
     * "title":"第24卷"}},{"title":"热血高校","thumb":"http://csimg.dm300
     * .com/images/spider/20150324/14271852205098.jpg","comicId":"1612","authorName":"高桥ヒロシ",
     * "comicType":"武侠格斗,校园","lastCharpter":{"id":"1192939","title":"热血高校26卷"}},{"title":"热血高校3",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271852216968.jpg",
     * "comicId":"1613","authorName":"高桥ヒロシ","comicType":"武侠格斗,校园",
     * "lastCharpter":{"id":"1653347","title":"43话 最终话"}},{"title":"热血魔投辰","thumb":"http://csimg
     * .dm300.com/images/spider/20150324/14271852549596.jpg","comicId":"1843","authorName":"贞安圭",
     * "comicType":"武侠格斗,竞技","lastCharpter":{"id":"512545","title":"第02卷"}},{"title":"热血红星",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271854111594.jpg",
     * "comicId":"3131","authorName":"Ariel Books","comicType":"科幻,冒险",
     * "lastCharpter":{"id":"420405","title":"第1卷"}},{"title":"热血棒球","thumb":"http://csimg.dm300
     * .com/images/spider/20150324/14271855107956.jpg","comicId":"4011","authorName":"高桥三千纲,
     * かざま锐二,堀井ひろし","comicType":"竞技,校园","lastCharpter":{"id":"1165536","title":"热血棒球02卷"}},
     * {"title":"热血情敌","thumb":"http://csimg.dm300.com/images/spider/20150324/14271855123624
     * .jpg","comicId":"4025","authorName":"柴山薰","comicType":"爱情,武侠格斗",
     * "lastCharpter":{"id":"978178","title":"第14卷完"}},{"title":"热血球儿","thumb":"http://csimg
     * .dm300.com/images/spider/20150324/14271855344435.jpg","comicId":"4200",
     * "authorName":"水岛新司","comicType":"竞技","lastCharpter":{"id":"1163523","title":"热血球儿29卷"}},
     * {"title":"热血女儿","thumb":"http://csimg.dm300.com/images/spider/20150324/14271855348748
     * .jpg","comicId":"4201","authorName":"黄美利","comicType":"爱情,搞笑,校园",
     * "lastCharpter":{"id":"564362","title":"热血女儿 第24卷"}},{"title":"热血高校前传",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271857161311.jpg",
     * "comicId":"5534","authorName":"内藤健一郎","comicType":"武侠格斗,校园,热血",
     * "lastCharpter":{"id":"340453","title":"第31话"}},{"title":"热血高校外传","thumb":"http://csimg
     * .dm300.com/images/spider/20150324/14271858242564.jpg","comicId":"6078",
     * "authorName":"高桥ヒロシ","comicType":"武侠格斗,校园","lastCharpter":{"id":"505378","title":"第01话"}},
     * {"title":"热血高校ZEROⅡ","thumb":"http://csimg.dm300.com/images/spider/20150324/14271861733970
     * .jpg","comicId":"7738","authorName":"高桥ヒロシ","comicType":"冒险",
     * "lastCharpter":{"id":"623234","title":"32话"}},{"title":"热血女主播","thumb":"http://csimg.dm300
     * .com/images/spider/20150324/14271863281578.jpg","comicId":"8564","authorName":"海野空太",
     * "comicType":"综合其他","lastCharpter":{"id":"1141911","title":"热血女主播 05卷"}},
     * {"title":"BOX-热血斗阵","thumb":"http://csimg.dm300.com/images/spider/20150324/14271866519775
     * .jpg","comicId":"10660","authorName":"百田尚树,大羽隆广","comicType":"武侠格斗,热血",
     * "lastCharpter":{"id":"110295","title":"第04卷"}},{"title":"热血车研社","thumb":"http://csimg
     * .dm300.com/images/spider/20150324/14271866646354.jpg","comicId":"10721",
     * "authorName":"村田雄介,太田垣康男","comicType":"竞技,校园","lastCharpter":{"id":"1657716",
     * "title":"第01卷"}},{"title":"热血之恋","thumb":"http://csimg.dm300
     * .com/images/spider/20150324/14271869054384.jpg","comicId":"11882","authorName":"綾香織里",
     * "comicType":"爱情,校园","lastCharpter":{"id":"1187001","title":"热血之恋 001集"}},{"title":"热血神话",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271870548828.jpg",
     * "comicId":"12551","authorName":"叶庭","comicType":"搞笑","lastCharpter":{"id":"1570421",
     * "title":"第1话"}},{"title":"热血格斗","thumb":"http://csimg.dm300
     * .com/images/spider/20150324/14271872055074.jpg","comicId":"13385","authorName":"A鸡米得",
     * "comicType":"冒险,武侠格斗,魔幻","lastCharpter":{"id":"1633446","title":"亚瑟王竟是小萝莉！"}},
     * {"title":"热血!大河先生!","thumb":"http://csimg.dm300.com/images/spider/20150324/14271872694122
     * .jpg","comicId":"13688","authorName":"雌岛","comicType":"校园","lastCharpter":{"id":"1132159",
     * "title":"热血!大河先生! 001集"}},{"title":"热血擂台","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273531119888.jpg","comicId":"14884","authorName":"殊中人",
     * "comicType":"武侠格斗,竞技,热血","lastCharpter":{"id":"1748293","title":"第三十四话"}},{"title":"热血摩的",
     * "thumb":"http://csimg.dm300.com/images/spider/20150326/14273532054919.jpg",
     * "comicId":"15511","authorName":"博洋大叔","comicType":"冒险,搞笑","lastCharpter":{"id":"1225134",
     * "title":"热血摩的 007集"}},{"title":"热血高校2","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273532233763.jpg","comicId":"15625","authorName":"高桥弘",
     * "comicType":"热血","lastCharpter":{"id":"503610","title":"第32话"}},{"title":"热血大河先生",
     * "thumb":"http://csimg.dm300.com/images/spider/20150326/14273532341113.jpg",
     * "comicId":"15695","authorName":"雌岛","comicType":"魔幻,校园","lastCharpter":{"id":"204143",
     * "title":"第1话"}},{"title":"BOX-热血斗阵东立","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273533265483.jpg","comicId":"16371","authorName":"大羽隆广",
     * "comicType":"武侠格斗","lastCharpter":{"id":"1103588","title":"热血斗阵东立 004卷"}},
     * {"title":"热血斗阵BOX","thumb":"http://csimg.dm300.com/images/spider/20150326/14273533265533
     * .jpg","comicId":"16378","authorName":"百田尚树","comicType":"武侠格斗",
     * "lastCharpter":{"id":"748255","title":"04卷"}},{"title":"热血高校3(WORST极恶王3)",
     * "thumb":"http://csimg.dm300.com/images/spider/20150326/14273533815887.jpg",
     * "comicId":"16774","authorName":"高桥弘","comicType":"校园","lastCharpter":{"id":"240026",
     * "title":"最终话正式版"}},{"title":"热血情敌（棋逢敌手）","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273534203241.JPG","comicId":"17135","authorName":"柴山薰",
     * "comicType":"爱情","lastCharpter":{"id":"247941","title":"番外卷2"}},{"title":"热血红星(中文版)",
     * "thumb":"http://csimg.dm300.com/images/spider/20150326/14273535501896.jpg",
     * "comicId":"18634","authorName":"罗伯特·霍华德","comicType":"综合其他","lastCharpter":{"id":"265869",
     * "title":"全集"}},{"title":"热血沸腾BurningBlood","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273537416820.jpg","comicId":"20090","authorName":"石渡治",
     * "comicType":"竞技","lastCharpter":{"id":"281484","title":"卷31(完结)"}}]
     */

    private int status;
    /**
     * title : 热血江湖
     * thumb : http://csimg.dm300.com/images/spider/20150324/14271837866662.jpg
     * comicId : 12
     * authorName : 梁载贤,全克瑨
     * comicType : 冒险,武侠格斗
     * lastCharpter : {"id":"1974754","title":"CH504"}
     */

    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String thumb;
        private String comicId;
        private String authorName;
        private String comicType;
        /**
         * id : 1974754
         * title : CH504
         */

        private LastCharpterBean lastCharpter;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getComicId() {
            return comicId;
        }

        public void setComicId(String comicId) {
            this.comicId = comicId;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getComicType() {
            return comicType;
        }

        public void setComicType(String comicType) {
            this.comicType = comicType;
        }

        public LastCharpterBean getLastCharpter() {
            return lastCharpter;
        }

        public void setLastCharpter(LastCharpterBean lastCharpter) {
            this.lastCharpter = lastCharpter;
        }

        public static class LastCharpterBean {
            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
