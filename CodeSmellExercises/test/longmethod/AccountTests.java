package longmethod;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class AccountTests {
	
	@Test
	public void debitingAccountShouldDeductAmountFromBalanceRecordTransactionAndUpdateLastdebitDate() throws Exception {
		Account account = new Account();
		account.credit(100);
		account.debit(50);
		assertEquals(50, account .getBalance(), 0);
		Transaction lastTransaction = account.getLastTransaction();
		assertTrue(lastTransaction.isDebit());
		assertEquals(50, lastTransaction.getAmount(), 0);

		Calendar calendar = Calendar.getInstance();
		
		assertEquals(calendar.get(Calendar.DATE) + "/" +
				calendar.get(Calendar.MONTH) + "/" + 
				calendar.get(Calendar.YEAR),
				account.getLastDebitDate());
	}
	
	@Test
	public void creditingAccountShouldAddAmountToBalance() throws Exception {
		Account account= new Account();
		account.credit(50);
		assertEquals(50, account.getBalance(), 0);
	}

}
