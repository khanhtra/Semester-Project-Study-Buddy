package timerManagement;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import UserManagement.User;

@Entity 
public class Timings 
{
	@Id
	private Integer id;
	private Date startTime;
	private Date endTime;
	
	@ManyToOne
	private User owner;
	
	public Timings()
	{
		
	}
	
	public Timings(int id, Date startTime, Date endTime, User owner) 
	{
		super();
		this.id = id; 
		this.startTime = startTime;
		this.endTime = endTime;
		this.owner = owner;
	}
	
	public Integer getId(){
		return id;
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
