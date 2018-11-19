package assignment_6_Bank;

import java.util.ArrayList;
import java.util.Collections;


import assignment_6_Accounts.*;

public class Bank_Assign6 {
	
	private ArrayList<BankAccount_Assign6> accounts;
	public static int CHECKING_ACCOUNT = 1;
	public static int SAVINGS_ACCOUNT = 2;

	
	
	/**
	 * This constructor builds a bank account by initializes an array list to hold bank accounts
	 */
	public Bank_Assign6()
	{
		//Initializes a listarray set to store the objects of the class BankAccount
		accounts = new ArrayList<BankAccount_Assign6>();
	}

	
	
	/**This method adds the account to the bank with its type specification
	 * @param acctType
	 * inserts the number corresponding to the bank account type as a checking or savings
	 * @param acctHolder
	 * inserts the account holder's name here
	 * @param initBalance
	 * inserts the account holder's balance here
	 * @return
	 * returns account's number for later purposes
	 */
	public int add_Account(int acctType, String acctHolder, double initBalance)
	{
		if (acctType == CHECKING_ACCOUNT)
		{
			BankAccount_Assign6 new_account = new CheckingAccount(acctHolder, initBalance);
			accounts.add(new_account);
			return new_account.getAccountNumber();
		}
		else if (acctType == SAVINGS_ACCOUNT)
		{
			BankAccount_Assign6 new_account = new SavingsAccount(acctHolder, initBalance);
			accounts.add(new_account);
			return new_account.getAccountNumber();
		}
		return 0;
	}
	

	
	/**This method gets a bank account corresponding to the provided account's number
	 * @param acct_number
	 * the account number of the desired bank account is inserted here
	 * @return
	 * returns the correct bank account
	 */
	public BankAccount_Assign6 get_BankAccount(int acct_number)
	{
		//This for loop is looking through the accounts arraylist with BankAccounts in it
		for (int i = 0; i < accounts.size(); i++)
		{
			//found_number is temporarily storing the account number found within each subscript 
			//of the ArrayList for imminent comparison using a double method that pulls the object
			//from the ArrayList accounts and then pulls the account number from that object
			int found_number = accounts.get(i).getAccountNumber();
			if (acct_number == found_number)
			{
				//Accounts.get(i) is the current bank account being looked at in the accounts arraylist
				return accounts.get(i);
			}
		}
		// returns nothing if bank account is not found
		return null;
	}
	
	/**This method formats a string list of all accounts in the bank
	 * @return
	 * returns the formatted list of accounts
	 */
	public String formatAccounts()
	{
		Collections.reverse(accounts);
		String all_Accounts = "";
		if (accounts.isEmpty())
		{
			all_Accounts = "There are no accounts.";
		}
		else
		{
			for (int i = 0; i < accounts.size(); i++)
			{
				String this_account = accounts.get(i).toString();
				all_Accounts = all_Accounts + this_account;
			}
		}
		return all_Accounts;
	}
	
	/**
	 * This method processes the accounts by performing the duties corresponding to each type:
	 * savings accounts get interest and checking accounts get fees
	 */
	public void processAccounts()
	{
		for (int i = 0; i < accounts.size(); i++)
		{
			BankAccount_Assign6 process_account = accounts.get(i);
			if (process_account instanceof SavingsAccount)
			{
				((SavingsAccount) process_account).addInterest(process_account.getBalance());
			}
			
			else if (process_account instanceof CheckingAccount)
			{
				((CheckingAccount) process_account).deductFees();
			}
			
		}
	}


}
