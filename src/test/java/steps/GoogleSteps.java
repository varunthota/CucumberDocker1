package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.mainPage;


public class GoogleSteps {
   private mainPage mp = new mainPage();
  @Given("^I open google page$")
  public void iWillOpenGooglePage() {
    mp.openGooglePage();
  }


  @Then("^I validate title and URL$")
  public void assertPageOpened() {
    mp.i_print_title_and_URL();
  }
}