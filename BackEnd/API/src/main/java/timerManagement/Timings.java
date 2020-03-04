package timerManagement;
import java.util.Date;

import UserManagement.User;

public class Timings //TODO Add a timings repository and service, make this class an entity
{
	private Date startTime;
	private Date endTime;
	private User owner;
	
	public Timings()
	{
		
	}
	
	public Timings(Date startTime, Date endTime, User owner) 
	{
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.owner = owner;
	}
	
	public Date getStartTime() 
	{
		return startTime;
	}
	
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}
	
	public Date getEndTime() 
	{
		return endTime;
	}
	
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}
	
	public User getOwner() 
	{
		return owner;
	}
	
	public void setOwner(User owner) 
	{
		this.owner = owner;
	}
}
