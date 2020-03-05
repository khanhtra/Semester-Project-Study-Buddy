package PetsManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetTypeService 
{
	private int id;
	
	@Autowired
	PetTypeRepository petTypeRepository;
	
	public List<PetType> getPetTypes() 
	{
		List<PetType> petTypes = new ArrayList<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	
	public void addPetType(String type, String subType, String rarity)
	{
		try 
		{
			id = petTypeRepository.findFirstByOrderByIdDesc().getId() + 1;
		}

		catch(NullPointerException e)
		{
			//Null Pointer when nothing is in the table 
		}
		
		PetType petType = new PetType(id, type, subType, rarity); 
		petTypeRepository.save(petType);
	}
}
