// Alex - this class seems really really useless? I guess? Oh well it's here
package model;

public class PollinatorVisitCount
{
	private int count = -1;
	
	public PollinatorVisitCount(int count)
	{
		if(count < 0)
		{
			throw new IllegalArgumentException("The minimum visit count must be positive or zero.");
		}
		this.count = count;
	}
	
	public int getCount()
	{
		return this.count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
}