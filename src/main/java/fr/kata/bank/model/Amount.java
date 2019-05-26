package fr.kata.bank.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;

/**
 * The Amount class
 * 
 * @author Skander
 *
 */
public class Amount {
	/**
	 * The formatter of decimal numbers
	 */
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
	/**
	 * The value of amount
	 */
	private BigDecimal value;

	/**
	 * The constructor
	 * 
	 * @param value The value of Amount
	 */
	public Amount(BigDecimal value) {
		this.value = ObjectUtils.defaultIfNull(value, BigDecimal.ZERO) ;
	}

	/**
	 * Translates a long value into a {@link Amount}
	 * 
	 * @param value the long value
	 * @return the Amount
	 */
	public static Amount valueOf(BigDecimal value) {
		return new Amount(value);
	}

	/**
	 * Addition of {@link Amount} to an other {@link Amount}
	 * 
	 * @param other a {@link Amount}
	 * @return a {@link Amount}
	 */
	public Amount add(Amount other) {
		if (other == null) {
			return this;
		}
		return valueOf(value.add(other.value));
	}

	/**
	 * Returns a Amount whose value is {@code (-this)}
	 * 
	 * @param other
	 * @return
	 */
	public Amount negate() {
		if (value.compareTo(BigDecimal.ZERO) == -1) {
			return this;
		}
		return valueOf(value.negate());
	}

	/**
	 * formats decimal numbers
	 * 
	 * @return formatted amount
	 */
	public String format() {
		return DECIMAL_FORMAT.format(value);
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
        final Amount other = (Amount) obj;
        return ObjectUtils.equals(value, other.value);
	}

}
