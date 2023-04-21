package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebNew
{
    WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize(); //Full screen.
        // wait for 10 seconds to see the result
        Thread.sleep(10000);
    }
    @Test
    public void dropdown()
    {
        /*WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("SQL");
        select.selectByVisibleText("JUnit");
        select.selectByVisibleText("JQuery");*/
        WebElement dropdown = driver.findElement(By.id("dropdowm-menu-1"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Python");
        WebElement dropdown1 = driver.findElement(By.id("dropdowm-menu-2"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("TestNG");
        WebElement dropdown2 = driver.findElement(By.id("dropdowm-menu-3"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Javascript");
    }
    @Test
    public void checkBox() throws InterruptedException
    {
        WebElement checkbox2= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[3]/input"));

        checkbox2.click();
        Thread.sleep(1000);
        checkbox3.click();
        Thread.sleep(1000);
    }
    @Test
    public void radioButton() throws InterruptedException
    {
        // select Purple from the radio button section
        WebElement radioBtn = driver.findElement(By.xpath("//input[@value='yellow']"));
        radioBtn.click();
        Thread.sleep(2000);
    }
    @Test
    public void selectedAndDisabledButton() throws InterruptedException
    {
        // select Purple from the radio button section
        WebElement disableBtn = driver.findElement(By.xpath("//input[@value='pumpkin']"));
        disableBtn.click();
        //wait for 2 seconds to see the result
        Thread.sleep(2000);
    }
    @AfterTest
    public void driverQuit()
    {
        driver.quit();
    }
}