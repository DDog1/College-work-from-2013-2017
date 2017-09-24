/********************************************************************************************/
/*	Name : Darren Cosgrave																	*/
/*	Date : 6 / December / 2013																*/
/*	Program name : Debit Card																*/
/*	Description : 	A java program that acts like a Debit Card system for a bank customer	*/
/********************************************************************************************/
class DebitCard
	{
		static String username;	//Variables
		static String password;
		static double balance = 0;

//Start method

		public static void main(String[] args)
			{
				usernameScreen();
				System.out.println("+------------------------------------------------------+");				//The welcome message, the user gets, if the enter in the right username and password
				System.out.println("|------------------ Hello : " +username+ " --------------------|");
				System.out.println("|------------ Thank you for using this ATM ------------|");
				System.out.println("+------------------------------------------------------+");
				System.out.println("");

				options();
			}

//End of start method

//User login
				static void usernameScreen()							//Were the user enters his or her name to login to there account
					{
						String usernameinput = "Darren";				//The username

						System.out.println("Please enter username : ");
						username = Keyboard.readString();

						System.out.println(" "); 						//Puts a space in to make it look clear after the user enters the name in

						if(username.equalsIgnoreCase(usernameinput))	//If the username is right
						{
							passwordScreen();
							username = "Darren";						//The username
						}
						else
						{
							System.out.println("The username you have entered is wrong");	//If the user enters in the wrong name, it go's back into the username login
							usernameScreen();
						}
					}

//End of user login

//Password input

				static void passwordScreen()						//Password of the user's account
					{
						String passwordinput = "Darren";			//The password

						System.out.println("Please enter your pin");
						password = Keyboard.readString();

						System.out.println(" ");	//Makes a space to clear it up after the user enters the password in
						System.out.println(" ");

						if(password.equals(passwordinput))	//If the password is right
						{

						}
						else
						{
							System.out.println("The password you have entered is wrong");	//If the user enters in the wrong password, it go's back into the password login
							passwordScreen();
						}
					}

//End of password input

//Options the user has to pick from

				static void options()
					{
						int options;	//Variables
						double moneyout;
						double moneyin;
						int credit;

						System.out.println(" ");
						System.out.println("Would you like to check one of the following ? : ");
						System.out.println(" ");
						System.out.println("+-------------------+");				//Options the user has to pick from
						System.out.println("| 1 | Withdraw      |");
						System.out.println("|---+---------------|");
						System.out.println("| 2 | Check Balance |");
						System.out.println("|---+---------------|");
						System.out.println("| 3 | Details       |");
						System.out.println("|---+---------------|");
						System.out.println("| 4 | Deposit       |");
						System.out.println("|---+---------------|");
						System.out.println("| 5 | Top up        |");
						System.out.println("|---+---------------|");
						System.out.println("| 6 | Exit          |");
						System.out.println("+-------------------+");
						System.out.println();
						System.out.print("Please select one of the following : ");

						options = Keyboard.readInt();	//Reads in the options the user enters in from 1-6

						System.out.println(" ");	//Puts in a space and a line to make it look clear were the user is
						System.out.println("+------------------------------------------------------+");

//Withdraw option

						if(options == 1)	//The withdraw option allows the user to take out the amount of money they want, but they have to have some money on there account to do so
							{
								System.out.println(" ");
								System.out.print(" How much are you withdrawing today : ");		//Asks you how much you would like to take out of your account
								moneyout = Keyboard.readDouble();		//Reads how much you want to take out
								balance = balance - moneyout;	//This take out money from the balance


								if(balance < 0)						//If the balance is 0 the user gets refunded
								{
									System.out.println(" You don't have enough in your account to take out this amount : " +moneyout);
									balance = balance + moneyout;		//Adds the money that the user tried to take out so it makes it back to 0 instead of -0 value
								}

								else if(balance < -1)
								{
									System.out.println(" Error you can't take out money, your amount must be bigger than 0.");
									balance = balance - moneyout;
								}
								else
								{
									System.out.println(" You've withdrawn : " +moneyout);		//Tells the user how much they withdrawn
								}
								System.out.println(" ");
								System.out.println("+------------------------------------------------------+");

								options();	//Displays the options menu
							}

//Check Balance option

						else if(options == 2)							//The check balance option allows the user to see how much they have there account
							{
								System.out.println("|                                                      |");
								System.out.println("            Your balance is : " +balance);			//Shows the user how much they have in the account
								System.out.println("|                                                      |");
								System.out.println("+------------------------------------------------------+");

								options();	//Displays the options menu
							}

//Details option

							else if(options == 3)	//The details option allows the user to look at there personal information
							{
								System.out.println(" ");
								System.out.println("+------------------------------------------------------+");
								System.out.println("|------------------ User details ----------------------|");
								System.out.println("|------------- Username : " +username+ " ----------------------|");		//Displays the username
								System.out.println("|------------------ Pin : " +password+ " ----------------------|");		//Displays the users password
								System.out.println("|---------- Card number : 1234-1234-1234 --------------|");
								System.out.println("+------------------------------------------------------+");
								System.out.println(" ");

								options();	//Displays the options menu
							}

//Deposit option

						else if(options == 4)	//The deposit option allows the user to put money into there account
							{
								System.out.println(" ");
								System.out.print(" How much are you depositing today : ");	//Asks you how much you would like to put in to your account
								moneyin = Keyboard.readDouble();		//Reads how much you want to put in
								if(moneyin > 100)
								{
									System.out.println(" Sorry we can't take big amounts over 100");	//Tells you that the bank can't take over 100
									System.out.println(" The amount " +(moneyin - 100)+ " has being refunded.");	//This gives the user back how much they went over, like 101, so they get 1 back
									balance = balance + 100;	//Adds 100 to balance
								}

									else
									{
										System.out.println(" You've deposit : " +moneyin);	//If all is ok they add in that amount of money into your account, if it's under a 100
										balance = balance + moneyin;		//Adds any amount under 100
									}

								if(balance > 1000)
								{
									System.out.println(" Sorry the maximum amount we can take is 1000");	//If the user's account bank balance is over 1000 and they try to put in more that 1000 they get the refund of how much they went over
									System.out.println(" The amount " +(balance - 1000)+ " has being refunded.");
									balance = 1000;			//Makes the balance 1000
								}
									System.out.println(" ");
									System.out.println("+------------------------------------------------------+");

									options();	//Displays the options menu
							}

//Top up option

						else if(options == 5)
							{
									System.out.println(" How much would you like to top up your mobile phone : ");


									System.out.println("+---+-------------------------------------------------------------------------+");	//The options the user has to pick from
									System.out.println("| 1 | by toping up 5 you will get free texts for 15 days                      |");
									System.out.println("+---+-------------------------------------------------------------------------+");
									System.out.println("| 2 | by toping up 10 you will get free calls to any meteor phone for 30 days |");
									System.out.println("+---+-------------------------------------------------------------------------+");
									System.out.println("| 3 | by toping up 20 you will get free calls and texts to any meteor phone   |");
									System.out.println("|   | for 30 days                                                             |");
									System.out.println("+---+-------------------------------------------------------------------------+");

									System.out.print(" Please select one of the following : ");

									credit = Keyboard.readInt();	//Reads what option they picked, from 1-3

									System.out.println("+------------------------------------------------------+");

									if(credit == 1 && balance > 0)	//If the balance is more than 0 and the user picks 1
									{
										System.out.println("|---------- Thank you, you have toped up by 5 ---------|");
										balance = balance - 5;	//Takes 5 out of your balance
									}

									else if(credit == 2 && balance > 0)	//If the balance is more than 0 and the user picks 2
									{
										System.out.println("|---------- Thank you, you have toped up by 10 --------|");
										balance = balance - 10;	//Takes 10 out of your balance
									}

									else if(credit == 3 && balance > 0)	//If the balance is more than 0 and the user picks 3
									{
										System.out.println("|---------- Thank you, you have toped up by 20 --------|");
										balance = balance - 20;	//Takes 20 out of your balance
									}
									else if(balance < credit)	//If the balance is less than the credit
									{
										System.out.println(" Sorry you don't have enough money in your account to buy this");	//If the user enters in one of the options but doesn't have enough in there account
									}
									else
									{
										System.out.println("|---- Sorry that is not an option please try again ----|");	//If the user enters in a number or character bar 1-3
									}

									System.out.println("+------------------------------------------------------+");

									options();	//Displays the options menu
							}



//Exit option

						else if(options == 6)	//The exit option allows the user to leave
							{
								System.out.println(" ");
								System.out.println("+------------------------------------------------------+");	//A thank you message the user gets is they enter 6
								System.out.println("|----------- Thank you for using this ATM -------------|");
								System.out.println("+------------------------------------------------------+");
								System.out.println(" ");
							}

						else
						{
							System.out.println("|---- Sorry that is not an option please try again ----|");	//If the user enters in a number or character bar 1-6
							System.out.println("+------------------------------------------------------+");

							options();	//Displays the options menu
						}

			}//End main

}//End class