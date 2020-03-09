package PetsManagement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Integer>
{
	public PetType findFirstByOrderByIdDesc();
	
	@Query(value = "SELECT * FROM pet_type "
			+ "WHERE rarity='common' "
			+ "ORDER BY RAND() "
			+ "LIMIT 1", nativeQuery = true)
	public PetType getRandomType();
}
