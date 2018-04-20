import services.ATMValue;
import services.Account;
import services.AccountService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple AccountService.
 */
public class TestAccountService
    extends TestCase
{
    	public static Test suite()
    	{
        	return new TestSuite( TestAccountService.class );
    	}

	public void testAccountIsFunded() {
		AccountService ser = new AccountService();
		ATMValue resp = new ATMValue();
		Account acc = new Account();
		acc.setBalance(10);
		assertTrue(ser.accountIsFunded(resp, acc, 10));
	}

	public void testAccountIsNotFunded() {
		AccountService ser = new AccountService();
		ATMValue resp = new ATMValue();
		Account acc = new Account();
		acc.setBalance(9);
		assertFalse(ser.accountIsFunded(resp, acc, 10));
	}
	public void testAccountCredsValid() {
		AccountService ser = new AccountService();
		ATMValue resp = new ATMValue();
		assertNotNull(ser.accountCredsValid(resp, 123456789, 1234));
	}

	public void testAccountCredsInvalid() {
		AccountService ser = new AccountService();
		ATMValue resp = new ATMValue();
		assertNull(ser.accountCredsValid(resp, 123456789, 1235));
	}
}

