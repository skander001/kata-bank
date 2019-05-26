package fr.kata.bank.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

/**
 * Test the Transaction class
 * 
 * @author Skander
 *
 */
public class TransactionTest {
	/**
	 * Tests the method printTransaction
	 */
	@Test
	public void testMethodPrintTransaction() {
		Transaction transaction = new Transaction(Amount.valueOf(BigDecimal.valueOf(3500)),
				LocalDate.parse("2019-11-03"), OperationType.DEPOSIT);
		String expected = String.format("%-10s\t%-10s\t%-10s", OperationType.DEPOSIT, "03/11/2019", Amount.valueOf(BigDecimal.valueOf(3500)).format());
		assertEquals(expected, transaction.printTransaction());

	}
}
