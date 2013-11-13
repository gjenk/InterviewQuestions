	// accepts an integer and returns true if the integer is a palindrome
	public static boolean integerIsPalindrome( int n)
	{
		Stack<Integer> first = new Stack<Integer>();
		Stack<Integer> second = new Stack<Integer>();
		
		int temp;
		while( n != 0 )
		{
			temp = n % 10;
			first.push(temp);
			n = n / 10;
		}
		int stackSize = first.size();
		
		for( int i = 0; i < stackSize/2; i++)
		{
			second.push(first.pop());
		}
		if (stackSize % 2 == 1)
			first.pop();
		
		while (!first.isEmpty()){
			if(first.pop() != second.pop())
				return false;
		}
		return true;
	}