package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface AppManager {

    WebDriver driver = new ChromeDriver();

    default void init(){
        driver.navigate().to("https://demoqa.com");
    }

    default void stop(){
        driver.quit();
    }
}
