//Alice

package default_package;

//Använder denna klass för att kalla på cunstructorn i superclassen
//implementerar accounttype till savings
	
//sätter värdet på savings till 0;

public class SavingsAccount extends Account{
	

	public SavingsAccount(CurrentAccount arg) {
	super(arg.getCustomer(), arg.getBank(), 0.0);
	accountType = "Savings";
	
	}

	public void receive(double inDouble) {
		theBalance = theBalance + inDouble;
	}
	
	public double send(double inDouble) {
		double toSave = inDouble;
		
		if (toSave > theBalance) {
			toSave = theBalance;
		}
		theBalance = theBalance - toSave;
		
		return toSave;
	}
}
