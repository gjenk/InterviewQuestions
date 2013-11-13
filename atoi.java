	public static int AtoI(String str)
	{
		boolean isNegative = (str.charAt(0) == '-');
		int out = 0;
		for (int i = 0; i < str.length(); i++)
		{
			int value = ((int)str.charAt(i)) - '0';
			if (value < 0 || value > 9)
				continue;
			out *= 10;
			out += value;
		}
		if(isNegative)
			out *= -1;
		
		return out;		
	}