package languages;

public class Kanji extends Age
{
	public static String getTodayInWords(Age person)
	{
		return ("今日は" +
				numToString(person.today.getYearInt()) + "年" + 
				numToString(person.today.getMonthInt()) + "月" +
				numToString(person.today.getDayInt()) + "日" +
				"です。\n");
	}
	
	public static String getTodayInNumbers(Age person)
	{
		return ("今日は" +
				ASCIItoUnicode(person.today.getYearInt()) + "年" + 
				ASCIItoUnicode(person.today.getMonthInt()) + "月" +
				ASCIItoUnicode(person.today.getDayInt()) + "日" +
				"です。\n");
	}
	
	public static String getBirthdayInWords(Age person)
	{
		return ("お誕生日は" +
				numToString(person.birthday.getYearInt()) + "年" +
				numToString(person.birthday.getMonthInt()) + "月" +
				numToString(person.birthday.getDayInt()) + "日" +
				"です。\n");
	}
	
	public static String getBirthdayInNumbers(Age person)
	{
		return ("お誕生日は" +
				ASCIItoUnicode(person.birthday.getYearInt()) + "年" +
				ASCIItoUnicode(person.birthday.getMonthInt()) + "月" +
				ASCIItoUnicode(person.birthday.getDayInt()) + "日" +
				"です。\n");
	}

	
	public static String getAgeInWords(Age person)
	{
		return ("人は" + numToString(person.ageNum) +  "歳です。\n");
	}
	public static String getAgeInNumbers(Age person)
	{
		return ("人は"+ ASCIItoUnicode(person.ageNum) + "歳です。\n");
	}
	
	
	//Convert an ASCII number (1,2,3,etc.) to full width Unicode (１, ２, ３, etc.)
	public static String ASCIItoUnicode(int num)
	{
		char thousands;
		char hundreds;
		char tens;
		char ones;

			/* debug
			System.out.printf("%d %d %d %d \n\n", num%10,
					(num%100 - num%10)/10,
					(num%1000 - num%100)/100,
			(num - (num%1000))/1000);
			*/
			
		//Covert the ones place into unicode
		ones = (char)('\uFF10' + (num%10));
		if (num < 10)
			return Character.toString(ones);
			
		//Convert the tens place into unicode
		tens = (char)('\uFF10' + (num%100 - num%10)/10);
		if (num < 100)
				return Character.toString(tens) + Character.toString(ones);
			
		//Convert the hundreds place into unicode
		hundreds = (char)('\uFF10' + (num%1000 - num%100)/100);
		if (num < 1000)
			return Character.toString(hundreds) +
					Character.toString(tens) +
					Character.toString(ones);
			
		//Convert the thousands place into unicode
		thousands = (char)('\uFF10' + (num - (num%1000))/1000);

		return Character.toString(thousands)+
				Character.toString(hundreds) +
				Character.toString(tens) +
				Character.toString(ones);
	}

	public static String numToString (int num)
	{
		String thousands = "";
		String hundreds = "";
		String tens = "";
		String ones = "";
	
		if (num == 0)
			return "〇";
		
		//System.out.printf("\nones: %d", num%10);
		switch(num%10)
		{
		case 0: break;
		case 1: ones = "一"; break;
		case 2: ones = "二"; break;
		case 3: ones = "三"; break;
		case 4: ones = "四"; break;
		case 5: ones = "五"; break;
		case 6: ones = "六"; break;
		case 7: ones = "七"; break;
		case 8: ones = "八"; break;
		case 9: ones = "九"; break;
		}
		if (num < 10)
			return ones;
		
		//System.out.printf("\ntens: %d", (num%100 - num%10)/10);
		
		switch ((num%100 - num%10)/10)
		{
		case 0: break;
		case 1: tens = "十"; break;
		case 2: tens = "二十"; break;
		case 3: tens = "三十"; break;
		case 4: tens = "四十"; break;
		case 5: tens = "五十"; break;
		case 6: tens = "六十"; break;
		case 7: tens = "七十"; break;
		case 8: tens = "八十"; break;
		case 9: tens = "九十"; break;
		default: break;
		}
		if (num < 100)
			return tens + ones;
		
		//System.out.printf("\nhundreds: %d %d", ((num%1000 - num%100)/100), num);
		
		switch((num%1000 - num%100)/100)
		{
		case 1: hundreds = "百"; break;
		case 2: hundreds = "二百"; break;
		case 3: hundreds = "三百"; break;
		case 4: hundreds = "四百"; break;
		case 5: hundreds = "五百"; break;
		case 6: hundreds = "六百"; break;
		case 7: hundreds = "七百"; break;
		case 8: hundreds = "八百"; break;
		case 9: hundreds = "九百"; break;
		default: break;
		}
		
		if (num < 1000)
			return hundreds + tens + ones;
		
		//System.out.printf("\nthousanddths: %d",(num - (num%1000))/1000);
		switch((num - (num%1000))/1000)
		{
		case 1: thousands = "千"; break;
		case 2: thousands = "二千"; break;
		default: break;
		}
		
		return thousands + hundreds + tens + ones;
		
	}
}