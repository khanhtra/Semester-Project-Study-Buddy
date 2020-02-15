package controllers;

import java.util.List;

import javax.persistence.Entity;

public class User 
{
	private String id;
	private List<Pet> pets;
	
	public User(String id, List<Pet> pets) 
	{
		this.id = id;
		this.pets = pets;
	}
	
	public User() 
	{
		
	}

	public List<Pet> getPets() 
	{
		return pets;
	}
	
	public void setPets(List<Pet> pets) 
	{
		this.pets = pets;
	}
	
	public void addPet(Pet pet)
	{
		pets.add(pet);
	}
	
	public void deletePet(Pet pet)
	{
		pets.removeIf(t -> t.equals(pet));
	}
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}	
}
