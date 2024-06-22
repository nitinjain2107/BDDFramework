package bddtask.BDDProject;


import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawCashSteps {
	 private BankAccount account;
	 private int dispensedAmount;
	
	  @Given("I have a balance of ${int} in my account")
	    public void i_have_a_balance_of_in_my_account(int balance) {
	        account = new BankAccount(balance);
	        System.out.println("Account created with balance: " + balance);

	    }

	    @When("I request ${int}")
	    public void i_request(int amount) {
	        dispensedAmount = account.withdraw(amount);
	        System.out.println("Requested amount: " + amount);
	        System.out.println("Dispensed amount: " + dispensedAmount);
	    }

	    @Then("${int} should be dispensed")
	    public void should_be_dispensed(int amount) {
	    	assertEquals(amount, dispensedAmount);
	    	System.out.println("Verified that " + amount + " was dispensed.");
	    	System.out.println("remaining balance is " + account.getBalance() );

}
}
