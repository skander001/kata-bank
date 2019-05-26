package fr.kata.bank.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import fr.kata.bank.exception.InvalidOperationException;

/**
 * The Account Class
 * 
 * @author Skander
 *
 */
public class Account {
	/**
	 * The balance of account
	 */
	private Amount balance = Amount.valueOf(BigDecimal.ZERO);
	/**
	 * The AccountOperations
	 */
	private AccountOperations accountOperations;

	/**
	 * The constructor
	 * 
	 */
	public Account() {
		accountOperations = new AccountOperations();
	}

	/**
	 * Deposit a amount in the account
	 * 
	 * @param amount The amout to deposit
	 * @param date   The date of deposition
	 * @throws InvalidOperationException throw exception if amount is null
	 */
	public void deposit(Amount amount, LocalDate date) throws InvalidOperationException {
		if (amount == null) {
			throw new InvalidOperationException(OperationType.DEPOSIT.name());
		}
		addOperation(amount, date, OperationType.DEPOSIT);
	}

	/**
	 * Withdrawal a amount from the account
	 * 
	 * @param amount The amount to deposit
	 * @param date   The date of deposition
	 * @throws InvalidOperationException throw exception if amount is null
	 */
	public void withdrawal(Amount amount, LocalDate date) throws InvalidOperationException {
		if (amount == null) {
			throw new InvalidOperationException(OperationType.WITHDRAWAL.name());
		}
		addOperation(amount.negate(), date, OperationType.WITHDRAWAL);
	}

	/**
	 * 
	 * @param amount        The amount
	 * @param date          The date
	 * @param operationType The OperationType
	 */
	private void addOperation(Amount amount, LocalDate date, OperationType operationType) {
		balance = balance.add(amount);
		Transaction transaction = new Transaction(amount, date, operationType);
		accountOperations.addTransaction(transaction, balance);
	}

	/**
	 * see the history (operation, date, amount, balance) of all operations
	 * 
	 * @return
	 */
	public String seeHistory() {
		return accountOperations.printAllOperations();
	}

}
