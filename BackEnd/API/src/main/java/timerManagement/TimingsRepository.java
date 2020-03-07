package timerManagement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TimingsRepository extends CrudRepository<Timings, Integer>
{
	public List<Timings> findByOwnerUsername(String username);
}
