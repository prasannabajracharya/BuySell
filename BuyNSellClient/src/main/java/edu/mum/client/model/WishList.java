package edu.mum.client.model;

/**
 * Created by yentran
 */
public class WishList {

    private String id;
    private String name;
    private String image;


    public WishList() {}

    @Override
    public String toString() {
        return "WishList {id='" + id + '\'' + ", name='" + name + '\'' + ", image='" + image +  '\'' +'}';
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
