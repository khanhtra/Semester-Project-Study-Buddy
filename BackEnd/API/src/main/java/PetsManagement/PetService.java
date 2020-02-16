package PetsManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService 
{
	@Autowired
	PetRepository petRepository;
	
	public List<Pet> getPets(String id) 
	{
		List<Pet> pets = new ArrayList<>();
		petRepository.findByOwnerId(id).forEach(pets::add);
		return pets;
	}

	public void addPet(Pet pet) 
	{
		pet.generateId();
		petRepository.save(pet);
	}

	public void deletePet(Pet pet) 
	{
		pet.generateId();
		petRepository.delete(pet);
	}
}
