package controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	//Gets all users (Probably unnecessary for now)
	@RequestMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	//Gets pet list from a user
	@RequestMapping("/users/{id}/pets")
	public List<Pet> getUsersPets(@PathVariable String id)
	{
		return userService.getUsersPet(id).getPets();
	}
	
	//Add a new pet to a user
	@RequestMapping(method=RequestMethod.POST, value = "/users/{id}/pets")
	public void addPet(@PathVariable String id, @RequestBody Pet pet)
	{
		userService.addPet(id, pet);
	}
	
	//Delete a pet from a user
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{id}/pets")
	public void deletePet(@PathVariable String id, @RequestBody Pet pet)
	{
		userService.deletePet(id, pet);
	}
	
	
}