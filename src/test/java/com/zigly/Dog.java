package com.zigly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dog {

	static WebDriver driver;
    static Wait wait;
    static long exestart;
    @BeforeClass
    public static void applicationLaunch() throws InterruptedException  {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popups");
        driver = new EdgeDriver(options);
        driver.get("https://www.zigly.com/?srsltid=AfmBOoqys8nbgg3v50ILa4n36n7hMvmP_4HnzNC0HrSMhjyQSP5lIQvQ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);
        
    }
    @Before
	public void exebeforeEveryTest() {
		long exestart = System.nanoTime();
		System.out.println("The Test execution started at :" + exestart);
	}
    @After
	public void exeAfterEverTest() {
		long exeend = System.nanoTime();
		long exeduration = exeend - exestart;
		System .out.println("The test execution ened at:" + exeend);
		System.out.println("Total time taken for Test execution is" + exeduration);
		}
    @Test
    public void method2() {
        WebElement dogs = driver.findElement(By.xpath("//a[@class='p-image' and @href='/shop/dogs.html']"));
        dogs.click();
          }
    @Test
    public void method3(){
        WebElement category = driver.findElement(By.xpath("//div[normalize-space(text())='Category']"));
        category.click();

        List<WebElement> listItems = driver.findElements(By.xpath("(//div[@role='tab' and normalize-space(text())='Category'])/following-sibling::div//form//li"));
        for (int i = 0; i < listItems.size(); i++) {
            System.out.println("Item " + (i + 1) + ": " + listItems.get(i).getText());
        }       
    }
    @Test
    public void method4(){
    	WebElement food = driver.findElement(By.xpath("//a[@href='https://www.zigly.com/shop/dogs.html?cat=4']"));
        food.click();
        
    }
   @Test

   public void method5() throws InterruptedException {
        WebElement foodType = driver.findElement(By.xpath("//div[@data-role='title' and @class='filter-options-title' and normalize-space(text())='Food Type']"));
        foodType.click();
        List<WebElement> listFoods = driver.findElements(By.xpath("//div[@data-role='title' and @class='filter-options-title' and normalize-space(text())='Food Type']/following-sibling::div//form//li"));
        for (int i = 0; i < listFoods.size(); i++) {
            System.out.println("option" + (i + 1) + ": " + listFoods.get(i).getText());
            Thread.sleep(5000);
        }
    }
    
    @Test
    public void method6() throws InterruptedException {
    	WebElement veg = driver.findElement(By.xpath("//span[@class='label' and text()='Veg']"));
    	veg.click();
    	Thread.sleep(5000);
    	WebElement pedi = driver.findElement(By.xpath("//a[normalize-space(text())='Pedigree Vegetarian Puppy & Adult Dry Dog Food']"));
    	pedi.click();
    	Thread.sleep(5000);
    }
    @Test
    public void method7() {
        WebElement cart =driver.findElement(By.xpath("//button[@type='submit' and @title='Add to Cart' and @id='product-addtocart-button']"));
        cart.click();
    }
    @Test

    public void method8() {
    	 WebElement check =driver.findElement(By.xpath("//a[@title='Checkout']"));
    	 check.click();
        
    }
    @Test

    public void method9() throws InterruptedException {
    	WebElement Address = driver.findElement(By.xpath("//div[@class='step-title' and normalize-space(text())='Contact Information']"));
    	if (Address.isDisplayed()) {
            System.out.println("The Adress is displayed on the page.");
        } else {
            System.out.println("The Address is NOT displayed on the page.");
        }
    	Thread.sleep(5000);
    	WebElement mobileInput = driver.findElement(By.name("mobilenumber"));
    	mobileInput.sendKeys("1234567890");
    }
    
    @AfterClass
    public static void theEnd(){
    	driver.quit();
    
    }
}