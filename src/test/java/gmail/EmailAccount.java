package gmail;

import jdk.vm.ci.meta.PrimitiveConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static gmail.Constants.SEARCH_WORD;

public class EmailAccount {
    private WebDriver driver;
    private WebDriverWait wait;
    private By searchButton = By.cssSelector("[d=\"M7 10l5 5 5-5z\"]");
    private By fullSearchFields = By.cssSelector("[class=\"ZZ\"]");
    private By countEmail = By.cssSelector("[class=\"ts\"]");
    private String messagesCount;

    public EmailAccount(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void getSearchResultByWord(){
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullSearchFields));
        WebElement fieldFrom = driver.findElement(By.cssSelector("[id=\":60\"]"));  //!!
        fieldFrom.click();
        fieldFrom.sendKeys(SEARCH_WORD);
        driver.findElement(By.id(":6e")).click();
    }

    public void getCountEmail(){
        messagesCount = driver.findElement(countEmail).getText();

        StringBuilder message = new StringBuilder();
        message.append("Колличество писем равно ");
        message.append(messagesCount);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":9v")));
    }
}
