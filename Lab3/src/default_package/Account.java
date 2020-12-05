//Alice

package default_package;

public class Account {

	protected Customer theCustomer;
	protected int accountNumber;
	protected String accountType;
	protected double theBalance;
	protected Bank theBank;
	
	private static int availableNumbers = 0;
	public static double CURRENTACCOUNTFEE = 10.0;
	public static double SAVINGSINTEREST = 0.01;
	
	public Account(Customer arg1, Bank arg2, double arg3) {
		theCustomer = arg1;
		theBalance = arg3;
		theBank = arg2;
		availableNumbers = availableNumbers + 1;
		accountNumber = availableNumbers;
		
		
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return theBalance;
	}
	
	
	public void annualChange() { //Test if the object is a current account ("current") or a savings account ("savings")
		if (accountType.equals("Current")) {
			theBalance = theBalance - CURRENTACCOUNTFEE;
		}
		else if (accountType.contentEquals("Savings")) {
			theBalance = theBalance + SAVINGSINTEREST;
		}
		
//		Calling the method subtracts CURRENTACCOUNTFEE from the value of the instance variable theBalance if the object is a currentacc
//		If the obj is a savings account then it adds the interest to theBalance
	}
	
//	String för vad som ska skrivas ut för alla account
	public String toString() {
		String result = "\n******************************"; 
		result = result + "\nAccount number : " + accountNumber;
		result = result + "\nCustomer : " + theCustomer.getName();
		result = result + "\nBalance : " + theBalance;
		result = result + "\n******************************";
		
		if (theCustomer.getCurrentAccount().hasSavingsAccount()) {
			result = result + "\nSavings account";
			result = result + "\nAccount number: " + theCustomer.getCurrentAccount().getSavingsAccount().accountNumber;
			result = result + "\nBalance : " + theCustomer.getCurrentAccount().getSavingsAccount().theBalance;
			result = result + "\n******************************\n";
		}
		
		return result;
	}
}
