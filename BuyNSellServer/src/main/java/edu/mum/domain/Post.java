package edu.mum.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by prasannabajracharya on 8/11/17.
 */
@Document
public class Post {
    @Id
    private String id;
    private String title;
    private Catagory catagory;
    private Date postedOn;
    private String description;
    private String photoURL;
    private String userId;
    private PriceDetail priceDetail;
    private String itemSpecification;
    private Integer numOfViews;
    //@DBRef
    private List<Comment> listOfComments;

    public Post(){}

    public Post(String title, Catagory catagory, Date postedOn, String description, String photoURL, String userId, PriceDetail priceDetail, String itemSpecification, Integer numOfViews, List<Comment> listOfComments) {
        this.title = title;
        this.catagory = catagory;
        this.postedOn = postedOn;
        this.description = description;
        this.photoURL = photoURL;
        this.userId = userId;
        this.priceDetail = priceDetail;
        this.itemSpecification = itemSpecification;
        this.numOfViews = numOfViews;
        this.listOfComments = listOfComments;
    }

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

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PriceDetail getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(PriceDetail priceDetail) {
        this.priceDetail = priceDetail;
    }

    public String getItemSpecification() {
        return itemSpecification;
    }

    public void setItemSpecification(String itemSpecification) {
        this.itemSpecification = itemSpecification;
    }

    public Integer getNumOfViews() {
        return numOfViews;
    }

    public void setNumOfViews(Integer numOfViews) {
        this.numOfViews = numOfViews;
    }

    public List<Comment> getListOfComments() {
        return listOfComments;
    }

    public void setListOfComments(List<Comment> listOfComments) {
        this.listOfComments = listOfComments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", catagory=" + catagory +
                ", postedOn=" + postedOn +
                ", description='" + description + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", userId='" + userId + '\'' +
                ", priceDetail=" + priceDetail +
                ", itemSpecification='" + itemSpecification + '\'' +
                ", numOfViews=" + numOfViews +
                ", listOfComments=" + listOfComments +
                '}';
    }
}
