package edu.uniandes.cct;

import static spark.Spark.post;
import static spark.Spark.get;

import com.google.gson.Gson;

import edu.uniandes.cct.model.CCT;
import edu.uniandes.cct.service.UserService;

public class Api {
	
	public static UserService userservice = new UserService();

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		post("/add-post",(req,res)->{
			res.type("application/json");
			CCT cct = (CCT) gson.fromJson(req.body(),CCT.class);
			return userservice.addPost(cct);		
		}, gson ::toJson);
		
		get("/",(req,res)->{
			res.type("application/json");
			return userservice.getAllPost();
		}, gson ::toJson);
		
		get("/:username",(req,res)->{
			res.type("application/json");
			CCT cct = userservice.getPostbyName(req.params("username"));
			if (cct != null) return cct;
			else return "No post found for " + req.params("username");
		}, gson ::toJson);
	}
	
}
