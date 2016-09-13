package com.wu.my.guagua.bean;

import java.util.List;

/**
 * Created by My on 2016/8/10.
 */
public class CartoonBean {

    /**
     * status : 0
     * data : {"charpterId":2007942,"title":"第252话","sid":259,"updateTime":1470801603,"counts":8,
     * "size":0.48,"addrs":["http://tkpic.tukucc.com/5400/20160810/c_577146/001.jpg",
     * "http://tkpic.tukucc.com/5400/20160810/c_577146/002.jpg","http://tkpic.tukucc
     * .com/5400/20160810/c_577146/003.jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/004
     * .jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/005.jpg","http://tkpic.tukucc
     * .com/5400/20160810/c_577146/006.jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/007
     * .jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/008.jpg"],"surl":"http://m.tuku
     * .cc/comic/19498/n-1470801122-55057/","iszm":0}
     */

    private int status;
    /**
     * charpterId : 2007942
     * title : 第252话
     * sid : 259
     * updateTime : 1470801603
     * counts : 8
     * size : 0.48
     * addrs : ["http://tkpic.tukucc.com/5400/20160810/c_577146/001.jpg","http://tkpic.tukucc
     * .com/5400/20160810/c_577146/002.jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/003
     * .jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/004.jpg","http://tkpic.tukucc
     * .com/5400/20160810/c_577146/005.jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/006
     * .jpg","http://tkpic.tukucc.com/5400/20160810/c_577146/007.jpg","http://tkpic.tukucc
     * .com/5400/20160810/c_577146/008.jpg"]
     * surl : http://m.tuku.cc/comic/19498/n-1470801122-55057/
     * iszm : 0
     */

    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int charpterId;
        private String title;
        private int sid;
        private int updateTime;
        private int counts;
        private double size;
        private String surl;
        private int iszm;
        private List<String> addrs;

        public int getCharpterId() {
            return charpterId;
        }

        public void setCharpterId(int charpterId) {
            this.charpterId = charpterId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public String getSurl() {
            return surl;
        }

        public void setSurl(String surl) {
            this.surl = surl;
        }

        public int getIszm() {
            return iszm;
        }

        public void setIszm(int iszm) {
            this.iszm = iszm;
        }

        public List<String> getAddrs() {
            return addrs;
        }

        public void setAddrs(List<String> addrs) {
            this.addrs = addrs;
        }
    }
}
