package PetsManagement;

public class PetType //TODO add a PetType repository and service, make this class an entity
{
	private long id;
	private String type;
	private String subType;
	private short rarity;
	
	public PetType()
	{
		
	}
	
	public PetType(int id, String type, String subType, short rarity)
	{
		super();
		this.id = id;
		this.type = type;
		this.subType = subType;
		this.rarity = rarity;		
	}
	
	public long getId() 
	{
		return id;
	}
	
	public void setId(long id) 
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
	
	public short getRarity() 
	{
		return rarity;
	}
	
	public void setRarity(short rarity) 
	{
		this.rarity = rarity;
	}	
	
	@Override
	public boolean equals (Object o)
	{
		return (subType.equals(((PetType)o).subType));
	}
}
