package model;

public class Garden
{
	private int garden_id = -1;
	private String address = "";
	
	public Garden(int garden_id, String address)
	{
		if(address.equals(""))
		{
			throw new IllegalArgumentException("The garden must have an address, no blank spaces.");
		}
		if(garden_id <= 0)
		{
			throw new IllegalArgumentException("GardenID must be a non-zero positive integer.");
		}
		this.garden_id = garden_id;
		this.address = address;
	}

	public int getGarden_id()
	{
		return this.garden_id;
	}
	public void setGarden_id(int garden_id)
	{
		this.garden_id = garden_id;
	}
	public String getGardenAddress()
	{
		return this.address;
	}
	
	public void setGardenAddress(String address)
	{
		this.address = address;
	}
	
}
