package edu.mum.client.model;

import java.util.List;

/**
 * Created by yentran
 */
public class Catagory{

	private String id;
    private String name;
    private List<WishList> wishlists;

    public Catagory() {}


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
    
    public List<WishList> getWishlists() {
		return wishlists;
	}


	public void setWishlists(List<WishList> wishlists) {
		this.wishlists = wishlists;
	}


	@Override
   	public String toString() {
   		return "Catagory {id='" + id + '\''+ ", name='" + name + '\'' +'}';
   	}
}
