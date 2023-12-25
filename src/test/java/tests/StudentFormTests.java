package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StudentFormTests extends TestBase implements HelperStudent {
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void goToPracticeForm() {
        selectPracticeForm();
    }

    @Test
    public void registrationStudentPositiveTest_softAssert() {
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com",
                "Male", "1234567890", "10 Sep 2020", "Maths,English", "Music",
                "J.Washington street, 10", "NCR", "Delphi");
        fillStudentForm(student);
        clickButtonSubmit();

        WebElement elementEmail = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
        WebElement elementPhone = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
        System.out.println(elementEmail.getText());
        System.out.println(elementPhone.getText());

        softAssert.assertEquals(elementEmail.getText(), "12345");
        System.out.println("=======================================");
        softAssert.assertTrue(elementPhone.getText().equals(student.getMobile()));
        softAssert.assertAll();
    }

    @Test
    public void registrationStudentPositiveTest() {
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com",
                "Male", "1234567890", "10 Sep 2020", "Maths,English", "Music",
                "J.Washington street, 10", "NCR", "Delphi");
        fillStudentForm(student);
        clickButtonSubmit();
        Assert.assertTrue(isElementPresent_Thanks_for());
    }

    @Test
    public void registrationStudentPositiveTest_1() {
        StudentDTO student = new StudentDTO("Frodo1", "Baggins1", "frodobaggins@mail.com",
                "Male", "1234567890", "10 Sep 2020", "Maths,English", "Sports",
                "J.Washington street, 10", "NCR", "Delphi");
        fillStudentForm(student);
        clickButtonSubmit();
        Assert.assertTrue(isElementPresent_Thanks_for());
    }

    @Test
    public void registrationStudentNegativeTest_lastname_empty() {
        StudentDTO student = new StudentDTO("Frodo1", "", "frodobaggins@mail.com",
                "Male", "1234567890", "10 Sep 2020", "Maths,English", "Sports",
                "J.Washington street, 10", "NCR", "Delphi");
        fillStudentForm(student);
        clickButtonSubmit();
        Assert.assertFalse(isElementPresent_Thanks_for());
    }

    @AfterMethod
    public void afterMethod() {
        pause(3);
        if (isElementPresent_Thanks_for()) {
            clickButtonCloseModal();
            //pause(2);
        } else {
            driver.navigate().refresh();
            hideFooter();
        }

    }


}
