package se.thinkcode.jdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.thinkcode.jdd.Subscriptions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UnsubscribeSteps {
    private Subscriptions subscriptions;
    private String message;

    @Given("^I have subscribed for a marketing service with my e-mail (.*)$")
    public void i_have_subscribed_for_a_marketing_service_with_my_e_mail(String address) throws Throwable {
        subscriptions = new Subscriptions();
        subscriptions.subscribe(address);
    }

    @When("^I unsubscribe (.*)$")
    public void i_unsubscribe(String address) throws Throwable {
        message = subscriptions.unsubscribe(address);
    }

    @Then("^I should get a goodbye message$")
    public void i_should_get_a_goodbye_message() throws Throwable {
        assertTrue("Should say Goodbye, but it said <" + message + ">", message.contains("Goodbye"));
    }

    @Then("^(.*) should be unsubscribed$")
    public void should_be_unsubscribed(String address) throws Throwable {
        assertFalse(address + " should not be a subscriber", subscriptions.isSubscribing(address));
    }

    @Then("^I should get an error message$")
    public void i_should_get_an_error_message() throws Throwable {
        assertTrue("Should say not a subscriber, but it said <" + message + ">", message.contains("not a subscriber"));
    }

    @Then("^(.*) should not be unsubscribed$")
    public void should_not_be_unsubscribed(String address) throws Throwable {
        assertTrue(address + " should still be a subscriber", subscriptions.isSubscribing(address));
    }
}
