package UserManagement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	//Gets all users
	@RequestMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	//Gets a single user
	@RequestMapping("/users/{username}")
	public User getUser(@PathVariable String username)
	{
		return userService.getUser(username);
	}
	
	//Creates a new user
	@RequestMapping(method=RequestMethod.POST, value = "/users/{username}/{salt}")
	public void addUser(@PathVariable String username, @PathVariable String salt, @RequestBody int password)
	{
		userService.addUser(username, salt, password);
	}
	
	//Deletes a user
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{username}")
	public void deleteUser(@PathVariable String username)
	{
		userService.deleteUser(username);
	}
	
	//Adds the specified number of tickets to a users account
	@RequestMapping(method=RequestMethod.POST, value = "/users/{username}/tickets")
	public void addTickets(@PathVariable String username, @RequestBody int tickets)
	{
		userService.addTickets(username, tickets);
	}
	
	//Removes a ticket from a users account
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{username}/tickets")
	public void removeTicket(@PathVariable String username)
	{
		userService.removeTicket(username);
	}
	
	//Lists the number of tickets a user has
	@RequestMapping("/users/{username}/tickets")
	public int getNumberOfTickets(@PathVariable String username)
	{
		return userService.getNumberOfTickets(username);
	}
	
	//Lists the number of used tickets a user has
	@RequestMapping("/users/{username}/tickets/used")
	public int getNumberOfUsedTickets(@PathVariable String username)
	{
		return userService.getNumberOfUsedTickets(username);
	}
}