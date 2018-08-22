package languages;

public class Hiragana extends Age
{
	//Return the sentence of today's date in words
	public static String getTodayInWords(Age person)
	{
		return ("きょうは" +
				intToCardinalString(person.today.getYearInt()) + "ねん" + 
				monthIntToString(person.today.getMonthInt()) + "がつ" +
				dayIntToString(person.today.getDayInt()) +
				"です。\n");
	}//public static String getTodayInWords(Age person)
	
	//Return the sentence of today's date in date format
	public static String getTodayInNumbers(Age person)
	{
		return ("きょうは" +
				ASCIItoUnicode(person.today.getYearInt()) + "ねん" + 
				ASCIItoUnicode(person.today.getMonthInt()) + "がつ" +
				ASCIItoUnicode(person.today.getDayInt()) + "にち" +
				"です。\n");
	}//end public static String getTodayInNumbers(Age person)
	
	//Return the sentence of birthdate in words
	public static String getBirthdayInWords(Age person)
	{
		return ("おたんじょうびは" +
				intToCardinalString(person.birthday.getYearInt()) + "ねん" +
				monthIntToString(person.birthday.getMonthInt()) +
				dayIntToString(person.birthday.getDayInt()) +
				"です。\n");
	}//end public static String getBirthdayInWords(Age person)
	
	//Return the sentence of birthdate in date format
	public static String getBirthdayInNumbers(Age person)
	{
		//TODO: Fix nichi suffix
		return ("おたんじょうびは" +
				ASCIItoUnicode(person.birthday.getYearInt()) + "ねん" +
				ASCIItoUnicode(person.birthday.getMonthInt()) + "がつ" +
				ASCIItoUnicode(person.birthday.getDayInt()) + "にち" +
				"です。\n");
	}//end public static String getBirthdayInNumbers(Age person)

	//Return sentence of person's age in word format
	public static String getAgeInWords(Age person)
	{
		return ("ひとは" + numToAge(person.ageNum) +  "さいです。\n");
	}//End public static String getAgeInWords(Age person)
	
