package assignment_6_Accounts;

public class CheckingAccount extends BankAccount_Assign6 {

	private int transactionCount;
	private int FREE_TRANSACTIONS = 3;
	private double TRANSACTION_FEE = 2;
	private static int nextAccountNumber = 1000;
	
	/**This constructor sets up a checking account as a form of a bank account.
	 * The account number is determined by the program.
	 * @param initaccountHolder
	 * input the account holder here
	 * @param initBalance
	 * input the initial balance of the account here
	 */
	public CheckingAccount(String initaccountHolder, double initBalance)
	{
		super(nextAccountNumber, initaccountHolder, initBalance);
		nextAccountNumber++;
		transactionCount = 0;
	}
	
	/* (non-Javadoc)
	 * @see assignment_6_Accounts.BankAccount_Assign6#deposit(double)
	 */
	public void deposit(double deposit_amount)
	{
		super.deposit(deposit_amount);
		transactionCount = transactionCount + 1;
	}
	
	/* (non-Javadoc)
	 * @see assignment_6_Accounts.BankAccount_Assign6#withdraw(double)
	 */
	public void withdraw(double withdraw_amount)
	{
		super.withdraw(withdraw_amount);
		transactionCount = transactionCount + 1;
	}
	
	/**
	 * This method deducts the appropriate fees from the holder's account for doing too many transactions
	 */
	public void deductFees()
	{
		if (transactionCount > FREE_TRANSACTIONS)
		{
			double fee_Total = TRANSACTION_FEE * (transactionCount - 3);
			super.withdraw(fee_Total);
			transactionCount = 0;
		}
	}
	
}
