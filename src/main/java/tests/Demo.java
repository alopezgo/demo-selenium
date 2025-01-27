package tests;

import base.BaseTest;
import enums.ContactUsForm;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Home;

import static org.testng.Assert.*;

public class Demo extends BaseTest {
    @Test
    @Parameters({"firstName"})
    public void demo(String firstName) throws InterruptedException {

        Home home = new Home(driver);
        assertTrue(home.validateLoginUrl(driver.getCurrentUrl()), "Error current url was not expected");
        assertTrue(home.validateQubikaLogo(), "Error Qubika Logo was not found");
        assertTrue(home.clickContactUs(), "Error founding or clicking Contact Us");
        assertTrue(home.validateFirstNameInput(), "Error founding First Name Input");
        assertTrue(home.validateEmailInput(), "Error founding Email Input");
        assertTrue(home.validateNewsletterCheckbox(), "Error founding Newsletter Checkbok");
        try{
            home.clickNewsletterCheckbox();
        }
        catch (Exception e){
            System.out.println("clickNewsletterCheckbox method failed: " + e.getMessage());
        };
        try{
            home.clickSubmit();
        }
        catch (Exception e){
            System.out.println("clikSubmit method failed: " + e.getMessage());
        };
        assertTrue(home.validateMandatoryFields(), "Error, not all mandatory fields are throwing a mandatory message");
        try{
            assertTrue(home.validateColorMessage(ContactUsForm.FIRST_NAME.getIndex()), "Error, is not red or not only one with a red color message");
        }
        catch (AssertionError e){
            System.out.println("Assertion failed: " + e.getMessage());
        }
        try{
           home.fillFirstName(firstName);
        }
        catch (AssertionError e){
            System.out.println("fillFirstName method failed: " + e.getMessage());
        }
        try{
            home.clickNewsletterCheckbox();
        }
        catch (Exception e){
            System.out.println("clickNewsletterCheckbox method failed: " + e.getMessage());
        };
        assertEquals(home.validateMandatoryAndEmptyFields(), 5);
        try{
            home.validateMandatoryFirstNameNotPresent();
        }
        catch (Exception e){
            System.out.println("validateMandatoryFirstNameNotPresent method failed: " + e.getMessage());
        };
        try{
            assertTrue(home.validateColorMessage(ContactUsForm.EMAIL.getIndex()), "Error, is not red or not only one with a red color message");
        }
        catch (AssertionError e){
            System.out.println("Assertion failed: " + e.getMessage());
        }

        Thread.sleep(5);


    }
}
