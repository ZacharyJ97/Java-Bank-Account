package assignment_6_Accounts;

public class SavingsAccount extends BankAccount_Assign6 {
	
	//static to make this statement in second constructor work?
	private double interestRate;
	private static int nextAccountNumber = 5000;
	private static double DEFAULT_RATE = .01;
	
	/**This constructs a savings account as a form of a bank account
	 * @param initAccountHolder
	 * inputs the account holder's name here
	 * @param initBalance
	 * inputs the balance for the account here
	 * @param rate
	 * inputs the rate for interest to be added to the account
	 */
	public SavingsAccount(String initAccountHolder, double initBalance, double rate)
	{
		super(nextAccountNumber, initAccountHolder, initBalance);
		interestRate = rate;
		nextAccountNumber++;
	}
	
	/**This savings account is actually used because it initializes the previous
	 * constructor's savings account but with the rate filled in as a fixed rate
	 * as a bank usually does.
	 * @param initAccountHolder
	 * input the name of the account holder here
	 * @param initBalance
	 * input the balance for the account here
	 */
	public SavingsAccount(String initAccountHolder, double initBalance)
	{
		this(initAccountHolder, initBalance, DEFAULT_RATE);
	}
	
	/**This method calculates and adds interest to the savings account using a set rate
	 * @param amount
	 * input the amount in the bank account to use in calculating interest
	 */
	public void addInterest(double amount)
	{
		double interest = interestRate * amount;
		this.deposit(interest);
	}

}
