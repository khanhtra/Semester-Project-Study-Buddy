package timerManagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimingsController 
{
	@Autowired
	TimingsService timingsService = new TimingsService();
	
	//Adds a start and end time for a study session to the database
	@RequestMapping(method=RequestMethod.POST, value = "/timings/{username}/add")
	public void addTimings(@PathVariable String username, @RequestBody Date startTime, @RequestBody Date endTime)
	{
		timingsService.addTiming(username, startTime, endTime);
	}
	
	//Gets a list of timings
	@RequestMapping("/timings/{username}")
	public List<Timings> getTimings(@PathVariable String username)
	{
		return timingsService.getTimings(username);
	}
}
