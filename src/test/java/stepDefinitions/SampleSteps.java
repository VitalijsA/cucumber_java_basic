package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.converters.extended.ToStringConverter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^Navigate to the url \"([^\"]*)\"$")
    public void navigateToTheUrl(String url) throws Throwable {
        driver.get(url);
    }

    @Then("^Click accept button$")
    public void clickAcceptButton() {
        WebElement popUp = driver.findElement(By.cssSelector("iframe[src*='https://consent.google.com?hl=lv&origin=https://www.google.com&continue=https://www.google.com/&if=1&m=0&pc=s&wp=-1&gl=LV']"));
        driver.switchTo().frame(popUp);
        driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
        driver.switchTo().defaultContent();
    }

    @Then("^Text input field is present$")
    public void textInputFieldIsPresent(){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
}

    @And("^Search button is present$")
    public void searchButtonIsPresent() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]"));
    }

    @And("^I'm feeling lucky button is present$")
    public void iMFeelingLuckyButtonIsPresent() {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[2]"));
    }

    @When("^I enter \"([^\"]*)\" in input$")
    public void iEnterInInput(String testText) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(testText);
    }

    @And("^Text input has \"([^\"]*)\" inside it$")
    public void textInputHasInsideIt(String testText){
        assertEquals(testText, driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).getAttribute("value"));
    }

    @Given("^I am on enter number page$")
    public void iAmOnEnterNumberPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number){
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^I see the message: \"([^\"]*)\"$")
    public void iSeeTheMessage(String message) {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumber(int number) {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @Then("^I see the alert message \"([^\"]*)\"$")
    public void iSeeTheAlertMessage(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }

}
