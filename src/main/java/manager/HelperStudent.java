package manager;

import models.StudentDTO;
import org.openqa.selenium.By;

public interface HelperStudent extends HelperBase{
    By buttonElements = By.xpath("//div[@class='card mt-4 top-card']");
    By buttonForms = By.xpath("//div[text()='Forms']");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");

    By fieldFistName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.id("userEmail");

    default void selectPracticeForm(){
        clickBase(buttonElements);
        pause(5);
        clickBase(buttonForms);
        clickBase(buttonPracticeForm);
    }
    default void fillStudentForm(StudentDTO student) {
        typeBase(fieldFistName, student.getFirstName());
        typeBase(fieldLastName, student.getLastName());
        typeBase(fieldEmail, student.getEmail());
    }

}
