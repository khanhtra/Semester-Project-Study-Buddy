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
		return userRepository.findById(username).get();
	}

	public void addUser(String username, String salt, int password) 
	{
		userRepository.save(new User(username, salt, password));
	}

	public void deleteUser(String username) 
	{
		userRepository.delete(new User(username, "oooooo", 0));	
	}

	public int getNumberOfUsedTickets(String username) 
	{
		return userRepository.findById(username).get().getUsedTickets();
	}

	public int getNumberOfTickets(String username) 
	{
		return userRepository.findById(username).get().getTickets();
	}

	public void addTickets(String username, int tickets) 
	{
		User user = userRepository.findById(username).get();
		user.addTickets(tickets);
		userRepository.save(user);
	}

	public void removeTicket(String username) 
	{
		User user = userRepository.findById(username).get();
		user.removeTicket();
		userRepository.save(user);		
	}
}
