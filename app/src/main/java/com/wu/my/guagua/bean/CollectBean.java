package com.wu.my.guagua.bean;

/**
 * Created by My on 2016/8/10.
 */
public class CollectBean {
    private String title;
    private String updateTime;
    private String thumb;
    private int id;
    private String comicId;
    private String lastCharpterTitle;

    public CollectBean() {

    }

    public void setLastCharpterTitle(String lastCharpterTitle) {
        this.lastCharpterTitle = lastCharpterTitle;
    }

    public String getLastCharpterTitle() {
        return lastCharpterTitle;
    }

    public CollectBean(String title, String updateTime, String thumb, String comicId, String
            lastCharpterTitle) {
        this.title = title;
        this.updateTime = updateTime;
        this.thumb = thumb;
        this.comicId = comicId;
        this.lastCharpterTitle = lastCharpterTitle;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComicId() {
        return comicId;
    }

    public void setComicId(String comicId) {
        this.comicId = comicId;
    }

    @Override
    public String toString() {
        return "CollectBean{" +
                "title='" + title + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", thumb='" + thumb + '\'' +
                ", id=" + id +
                ", comicId='" + comicId + '\'' +
                ", lastCharpterTitle='" + lastCharpterTitle + '\'' +
                '}';
    }
}
