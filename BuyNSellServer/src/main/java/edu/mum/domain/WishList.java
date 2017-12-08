package edu.mum.domain;

import org.springframework.data.annotation.Id;

/**
 * @author yentran
 *
 */
public class WishList {

    @Id
    private String id;
    private String image;
    private String name;

    public WishList() {}

    @Override
    public String toString() {
        return "WishList {id='" + id + '\'' + ", name='" + name + '\''+ ", image='" + image + '\''  +'}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
