package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static gmail.Constants.*;

public class LoginGmail {
    private WebDriver driver;
    private WebDriverWait wait;
    private By pass = By.id("password");
    private By password = By.cssSelector("[aria-label=\"Введите пароль\"]");
    private By buttonCancel = By.cssSelector("[jsname=\"UjXomb\"]");
    private By bodyRecovery = By.id(":3");

    public LoginGmail(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "identifierId")
    private WebElement emailIdentifier;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    @FindBy(id = "password")
    private WebElement passwordIdentifier;

    @FindBy(id = "passwordNext")
    private WebElement nextButtonPassword;

    public void open() {
        driver.get(SITE_URL);
    }

    public void enterEmail() {
        emailIdentifier.click();
        emailIdentifier.sendKeys(LOGIN);
        nextButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
    }

    public void enterPassword() {
        passwordIdentifier.click();
        driver.findElement(password).sendKeys(PASSWORD);
        nextButtonPassword.click();
    }

    public void pageRecoveryAccount() {
        if (driver.getTitle().equals("Параметры восстановления аккаунта")) {
            driver.findElement(buttonCancel).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(bodyRecovery));
    }
}
