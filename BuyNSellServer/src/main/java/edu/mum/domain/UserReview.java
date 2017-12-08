package edu.mum.domain;

import java.util.Date;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
public class UserReview {
    private String id;
    private String content;
    private Date reviewedOn;
    private String userId;
    private String reviewedBy;
    private Integer rating;

    public UserReview(){}

    public UserReview(String content, Date reviewedOn, String userId, String reviewedBy, Integer rating) {
        this.content = content;
        this.reviewedOn = reviewedOn;
        this.userId = userId;
        this.reviewedBy = reviewedBy;
        this.rating = rating;
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

    public Date getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(Date reviewedOn) {
        this.reviewedOn = reviewedOn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
