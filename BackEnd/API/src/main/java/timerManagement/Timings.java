package timerManagement;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import UserManagement.User;

@Entity 
@Table(name = "timings")
public class Timings //TODO Add a timings repository and service, make this class an entity
{
	@Id
	private Integer timing_id;
	private Date startTime;
	private Date endTime;
	private User owner;
	
	public Timings()
	{
		
	}
	
	public Timings(int timing_id, Date startTime, Date endTime, User owner) 
	{
		super();
		this.timing_id = timing_id; 
		this.startTime = startTime;
		this.endTime = endTime;
		this.owner = owner;
	}
	
	public Integer getId(){
		return timing_id;
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
