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
	
	public User getUser(String id)
	{
		return userRepository.findById(id).orElse(null);
	}

	public void addUser(String id) 
	{
		userRepository.save(new User(id));
	}

	public void deleteUser(String id) 
	{
		userRepository.delete(new User(id));	
	}
}
