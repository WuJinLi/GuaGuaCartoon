package com.wu.my.guagua.bean;

import java.util.List;

/**
 * Created by My on 2016/8/8.
 */
public class HotloadBean {

    /**
     * status : 0
     * data : [{"title":"致幻毁灭者","thumb":"http://csimg.dm300
     * .com/images/spider/20151226/14511204106068.jpg","comicId":"48876",
     * "lastCharpter":{"id":"2007221","title":"第250话"}},{"title":"宅妖记","thumb":"http://csimg
     * .dm300.com/images/spider/20160530/14646024026206.jpg","comicId":"51569",
     * "lastCharpter":{"id":"2007222","title":"第36话"}},{"title":"极乐世界","thumb":"http://csimg
     * .dm300.com/images/spider/20160607/14652900036940.jpg","comicId":"51739",
     * "lastCharpter":{"id":"2007196","title":"第51话"}},{"title":"魔王与勇者与圣剑神殿",
     * "thumb":"http://csimg.dm300.com/images/spider/20150327/14273856201309.jpg",
     * "comicId":"22664","lastCharpter":{"id":"2007179","title":"第81话"}},{"title":"哥变成魔法少女了？！",
     * "thumb":"http://csimg.dm300.com/images/spider/20150710/14365164094435.jpg",
     * "comicId":"46211","lastCharpter":{"id":"2006830","title":"第98话"}},{"title":"寄生少女",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271849581236.jpg",
     * "comicId":"788","lastCharpter":{"id":"2006850","title":"第83话"}},{"title":"我是杀手女仆",
     * "thumb":"http://csimg.dm300.com/images/spider/20151226/14511216027511.jpg",
     * "comicId":"48877","lastCharpter":{"id":"2006885","title":"第55话"}},{"title":"白泽异闻录",
     * "thumb":"http://csimg.dm300.com/images/spider/20160327/14590692057154.jpg",
     * "comicId":"50453","lastCharpter":{"id":"2006893","title":"第65话"}},{"title":"食色大陆",
     * "thumb":"http://csimg.dm300.com/images/spider/20160519/14636424038993.jpg",
     * "comicId":"51382","lastCharpter":{"id":"2006884","title":"第31话"}},{"title":"风夏",
     * "thumb":"http://csimg.dm300.com/images/upload/20150409/14285678848875.jpg",
     * "comicId":"11702","lastCharpter":{"id":"2006869","title":"第119话"}},{"title":"地藏齐天",
     * "thumb":"http://csimg.dm300.com/images/spider/20151108/14469972075279.jpg",
     * "comicId":"48074","lastCharpter":{"id":"2006862","title":"第92话"}},{"title":"颜值恋",
     * "thumb":"http://csimg.dm300.com/images/spider/20151223/14508588032280.jpg",
     * "comicId":"48786","lastCharpter":{"id":"2006858","title":"第62话"}},{"title":"人皮衣裳",
     * "thumb":"http://csimg.dm300.com/images/spider/20160110/14523984037814.jpg",
     * "comicId":"49236","lastCharpter":{"id":"2006857","title":"第105话"}},{"title":"東京喰種RE",
     * "thumb":"http://csimg.dm300.com/images/spider/20150604/14334060031333.jpg",
     * "comicId":"33157","lastCharpter":{"id":"2006798","title":"第88话"}},{"title":"木兰无长兄",
     * "thumb":"http://csimg.dm300.com/images/spider/20160406/14599320028403.jpg",
     * "comicId":"50628","lastCharpter":{"id":"2006445","title":"第64话"}},{"title":"我的逆天神器",
     * "thumb":"http://csimg.dm300.com/images/spider/20151004/14439432054295.jpg",
     * "comicId":"47738","lastCharpter":{"id":"2006437","title":"第121话"}},{"title":"我是大反派",
     * "thumb":"http://csimg.dm300.com/images/spider/20160322/14586336025560.jpg",
     * "comicId":"50362","lastCharpter":{"id":"2006432","title":"第47话"}},{"title":"我家大师兄脑子有坑",
     * "thumb":"http://csimg.dm300.com/images/spider/20150807/14389312907366.jpg",
     * "comicId":"46598","lastCharpter":{"id":"2006428","title":"第162话"}},{"title":"间谍女高",
     * "thumb":"http://csimg.dm300.com/images/spider/20150615/14343652101568.jpg",
     * "comicId":"35053","lastCharpter":{"id":"2006406","title":"第66话"}},{"title":"不死者",
     * "thumb":"http://csimg.dm300.com/images/spider/20151007/14442060067099.jpg",
     * "comicId":"47768","lastCharpter":{"id":"2006398","title":"第83话"}},{"title":"羞耻侠",
     * "thumb":"http://csimg.dm300.com/images/spider/20160322/14586336022301.jpg",
     * "comicId":"50361","lastCharpter":{"id":"2006394","title":"第49话"}},{"title":"恋恋星耀",
     * "thumb":"http://csimg.dm300.com/images/spider/20160519/14636424084153.jpg",
     * "comicId":"51383","lastCharpter":{"id":"2006388","title":"第20话"}},{"title":"王爷你好贱",
     * "thumb":"http://csimg.dm300.com/images/spider/20160529/14645232034065.jpg",
     * "comicId":"51545","lastCharpter":{"id":"2006386","title":"第27话"}},{"title":"罗刹大人请留步",
     * "thumb":"http://csimg.dm300.com/images/spider/20160110/14524368084274.jpg",
     * "comicId":"49257","lastCharpter":{"id":"2006379","title":"第110话"}},{"title":"驭灵师",
     * "thumb":"http://csimg.dm300.com/images/spider/20160518/14635572039425.jpg",
     * "comicId":"51359","lastCharpter":{"id":"2006371","title":"第34话"}},{"title":"白灵杀手",
     * "thumb":"http://csimg.dm300.com/images/spider/20151211/14498004047254.jpg",
     * "comicId":"48486","lastCharpter":{"id":"2004846","title":"第77话"}},{"title":"王者天下",
     * "thumb":"http://csimg.dm300.com/images/spider/20150324/14271852058104.jpg",
     * "comicId":"1539","lastCharpter":{"id":"2003872","title":"王者天下484集"}},{"title":"猫狗杀",
     * "thumb":"http://csimg.dm300.com/images/spider/20150731/14383128058440.jpg",
     * "comicId":"46493","lastCharpter":{"id":"2004823","title":"第44话"}},{"title":"神殿街",
     * "thumb":"http://csimg.dm300.com/images/spider/20151225/14510568059339.jpg",
     * "comicId":"48846","lastCharpter":{"id":"2004797","title":"第36话"}},{"title":"猎魂师",
     * "thumb":"http://csimg.dm300.com/images/spider/20160327/14590692038928.jpg",
     * "comicId":"50450","lastCharpter":{"id":"2004801","title":"第78话"}}]
     */

    private int status;
    /**
     * title : 致幻毁灭者
     * thumb : http://csimg.dm300.com/images/spider/20151226/14511204106068.jpg
     * comicId : 48876
     * lastCharpter : {"id":"2007221","title":"第250话"}
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
        /**
         * id : 2007221
         * title : 第250话
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
