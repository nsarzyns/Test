package model;

public class Date
{
	private int day = -1, month = -1, year = -1;

	/**
	 *
	 * @param day - The day of month as a number (01-31)
	 * @param month - The month of the year as a number (01-12)
	 * @param year - The year in which the data was taken (example year = 2017)

	 */
	public Date(int day, int month, int year)
	{
		if(day > 31 || day < 1)
		{
			throw new IllegalArgumentException("There is a minimum of 1 and a maximum of 31 days in a month.");
		}
		if(month > 12 || month < 1)
		{
			throw new IllegalArgumentException("The minimum integer representing a month is 1 (January) and the maximum" +
					"is 12 (December).");
		}
		if(year < 2013)
		{
			throw new IllegalArgumentException("There is no data preceding the year 2013.");
		}
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 *
	 * @return - Returns the date as a string. Example: 02/06/2017 = February 6th, 2017
	 */
	public String stringifyDate()
	{
		String date = "";
		
		date += Integer.toString(this.month);
		date += "/";
		date += Integer.toString(this.day);
		date += "/";
		date += Integer.toString(this.year);
		
		return date;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int getYear()
	{
		return this.year;
	}
}