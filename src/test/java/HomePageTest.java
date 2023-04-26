import PageObject.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        HomePage = new HomePage(driver);
        HomePage.closeCookie();
    }

    @Test
    public void checkFirstQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickFirstQuestions();
        String text = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals("Текст не совпадает", text, HomePage.getFirstAnswer());
    }

    @Test
    public void checkSecondQuestions() {
        HomePage.scrollQuestions();
        HomePage.clickSecondQuestion();
        String text = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        assertEquals("Текст не совпадает", text, HomePage.getSecondAnswer());
    }

    @Test
    public void checkThirdQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickThirdQuestion();
        String text = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals("Текст не совпадает", text, HomePage.getThirdAnswer());
    }

    @Test
    public void checkFourthQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickFourthQuestion();
        String text = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals("Текст не совпадает", text, HomePage.getFourthAnswer());
    }

    @Test
    public void checkFifthQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickFifthQuestion();
        String text = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals("Текст не совпадает", text, HomePage.getFifthAnswer());
    }

    @Test
    public void checkSixthQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickSixthQuestion();
        String text = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals("Текст не совпадает", text, HomePage.getSixthAnswer());
    }

    @Test
    public void checkSeventhQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickSeventhQuestion();
        String text = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals("Текст не совпадает", text, HomePage.getSeventhAnswer());
    }

    @Test
    public void checkEighthQuestion() {
        HomePage.scrollQuestions();
        HomePage.clickEighthQuestion();
        String text = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals("Текст не совпадает", text, HomePage.getEighthAnswer());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
