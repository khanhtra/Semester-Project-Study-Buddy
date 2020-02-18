package PetsManagement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer>
{
	public List<Pet> findByOwnerId(String id);
}
