package fr.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

import fr.kata.bank.exception.InvalidOperationException;
import fr.kata.bank.model.Account;
import fr.kata.bank.model.Amount;

/**
 * The Main class
 * 
 * @author Skander
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account account = new Account();
		try {
			account.deposit(new Amount(BigDecimal.valueOf(3500)), LocalDate.parse("2019-11-05"));
			account.withdrawal(new Amount(BigDecimal.valueOf(200)), LocalDate.parse("2019-11-06"));
			account.withdrawal(new Amount(BigDecimal.valueOf(300)), LocalDate.parse("2019-11-06"));
			account.deposit(new Amount(BigDecimal.valueOf(200)), LocalDate.parse("2019-11-07"));
			System.out.println(account.seeHistory());
		} catch (InvalidOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
