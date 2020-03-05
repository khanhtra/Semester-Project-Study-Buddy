package PetsManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import UserManagement.User;

@Entity
public class Pet 
{
	@Id
	private Integer id;
	private String name;
	
	@ManyToOne
	private PetType type;
	
	@ManyToOne//(cascade = {CascadeType.ALL})
	private User owner;
	
	public Pet()
	{
		
	}
	
	public Pet(int id, String name, PetType type, User owner)
	{
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.owner = owner;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public PetType getType()
	{
		return type;
	}
	
	public User getOwner()
	{
		return owner;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(PetType type)
	{
		this.type = type;
	}
	
	public void setOwner(User owner)
	{
		this.owner = owner;
	}
	
	@Override
	public boolean equals (Object o)
	{
		return ((name.equals(((Pet)o).name)) && (type.equals(((Pet)o).type)) && (owner.equals(((Pet)o).owner)));	
	}
}
