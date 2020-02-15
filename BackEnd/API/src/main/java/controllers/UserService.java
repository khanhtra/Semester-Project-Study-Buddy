package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService 
{
	private List<Pet> pets = new ArrayList<>(Arrays.asList(
			new Pet ("Boo", "Dog"),
			new Pet ("Kit", "Cat"),
			new Pet ("El", "Elephant"),
			new Pet ("Foggy", "Frog"),
			new Pet ("Wilas", "Gecko"),
			new Pet ("Varun", "Snake")
			));
	
	private List<Pet> pets2 = new ArrayList<>(Arrays.asList(
			new Pet ("Cosmo", "Dog"),
			new Pet ("Kipper", "Dog"),
			new Pet ("Jim", "Sheep")
			));
	
	private List<Pet> pets3 = new ArrayList<>(Arrays.asList(
			new Pet ("Ben", "Dog")
			));
	
	private List<User> users = new ArrayList<>(Arrays.asList(
			new User ("1", (ArrayList<Pet>) pets),
			new User ("2", (ArrayList<Pet>) pets2),
			new User ("3", (ArrayList<Pet>) pets3)
			));
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public User getUsersPet(String id)
	{
		return users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addPet(String id, Pet pet) 
	{
		users.stream().filter(t -> t.getId().equals(id)).findFirst().get().addPet(pet);
	}

	public void deletePet(String id, Pet pet) 
	{
		users.stream().filter(t -> t.getId().equals(id)).findFirst().get().deletePet(pet);	
	}
}
