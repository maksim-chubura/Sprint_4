package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    // добавил поле driver
    private WebDriver driver;
    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    //локатор для выпадающего списка в Вопросах о важном
    private By questions = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div");


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
    public void clickQuestions() {
        driver.findElement(By.cssSelector("#accordion__heading-4")).click();
    }
    public void clickSecondQuestions() {
        driver.findElement(By.cssSelector("#accordion__heading-6")).click();
    }
    // метод возвращает отображаемый текст выпадающего списка
    public String getAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-4")).getText();
    }
    public String getSecondAnswer() {
        return driver.findElement(By.cssSelector("#accordion__panel-6")).getText();
    }
}
