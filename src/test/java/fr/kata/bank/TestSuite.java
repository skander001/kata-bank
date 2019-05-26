package fr.kata.bank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.kata.bank.model.AccountOperationsTest;
import fr.kata.bank.model.AccountStatementTest;
import fr.kata.bank.model.AccountTest;
import fr.kata.bank.model.AmountTest;
import fr.kata.bank.model.TransactionTest;

/**
 * Class for launch all class of Test
 * 
 * @author Skander
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	AccountStatementTest.class,
	AccountTest.class,
	AmountTest.class,
	TransactionTest.class,
	AccountOperationsTest.class
})
public class TestSuite {

}
