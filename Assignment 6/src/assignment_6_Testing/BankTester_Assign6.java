package assignment_6_Testing;

import java.util.Scanner;
import assignment_6_Bank.*;
import assignment_6_Accounts.*;

public class BankTester_Assign6 {
	
	public static void main(String[] args) 
	{
		Bank_Assign6 Reynolds_Bank = new Bank_Assign6();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter an account type (1 for CheckingAccount, 2 for SavingsAccount) or 0 to quit: ");
		int new_account_type = scan.nextInt();
		
		if (new_account_type != 1 && new_account_type != 2 && new_account_type != 0)
		{
			System.out.println("Sorry, invalid account type. Please try again. \n");
			System.out.println("Please enter an account type (1 for CheckingAccount, 2 for SavingsAccount) or 0 to quit: ");
			new_account_type = scan.nextInt();
		}
		if (new_account_type == 0)
		{
			System.out.println("************************************************************");
			System.out.println("Thank you for using the test program. Good-bye!");
			System.out.println("************************************************************");
			
		}
		
		while (new_account_type != 0)
		{
			//Did i do this correctly? for catching invalid input?
			if (new_account_type != 1 && new_account_type != 2)
			{
				System.out.println("Sorry, invalid account type. Please try again. \n");
				System.out.println("Please enter an account type (1 for CheckingAccount, 2 for SavingsAccount) or 0 to quit: ");
				new_account_type = scan.nextInt();
			}
			
			System.out.println("Please enter the account holder's first name: ");
			String first_Name = scan.next();
			System.out.println("Please enter the account holder's last name: ");
			String last_Name = scan.next();
			String accountHolder_Name = first_Name + " " + last_Name;
			System.out.println("Please enter an initial balance: ");
			double newBalance = scan.nextDouble();
			
			//do i need to ask for general account input in if statement or just once outside it so all if statements receive info?
			if (new_account_type == 1)
			{
				
				int new_Account_Number = Reynolds_Bank.add_Account(new_account_type, accountHolder_Name, newBalance);
				
				BankAccount_Assign6 checking_Account = Reynolds_Bank.get_BankAccount(new_Account_Number);
				
				System.out.println("Account added successfully. The new account number is " + new_Account_Number + "\n");
				
				System.out.println("Now, let's make two deposits. \n");
				
				for (int i = 0; i < 2; i++)
				{
					System.out.println("Please enter a deposit amount: ");
					try 
					{
						double deposit_amount = scan.nextDouble();
						checking_Account.deposit(deposit_amount);
						System.out.println("Thank you. Transaction successful.");
					}
					catch (IllegalArgumentException bad_input)
					{
						System.out.println(bad_input.getMessage());
					}
					
				}
				
				System.out.println("Now let's make two withdrawals");
				
				for (int i = 0; i < 2; i++)
				{
					System.out.println("Please enter a withdrawal amount: ");
					try 
					{
						double withdraw_amount = scan.nextDouble();
						checking_Account.withdraw(withdraw_amount);
						System.out.println("Thank you. Transaction successful.");
					}
					catch (IllegalArgumentException bad_input)
					{
						System.out.println(bad_input.getMessage());
					}
					
				}
				System.out.println("Transactions complete for account " + new_Account_Number);
				
				
			}
			
			if (new_account_type == 2)
			{
				
				//BankAccount_Assign6 new_Savings_Account = new SavingsAccount(accountHolder_Name, savings_Balance);
				// am i doing this right?
				int new_Account_Number = Reynolds_Bank.add_Account(new_account_type, accountHolder_Name, newBalance);
				
				BankAccount_Assign6 savings_Account = Reynolds_Bank.get_BankAccount(new_Account_Number);
				
				System.out.println("Account added successfully. The new account number is " + new_Account_Number + "\n");
				
				System.out.println("Now, let's make two deposits. \n");
				
				//For loop? or just have the same code twice?
				for (int i = 0; i < 2; i++)
				{
					System.out.println("Please enter a deposit amount: ");
					try 
					{
						double deposit_amount = scan.nextDouble();
					savings_Account.deposit(deposit_amount);
						System.out.println("Thank you. Transaction successful.");
					}
					catch (IllegalArgumentException bad_input)
					{
						System.out.println(bad_input.getMessage());
					}
					
				}
				
				System.out.println("Now let's make two withdrawals");
				
				for (int i = 0; i < 2; i++)
				{
					System.out.println("Please enter a withdrawal amount: ");
					try 
					{
						double withdraw_amount = scan.nextDouble();
						savings_Account.withdraw(withdraw_amount);
						System.out.println("Thank you. Transaction successful.");
					}
					catch (IllegalArgumentException bad_input)
					{
						System.out.println(bad_input.getMessage());
					}
					
				}
				System.out.println("Transactions complete for account " + new_Account_Number);
			}
			
			System.out.println("Please enter an account type (1 for CheckingAccount, 2 for SavingsAccount) or 0 to quit: ");
			new_account_type = scan.nextInt();
			
		}
		
		System.out.println("************************************************************");
		System.out.println("Account creation complete");
		System.out.println("************************************************************ \n");
		
		System.out.println("Finally, press any key and hit Enter to perform monthly maintenance and view all accounts. ");
		scan.next();
		
		System.out.println("Performing monthly maintenance on accounts...done \n");
		System.out.println("All bank accounts, sorted by balance from highest to lowest: ");
		Reynolds_Bank.processAccounts();
		Reynolds_Bank.formatAccounts();
		System.out.print(Reynolds_Bank.formatAccounts().toString() + "\n");
		
		System.out.println("************************************************************");
		System.out.println("Thank you for using the test program. Good-bye!");
		System.out.println("************************************************************");
	
		scan.close();
	}
	
}
