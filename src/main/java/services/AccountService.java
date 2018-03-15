package services;

import java.util.ArrayList;

public class AccountService {
	ArrayList <Account> accList = new ArrayList<Account>(){{
		add(new Account(123456789,1234,800,200));
		add(new Account(987654321,4321,1230,150));
	}};

	public AccountService() {
	}

	public boolean accountIsFunded(ATMValue resp, Account acc, int amount) {
		if( amount > (acc.getBalance() + acc.getOverDraft())){
			resp.setMessage("Account has insufficient funds");
			return false;
		}
		return true;
	}

	public Account accountCredsValid(ATMValue resp, int accId, int pin ) {
		boolean accFound = false;
		for( Account acc : accList){
			if( !accFound && acc.getAccNumber() == accId){
				accFound = true;
				if( acc.getPIN() == pin){
					return acc;
				}
			}
		}
		resp.setMessage("Account not found with these credentials");
		return null;
	}



}
