package fr.kata.bank.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Class to test the class Amount
 * 
 * @author Skander
 *
 */
public class AmountTest {
	/**
	 * Ensures that a {@link NullPointerException} will be thrown if the value of
	 * amount is null
	 */
	@Test
	public void exceptionShouldBeThrownWhenValueIsNull() {
		Amount amount = new Amount(null);
		assertEquals(new Amount(BigDecimal.ZERO), amount);
	}
	
	/**
	 * Ensures that a {@link Amount} will be created if the value of
	 * amount is not null
	 */
	@Test
	public void amountShouldBeCreatedWhenValueIsNotNull() {
		Amount amount = new Amount(BigDecimal.valueOf(500.36));
		assertNotNull(amount);
	}
	/**
	 * Test the method add of amount
	 */
	@Test
	public void testMethodAddNonNullValueOfAmount() {
		Amount amount = new Amount(BigDecimal.valueOf(1200.50));
		Amount otherAmount = new Amount(BigDecimal.valueOf(300.25));
		Amount newAmount = amount.add(otherAmount);
		
		assertEquals(new Amount(BigDecimal.valueOf(1500.75)), newAmount);
	}
	/**
	 * Test the method add of amount
	 */
	@Test
	public void testMethodAddNullValueOfAmount() {
		Amount amount = new Amount(BigDecimal.valueOf(1200.50));
		Amount newAmount = amount.add(null);
		
		assertEquals(new Amount(BigDecimal.valueOf(1200.50)), newAmount);
	}
	/**
	 * Test the method negate
	 */
	@Test
	public void testMethodNegate() {
		Amount amount = new Amount(BigDecimal.valueOf(1200));
		assertEquals(new Amount(BigDecimal.valueOf(-1200)), amount.negate());
		amount = new Amount(BigDecimal.valueOf(-1200));
		assertEquals(new Amount(BigDecimal.valueOf(-1200)), amount.negate());
	}
	
	/**
	 * Test the method format
	 */
	@Test
	public void testMeThodFormat() {
		Amount amount = new Amount(BigDecimal.valueOf(300.568));
		assertEquals("300,57", amount.format());
	}

}
