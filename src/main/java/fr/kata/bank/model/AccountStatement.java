package fr.kata.bank.model;

/**
 * The AccountStatement
 * 
 * @author Skander
 *
 */
public class AccountStatement {
	/**
	 * The Transaction
	 */
	private Transaction transaction;
	/**
	 * The balance
	 */
	private Amount balance;

	/**
	 * The constructor
	 * 
	 * @param transaction
	 * @param balance
	 */
	public AccountStatement(Transaction transaction, Amount balance) {
		this.transaction = transaction;
		this.balance = balance;
	}

	/**
	 * Print the AccountStatement
	 * 
	 * @return A string that represents the AccountStatement
	 */
	public String printAccountStatement() {
		return String.format("%-10s\t%s\n", transaction.printTransaction(), balance.format());
	}

}
