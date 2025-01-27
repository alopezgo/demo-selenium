package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Home {

    public WebDriver driver;
    public WebDriverWait wait;

    public Home(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "logo")
    WebElement qubikaLogo;
    @FindBy(xpath = "//a[text() = 'Contact Us']/parent::li")
    WebElement contactUsBtn;
    @FindBy(xpath = "//input[contains(@id, 'firstname')]")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[contains(@id, 'lastname')]")
    WebElement lastNameInput;
    @FindBy(xpath = "//input[contains(@id, 'email')]")
    WebElement emailInput;
    @FindBy(xpath = "//input[contains(@id, 'company')]")
    WebElement companyInput;
    @FindBy(xpath = "//select[contains(@id, 'contact_type')]")
    WebElement contactTypeSelect;
    @FindBy(xpath = "//textarea[contains(@id, 'message')]")
    WebElement messageArea;
    @FindBy(xpath = "//*[contains(@id, 'newsletter')]")
    WebElement newsletterCheck;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//input[contains(@id, 'firstname')]/parent::div/following-sibling::ul/descendant::li")
    WebElement firstNameMandatoryMessage;



    public boolean validateLoginUrl(String url) {
        try{
            wait.until(driver -> driver.getCurrentUrl().equals(url));
            return url.equals("https://qubika.com/") ;
        }catch(Exception e){
            throw e;
        }

    }

    public boolean validateQubikaLogo() {
        try{
            wait.until(ExpectedConditions.visibilityOf(qubikaLogo));
            return qubikaLogo.isDisplayed();
        }catch(Exception e){
            throw e;
        }

    }
    public boolean clickContactUs() {
        boolean flag = false;
        try{
            wait.until(ExpectedConditions.visibilityOf(contactUsBtn));
            if (qubikaLogo.isDisplayed()){
                contactUsBtn.click();
                flag = true;
            };
            return flag;
        }catch(Exception e){
            throw e;
        }

    }

    public boolean validateFirstNameInput(){
        try{
            wait.until(ExpectedConditions.visibilityOf(firstNameInput));
            return firstNameInput.isDisplayed();

        }catch(Exception e){
            throw e;
        }
    }
    public boolean validateEmailInput(){
        try{
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            return emailInput.isDisplayed();

        }catch(Exception e){
            throw e;
        }
    }
    public boolean validateNewsletterCheckbox(){
        try{
            wait.until(ExpectedConditions.visibilityOf(newsletterCheck));
            return newsletterCheck.isDisplayed();

        }catch(Exception e){
            throw e;
        }
    }

    public void clickNewsletterCheckbox(){
        try{
            wait.until(ExpectedConditions.visibilityOf(newsletterCheck));
            newsletterCheck.click();

        }catch(Exception e){
            throw e;
        }
    }
    public void clickSubmit(){
        try{
            wait.until(ExpectedConditions.visibilityOf(submitBtn));
            submitBtn.click();
        }catch(Exception e){
            throw e;
        }
    }

    public boolean validateMandatoryFields(){
        try{
            List<WebElement> mandatorFieldsElements = driver.findElements(By.xpath("//*[@required]"));
            List<WebElement> messageMandatoryElements = driver.findElements(By.xpath("//label[@class = 'hs-error-msg hs-main-font-element']"));
            return mandatorFieldsElements.size() == messageMandatoryElements.size();
        }catch(Exception e){
            throw e;
        }

    }
    public boolean validateColorMessage(int inputIndex){
        try{
            List<WebElement> messageMandatoryElements = driver.findElements(By.xpath("//label[@class = 'hs-error-msg hs-main-font-element']"));
            if (!messageMandatoryElements.get(inputIndex).getCssValue("color").equals("rgb(255, 0, 0)")) {
                return false;
            }
            for (int i = 0; i < messageMandatoryElements.size(); i++) {
                if (i != inputIndex) {
                    if (messageMandatoryElements.get(i).getCssValue("color").equals("rgb(255, 0, 0)")) {
                        return false;
                    }
                }
            }
            return true;

        }catch(Exception e){
            throw e;
        }

    }

    public void fillFirstName(String firstName){
        try{
            wait.until(ExpectedConditions.visibilityOf(firstNameInput));
            firstNameInput.sendKeys(firstName);

        }catch(Exception e){
            throw e;
        }
    }

    public int validateMandatoryAndEmptyFields(){
        try{
            List<WebElement> mandatoryTextFieldsElements = driver.findElements(By.xpath("//*[@required and @value='']"));
            List<WebElement> mandatorySelectFieldElements = driver.findElements(By.xpath("//select[@class='hs-input invalid error is-placeholder']"));
            List<WebElement> mandatoryTextAreaElements = driver.findElements(By.xpath("//textarea[not(@text()) and @required]"));
            int inputTextEmpty = mandatoryTextFieldsElements.size();
            int selectEmpty = mandatorySelectFieldElements.size();
            int textAreaEmpty = mandatoryTextAreaElements.size();
            int mandatoryAndEmpty = inputTextEmpty + selectEmpty + textAreaEmpty;
            return mandatoryAndEmpty;
        }catch(Exception e){
            throw e;
        }

    }

    public void validateMandatoryFirstNameNotPresent(){
        try{
            wait.until(ExpectedConditions.invisibilityOf(firstNameInput));
        }catch(Exception e){
        throw e;}

    }

}
