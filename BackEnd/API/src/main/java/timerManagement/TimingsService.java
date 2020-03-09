package timerManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import UserManagement.User;

@Service
public class TimingsService {
	@Autowired
	TimingsRepository timingsRepository;

	int id;

	public TimingsService(){

	}

	public List<Timings> getTimings (String username){
		List<Timings> timings = new ArrayList<>();
		timingsRepository.findByOwnerUsername(username).forEach(timings::add);
		return timings;
	}
	
	
	public void addTiming(User username, Date startTime, Date endTime) {
		try 
		{
			id = timingsRepository.findFirstByOrderByIdDesc().getId() + 1;
		}
		
		catch(NullPointerException e)
		{
			
		}
		timingsRepository.save(new Timings(id, startTime, endTime, username));
	}
}
