package UserManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User 
{
	@Id
	private String username;
	private String salt;
	private int password;
	private int tickets;
	private int usedTickets;
	
	public User() 
	{
		
	}
	
	public User(String username, String salt, int password) 
	{
		this.username = username;
		this.salt = salt;
		this.password = password;
	}
	
	public String getId() 
	{
		return username;
	}
	
	public void setId(String username)
	{
		this.username = username;
	}
	
	public String getSalt()
	{
		return salt;
	}
	
	public void setSalt(String salt)
	{
		this.salt = salt;
	}
	
	public int getPassword()
	{
		return password;
	}
	
	public void setPassword(int password)
	{
		this.password = password;
	}

	public int getTickets() 
	{
		return tickets;
	}

	public void setTickets(int tickets) 
	{
		this.tickets = tickets;
	}

	public int getUsedTickets() 
	{
		return usedTickets;
	}

	public void setUsedtickets(int usedtickets) 
	{
		this.usedTickets = usedtickets;
	}

	public void addTickets(int tickets) 
	{
		this.tickets += tickets; 	
	}

	public void removeTicket() 
	{
		--tickets;
		++usedTickets;
	}
}
