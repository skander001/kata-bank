package fr.kata.bank.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

/**
 * Tests the AccountStatement class
 * 
 * @author Skander
 *
 */
public class AccountStatementTest {
	/**
	 * Tests the method printAccountStatement
	 */
	@Test
	public void testMethodprintAccountStatement() {
		Transaction transaction = new Transaction(Amount.valueOf(BigDecimal.valueOf(3500)),
				LocalDate.parse("2019-11-03"), OperationType.DEPOSIT);
		AccountStatement accountStatement = new AccountStatement(transaction, Amount.valueOf(BigDecimal.valueOf(3500)));
		String expected = String.format("%-10s\t%s\n", transaction.printTransaction(),
				Amount.valueOf(BigDecimal.valueOf(3500)).format());
		assertEquals(expected, accountStatement.printAccountStatement());

	}

}
