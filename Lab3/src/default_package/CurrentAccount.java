//Alice

package default_package;

import java.util.*;

//I denna klass kollar vi vart pengar kommer ifrån och sen var de ska vidare
public class CurrentAccount extends Account {
	
	private SavingsAccount theSavingsAccount=null;
	
	//En dynamisk array som sparar int av transactions
	private ArrayList<Transaction> theTransactions;

	public CurrentAccount(Customer arg1, Bank arg2, double arg3) {
		super(arg1, arg2, arg3);
		arg1.addCurrentAccount(this);
		accountType = "Current";
		theTransactions = new ArrayList<Transaction>();

	}
	
	public boolean hasSavingsAccount() { //Testar om savings acc är kopplat till current acc.
		
		return theSavingsAccount != null;
	}
	
	public SavingsAccount createSavingsAccount() { //Testar om savings acc existerar, isåfall skrivs det ut och returnar null.
		//Om det inte finns skapas en "instance" av SavingsAccount och kopplas till theSavingsAccount sen skrivs det ut.
		//Returnernar adressen av savings acc.
		if (hasSavingsAccount()) {
			System.out.println("A savings account already exists");
			return null;
			}
		
		else {
			theSavingsAccount = new SavingsAccount(this);
			System.out.println("Added new savings account to the current account: " + accountNumber);
			return theSavingsAccount;
			
		}
	}
		
	
	
	public Customer getCustomer() {
		
		return theCustomer;
	}
	
	public Bank getBank() {
		
		return theBank;
	}
	
	public SavingsAccount getSavingsAccount() {
		
		return theSavingsAccount;
	}
	
//	lägger till mer till the balance
	public void send (double inDouble) {
		double toSave = inDouble;
		
		if (!hasSavingsAccount()) {
			System.out.println("No savings account exists");
		}
		
		else {
			if (inDouble > theBalance) {
				toSave = theBalance;
			}
		}
		
		theSavingsAccount.receive(toSave);
		theBalance = theBalance - toSave;
		Transaction transfer = new Transaction(theSavingsAccount.accountNumber, -toSave, theBalance);
		theTransactions.add(transfer);
	}
	
	//Kollar om det finns ett account number genom att kalla på metoden "get account"
	public void send (int inInt, double inDouble) {
		Account dummy = theBank.getAccount(inInt);
		
		if (theBank.getAccount(inInt) != null) {
			if (dummy.accountType.equals("Savings")) {
				System.out.println("This is not a current account!");
			}
			
			else {
				if (inDouble > theBalance); {
					inDouble = theBalance;
			}
			
//			Finns accountnumret så kallar programmet på recieve med accountnumber och indouble
			CurrentAccount dummy2 = (CurrentAccount) dummy;
			dummy2.receive(accountNumber, inDouble);
			theBalance = theBalance - inDouble;
			Transaction transfer = new Transaction(inInt, -inDouble, theBalance);
			theTransactions.add(transfer);
			}
		
		}
		
	}
	
//	Här flyttar man pengar mellan current acc och savings acc
	public void receive(double inDouble) {
		double send = theSavingsAccount.send(inDouble);
		theBalance = theBalance + send;
		Transaction transfer = new Transaction(theSavingsAccount.accountNumber, send, theBalance);
		theTransactions.add(transfer);
		
	}
//	lägger till pengar på ett konto
	public void receive(int inInt, double inDouble) {
		theBalance = theBalance + inDouble;
		Transaction transfer = new Transaction(inInt, inDouble, theBalance);
		theTransactions.add(transfer);
		
	}
	
//	Samlar alla transactions med en loop och skriver ut de rad för rad
	public String listTransactions() {
		String result = "\n\nTransaction summary of the current account: " + accountNumber;
		for (int i = 0; i < theTransactions.size(); i++) {
			result = result + "\n" + (theTransactions.get(i)).toString();
		}
		return result;
	}
	
//	Plussar på the balance med nya transaktionen som finns i arg
	public void payIn(double arg) {
		theBalance = theBalance + arg;
	}
	
}
