package edu.mum.client.model;

import java.util.Date;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
public class Comment {

    private String id;
    private String content;
    private Date commentedOn;
    private String userId;
    private String postId;

    public Comment() {
    }

    public Comment(String content, Date commentedOn, String userId, String postId) {
        this.content = content;
        this.commentedOn = commentedOn;
        this.userId = userId;
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentedOn() {
        return commentedOn;
    }

    public void setCommentedOn(Date commentedOn) {
        this.commentedOn = commentedOn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", commentedOn=" + commentedOn +
                ", userId='" + userId + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
