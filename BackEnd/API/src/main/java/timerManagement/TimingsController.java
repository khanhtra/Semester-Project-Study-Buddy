package timerManagement;

import java.util.Date;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimingsController 
{
	//Adds a start and end time for a study session to the database
	@RequestMapping(method=RequestMethod.POST, value = "/timings/{username}")
	public void addTimings(@PathVariable String username, @RequestBody Date startTime, @RequestBody Date endTime)
	{
		;
	}
}
