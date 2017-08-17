package com.baxter.manyToOne;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CATEGORY")

public class Category {
	@Id
	@Column(name="CATEGORY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	

	
	public Category()
	{
		
	}
	
	public Category(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	

}
