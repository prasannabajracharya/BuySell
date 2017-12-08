package edu.mum.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yentran
 */
@Document
public class Catagory {
	
    @Id
    private String id;
    private String name;
    
	@DBRef
    private List<WishList> wishLists;

    public Catagory() {}
    
    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Catagory {id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}
    
    
}
