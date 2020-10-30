package pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JobPage {
    protected static WebDriver driver;
    public JobPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.ID, using = "modal_button")
    private WebElement submit;

    public void enterName(String name){
         nameInput.clear();
         nameInput.sendKeys(name);
    }
    public void enterJob(String job){
        jobInput.clear();
        jobInput.sendKeys(job);
    }
    public void clickSubmit(){
        submit.click();
    }
    public void enterNameJobAndSubmit(String name, String job){
        enterName(name);
        enterJob(job);
        submit.click();
    }
    public void enterNameAndJob(String name, String job){
        enterName(name);
        enterJob(job);
    }

}
