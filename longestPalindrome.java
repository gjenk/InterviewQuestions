// returns the longest palindrome within a string
	public static String longestPalindrome(String str)
	{
		if (str.length() == 0)
			return null;
		
		int first = 0;
		int last = 0;
		int firstLongest = 0;
		int lastLongest = 0;
		
		for (int i = 0; i < str.length(); i++)
		{
			first = i;
			last = i;
			while(first >= 0 && last < str.length())
			{
				if (str.charAt(first) != str.charAt(last))
					break;
				if((lastLongest - firstLongest) <= (last - first))
				{
					firstLongest = first;
					lastLongest = last;
				}
				first--;
				last++;
			}
			
			first = i;
			last = i + 1;
			while(first >= 0 && last < str.length() )
			{
				if (str.charAt(first) != str.charAt(last))
					break;
				if((lastLongest - firstLongest) <= (last - first))
				{
					firstLongest = first;
					lastLongest = last;
				}
				first--;
				last++;
			}
		}
			
		return str.substring(firstLongest, lastLongest + 1);
	}