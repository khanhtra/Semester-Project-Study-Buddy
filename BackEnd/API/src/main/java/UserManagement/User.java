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
	
	@Override
	public boolean equals (Object o)
	{
		return (username.equals(((User)o).username));
	}
}
