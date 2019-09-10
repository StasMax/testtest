package gmail;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static gmail.Constants.*;

public class TestClass {

    @Test
    public void loginAndSendEmail() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        LoginGmail loginGmail = PageFactory.initElements(driver, LoginGmail.class);
        EmailAccount emailAccount = PageFactory.initElements(driver, EmailAccount.class);

        loginGmail.open();
        loginGmail.enterEmail();
        loginGmail.enterPassword();
        loginGmail.pageRecoveryAccount();
        emailAccount.getSearchResultByWord(SEARCH_WORD);
        String countEmails = emailAccount.getCountEmail();
        emailAccount.openSendEmailForm();
        emailAccount.fillEmailFormAdress(E_MAIL);
        emailAccount.fillEmailFormTopic(TOPIC);
        emailAccount.fillEmailFormDescription("Колличество писем равно " + countEmails);
        emailAccount.sendEmail();
        emailAccount.close();
    }
}
