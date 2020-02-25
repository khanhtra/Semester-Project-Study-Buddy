package UserManagement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;
	
	public UserService()
	{
		
	}

	public List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users; 
	}
	
	public User getUser(String username)
	{
		return userRepository.findById(username).orElse(null);
	}

	public void addUser(String username, String salt, int password) 
	{
		userRepository.save(new User(username, salt, password));
	}

	public void deleteUser(String username) 
	{
		userRepository.delete(new User(username, "oooooo", 0));	
	}
}
