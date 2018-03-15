package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import services.ATMService;
import services.ATMValue;
import services.Account;
import services.AccountService;

@RestController
public class RestProcessor {
	ATMService atmSer = new ATMService();
	AccountService accSer = new AccountService();

	@RequestMapping(value="/withdrawal", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody ATMValue withdrawal(@RequestParam("accId") int accId, @RequestParam("pin") int pin, @RequestParam("amount") int amount) {
		ATMValue resp = new ATMValue();
		Account acc = null;
		acc = accSer.accountCredsValid(resp, accId, pin);
		if( acc != null && accSer.accountIsFunded(resp, acc, amount)){
			if( atmSer.withDrawal(resp, amount)){
				// if the withdrawal is successful from the ATM then update the account balance
				if( amount > acc.getBalance()){
					// we need to '0' the balance and reduce the overdraft accordingly
					int origBal = acc.getBalance();
					acc.setBalance(0);
					acc.setOverDraft(acc.getOverDraft() - (amount - origBal));
				} else { //just reduce the balance
					acc.setBalance(acc.getBalance()-amount);
				}
				resp.setTotal(acc.getBalance());
				resp.setMessage("Transaction complete");
			}
		}
		return resp;
    }

	@RequestMapping(value="/balance", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ATMValue balance(@RequestParam("accId") int accId, @RequestParam("pin") int pin) {
		ATMValue resp = new ATMValue();
		Account acc = null;
		acc = accSer.accountCredsValid(resp, accId, pin);
		if( acc != null){
			resp.setTotal(acc.getBalance());
			resp.setMessage("Transaction complete");
		}
		return resp;
    }

}