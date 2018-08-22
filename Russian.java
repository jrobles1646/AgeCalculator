package languages;

public class Russian extends Age
{
	public static String getTodayInWords(Age person)
	{
		return ("Сегодня "+
				numToOrdinalString(person.today.getDayInt()) + " " +
				monthIntToString(person.today.getMonthInt()) + " " +
				numToGenitiveString(person.today.getYearInt())) + " года.\n";
	}
	
	public static String getTodayInNumbers(Age person)
	{
		return ("Сегодня " +
				person.today.getDayInt() + "." +
				person.today.getMonthInt() + "." +
				person.today.getYearInt()) + " г.";
	}
	
	public static String getBirthdayInWords(Age person)
	{
		return ("Этот человек родился " +
				numToOrdinalString(person.birthday.getDayInt()) + " " +
				monthIntToString(person.birthday.getMonthInt())+ " " +
				numToGenitiveString(person.birthday.getYearInt())) + " года.\n";
	}
	
	public static String getBirthdayInNumbers(Age person)
	{
		return ("Этот человек родился " +
	person.birthday.getDayInt() + "." +
	person.birthday.getMonthInt() + "." +
	person.birthday.getYearInt() + " г.\n");
	}
	
	public static String getAgeInWords(Age person)
	{
		return ("Этому человеку " + numToNominativeString(person.ageNum) +
				" " + getWordForYear(person.ageNum) + ".\n");
	}
	
	public static String getAgeInNumbers(Age person)
	{
		return ("Этому человеку " + person.ageNum +
				" " + getWordForYear(person.ageNum) + ".\n");
	}
	
	
	
	public static String monthIntToString (int monthInt)
	{
		switch(monthInt)
		{
		case 1: return "января";
		case 2: return "февраля";
		case 3: return "марта";
		case 4: return "апреля";
		case 5: return "мая";
		case 6: return "июня";
		case 7: return "июля";
		case 8: return "августа";
		case 9: return "сентября";
		case 10: return "октября";
		case 11: return "nоября";
		case 12: return "декабря";
		default: //User inputs a weird month
			return "плохоября";	//Returns an error month
		}
	}
	
	public static String numToOrdinalString (int dayInt)
	{
		switch(dayInt)
		{
			case 1: return "первое";
			case 2: return "второе";
			case 3: return "третье";
			case 4: return "четвёртое";
			case 5: return "пятое";
			case 6: return "шестое";
			case 7: return "седьмое";
			case 8: return "восьмое";
			case 9: return "девятое";
			case 10: return "десятое";
			case 11: return "одиннадцатое";
			case 12: return "двенадцатое";
			case 13: return "тринадцатое";
			case 14: return "четырнадцатое";
			case 15: return "пятнадцатое";
			case 16: return "шестнадцатое";
			case 17: return "семнадцатое";
			case 18: return "восемнадцатое";
			case 19: return "девятнадцатое";
			case 20: return "двадцатое";
			case 21: return "двадцать первое";
			case 22: return "двадцать второе";
			case 23: return "двадцать третье";
			case 24: return "двадцать четвёртое";
			case 25: return "двадцать пятое";
			case 26: return "двадцать шестое";
			case 27: return "двадцать седьмое";
			case 28: return "двадцать восьмое";
			case 29: return "двадцать девятое";
			case 30: return "тридцатое";
			case 31: return "тридцать первое";
			default: return "Плохое";
		}
	}
	
