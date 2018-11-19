package assignment_6_Accounts;

import java.util.ArrayList;

public abstract class BankAccount_Assign6 implements Comparable<BankAccount_Assign6>{
	
	//Private instance variables
		private int accountNumber;
		private double balance;
		private String accountHolder;
		private ArrayList<Double> transactions;
		private int total_transactions;
		

		//One Constructor for initialization
		
		/**This constructs a bank account object from a number, holder, and balance and initializes variables
		 * @param initAccountNumber input the account number here, this is assigned by the program
		 * @param acctHolder the holder's name is input here
		 * @param initBalance the initial balance for the account is input here
		 */
		public BankAccount_Assign6(int initAccountNumber, String acctHolder, double initBalance)
		{
			accountNumber = initAccountNumber;
			balance = initBalance;
			accountHolder = acctHolder;
			transactions = new ArrayList<Double>();
		}
		
		/**This method gets the name of the account holder
		 * @return returns account holder's name
		 */
		public String getAccountHolder()
		{
			return accountHolder;
		}
		
		/** This method retrieves the account number of the Bank Account
		 * @return
		 * returns account number
		 */
		public int getAccountNumber()
		{
			return accountNumber;
		}
		
		/**This method retrieves the balance of the Bank Account
		 * @return
		 * returns the balance of the account
		 */
		public double getBalance()
		{
			return balance;
		}
		
		/**This method deposits the user-specified value into the account(the balance)
		 * Exception clauses are in place for negative or zero deposits
		 * Entering a negative or zero will throw out the number
		 * @param dep_amount
		 * This parameter is the amount you would like to deposit
		 */
		public void deposit(double dep_amount)
		{
			if (dep_amount <= 0)
			{
				throw new IllegalArgumentException("A zero or negative number is not allowed! You've lost a deposit transaction.");
			}
			else
			{
				transactions.add(dep_amount);
				balance = balance + dep_amount;
				total_transactions = total_transactions + 1;
			}
			
		}
		
		/**This method withdraws the specified amount from the previously selected bank account
		 * Has an exception clause in order to prevent overdrawing
		 * @param with_amount
		 * Enter the amount to withdrawal in this parameter
		 */
		public void withdraw(double with_amount)
		{
			if (with_amount > balance)
			{
				throw new IllegalArgumentException("Cannot withdraw what you don't have ya broke fool, try again");
			}
			else
			{
			transactions.add(-with_amount);
			balance = balance - with_amount;
			total_transactions = total_transactions + 1;
			}
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 * Overrides Java Lang's comparable method with our own sorting method
		 */
		public int compareTo(BankAccount_Assign6 other)
		{
			BankAccount_Assign6 otherbank = (BankAccount_Assign6) other;
			if (balance < otherbank.balance) {return -1; }
			if (balance > otherbank.balance) {return 1; }
			if (balance == otherbank.balance) {return 0; }
			return 0;
		}
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 * Overrides Java Lang's toString formatting with our own
		 */
		public String toString()
		{
			return getClass().getSimpleName() + " #" + getAccountNumber() + " owned by " + getAccountHolder() + ": " + String.format("$% .2f", getBalance()) + ". \n";
		}

}
