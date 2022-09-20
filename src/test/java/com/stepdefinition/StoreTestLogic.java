package com.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreTestLogic {
	
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		System.out.println("Sample tests");
	}

	@Given("some other precondition")
	public void some_other_precondition() {
		System.out.println("Sample tests");
	}

	@When("I complete action")
	public void i_complete_action() {
		System.out.println("Sample tests");
	}

	@When("some other action")
	public void some_other_action() {
		System.out.println("Sample tests");
	}

	@When("yet another action")
	public void yet_another_action() {
		System.out.println("Sample tests");
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		System.out.println("Sample tests");
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
		System.out.println("Sample tests");
	}
}
