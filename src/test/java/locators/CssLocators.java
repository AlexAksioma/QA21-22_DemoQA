package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssLocators {

    WebDriver driver;

    @Test
    public void textBox(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement inputFullName = driver.findElement(By.cssSelector("input[id='userName']"));
        System.out.println("--> "+inputFullName.getAttribute("placeholder"));
        WebElement currentAddress = driver.findElement(By.cssSelector("[placeholder='Current Address']"));
        System.out.println("--> "+currentAddress.getTagName());
        WebElement address = driver.findElement(By.cssSelector("#permanentAddress-label"));
        WebElement address1 = driver.findElement(By.id("permanentAddress-label"));
        System.out.println("--> "+address1.getText());
        driver.quit();
    }
    @Test
    public void checkBox(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        WebElement svg = driver.findElement(By.cssSelector("span[class='rct-text']>label>span[class='rct-node-icon']>svg"));
        System.out.println("--> "+svg.getAttribute("fill"));

        driver.quit();
    }

    @Test
    public void radioButton(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        WebElement radioButton = driver.findElement(By.id("yesRadio"));
        WebElement elementP = driver.findElement(
                By.cssSelector("div[class='col-12 mt-4 col-md-6'] :nth-child(2) :nth-child(5)"));
        System.out.println("--> "+elementP.getText());
        driver.quit();
    }


}
