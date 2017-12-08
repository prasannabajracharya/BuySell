package edu.mum.domain;

/**
 * Created by prasannabajracharya on 8/12/17.
 */
public class PriceDetail {
    private Double price;
    private Boolean negotiable;

    private String condition;

    private String ownershipDoc;

    public PriceDetail(){}

    public PriceDetail(Double price, Boolean negotiable, String condition, String ownershipDoc) {
        this.price = price;
        this.negotiable = negotiable;
        this.condition = condition;
        this.ownershipDoc = ownershipDoc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(Boolean negotiable) {
        this.negotiable = negotiable;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getOwnershipDoc() {
        return ownershipDoc;
    }

    public void setOwnershipDoc(String ownershipDoc) {
        this.ownershipDoc = ownershipDoc;
    }
}
