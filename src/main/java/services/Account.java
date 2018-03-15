package services;

public class Account {
	private int accNumber = 0;
	private int PIN = 0;
	private int overDraft = 0;
	private int balance = 0;

	Account(int accNum, int pin, int bal, int oDraft){
		setAccNumber(accNum);
		setPIN(pin);
		setOverDraft(oDraft);
		setBalance(bal);
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public int getPIN() {
		return PIN;
	}
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	public int getOverDraft() {
		return overDraft;
	}
	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
