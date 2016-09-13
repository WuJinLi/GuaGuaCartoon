package com.wu.my.guagua.bean;

import java.util.List;

/**
 * Created by My on 2016/8/11.
 */
public class ClassifyTBean {

    /**
     * status : 0
     * data : [{"title":"天行轶事","thumb":"http://csimg.dm300
     * .com/images/spider/20150327/14273856377748.jpg","comicId":"22743","authorName":"怪盏",
     * "comicType":"爱情,武侠格斗,魔幻","lastCharpter":{"id":"1990980","title":"第64话 全家福"}},
     * {"title":"天降系拍档","thumb":"http://csimg.dm300.com/images/spider/20160622/14666040031447
     * .jpg","comicId":"51943","authorName":"未知","comicType":"搞笑,魔幻,热血",
     * "lastCharpter":{"id":"1990965","title":"第02话 新生活"}},{"title":"恋恋星耀","thumb":"http://csimg
     * .dm300.com/images/spider/20160519/14636424084153.jpg","comicId":"51383",
     * "authorName":"布布星球","comicType":"爱情","lastCharpter":{"id":"1990704","title":"第16话"}},
     * {"title":"义变","thumb":"http://csimg.dm300.com/images/spider/20151220/14505912099403.jpg",
     * "comicId":"48706","authorName":"烽云传媒","comicType":"科幻,武侠格斗,热血",
     * "lastCharpter":{"id":"1990616","title":"第50话"}},{"title":"万网驱魔人","thumb":"http://csimg
     * .dm300.com/images/spider/20160326/14589708046219.jpg","comicId":"50420",
     * "authorName":"风人动漫","comicType":"科幻,搞笑","lastCharpter":{"id":"1990609","title":"第47话"}},
     * {"title":"颜值恋","thumb":"http://csimg.dm300.com/images/spider/20151223/14508588032280.jpg",
     * "comicId":"48786","authorName":"一本正经","comicType":"综合其他","lastCharpter":{"id":"1990611",
     * "title":"第57话"}},{"title":"星座不求人","thumb":"http://csimg.dm300
     * .com/images/spider/20160626/14668766508841.jpg","comicId":"51979","authorName":"蛋壳",
     * "comicType":"生活,热血","lastCharpter":{"id":"1990408","title":"第54话"}},{"title":"极乐世界",
     * "thumb":"http://csimg.dm300.com/images/spider/20160607/14652900036940.jpg",
     * "comicId":"51739","authorName":"暴青漫画","comicType":"冒险,热血","lastCharpter":{"id":"1990563",
     * "title":"第38话"}},{"title":"木木长生","thumb":"http://csimg.dm300
     * .com/images/spider/20160520/14637180085227.jpg","comicId":"51398","authorName":"湫然,止鱼",
     * "comicType":"冒险,热血","lastCharpter":{"id":"1990565","title":"第19话"}},{"title":"祈灵",
     * "thumb":"http://csimg.dm300.com/images/spider/20160528/14644224031499.jpg",
     * "comicId":"51519","authorName":"德猫Richard","comicType":"魔幻",
     * "lastCharpter":{"id":"1990567","title":"第51话"}},{"title":"银之守墓人","thumb":"http://csimg
     * .dm300.com/images/spider/20150326/14273532358374.jpg","comicId":"15705","authorName":"零盟",
     * "comicType":"冒险,侦探,恐怖,热血","lastCharpter":{"id":"1976763","title":"银之守墓人 191集"}},
     * {"title":"王爷你好贱","thumb":"http://csimg.dm300.com/images/spider/20160529/14645232034065
     * .jpg","comicId":"51545","authorName":"高能漫画","comicType":"热血",
     * "lastCharpter":{"id":"1990582","title":"第22话"}},{"title":"残酷真理","thumb":"http://csimg
     * .dm300.com/images/spider/20150617/14345468399035.jpg","comicId":"44841","authorName":"IF",
     * "comicType":"侦探,魔幻","lastCharpter":{"id":"1990525","title":"第70话"}},{"title":"条漫哈",
     * "thumb":"http://csimg.dm300.com/images/spider/20160529/14645268031137.jpg",
     * "comicId":"51554","authorName":"腾讯动漫","comicType":"搞笑","lastCharpter":{"id":"1990524",
     * "title":"第237话"}},{"title":"斗罗大陆3龙王传说","thumb":"http://csimg.dm300
     * .com/images/spider/20151230/14514241326448.jpg","comicId":"48971","authorName":"未知",
     * "comicType":"魔幻,热血","lastCharpter":{"id":"1990550","title":"第08话（1）"}},{"title":"一品芝麻狐",
     * "thumb":"http://csimg.dm300.com/images/spider/20160409/14601348152327.jpg",
     * "comicId":"50678","authorName":"王溥","comicType":"热血,综合其他","lastCharpter":{"id":"1990422",
     * "title":"第43话"}},{"title":"古校夜游神","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273855112974.jpg","comicId":"22073","authorName":"槊然",
     * "comicType":"冒险,魔幻,校园","lastCharpter":{"id":"1990420","title":"第46话"}},{"title":"夏娃未成年",
     * "thumb":"http://csimg.dm300.com/images/spider/20160521/14637996036685.jpg",
     * "comicId":"51413","authorName":"隔壁的特特罗","comicType":"热血","lastCharpter":{"id":"1990418",
     * "title":"第25话"}},{"title":"基因猎人","thumb":"http://csimg.dm300
     * .com/images/spider/20151124/14483700034595.jpg","comicId":"48206","authorName":"游益互娱",
     * "comicType":"热血","lastCharpter":{"id":"1990417","title":"第51话 神秘药人（中）"}},{"title":"无罪之城",
     * "thumb":"http://csimg.dm300.com/images/spider/20160412/14604744024731.jpg",
     * "comicId":"50743","authorName":"宇宙牧场","comicType":"科幻,冒险,热血",
     * "lastCharpter":{"id":"1990416","title":"第36话"}},{"title":"断头岛","thumb":"http://csimg.dm300
     * .com/images/spider/20160420/14611608099461.jpg","comicId":"50893","authorName":"游益互娱",
     * "comicType":"侦探","lastCharpter":{"id":"1990415","title":"第14话 地狱之火"}},{"title":"凹凸世界",
     * "thumb":"http://csimg.dm300.com/images/spider/20150615/14343650836055.jpg",
     * "comicId":"34868","authorName":"七创社","comicType":"武侠格斗,热血","lastCharpter":{"id":"1990296",
     * "title":"第51话"}},{"title":"从前有座灵剑山","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273531121761.jpg","comicId":"14896","authorName":"鲜漫动漫",
     * "comicType":"冒险,魔幻,热血","lastCharpter":{"id":"1976769","title":"从前有座灵剑山 179集"}},
     * {"title":"应声入网!","thumb":"http://csimg.dm300.com/images/spider/20150617/14345467217788
     * .jpg","comicId":"44610","authorName":"草宝金","comicType":"竞技,校园,热血",
     * "lastCharpter":{"id":"1990341","title":"84.山禾."}},{"title":"葬魂门","thumb":"http://csimg
     * .dm300.com/images/spider/20150326/14273531875044.jpg","comicId":"15386",
     * "authorName":"TWO方土","comicType":"冒险,热血","lastCharpter":{"id":"1967716","title":"葬魂门
     * 175集"}},{"title":"傲世九重天","thumb":"http://csimg.dm300
     * .com/images/spider/20150326/14273531907889.jpg","comicId":"15404","authorName":"漫王",
     * "comicType":"冒险,魔幻,热血","lastCharpter":{"id":"1980515","title":"29话 五轻柔的推测（二）"}},
     * {"title":"青空下之黑猫","thumb":"http://csimg.dm300.com/images/spider/20150617/14345469456727
     * .jpg","comicId":"45036","authorName":"墨_飛煙","comicType":"耽美BL",
     * "lastCharpter":{"id":"1990333","title":"48"}},{"title":"豪门甜心","thumb":"http://csimg.dm300
     * .com/images/spider/20150716/14370348067908.jpg","comicId":"46294",
     * "authorName":"新青年期刊出版总社","comicType":"爱情,搞笑","lastCharpter":{"id":"1856609",
     * "title":"第15话"}},{"title":"仙女湖","thumb":"http://csimg.dm300
     * .com/images/spider/20150617/14345467274964.jpg","comicId":"44623","authorName":"星漫文化",
     * "comicType":"爱情,魔幻","lastCharpter":{"id":"1990199","title":"第18话 私下的交谈（下）"}},
     * {"title":"红道","thumb":"http://csimg.dm300.com/images/spider/20150617/14345465522695.jpg",
     * "comicId":"44298","authorName":"美蓝漫画图:s_owl/文:s_owl","comicType":"武侠格斗,魔幻,历史战争",
     * "lastCharpter":{"id":"1990171","title":"第67集 幕后主使者（上）"}}]
     */

    private int status;
    /**
     * title : 天行轶事
     * thumb : http://csimg.dm300.com/images/spider/20150327/14273856377748.jpg
     * comicId : 22743
     * authorName : 怪盏
     * comicType : 爱情,武侠格斗,魔幻
     * lastCharpter : {"id":"1990980","title":"第64话 全家福"}
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
         * id : 1990980
         * title : 第64话 全家福
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
