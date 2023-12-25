package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase {
    By buttonElements = By.xpath("//div[@class='card mt-4 top-card']");
    By buttonForms = By.xpath("//div[@class='category-cards']/div[2]");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");

    By fieldFistName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.id("userEmail");
    By fieldMobile = By.id("userNumber");
    By fieldBDay = By.id("dateOfBirthInput");
    By fieldSubject = By.id("subjectsInput");
    By checkBoxSport = By.xpath("//label[@for='hobbies-checkbox-1']");
    By checkBoxReading = By.xpath("//label[@for='hobbies-checkbox-2']");
    By checkBoxMusic = By.xpath("//label[@for='hobbies-checkbox-3']");

    By currentAddress = By.id("currentAddress");
    By buttonSelectState = By.id("react-select-3-input");
    By buttonSelectCity = By.id("react-select-4-input");
    By text_thanks_for = By.id("example-modal-sizes-title-lg");

    By buttonSubmit = By.id("submit");
    By buttonCloseModal = By.id("closeLargeModal");

    default void selectPracticeForm() {
//        clickBase(buttonElements);
//        pause(5);
        hideFooter();
        clickBase(buttonForms);
        hideFooter();
        pause(3);
        clickBase(buttonPracticeForm);
    }

    default void fillStudentForm(StudentDTO student) {
        typeBase(fieldFistName, student.getFirstName());
        typeBase(fieldLastName, student.getLastName());
        typeBase(fieldEmail, student.getEmail());
        selectGender(student.getGender());
        typeBase(fieldMobile, student.getMobile());
        //typeBase(fieldBDay, student.getDateOfBirth());
        typeBDayByKeys(fieldBDay, student.getDateOfBirth());
        addSubject(fieldSubject, student.getSubjects());
        selectHobby(student.getHobbies());

        typeBase(currentAddress, student.getAddress());
        typeState(buttonSelectState, student.getState());
        typeCity(buttonSelectCity, student.getCity());

    }

    default void typeCity(By buttonSelectCity, String city){
        driver.findElement(buttonSelectCity).sendKeys(city);
        //driver.findElement(buttonSelectCity).sendKeys(Keys.ENTER);
    }

    default void typeState(By buttonSelectState, String state){
        //clickBase(buttonSelectState);
        driver.findElement(buttonSelectState).sendKeys(state);
        driver.findElement(buttonSelectState).sendKeys(Keys.ENTER);
    }

    default void selectHobby(String hobbies) {
        switch (hobbies) {
            case "Sports":
                clickBase(checkBoxSport);
                break;
            case "Reading":
                clickBase(checkBoxReading);
                break;
            case "Music":
                clickBase(checkBoxMusic);
                break;
        }
    }


    default void addSubject(By fieldSubject, String subjects) {
        String[] splitArray = subjects.split(",");
        clickBase(fieldSubject);
        for (String subject : splitArray) {
            driver.findElement(fieldSubject).sendKeys(subject);
            driver.findElement(fieldSubject).sendKeys(Keys.ENTER);
        }
    }

    default void typeBDayByKeys(By fieldBDay, String dateOfBirth) {
        WebElement element = driver.findElement(fieldBDay);
        element.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("OS --> " + operationSystem);
        if (operationSystem.startsWith("Win")) {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }
        element.sendKeys(dateOfBirth);
        element.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender) {
        if (gender.equals("Male")) {
            clickBase(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            clickBase(By.xpath("//label[@for='gender-radio-2']"));
        } else {
            clickBase(By.xpath("//label[@for='gender-radio-3']"));
        }
    }

    default void clickButtonSubmit(){
        clickBase(buttonSubmit);
    }
    default boolean isElementPresent_Thanks_for(){
        return isElementPresent(text_thanks_for);
    }

    default void clickButtonCloseModal(){
        clickBase(buttonCloseModal);
    }

}
