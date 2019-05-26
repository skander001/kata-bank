package fr.kata.bank.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;

/**
 * The Transaction
 * 
 * @author Skander
 *
 */
public class Transaction {
	/**
	 * The Date Formatter
	 */
	private static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	/**
	 * The amount of Transaction
	 */
	private Amount amount;
	/**
	 * The date of Transaction
	 */
	private LocalDate transctionDate;
	/**
	 * The Operation Type
	 */
	private OperationType operationType;

	/**
	 * The constructor
	 * 
	 * @param amount
	 * @param transctionDate
	 * @param operationType
	 */
	public Transaction(Amount amount, LocalDate transctionDate, OperationType operationType) {
		this.amount = Objects.requireNonNull(amount, "The amount must not be null");
		this.transctionDate = Objects.requireNonNull(transctionDate, "The transctionDate must not be null");
		this.operationType = Objects.requireNonNull(operationType, "The operationType must not be null");
	}

	/**
	 * Print the transaction
	 * 
	 * @return a String that represents the transaction
	 */
	public String printTransaction() {
		return String.format("%-10s\t%-10s\t%-10s", operationType, FORMAT_DATE.format(transctionDate), amount.format());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Transaction other = (Transaction) obj;
		return ObjectUtils.equals(amount, other.amount) && ObjectUtils.equals(transctionDate, other.transctionDate)
				&& ObjectUtils.equals(operationType, other.operationType);
	}

}
