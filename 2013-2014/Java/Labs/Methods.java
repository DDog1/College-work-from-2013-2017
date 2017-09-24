class Methods
{
	public static void main(String args[])
	{
		System.out.println("Please enter account code:");
		String  accCode = Keyboard.readString();

		String account = getAccountType(accCode);
		System.out.println(account);


	}

	public static String getAccountType(String accountType)
	{

		if (accountType.equals("1"))
			return "Current Account";
		else if (accountType.equals("2"))
			return "Savings Account";
		else if (accountType.equals("3"))
			return "Credit Account";
		else
			return "Unknown Accout";

	}


}