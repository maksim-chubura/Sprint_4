import PageObject.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePageTest {
    private WebDriver driver;
    HomePage HomePage;

    @Before
    public void setUp() {
        // создали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //создали драйвер для браузера Firefox
        //FirefoxOptions options = new FirefoxOptions();
        //driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage = new HomePage(driver);
        HomePage.closeCookie();
    }

    @Test
    public void checkTestQuestions() {
        HomePage.scrollQuestions();
        HomePage.clickQuestions();
        String text = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals("Текст не совпадает", text, HomePage.getAnswer());
    }

    @Test
    public void checkTestSecondQuestions() {
        HomePage.scrollQuestions();
        HomePage.clickSecondQuestions();
        String text = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals("Текст не совпадает", text, HomePage.getSecondAnswer());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
