package com.tutorialspoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lmax.inputdisruptor.InputDisruptor;
import com.lmax.outputdisruptor.OutputDisruptor;

import edu.uniandes.cct.serviceRequest.ServiceDeskManager;

@Path("/UserService")
public class UserService {

	 UserDao userDao = new UserDao();
	 private static ServiceDeskManager sdm;

	 public UserService() {
		 System.gc();
		 if (sdm == null){
		  	 InputDisruptor.startProcessing();
			 OutputDisruptor.startProcessing();
			 sdm = new ServiceDeskManager();
			 sdm.StartAsyncProcessing();
		 }
	 }

	// @GET
	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes("application/x-www-form-urlencoded")
	public List<User> getUsers(@FormParam("ID") String id, @FormParam("Nombre") String nombre,
			@FormParam("Descripcion") String descripcion, @FormParam("Cargo") String cargo,
			@FormParam("Area") String area) {
		System.out.println(id);
		System.out.println(nombre);
		System.out.println(descripcion);
		return userDao.getAllUsers(Integer.parseInt(id), nombre, descripcion,cargo,area);
	}
	
	// @GET
		@POST
		@Path("/users2")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes("application/x-www-form-urlencoded")
		public void getUsers2(@FormParam("IDS") String idList) {
			System.out.println(idList);;
			userDao.getAllUsers2(idList);
		}
}