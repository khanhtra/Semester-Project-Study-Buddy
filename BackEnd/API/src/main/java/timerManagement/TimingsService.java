package timerManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import UserManagement.User;

/**
 * The Timings service accesses and modifies the database using the repository
 * 
 */
@Service
public class TimingsService {
	@Autowired
	TimingsRepository timingsRepository;

	int id;

	public TimingsService(){

	}

	/**
	 * Gets a list of timings 
	 * 
	 * @param username The users username
	 * @return A List of timings for the username
	 */
	public List<Timings> getTimings (String username){
		List<Timings> timings = new ArrayList<>();
		timingsRepository.findByOwnerUsername(username).forEach(timings::add);
		return timings;
	}
	
	/**
	 * Adds a time interval
	 * 
	 * @param username The users username
	 * @param startTime The start of the interval 
	 * @param endTime The end of the interval
	 */
	public void addTiming(String username, Date startTime, Date endTime) {
		try 
		{
			id = timingsRepository.findFirstByOrderByIdDesc().getId() + 1;
		}
		
		catch(NullPointerException e)
		{
			
		}
		
		User user = timingsRepository.findById(id).get().getOwner();
		timingsRepository.save(new Timings(id, startTime, endTime, user));
	}
}
