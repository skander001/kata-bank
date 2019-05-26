package fr.kata.bank.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.kata.bank.exception.InvalidOperationException;

/**
 * The Test of Account class
 * 
 * @author Skander
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	/**
	 * The AccountOperations
	 */
	@Mock
	private AccountOperations accountOperations;
	/**
	 * The Account
	 */
	@InjectMocks
	private Account account ;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test The method deposit
	 * @throws InvalidOperationException 
	 */
	@Test
	public void testMethodDeposit() throws InvalidOperationException {
		account.deposit(Amount.valueOf(BigDecimal.valueOf(1200)), LocalDate.parse("2019-11-05"));
		Mockito.verify(accountOperations).addTransaction(new Transaction(Amount.valueOf(BigDecimal.valueOf(1200)),
				LocalDate.parse("2019-11-05"), OperationType.DEPOSIT), Amount.valueOf(BigDecimal.valueOf(1200)));
	}
	
	/**
	 * Test The method deposit with null value of amount
	 * @throws InvalidOperationException 
	 */
	@Test(expected=InvalidOperationException.class)
	public void testMethodDepositWithNullValueOfAmount() throws InvalidOperationException {
		account.deposit(null, LocalDate.parse("2019-11-05"));
	}
	
	
	/**
	 * Test The method withdrawal
	 * @throws InvalidOperationException 
	 */
	@Test
	public void testMethodWithdrawal() throws InvalidOperationException {
		account.withdrawal(Amount.valueOf(BigDecimal.valueOf(200)), LocalDate.parse("2019-11-05"));
		Mockito.verify(accountOperations).addTransaction(new Transaction(Amount.valueOf(BigDecimal.valueOf(-200)),
				LocalDate.parse("2019-11-05"), OperationType.WITHDRAWAL), Amount.valueOf(BigDecimal.valueOf(-200)));
		
	}
	
	/**
	 * Test The method withdrawal with null value of amount
	 * @throws InvalidOperationException 
	 */
	@Test(expected=InvalidOperationException.class)
	public void testMethodWithdrawalWithNullValueOfAmount() throws InvalidOperationException {
		account.withdrawal(null, LocalDate.parse("2019-11-05"));
		
	}
	
	/**
	 * Test The method seeHistory
	 * @throws InvalidOperationException 
	 */
	@Test
	public void testMethodSeeHistory() throws InvalidOperationException {
		account.deposit(Amount.valueOf(BigDecimal.valueOf(3200)), LocalDate.parse("2019-11-05"));
		Mockito.when(accountOperations.printAllOperations()).thenReturn("Operation 	Date      	Amount    	Balance   \r\n" + 
				"DEPOSIT   	05/11/2019	3200,00    	3200,00");
		assertEquals("Operation 	Date      	Amount    	Balance   \r\n" + 
				"DEPOSIT   	05/11/2019	3200,00    	3200,00", account.seeHistory());
		
	}
}
