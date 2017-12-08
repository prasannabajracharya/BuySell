package edu.mum.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Rabin Shrestha on 8/10/2017.
 */
@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String userName;
    private String password;
    private boolean enabled;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String zipcode;
    private String phoneNo;
    private String photoUrl;
    private Date lastLogIn;
    private Date createdOn;
    private List<UserReview> userReviewList;
    private List<String> userPostIds;
    private List<Catagory> catagoryWishList;
    
    @DBRef
    private List<Role> roleList;
    
    
    public List<Role> getRoles() {
		return roleList;
	}

	public void setRoles(List<Role> roles) {
		this.roleList = roles;
	}

	public List<Catagory> getCatagoryWishList() {
        return catagoryWishList;
    }

    public void setCatagoryWishList(List<Catagory> catagoryWishList) {
        this.catagoryWishList = catagoryWishList;
    }


    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", lastLogIn=" + lastLogIn +
                ", createdOn=" + createdOn +
                ", userReviewList=" + userReviewList +
                ", userPostIds=" + userPostIds +
                '}';
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getUserPostIds() {
        return userPostIds;
    }

    public void setUserPostIds(List<String> userPostIds) {
        this.userPostIds = userPostIds;
    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(Date lastLogIn)
    {
        this.lastLogIn = lastLogIn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;

        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String date= dateFormat .format(createdOn);
        Date today = Calendar.getInstance().getTime();
        System.out.println("date:"+date);
        System.out.println("date:"+this.createdOn);*/

    }

    public List<UserReview> getUserReviewList() {
        return userReviewList;
    }

    public void setUserReviewList(List<UserReview> userReviewList) {
        this.userReviewList = userReviewList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
/*
        Date createdOn;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date today = Calendar.getInstance().getTime();
        String todayStr= dateFormat .format(today);
        System.out.println("date: "+today);
        System.out.println("date: str"+todayStr);*/
        //sample date : 2017-08-15T16:08:22.019-0500


    }
}
