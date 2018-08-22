package languages;
import java.util.Calendar;

public class Age extends Date
{
	
///////////////////////////////// VARIABLE ASSIGNMENTS //////////////////////////
	protected Date today, birthday;
	protected int ageNum;

	
///////////////////////////////// DEFAULT CONSTRUCTORS //////////////////////////
	public Age()
	{
		today = new Date();
		birthday = new Date();
		setToday();
		setAgeNum();
	}//end default constructor public Age()
	
	public Age(int day, int month, int year)
	{
		today = new Date();
		birthday = new Date(day, month, year);
		setToday();
		setAgeNum();
	}//end constructor public Age()
	

///////////////////////////////// MUTATER FUNCTIONS //////////////////////////	
	
	public void setToday()
	{
		Calendar lCal = Calendar.getInstance();
		
		today.setYearInt(lCal.get(Calendar.YEAR));
		today.setMonthInt(lCal.get(Calendar.MONTH) + 1);
		today.setDayInt(lCal.get(Calendar.DATE));
	}//end	public void setToday()
	
	//Calculate age from birthday information and today's date
	public int setAgeNum()
	{
		
		//Convert today's info in the integer form of YYYYMMDD
		int a = today.getYearInt() * 10000
				+ today.getMonthInt() * 100
				+ today.getDayInt();
		
		//DEBUG
		System.out.printf("%d %d %d\n", today.getYearInt() * 10000,
				today.getMonthInt() * 100,
				today.getDayInt());
		
		//Convert birthday info in the integer form of YYYYMMDD
		int b = birthday.getYearInt() * 10000
				+ birthday.getMonthInt() * 100
				+ birthday.getDayInt();
	
		
		//Compute integer division to get first two digits
		ageNum = (a-b)/10000;
		
		//DEBUG
		System.out.printf("%d %d %d\n", birthday.getYearInt() * 10000,
				birthday.getMonthInt() * 100,
				birthday.getDayInt());
		
		System.out.printf("  %d\n- %d\n%d\n",a,b, ageNum);
		System.out.printf("today is %d\n your bday was %d\nyour age is %d\n", a,b,ageNum);
		return ageNum;
	}//end public int setAgeNum()
	
///////////////////////////////// ACCESSOR FUNCTIONS //////////////////////////	
	public int getAgeNum()
		{ return ageNum; }
}
