package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class MyStepdefs {

    WebElement q;
    WebDriverWait wait;

    private WebDriver driver;

    @Before
    public void startBrowser() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"), dc);
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

    @Given("^I can open google$")
    public void iCanOpenGoogle() throws Throwable {
        driver.get("https://www.google.com");
//        wait(5000);
    }

    @When("^Page opens$")
    public void page_opens() throws Throwable {

        q=driver.findElement(By.name("q"));

    }

    @Then("^I can search$")
    public void i_can_search() throws Throwable {
        q.sendKeys("Docker");
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input.lsb"))));
    }

}
