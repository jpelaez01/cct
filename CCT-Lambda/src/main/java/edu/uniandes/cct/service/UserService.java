package edu.uniandes.cct.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import edu.uniandes.cct.model.CCT;

public class UserService {
	
	MongoClient client = new MongoClient("localhost",27017);
	Datastore datastore = new Morphia().createDatastore(client, "CCT");

	public String addPost(CCT cct){
		
		datastore.save(cct);
		return "add post";
	}
	
	public List<CCT> getAllPost(){
		List<CCT> list = datastore.find(CCT.class).asList();		
		return list;

	}
	public CCT getPostbyName(String userName){
		CCT cct= datastore.find(CCT.class, "oth",userName).get();
		if (cct != null) return cct;
		else return null;
		
	}
}
