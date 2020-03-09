package timerManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimingsService {
	@Autowired
	TimingsRepository timingsRepository;

	public TimingsService(){

	}

	public List<Timings> getTimings (String username){
		List<Timings> timings = new ArrayList<>();
		timingsRepository.findByOwnerUsername(username).forEach(pets::add);
		return timings;
	}
	
	
	public void addTiming(String username, Date startTime, Date endTime) {
		timingsRepository.save(new Timings(startTime, endTime, username));
	}
}
