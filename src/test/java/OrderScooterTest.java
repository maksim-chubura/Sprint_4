import PageObject.OrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OrderScooterTest {
    private WebDriver driver;
    OrderScooter Order;

    @Before
    public void setUp() {
        // создали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //создали драйвер для браузера Firefox
        //FirefoxOptions options = new FirefoxOptions();
        //driver = new FirefoxDriver(options);
        //  WebDriver driver = new FirefoxDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Order = new OrderScooter(driver);
        Order.closeCookie();
    }

    @Test
    public void checkOrderScooter() {
        Order.clickOrderButtonUp();
        Order.login("Максим", "Чубура", "Кирова, 70", "+79280368957");
        Order.clickMetroName1();
        Order.clickNextButton();
        Order.setDateOrder();
        Order.setRentalPeriodTwoDays();
        Order.setColourScooterBlack();
        Order.setCommentToCourier("Жду с нетерпением!");
        Order.clickOrderButton2();
        Order.clickYesButton();
        Order.setConfirmation();
    }
    @Test
    public void checkOrderScooter1() {
        Order.clickOrderButtonDown();
        Order.login("Вероника", "Хрусталева", "Макаренко, 34", "+79614093164");
        Order.clickMetroName2();
        Order.clickNextButton();
        Order.setDateOrder();
        Order.setRentalPeriodOneDays();
        Order.setColourScooterGray();
        Order.setCommentToCourier("Не опаздывайте!");
        Order.clickOrderButton2();
        Order.clickYesButton();
        Order.setConfirmation();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
