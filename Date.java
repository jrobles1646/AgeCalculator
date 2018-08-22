//Mutator functions do not check for incorrect leap year dates or dates like April 31

package languages;

import java.util.Calendar;

public class Date
{
///////////////////////////////// VARIABLE ASSIGNMENTS //////////////////////////
	protected int dayInt, monthInt, yearInt;	//Date information in integer form
	protected String day, month, year;	//Date information in string form
	
///////////////////////////////// DEFAULT CONSTRUCTORS //////////////////////////
	public Date()
	{
		Calendar lCal = Calendar.getInstance();
		
		yearInt = lCal.get(Calendar.YEAR);
		monthInt = lCal.get(Calendar.MONTH) + 1;
		dayInt = lCal.get(Calendar.DATE);

		day = "DD";
		month = "MM";
		year = "YYYY";
		
	}//end default constructor public Date()
	
	public Date(int dd, int mm, int yyyy)
	{
		setDayInt(dd);
		setMonthInt(mm);
		setYearInt(yyyy);

		day = "DD";
		month = "MM";
		year = "YYYY";
	}//end constructor public Date()

///////////////////////////////// MUTATER FUNCTIONS //////////////////////////	
	
	public void setDayInt(int day)
	{
		if (day >=1 && day <= 31)
			dayInt = day;
		
		//TODO Throw an error at GUI
		else
		{
			throw new IllegalArgumentException("OUT OF BOUND DAY (DD)");
		}
	}//end function public void setDayInt(int day)

	public void setMonthInt(int month)
	{
		if (month >= 1 && month <= 12)
			monthInt = month;
	
		//TODO Throw an error at GUI
		else
		{
			throw new IllegalArgumentException("OUT OF BOUND MONTH (MM)");
		}
	}//end function public void setMonthInt(int month)
	
	public void setYearInt(int year)
	{
		Calendar lCal = Calendar.getInstance();
		
		if (year > lCal.get(Calendar.YEAR) - 100 && year <= lCal.get(Calendar.YEAR))
			yearInt = year;

		//TODO Throw an error at GUI
		else
		{
			throw new IllegalArgumentException("OUT OF BOUND YEAR (YYYY)");
		}
	}//end function public void setYearInt(int year)
	

///////////////////////////////// ACCESSOR FUNCTIONS //////////////////////////	
	public int getDayInt()
		{ return dayInt;}
	public int getMonthInt()
		{ return monthInt; }
	public int getYearInt()
		{ return yearInt; }
	public String getDay()
		{ return day; }
	public String getMonth()
		{ return month; }
	public String getYear()
		{ return year; }
}//end public class Date
