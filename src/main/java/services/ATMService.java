package services;

public class ATMService {
	private static ATMValue currentValue = new ATMValue();

	public ATMService(){
		currentValue.setTotal(2000);
		currentValue.setFifties(20);
		currentValue.setTwenties(30);
		currentValue.setTens(30);
		currentValue.setFives(10);
	}

	public boolean withDrawal(ATMValue resp, int txnAmount){
		boolean rtn = false;
		if(currentValue.getBalance() < txnAmount) {
			resp.setMessage("ATM has insufficient funds.");
		} else if( txnAmount % 5 > 0){
			resp.setMessage("Withrawal amount invalid.");
		} else {
			processWithDrawal(txnAmount, resp);
			rtn = true;
		}
		return rtn;
	}

	private void processWithDrawal(int txnAmount, ATMValue resp) {
		int remainingTxnAmount = txnAmount;
		remainingTxnAmount -= processFifties(remainingTxnAmount, resp);
		remainingTxnAmount -= processTwenties(remainingTxnAmount, resp);
		remainingTxnAmount -= processTens(remainingTxnAmount, resp);
		remainingTxnAmount -= processFives(remainingTxnAmount, resp);
	}

	private int processFives(int txnAmount, ATMValue resp) {
		int demoninationAmt = 0;
		if(( txnAmount >= 5) && currentValue.getFives() > 0){
			int countNeeded = txnAmount/5;
			if(countNeeded <= currentValue.getFives()){
				resp.setFives(countNeeded);
				// Reduce the count and the overall ATM balance
				currentValue.setFives(currentValue.getFives()- countNeeded);
				currentValue.setTotal(currentValue.getBalance() - countNeeded * 5);
				// reduce the overall balance of the withdrawal needed to parse
				demoninationAmt = countNeeded * 5;
			}
		}
		return demoninationAmt;
	}

	private int processTens(int txnAmount, ATMValue resp) {
		int demoninationAmt = 0;
		if(( txnAmount >= 10) && currentValue.getTens() > 0){
			int countNeeded = txnAmount/10;
			if(countNeeded <= currentValue.getTens()){
				resp.setTens(countNeeded);
				// Reduce the count and the overall ATM balance
				currentValue.setTens(currentValue.getTens()- countNeeded);
				currentValue.setTotal(currentValue.getBalance() - countNeeded * 10);
				// reduce the overall balance of the withdrawal needed to parse
				demoninationAmt = countNeeded * 10;
			}
		}
		return demoninationAmt;
	}

	private int processTwenties(int txnAmount, ATMValue resp) {
		int demoninationAmt = 0;
		if(( txnAmount >= 20) && currentValue.getTwenties() > 0){
			int countNeeded = txnAmount/20;
			if(countNeeded <= currentValue.getTwenties()){
				resp.setTwenties(countNeeded);
				// Reduce the count and the overall ATM balance
				currentValue.setTwenties(currentValue.getTwenties()- countNeeded);
				currentValue.setTotal(currentValue.getBalance() - countNeeded * 20);
				// reduce the overall balance of the withdrawal needed to parse
				demoninationAmt = countNeeded * 20;
			}
		}
		return demoninationAmt;
	}

	private int processFifties(int txnAmount, ATMValue resp) {
		int demoninationAmt = 0;
		if(( txnAmount >= 50) && currentValue.getFifties() > 0){
			int countNeeded = txnAmount/50;
			if(countNeeded <= currentValue.getFifties()){
				resp.setFifties(countNeeded);
				// Reduce the count of 50s and the overall ATM balance
				currentValue.setFifties(currentValue.getFifties()-countNeeded);
				currentValue.setTotal(currentValue.getBalance() - countNeeded * 50);
				// reduce the overall balance of the withdrawal needed to parse
				demoninationAmt = countNeeded * 50;
			}
		}
		return demoninationAmt;
	}
}
