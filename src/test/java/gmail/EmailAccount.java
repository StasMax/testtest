package gmail;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    private By searchTriangleButton = By.cssSelector("[d=\"M7 10l5 5 5-5z\"]");
    private By fullSearchFields = By.cssSelector("[class=\"ZZ\"]");
    private By countEmail = By.cssSelector("[class=\"ts\"]");
    private By bodyDescription = By.id(":ey");
    private By bodyEmails = By.id(":9v");
    private By bodyEmailSent = By.id("link_vsm");

    @FindBy(css = "[id=\":60\"]")
    private WebElement fieldFrom;

    @FindBy(css = "[class=\"T-I J-J5-Ji T-I-KE L3\"]")
    private WebElement sendEmailButton;

    @FindBy(id = ":6e")
    private WebElement searchButton;

    @FindBy(id = ":e7")
    private WebElement emailField;

    @FindBy(id = ":dp")
    private WebElement topicField;

    @FindBy(id = ":eu")
    private WebElement descriptionField;

    @FindBy(id = ":df")
    private WebElement sendEmail;

    public EmailAccount(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @Step("Click on triangle button of search field, open table search, enter search keyword in field")
    public void getSearchResultByWord(String searchWord) {
        driver.findElement(searchTriangleButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullSearchFields));
        fieldFrom.click();
        fieldFrom.sendKeys(searchWord);
        searchButton.click();
    }

    @Step("Get number of e-mails for keyword")
    public String getCountEmail() {
        return driver.findElement(countEmail).getText();
    }

    @Step("Click button new message, open table new message")
    public void openSendEmailForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyEmails));
        sendEmailButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyDescription));
    }

    @Step("Fill e-mail field")
    public void fillEmailFormAdress(String address) {
        emailField.sendKeys(address);
    }

    @Step("Fill topic field")
    public void fillEmailFormTopic(String topic) {
        topicField.sendKeys(topic);
    }

    @Step("Fill description field")
    public void fillEmailFormDescription(String description) {
        descriptionField.sendKeys(description);
    }

    @Step("Click send e-mail button")
    public void sendEmail() {
        sendEmail.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyEmailSent));
    }

    @Step("Close browser")
    public void close() {
        driver.quit();
    }
}
