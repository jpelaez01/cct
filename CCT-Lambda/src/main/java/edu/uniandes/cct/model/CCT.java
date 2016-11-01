package edu.uniandes.cct.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class CCT {

	@Id
	private ObjectId id;
	private String title;
	private String description;
	private String oth;

	public CCT(){
		super();
	}
	
	public CCT(String title, String description, String oth) {
		super();
		this.title = title;
		this.description = description;
		this.oth = oth;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

}
