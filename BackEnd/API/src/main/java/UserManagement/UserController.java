package UserManagement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id)
	{
		return userService.getUser(id);
	}
	
	//Creates a new user
	@RequestMapping(method=RequestMethod.POST, value = "/users/{id}")
	public void addUser(@PathVariable String id)
	{
		userService.addUser(id);
	}
	
	//Deletes a user
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable String id)
	{
		userService.deleteUser(id);
	}
}