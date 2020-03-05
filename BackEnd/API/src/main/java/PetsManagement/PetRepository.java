package PetsManagement;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer>
{
	public List<Pet> findByOwnerUsername(String username);
	public Pet findFirstByOrderByIdDesc();
}