	//Return sentence of person's age in number format
	public static String getAgeInNumbers(Age person)
	{
		return ("人は"+ ASCIItoUnicode(person.ageNum) + "さいです。\n");
	}//end public static String getAgeInNumbers(Age person)
	
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
	}//end	public static String ASCIItoUnicode(int num)
	
	//Convert an integer value to string (months of the year)
	public static String monthIntToString (int monthInt)
	{
		switch(monthInt)
		{
		case 1: return "いちがつ";
		case 2: return "にがつ";
		case 3: return "さんがつ";
		case 4: return "しがつ";
		case 5: return "ごがつ";
		case 6: return "ろくがつ";
		case 7: return "しちがつ";
		case 8: return "はちがつ";
		case 9: return "くがつ";
		case 10: return "じゅうがつ";
		case 11: return "じゅういちがつ";
		case 12: return "じゅうにがつ";
		default: //User inputs a weird month
			return "ばつがつ";	//Returns an error month
		}
	}//	public static String monthIntToString (int monthInt)
	
	//Converts an integer value to a string (day of the month)
	public static String dayIntToString (int dayInt)
	{
		switch(dayInt)
		{
			case 1: return "ついたち";
			case 2: return "ふつか";
			case 3: return "みっか";
			case 4: return "よっか";
			case 5: return "いつか";
			case 6: return "むいか";
			case 7: return "なのか";
			case 8: return "ようか";
			case 9: return "ここのか";
			case 10: return "とおか";
			case 11: return "じゅういちにち";
			case 12: return "じゅうににち";
			case 13: return "じゅうさんにち";
			case 14: return "じゅうよっか";
			case 15: return "じゅうごにち";
			case 16: return "じゅうろくにち";
			case 17: return "じゅうしちにち";
			case 18: return "じゅうはちにち";
			case 19: return "じゅうくにち";
			case 20: return "はつか";
			case 21: return "にじゅういちにち";
			case 22: return "にじゅうににち";
			case 23: return "にじゅうさんにち";
			case 24: return "にじゅうよっか";
			case 25: return "にじゅうごにち";
			case 26: return "にじゅうろくにち";
			case 27: return "にじゅうしちにち";
			case 28: return "にじゅうはちにち";
			case 29: return "にじゅうくにち";
			case 30: return "さんじゅうにち";
			case 31: return "さんじゅういちにち";
			default: return "ばつか";
		}
	}//end public static String dayIntToString (int dayInt)
	
	//Convert integer value to a string (age)
	public static String numToAge (int num)
	{
		String ones = "";	//Ones place of age
		String tens = "";	//Tens place of age
		
		if (num == 0)
			return "ゼロ";
		if (num == 20)
			return "はたち";
		
		if (num>10)
		{
			switch(num/10)
			{
			case 1: tens = "じゅ"; break;
			case 2: tens = "にじゅ"; break;
			case 3: tens = "さんじゅ"; break;
			case 4: tens = "よんじゅ"; break;
			case 5: tens = "ごじゅ"; break;
			case 6: tens = "ろくじゅ"; break;
			case 7: tens = "ななじゅ"; break;
			case 8: tens = "はちじゅ"; break;
			case 9: tens = "きゅうじゅ"; break;
			}
			
			if (num%10 == 0)
				return tens + "っさい";
			else
				tens += "う";
		}
		
		switch (num%10)
		{
		case 1: ones = "いっ"; break;
		case 2: ones =  "に"; break;
		case 3: ones =  "さん"; break;
		case 4: ones =  "よん"; break;
		case 5: ones =  "ご"; break;
		case 6: ones =  "ろく"; break;
		case 7: ones =  "なな"; break;
		case 8: ones =  "はっ"; break;
		case 9: ones =  "きゅう"; break;
		}
		
		return tens + ones + "さい";
	}//public static String numToAge (int num)
	
	//Function to convert an integer value to Japanese cardinal numbers
	public static String intToCardinalString(int num)
	{
		String thousands = "";		//Thousands place of number
		String tens = "";			//Tens place of number
		String ones = "";			//Ones place of number
		String concatenate = "";	//Concatenation of all number places
		
		//Convert 0 to string and return it
		if (num == 0)
			return "ゼロ";
		
		//Debug
		System.out.printf("debug: thousands place is %d\n", (num - (num%1000))/1000);
		
		//Find the string for the number in its thousands place
		if (num >= 1000)
		{
			switch((num - (num%100)))
			{
				case 1900: thousands = "せんきゅうひゃく"; break;
				case 2000: thousands = "にせん"; break;
				default: break;
			}

			concatenate += thousands;
		}
		
		//Debug
		System.out.printf("debug: actual tens place is %d\n", (num%100 - num%10)/10);
		
		//Find the string for the number in its tens place
		if ((num%100 - num%10) >= 10 && (num%100 - num%10) <= 90)
		{
			switch (num%100 - num%10)
			{
				case 10: tens = "じゅう"; break;
				case 20: tens = "にじゅう"; break;
				case 30: tens = "さんじゅう"; break;
				case 40: tens = "よんじゅう"; break;
				case 50: tens = "ごじゅう"; break;
				case 60: tens = "ろくじゅう"; break;
				case 70: tens = "ななじゅう"; break;
				case 80: tens = "はちじゅう"; break;
				case 90: tens = "きゅうじゅう"; break;
				default: break;
			}
			
			concatenate += tens;
		}
		
		System.out.printf("debug: ones place is %d\n", num%10);
		
		//Find the string of the number for in its ones place
		if (num%10 >= 1 && num%10 <= 9)
		{
			switch (num%10)
			{
			case 1: ones = "いち"; break;
			case 2: ones =  "に"; break;
			case 3: ones =  "さん"; break;
			case 4: ones =  "よん"; break;
			case 5: ones =  "ご"; break;
			case 6: ones =  "ろく"; break;
			case 7: ones =  "しち"; break;
			case 8: ones =  "はち"; break;
			case 9: ones =  "きゅう"; break;
			}
			concatenate += ones;
		}
		return concatenate;
	}//end public static String intToCardinalString(int num)
}//end public class Hiragana extends Age