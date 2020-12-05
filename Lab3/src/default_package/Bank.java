//Alice

package default_package;

import java.util.ArrayList;

public class Bank {

	private ArrayList<Account> theAccounts;
	private ArrayList<Customer> theCustomers;
	
//	Två stycken arrays som håller information om account resp. customer
	public Bank() {
		theAccounts = new ArrayList<Account>();
		theCustomers = new ArrayList<Customer>();
	}
	
//	Kollar om personen redan finns som kund
	public boolean hasCustomer(String arg) {
		boolean dummy = false;
		for (int i = 0; i < theCustomers.size(); i++) {
			if (theCustomers.get(i).getName().equals(arg)) {
				dummy = true;
			}
		}		
		return dummy;
	}
//	Om personen redan finns så skriver vi ut det, annars addar vi hen till stringen Customer.
	public void addCustomer(String arg) {
		if (hasCustomer(arg)) {
			System.out.println("The customer already exists.");
		}
		else {
			theCustomers.add(new Customer(arg));
			System.out.println("Customer added.");
		}
	}
	
//	Kollar om personen redan har ett konto, om inte så lägger vi till ett konto.
	public void addCurrentAccount(String arg1, double arg2) {
		if (hasCustomer(arg1)) {
			Customer dummy = getCustomer(arg1);
			if (dummy.hasCurrentAccount()) {
				System.out.println("The customer already has a current account.");
			}
			else {
				CurrentAccount newAccount = new CurrentAccount(dummy, this, arg2);
				theAccounts.add(newAccount);
				dummy.addCurrentAccount(newAccount);
				System.out.println("Added a account for " + dummy.getName());
			}
		}
		else {
			System.out.println("There is no customer with that name.");
		}
	}
	
	
	public Customer getCustomer(String arg) {
		if (!hasCustomer(arg)) return null;
		else {
			Customer dummy;
			int irun = 0;
			do {
				dummy = theCustomers.get(irun);
				irun++;
			} while (!dummy.getName().equals(arg));
			return dummy;
		}
	}
	
	//Här lägger vi till ett nytt savings-account till current-account. Kollar så namnet stämmer, sen sätter vi det vid theAccounts.
	public void addSavingsAccount(String inString) {
		if (hasCustomer(inString) && getCustomer(inString).getCurrentAccount().hasSavingsAccount()) {
			System.out.println("Savings account already exists");
		}
		
		else if (hasCustomer(inString)) {
			theAccounts.add(getCustomer(inString).getCurrentAccount().createSavingsAccount());
			
		}
		
		else {
			System.out.println("No customer with that name exists");
		}
		
	}
	
	//Söker ett account med argumenten som representerar nummret och returnerar det.
	public Account getAccount(int inInt) {
		for(int i=0; i < theAccounts.size(); i++) {
			if (theAccounts.get(i).accountNumber == inInt)
				return theAccounts.get(i);
		}
		System.out.println("No such account exists!");
		return null;
	}
	// Kallar på alla annual change i alla accounts som existerar
	public void computeAnnualChange() {
		for(int i=0; i < theAccounts.size(); i++) {
			(theAccounts.get(i)).annualChange();
		}
		
	}
	
	public void transfer(String arg1, String arg2, double arg3) {
		if (hasCustomer(arg1) && getCustomer(arg1).hasCurrentAccount()) {
			if (arg2.equals("save")) {
				if (!(getCustomer(arg1).getCurrentAccount().hasSavingsAccount())) {
					getCustomer(arg1).getCurrentAccount().getBank().addSavingsAccount(arg1);
				}
				getCustomer(arg1).getCurrentAccount().send(arg3);
			}
			
			else if (arg2.equals("withdraw")) {
				if (getCustomer(arg1).getCurrentAccount().hasSavingsAccount()) {
					getCustomer(arg1).getCurrentAccount().receive(arg3);
					
				}
				
			}

			else if (arg2.equals("external")) {
				getCustomer(arg1).getCurrentAccount().receive(0, arg3);
				
			}
			
			else if (arg2 != null) {
				getCustomer(arg1).getCurrentAccount().send(getCustomer(arg2).getCurrentAccount().getAccountNumber(), arg3);
					
			}
		}
	}
	
	public void transactions(String inString) {
		System.out.println(getCustomer(inString).getCurrentAccount().listTransactions());
	}
	
	
	public String toString() {
		String result = "\nBank information : ";
		double totalValue = 0.0;
		for (int i = 0; i < theAccounts.size(); i++) {
			totalValue = totalValue + theAccounts.get(i).getBalance();
		}
		
		result = result + "\nNumber of customers : " + theCustomers.size();	
		result = result + "\nNumber of accounts : " + theAccounts.size();
		result = result + "\nIt controls a total of " + totalValue;
		return result;
	}
}
