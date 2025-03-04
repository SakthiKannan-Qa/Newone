package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    
    WebDriver driver;

    @Given("User should navigate to the application")
    public void userShouldNavigateToTheApplication() {
        WebDriverManager.edgedriver().setup();  
        driver = new EdgeDriver();  
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
    }

    @Given("user click on the login link")
    public void userClickOnTheLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]/span[2]")));
        loginButton.click();
    }

    @Given("user enter the username as Sakthi")
    public void userEnterTheUsernameAsSakthi() {
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("Sakthi"); 
        
    }

    @Given("User enter the password as pass1234")
    public void userEnterThePasswordAsPass1234(){
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("Pass1234");
       
    }

    @When("user click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        
    }

    @Then("login should be success")
    public void loginShouldBeSuccess() {
        String text = driver.findElement(By.xpath("//span[contains(text(), 'Sakthi')]")).getText();
        System.out.println("Login Successful: " + text);
        
    }
}
