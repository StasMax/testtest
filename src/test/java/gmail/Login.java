package gmail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static gmail.Constants.SEARCH_WORD;

public class Login {


    @Test
    public void login(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

LoginGmail loginGmail = PageFactory.initElements(driver, LoginGmail.class);
        EmailAccount emailAccount = PageFactory.initElements(driver, EmailAccount.class);
loginGmail.open();
loginGmail.enterEmail();
loginGmail.enterPassword();
loginGmail.pageRecoveryAccount();

emailAccount.getSearchResultByWord();









        driver.findElement(By.cssSelector("[class=\"T-I J-J5-Ji T-I-KE L3\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":ey")));
        driver.findElement(By.id(":e7")).sendKeys(E_MAIL);
        driver.findElement(By.id(":dp")).sendKeys(DESCRIPTION);
        driver.findElement(By.id(":eu")).sendKeys(message.toString());
        driver.findElement(By.id(":df")).click();

    }
}
