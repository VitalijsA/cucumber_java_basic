package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AgePage;
import pages_sample.AgeSubmittedPage;
import pages_sample.JobPage;
import static org.junit.Assert.*;
import java.util.List;

public class JobListSteps {
    private WebDriver driver;
    static JobPage jobPage;

    public JobListSteps() {
        this.driver = Hooks.driver;
        jobPage = PageFactory.initElements(Hooks.driver, JobPage.class);
    }
    @Given("^I am on people/job page$")
    public void iAmOnPeopleJobPage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @And("^I click Add person$")
    public void iClickAddPerson() {
        String name = "Vitalijs";
        String job = "Engineer";
        driver.findElement(By.id("addPersonBtn")).click();
        jobPage.enterNameJobAndSubmit(name,job);
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() {
        jobPage.clickSubmit();
    }

    @Then("^Amount of people is (\\d+)$")
    public void amountOfPeopleIs(int size) {
        List<WebElement> links = driver.findElements(By.xpath("//li[contains(@id, \"person\")]"));
        assertEquals(size, links.size());
    }

    @When("^I click delete person$")
    public void iClickDeletePerson() {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }

    @And("^I click edit person$")
    public void iClickEditPerson() {
        String name = "Vitalijs";
        String job = "Engineer";
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]")).click();
        jobPage.enterNameAndJob(name,job);
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }
    @Then("^First persons name is \"([^\"]*)\" and job is \"([^\"]*)\"$")
    public void firstPersonsNameIsAndJobIs(String name, String job) throws Throwable {
        List<WebElement> links = driver.findElements(By.xpath("//li[contains(@id, \"person\")]"));
        assertEquals(name, links.get(0).findElement(By.xpath("//span[3]")).getText());
        assertEquals(job, links.get(0).findElement(By.xpath("//span[4]")).getText());
    }

    @And("^After adding person with \"([^\"]*)\" and \"([^\"]*)\" is on the page\\.$")
    public void afterActionPersonWithAndStatusOnThePage(String name, String job) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]")).getText());
        assertEquals(job, driver.findElement(By.xpath("//*[@id=\"person3\"]/span[4]")).getText());
    }
    @And("^After editing person with \"([^\"]*)\" and \"([^\"]*)\" is on the page\\.$")
    public void afterActionPersonWithAndStatusIsOnThePage(String name, String job) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals(job, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[4]")).getText());
    }
    @And("^After deleting person with \"([^\"]*)\" and \"([^\"]*)\" is not on the page\\.$")
    public void afterActionPersonWithAndStatusIsNotOnThePage(String name, String job) throws Throwable {
        assertEquals(0, driver.findElements(By.id("person3")).size());
    }

    @And("^I click reset original list$")
    public void iClickResetOriginalList() {
        driver.findElement(By.xpath("/html/body/div[4]/button[2]")).click();
    }

    @And("^Resetting After editing person with \"([^\"]*)\" and \"([^\"]*)\" is not on the page\\.$")
    public void resettingAfterEditingResettingPersonWithAndStatusOnThePage(String name, String job) throws Throwable {
        assertNotEquals(driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText(), name);
        assertNotEquals(driver.findElement(By.xpath("//*[@id=\"person0\"]/span[4]")).getText(), job);
    }

    @And("^Resetting After deleting person with \"([^\"]*)\" and \"([^\"]*)\" is on the page\\.$")
    public void resettingAfterDeletingPersonWithAndStatusOnThePage(String name, String job) throws Throwable {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).isDisplayed());
    }
    @And("^Resetting After adding person with \"([^\"]*)\" and \"([^\"]*)\" is not on the page\\.$")
    public void resettingAfterAddingPersonWithAndStatusOnThePage(String name, String job) throws Throwable {
        assertEquals(0, driver.findElements(By.id("person3")).size());
    }

    @And("^I click Add person button$")
    public void iClickAddPersonButton() throws Throwable{
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void iEnterNameAndJob(String name, String job) throws Throwable {
        jobPage.enterNameAndJob(name,job);
    }

    @When("^I click clear all fields$")
    public void iClickClearAllFields() {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @Then("^Name and job fields are empty$")
    public void nameAndJobFieldsAreEmpty() {
        assertEquals("", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("", driver.findElement(By.id("job")).getAttribute("value"));
    }
}
