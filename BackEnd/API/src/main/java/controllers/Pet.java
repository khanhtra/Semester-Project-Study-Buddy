package controllers;

public class Pet 
{
	private String name;
	private String type;
	
	public Pet()
	{
		
	}
	
	public Pet(String name, String type)
	{
		super();
		this.name = name;
		this.type = type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	@Override
	public boolean equals (Object o)
	{
		return ((name.equals(((Pet)o).name)) && (type.equals(((Pet)o).type)));	
	}
}
