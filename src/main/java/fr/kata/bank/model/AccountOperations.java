package fr.kata.bank.model;

import java.util.LinkedList;
import java.util.List;

/**
 * The AccountOperations
 * 
 * @author Skander
 *
 */
public class AccountOperations {
	/**
	 * The header of history
	 */
	private static final String HEADER = String.format("%-10s\t%-10s\t%-10s\t%-10s\n", "Operation", "Date", "Amount",
			"Balance");

	/**
	 * The list of AccountStatement Uses LinkedList because is more efficient when
	 * adding element in the first index
	 * 
	 */
	private List<AccountStatement> transactions = new LinkedList<>();

	/**
	 * Adds a new transaction in the first index of List
	 * 
	 * @param transaction
	 */
	public void addTransaction(Transaction transaction, Amount balance) {
		transactions.add(0, new AccountStatement(transaction, balance));
	}

	/**
	 * print All operations
	 * 
	 */
	public String printAllOperations() {
		StringBuilder output = new StringBuilder(HEADER);
		transactions.stream().forEach(item -> output.append(item.printAccountStatement()));
		return output.toString();
	}
}
