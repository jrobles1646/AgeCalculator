package languages;

public class English extends Age
{
	public static String getTodayInWords(Age person)
	{
		return ("Today is " + 
				monthIntToString(person.today.getMonthInt()) +
				" the " + dayIntToString(person.today.getDayInt()) +
				", " + numToString(person.today.getYearInt()) +
				".\n");
	}
	
	public static String getTodayInNumbers(Age person)
	{
		return("Today is " + 
				person.today.getMonthInt() + "/" +
				person.today.getDayInt() + "/" +
				person.today.getYearInt() + ".\n");
	}
	
	public static String getBirthdayInWords(Age person)
	{
		return ("The person was born on " +
				monthIntToString(person.birthday.getMonthInt()) + " the " +
				dayIntToString(person.birthday.getDayInt()) + ", " + 
				numToString(person.birthday.getYearInt()) +".\n");
	}
	
	public static String getBirthdayInNumbers(Age person)
	{
		return ("The person was born on " +
				person.birthday.getMonthInt() + "/" +
				person.birthday.getDayInt() + "/" + 
				person.birthday.getYearInt() +".\n");
	}
	
	
	public static String getAgeInWords(Age person)
	{
		String pluralYear = "years"; //The word can either be "year" or "years"
		
		if (person.ageNum < 2)
			pluralYear = "year";
		
		return ("This person is " +
				numToString(person.ageNum) + " " +
				pluralYear + " old.\n");
	}
	
	//Find what age is and calculate in numerals
	public static String getAgeInNumbers(Age person)
	{
		String pluralYear = "years"; //The word can either be "year" or "years"
		
		if (person.ageNum < 2)
			pluralYear = "year";
		
		return ("This person is " + person.ageNum + " " +
				pluralYear + " old.\n");
	}//end function public static String getAgeInNumbers(Age person)
	
	//Find the corresponding month to its integer value
	public static String monthIntToString (int monthInt)
	{
		switch(monthInt)
		{
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		default: return "Erruary";	//Returns an error month
		}
	}
	
	//Find the ordinal word of the integer
	public static String dayIntToString (int dayInt)
	{
		switch(dayInt)
		{
			case 1: return "first";
			case 2: return "second";
			case 3: return "third";
			case 4: return "fourth";
			case 5: return "fifth";
			case 6: return "sixth";
			case 7: return "seventh";
			case 8: return "eighth";
			case 9: return "ninth";
			case 10: return "tenth";
			case 11: return "eleventh";
			case 12: return "twelfth";
			case 13: return "thirteenth";
			case 14: return "fourteenth";
			case 15: return "fifteenth";
			case 16: return "sixteenth";
			case 17: return "seventeenth";
			case 18: return "eighteenth";
			case 19: return "nineteenth";
			case 20: return "twentieth";
			case 21: return "twenty-first";
			case 22: return "twenty-second";
			case 23: return "twenty-third";
			case 24: return "twenty-fourth";
			case 25: return "twenty-fifth";
			case 26: return "twenty-sixth";
			case 27: return "twenty-seventh";
			case 28: return "twenty-eighth";
			case 29: return "twenty-ninth";
			case 30: return "thirtieth";
			case 31: return "thirty-first";
			default: return "errorth";
		}
	}//end public static String dayIntToString (int dayInt)
	
	
	public static String numToString (int num)
	{
		String thousands = "";
		String tens = "";
		String teens = "";
		String ones = "";
		String concatenate = "";
		
		//Convert 0 to string and return it
		if (num == 0)
			return "not even one";
		
		System.out.printf("debug: thousands place is %d\n", (num - (num%1000))/1000);
		
		if (num >= 1000)
		{
		//switch((num - (num%100))/100)
		switch((num - (num%100)))
		{
		case 1800: thousands = "eighteen"; break;
		case 1900: thousands = "nineteen"; break;
		case 2000: thousands = "two thousand"; break;
		default: break;
		}
		
		concatenate += thousands;
		
		if (num != 2000)
		concatenate += " ";
		}
		
		
		if (num%100 >= 10 && num%100 <= 19) {
			switch (num%100)
			{
			case 10: teens = "ten"; break;
			case 11: teens =  "eleven"; break;
			case 12: teens =  "twelve"; break;
			case 13: teens =  "thirteen"; break;
			case 14: teens =  "fourteen"; break;
			case 15: teens =  "fifteen"; break;
			case 16: teens =  "sixteen"; break;
			case 17: teens =  "seventeen"; break;
			case 18: teens =  "eighteen"; break;
			case 19: teens =  "nineteen"; break;
			default: break;
			}
			
			concatenate += teens;
		}
		
		System.out.printf("debug: actual tens place is %d\n", (num%100 - num%10)/10);
		//Find the string for the number in its tens place
		if ((num%100 - num%10) >= 20 && (num%100 - num%10) <= 90)
		{
		
			switch (num%100 - num%10)
			{
				case 20: tens = "twenty"; break;
				case 30: tens = "thirty"; break;
				case 40: tens = "fourty"; break;
				case 50: tens = "fifty"; break;
				case 60: tens = "sixty"; break;
				case 70: tens = "seventy"; break;
				case 80: tens = "eighty"; break;
				case 90: tens = "ninety"; break;
				default: break;
			}
			
			concatenate += tens;
			if (num%10 !=0)
				concatenate += "-";
		}
		//Add a space if the number is greater than 20 and has no ones place

			
		
		System.out.printf("debug: ones place is %d\n", num%10);
		//Find the string of the number for in its ones place
		if (!(num%100 >= 11 && num%100 <= 19))
		{ //If the tens and ones place is not a teen number
			switch (num%10)
			{
			case 1: ones = "one"; break;
			case 2: ones =  "two"; break;
			case 3: ones =  "three"; break;
			case 4: ones =  "four"; break;
			case 5: ones =  "five"; break;
			case 6: ones =  "six"; break;
			case 7: ones =  "seven"; break;
			case 8: ones =  "eight"; break;
			case 9: ones =  "nine"; break;
			}
			
			concatenate += ones;
		}
		

		return concatenate;
	}//end function public static String numToString (int num)
}//end public class English extends Age