	public static String numToGenitiveString (int num)
	{
		String thousands = "";
		String tens = "";
		String teens = "";
		String ones = "";
		String concatenate = "";
		
		if (num == 1900)
			return "тысяча девяностого";
		if (num == 2000)
			return "двухтысячного";
		//Convert 0 to string and return it
		if (num == 0)
		
		System.out.printf("debug: thousands place is %d\n", (num - (num%1000))/1000);
		
		if (num >= 1000)
		{
			switch((num - (num%100)))
			{
			case 1800: thousands = "тысяча восемьдесят"; break;
			case 1900: thousands = "тысяча девятьсот"; break;
			case 2000: thousands = "две тысячи"; break;
			default: break;
			}
		
			concatenate += thousands;
		
			if (num != 2000)
				concatenate += " ";
		}
		
		if (num%100 >= 11 && num%100 <= 19)
		{
			switch (num%100)
			{
			case 11: teens = "одиннадцатого"; break;
			case 12: teens = "двенадцатого"; break;
			case 13: teens = "тринадцатого"; break;
			case 14: teens = "четырнадцатого"; break;
			case 15: teens = "пятнадцатого"; break;
			case 16: teens = "шестнадцатого"; break;
			case 17: teens = "семнадцатого"; break;
			case 18: teens = "восемнадцатого"; break;
			case 19: teens = "девятнадцатого"; break;
			default: break;
			}
			concatenate += teens;
			return concatenate;
		}

		if (num%100 >= 10 && num%100 <= 90 && num%10 == 0)
		{
			switch (num%100)
			{
				case 10: tens = "десятого"; break;
				case 20: tens = "двадцатого"; break;
				case 30: tens = "тридцатого"; break;
				case 40: tens = "сорокового"; break;
				case 50: tens = "пятидесятого"; break;
				case 60: tens = "шестидесятого"; break;
				case 70: tens = "семидесятого"; break;
				case 80: tens = "восьмидесятого"; break;
				case 90: tens = "девяностого"; break;
				default: break;
			}
			concatenate += tens;
			return concatenate;
		}
		
		else if ((num%100 - num%10) >= 20 && (num%100 - num%10) <= 90)
		{
		
			switch (num%100 - num%10)
			{
				case 20: tens = "двадцать"; break;
				case 30: tens = "тридцать"; break;
				case 40: tens = "сорок"; break;
				case 50: tens = "пятьдесят"; break;
				case 60: tens = "шестьдесят"; break;
				case 70: tens = "семьдесят"; break;
				case 80: tens = "восемьдесят"; break;
				case 90: tens = "девяносто"; break;
				default: break;
			}
			
			concatenate += tens;
			if (num%10 !=0)
				concatenate += " ";
		}
		
		System.out.printf("debug: ones place is %d\n", num%10);
		//Find the string of the number for in its ones place
		if (!(num%100 >= 11 && num%100 <= 19))
		{ //If the tens and ones place is not a teen number
			switch (num%10)
			{
			case 1: ones = "первого"; break;
			case 2: ones =  "второго"; break;
			case 3: ones =  "третьего"; break;
			case 4: ones =  "четвёртого"; break;
			case 5: ones =  "пятого"; break;
			case 6: ones =  "шестого"; break;
			case 7: ones =  "седьмого"; break;
			case 8: ones =  "восьмого"; break;
			case 9: ones =  "девятого"; break;
			}
			concatenate += ones;
		}
		

		return concatenate;
	}//end function public static String numToGenitiveString (int num)
	
	public static String getWordForYear(int num)
	{
		if (num%100 >= 11 && num%100 <= 19)
			return "лет";
		
		if (num%10 == 1)
			return "год";
		
		if (num%10 >= 2 && num%10 <= 4)
			return "года";
		
		else
			return "лет";
	}
	
	public static String numToNominativeString(int num)
	{
		String thousands = "";
		String tens = "";
		String teens = "";
		String ones = "";
		String concatenate = "";
		
		//Convert 0 to string and return it
		if (num == 0)
			return "ноль";
		
		System.out.printf("debug: thousands place is %d\n", (num - (num%1000))/1000);
		
		if (num >= 1000)
		{
		switch((num - (num%100))/100)
		{
		case 19: thousands = "тысяча"; break;	//TODO just says "thousand"
		case 20: thousands = "два тысяча"; break;
		default: break;
		}
		
		concatenate += thousands;
		
		if (num != 2000)
		concatenate += " ";
		}
		
		
		if (num%100 >= 11 && num%100 <= 19) {
			switch (num%100)
			{
			case 11: teens =  "одиннадцать"; break;
			case 12: teens =  "двенадцать"; break;
			case 13: teens =  "тринадцать"; break;
			case 14: teens =  "четырнадцать"; break;
			case 15: teens =  "пятнадцать"; break;
			case 16: teens =  "шестнадцать"; break;
			case 17: teens =  "семнадцать"; break;
			case 18: teens =  "восемнадцать"; break;
			case 19: teens =  "девятнадцать"; break;
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
				case 20: tens = "двадцать"; break;
				case 30: tens = "тридцать"; break;
				case 40: tens = "сорок"; break;
				case 50: tens = "пятьдесят"; break;
				case 60: tens = "шестьдесят"; break;
				case 70: tens = "семьдесят"; break;
				case 80: tens = "восемьдесят"; break;
				case 90: tens = "девяносто"; break;
				default: break;
			}
			
			concatenate += tens;
			if (num%10 !=0)
				concatenate += " ";
		}
		//Add a space if the number is greater than 20 and has no ones place

			
		
		System.out.printf("debug: ones place is %d\n", num%10);
		//Find the string of the number for in its ones place
		if (!(num%100 >= 11 && num%100 <= 19))
		{ //If the tens and ones place is not a teen number
			switch (num%10)
			{
			case 1: ones = "один"; break;
			case 2: ones =  "два"; break;
			case 3: ones =  "три"; break;
			case 4: ones =  "четыре"; break;
			case 5: ones =  "пять"; break;
			case 6: ones =  "шесть"; break;
			case 7: ones =  "семь"; break;
			case 8: ones =  "восемь"; break;
			case 9: ones =  "девять"; break;
			}
			concatenate += ones;
		}
		return concatenate;
	}//public static String numToNominativeString(int num)
}//public class Russian extends Age