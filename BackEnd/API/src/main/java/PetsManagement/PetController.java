package PetsManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import UserManagement.User;

@RestController
public class PetController 
{
	@Autowired
	private PetService petService;
	
	//Gets all pets for a user
	@RequestMapping("/users/{id}/pets")
	public List<Pet> getPets(@PathVariable String id)
	{
		return petService.getPets(id);
	}
	
	//Creates a new pet for a user
	@RequestMapping(method=RequestMethod.POST, value = "/users/pets")
	public void addPet(@RequestBody Pet pet)
	{
		petService.addPet(pet);
	}
	
	//Deletes a pet from a user
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/pets")
	public void deletePet( @RequestBody Pet pet)
	{
		petService.deletePet(pet);
	}
	
	//Only for testing purposes
	@RequestMapping("/test")
	public Pet test()
	{
		return new Pet("Kipper","Dog", new User("9000"));
	}
}
