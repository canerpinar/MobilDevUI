package org.mobildev;


import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/userservice")
public class UserService {

	private UserRepository repository = new UserRepository();
	


	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonEntity getPerson() {	
		return new PersonEntity("John", "Wayn", "john@example.com", "password");
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public String savePerson(PersonEntity person) {	
		String result = "";
		try {
			result = repository.savePerson(person);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonEntity> getUsers(){
		try {
			return repository.getUsers();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/delete")
	public String deletePerson(@QueryParam("userId") Integer userId) {
		System.err.println(userId);
		try {
			return repository.deletePerson(userId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
