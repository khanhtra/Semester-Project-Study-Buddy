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
}