package com.pradeep.microservice.models;

public class MovieCatalogueItem {

	private String name;
	private String desc;
	private int rating;

	
	public MovieCatalogueItem(String name, String desc, int rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MovieCatalogueItem [name=" + name + ", desc=" + desc + ", rating=" + rating + "]";
	}

}
