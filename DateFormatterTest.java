/*
 * 
 * Author: James York
 * Date: July 26, 2012
 * 
 */

package com.kroysemaj.dateformatter;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class DateFormatterTest 
{

	DateFormatter df = new DateFormatter();
	String s1 = "20121214";
	String s2 = "20121217";
	
	@Test
	public void testParseYear() //parsing year
	{
		assertEquals(2012, df.parseYear(s1));
	}
	
	@Test
	public void testParseMonth() //parsing year
	{
		assertEquals(12, df.parseMonth(s1));
	}
	
	@Test
	public void testParseDay() //parsing year
	{
		assertEquals(14, df.parseDay(s1));
	}
		
	@Test
	public void testFormatDate()
	{
		Date date = new Date();

		assertEquals("July 27, 2012", df.formatDate(date));
	}
	
	@Test
	public void testOverloadedFormatDate()
	{
		
		Date date1 = df.createDate(s1);
		Date date2 = df.createDate(s2);
		
		assertEquals("December 14, 2012 - December 17, 2012", df.formatDate(date1, date2));
	}
	
	@Test
	public void testFormatCreatedDate()
	{
		Date date = new Date();
		date = df.createDate(s1);
		
		
		assertEquals("December 14, 2012", df.formatDate(date));
	}
		
	@Test
	public void testCreatedDate()
	{
		String s2 = "Fri Dec 14 00:00:00 EST 2012";
		Date d = df.createDate(s1);
		
		assertEquals(s2, d.toString());
	}
	
	@Test
	public void testValidDate()
	{
		String s1 = "20121214";
		Date d = df.createDate(s1);
		
		assertEquals("Valid Date Range", df.validateDate(s1));
	}
	
	@Test
	public void testInvalidDay()
	{
		String s1 = "20121244";
		Date d = df.createDate(s1);
		
		assertEquals("Invalid Date Range", df.validateDate(s1));
	}
	
	@Test
	public void testInvalidMonth()
	{
		String s1 = "20121624";
		Date d = df.createDate(s1);
		
		assertEquals("Invalid Date Range", df.validateDate(s1));
	}
}
