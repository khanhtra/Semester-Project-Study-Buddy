package PetsManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UserManagement.User;

@Service
public class PetService 
{
	int id;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	PetTypeRepository petTypeRepository;
	
	public List<Pet> getPets(String username) 
	{
		List<Pet> pets = new ArrayList<>();
		petRepository.findByOwnerUsername(username).forEach(pets::add);
		return pets;
	}

	public void addPet(String rarity, User user) 
	{
		try 
		{
			id = petRepository.findFirstByOrderByIdDesc().getId() + 1;
		}
		
		catch(NullPointerException e)
		{
			
		}
		
		PetType petType = petTypeRepository.getRandomType();
		petRepository.save(new Pet(id, "Leo", petType, user));
	}

	public void deletePet(int id) 
	{
		petRepository.deleteById(id);
	}

	public void renamePet(int id, String name) 
	{
		PetType type = petRepository.findById(id).get().getType();
		User owner = petRepository.findById(id).get().getOwner();
		petRepository.save(new Pet(id, name, type, owner));	
	}
}
