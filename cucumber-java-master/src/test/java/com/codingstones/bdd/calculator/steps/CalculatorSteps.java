package com.codingstones.bdd.calculator.steps;

import com.codingstones.bdd.calculator.Calculator;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorSteps {
    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    Calculator calculator;

    @Then("the result should be {int}")
    public void theResultShouldBeArg0(int arg0) {
        Assert.assertTrue(calculator.currentValue() == arg0);
    }

    @When("^I subtract (\\d+) from (\\d+)$")
    public void iSubtractFrom(int arg0, int arg1) {
        calculator.subtract(arg0, arg1);
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void iAddAnd(int arg0, int arg1) {
        calculator.subtract(arg0, arg1);
    }
}
