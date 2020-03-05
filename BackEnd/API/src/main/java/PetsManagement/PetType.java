package PetsManagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PetType //TODO add a PetType repository and service, make this class an entity
{
	@Id
	private int id;
	private String type;
	private String subType;
	private String rarity;
	
	public PetType()
	{
		
	}
	
	public PetType(int id, String type, String subType, String rarity)
	{
		super();
		this.id = id;
		this.type = type;
		this.subType = subType;
		this.rarity = rarity;		
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getSubType() 
	{
		return subType;
	}
	
	public void setSubType(String subType) 
	{
		this.subType = subType;
	}
	
	public String getRarity() 
	{
		return rarity;
	}
	
	public void setRarity(String rarity) 
	{
		this.rarity = rarity;
	}	
	
	@Override
	public boolean equals (Object o)
	{
		return (subType.equals(((PetType)o).subType));
	}
}
