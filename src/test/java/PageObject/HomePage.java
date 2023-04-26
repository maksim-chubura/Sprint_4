package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    // добавил поле driver
    private WebDriver driver;
    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    //локатор для выпадающего списка в Вопросах о важном
    private By questions = By.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/div[2]/div");


    // метод для закрытия кнопки куки
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // метод прокручивает до Вопросов о важном
    public void scrollQuestions() {
        WebElement element = driver.findElement(questions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // метод нажимает на выпадающий список
    public void clickFirstQuestions() {
        driver.findElement(By.cssSelector("#accordion__heading-0")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickSecondQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-1")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickThirdQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-2")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickFourthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-3")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickFifthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-4")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickSixthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-5")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickSeventhQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-6")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void clickEighthQuestion() {
        driver.findElement(By.cssSelector("#accordion__heading-7")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    // метод возвращает отображаемый текст выпадающего списка
    public String getFirstAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-0")).getText();
    }
    public String getSecondAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-1")).getText();
    }
    public String getThirdAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-2")).getText();
    }
    public String getFourthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-3")).getText();
    }
    public String getFifthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-4")).getText();
    }
    public String getSixthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-5")).getText();
    }
    public String getSeventhAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-6")).getText();
    }
    public String getEighthAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-7")).getText();
    }
}
