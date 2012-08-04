/*
 * 
 * Author: James York
 * Date: July 26, 2012
 * 
 */

package com.kroysemaj.dateformatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateFormatter 
{

	public int parseYear(String d) //parse year from string
	{
		int year = 0;
		
		return year = Integer.parseInt(d.substring(0, 4));
	}
	
	public int parseMonth(String d) //parse month from string
	{
		int month = 0;
		
		month = Integer.parseInt(d.substring(4, 6));
		
		if(month > 12)
		{
			month = -1;
		}

		return month;
	}
	
	public int parseDay(String d) //parse day from string
	{
		int day = 0;
		int month = this.parseMonth(d);
		
		day = Integer.parseInt(d.substring(6, 8));

		switch(month)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			{
				if(day > 31)
				{
					day = -1;
				}
			}
			case 2:
			{
				if (day > 28)
				{
					day = -1;
				}
			}
			case 4:
			case 6:
			case 9:
			case 11:
			{
				if(day > 30)
				{
					day = -1;
				}
			}
		}
		
		return day;
	}

	public Date createDate(String s) //create Date using String
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0); 	// Sets hour, minutes, and seconds to 0 as they are not compared
		cal.set(Calendar.MINUTE, 0);		// and are set to the current system time at runtime, making the test
		cal.set(Calendar.SECOND, 0);		// much more difficult to verify.
		cal.set(Calendar.YEAR, this.parseYear(s));
		cal.set(Calendar.DAY_OF_MONTH, this.parseDay(s));
		cal.set(Calendar.MONTH, this.parseMonth(s)-1);

		Date d = cal.getTime();
			
		return d;
	}

	public String formatDate(Date date) //format date from created Date
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
		String formattedDate = sdf.format(date);
		
		return formattedDate;
	}
	
	public String formatDate(Date date1, Date date2) //overloaded formatDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy"); //designate pattern
		String formattedDate = sdf.format(date1)+" - "+sdf.format(date2); 
		
		return formattedDate;
	}

	public String validateDate(String s1)
	{
		int m = -1;
		int d = -1;
		String msg = "Valid Date Range";
		
		if(m == this.parseMonth(s1) || d == this.parseDay(s1))
		{
			 msg = "Invalid Date Range";
		}		
		
		return msg;
	}
	
	
	
}
