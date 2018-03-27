package com.dq.qingfengnc.bean.goodsdetail;

import java.util.List;

/**
 * Description：
 * Created by jingang on 2017/11/13.
 */
public class Comment {

    private String id;
    private String nickname;
    private String headimgurl;
    private String level;
    private String content;
    private String createtime;
    private List<String> images;
    private List<String> appendImages;
    private String appendContent;
    private List<String> replyImages;
    private String replyContent;
    private List<String> appendReplyImages;
    private String appendReplyContent;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setAppendImages(List<String> appendImages) {
        this.appendImages = appendImages;
    }

    public List<String> getAppendImages() {
        return appendImages;
    }

    public void setAppendContent(String appendContent) {
        this.appendContent = appendContent;
    }

    public String getAppendContent() {
        return appendContent;
    }

    public void setReplyImages(List<String> replyImages) {
        this.replyImages = replyImages;
    }

    public List<String> getReplyImages() {
        return replyImages;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setAppendReplyImages(List<String> appendReplyImages) {
        this.appendReplyImages = appendReplyImages;
    }

    public List<String> getAppendReplyImages() {
        return appendReplyImages;
    }

    public void setAppendReplyContent(String appendReplyContent) {
        this.appendReplyContent = appendReplyContent;
    }

    public String getAppendReplyContent() {
        return appendReplyContent;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", level='" + level + '\'' +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", images=" + images +
                ", appendImages=" + appendImages +
                ", appendContent='" + appendContent + '\'' +
                ", replyImages=" + replyImages +
                ", replyContent='" + replyContent + '\'' +
                ", appendReplyImages=" + appendReplyImages +
                ", appendReplyContent='" + appendReplyContent + '\'' +
                '}';
    }
}