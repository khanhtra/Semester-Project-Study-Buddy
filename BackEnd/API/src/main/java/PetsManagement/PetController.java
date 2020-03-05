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
	
	@Autowired
	private PetTypeService petTypeService;
	
	//Gets all pets for a user
	@RequestMapping("/users/{username}/pets")
	public List<Pet> getPets(@PathVariable String username)
	{
		return petService.getPets(username);
	}
	
	//Renames a the pet that goes by the given id
	@RequestMapping(method=RequestMethod.POST, value = "/users/pets/rename/{id}/{name}")
	public void renamePet(@PathVariable int id, @PathVariable String name)
	{
		petService.renamePet(id, name);
	}
	
	//Creates a new pet for a user
	@RequestMapping(method=RequestMethod.POST, value = "/users/pets/{rarity}")
	public void addPet(@PathVariable String rarity, @RequestBody User user)
	{
		petService.addPet(rarity, user);
	}
	
	//Deletes a pet from a user
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/pets/{id}")
	public void deletePet(@PathVariable int id)
	{
		petService.deletePet(id);
	}
	
	//Adds a new pet type to the DB
	@RequestMapping(method=RequestMethod.POST, value = "/pettypes/{type}/{subType}/{rarity}")
	public void addPetType(@PathVariable String type, @PathVariable String subType, @PathVariable String rarity)
	{
		petTypeService.addPetType(type, subType, rarity);
	}
	
	//Displays all pet types in the DB
	@RequestMapping("/pettypes")
	public List<PetType> getPetTypes()
	{
		return petTypeService.getPetTypes();
	}
	
	//Only for testing purposes
	@RequestMapping("/test")
	public Pet test()
	{
		return new Pet(0, "Kipper",new PetType(0, "Dog", "Terrier", "Common"), new User("9000", "ooooo", 1));
	}
}
