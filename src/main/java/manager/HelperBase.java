package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager{

    default void clickBase(By locator){
        driver.findElement(locator).click();
    }

    default void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    default void typeBase(By locator, String text){
        WebElement element = driver.findElement(locator);
        clickBase(locator);
        element.clear();
        element.sendKeys(text);
    }

    default void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    default boolean isElementPresent(By locator){
        //return driver.findElements(locator).size()>0;
        return !driver.findElements(locator).isEmpty();
    }

}
