
public class Account {
	int balance;
	static final int MIN_BALANCE=0;
	static final int MAX_BALANCE=1000000;
	
	public Account() {			}
	
	void setBalance(int balance) {
		if(balance>=0 && balance<=1000000)  {
			this.balance=balance;
		}
	}
	
	int getBalance() {
		return balance;
	}
}	
