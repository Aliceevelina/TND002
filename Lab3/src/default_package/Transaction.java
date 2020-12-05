package default_package;


//Här sparar vi information om varje transfer

public class Transaction {

	private int otherAccount;
	private double money;
	private double balance;
	
//	Här sparas transfered money i variabeln money, detta är den slutgiltiga balance efter plussning
	public Transaction(int arg1, double arg2, double arg3) {
		otherAccount = arg1;
		money = arg2;
		balance = arg3;
	}

//	Sen skrivs det ut
	public String toString() {
		String result = String.format("\nAccount: %2d \nTRansfered money: %7.2f \nBalance: %7.2f"
										,otherAccount, money, balance);
		
		return result;		
				
	}
}
