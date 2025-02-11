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
        assertTrue(home.clickNewsletterCheckbox(), "Error checking newsletter checkbox");
        assertFalse(home.clickSubmit(), "Error submitting contact form when not all mandatary fields are completed");
        assertTrue(home.validateMandatoryFields(), "Error, not all mandatory fields are throwing a mandatory message");
        assertFalse(home.validateColorMessage(ContactUsForm.FIRST_NAME.getIndex()), "Error, is not red or not only one with a red color message");
        assertTrue(home.fillFirstName(firstName), "Error sending keys to fillFirstName");
        assertFalse(home.clickNewsletterCheckbox(), "Error submitting contact form when not all mandatary fields are completed");
        assertTrue(home.validateMandatoryAndEmptyFields(5), "Error validating mandatoru error quantity in contact form");
        assertTrue(home.validateMandatoryFirstNameNotPresent(), "Error validating mandatory First Name");
        assertFalse(home.validateColorMessage(ContactUsForm.EMAIL.getIndex()), "Error, is not red or not only one with a red color message");


    }
}
