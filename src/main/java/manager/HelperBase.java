package manager;

import org.openqa.selenium.By;

public interface HelperBase extends AppManager{

    default void clickBase(By locator){
        driver.findElement(locator).click();
    }


}
