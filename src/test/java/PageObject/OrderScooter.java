package PageObject;

import org.openqa.selenium.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderScooter {
    // добавил поле driver
    private WebDriver driver;
    // локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");
    // локатор для верхней кнопки "Заказать"
    private By orderButtonUp = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    // локатор для нижней кнопки "Заказать"
    private By orderButtonDown = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    // локатор для поля Имя
    private By firstNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // локатор для поля Фамилия
    private By lastNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // локатор для поля Адрес
    private By addressNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // локатор для списка метро
    private By metroName = By.className("select-search__input");
    // локатор для номера телефона
    private By telephoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // локатор для кнопки "Далее" из формы заказа
    private By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    // локатор для поля "Когда привезти самокат"
    private By dateOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");

    // локатор для поля "Срок аренды"
    private By rentalPeriod = By.className("Dropdown-arrow");
    // локатор для чек-бокса цвет самоката
    private By colourScooter = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]");
    // локатор для комментария курьеру
    private By commentToCourier = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // локатор для кнопки "Заказать" из второй формы
    private By orderButton2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // локатор для кнопки Да
    private By yesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // локатор подтверждения заказа
    private By confirmation = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]");

    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }
    // метод для закрытия кнопки куки
    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }
    //метод для нажатия верхней кнопки Заказать
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }
    //метод для нажатия нижней кнопки Заказать
    public void clickOrderButtonDown() {
        WebElement buton = driver.findElement(orderButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buton);
        driver.findElement(orderButtonDown).click();
    }
    //метод заполняет поля ввода Имя
    public void setFirstNameField (String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    // метод заполняет поля ввода Фамилия
    public void setLastNameField (String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    //метод заполняет поля ввода Адрес
    public void setAddressNameField (String addressName) {
        driver.findElement(addressNameField).sendKeys(addressName);
    }
    // метод заполняет поля ввода Станция метро
    public void clickMetroName1() {
        driver.findElement(metroName).click();
        driver.findElement(By.xpath(".//button[@value='17']")).click();
    }
    public void clickMetroName2() {
        driver.findElement(metroName).click();
        driver.findElement(By.xpath(".//button[@value='34']")).click();
    }
    // метод заполняет поля ввода Телефон
    public void setTelephoneNumber (String numer) {
        driver.findElement(telephoneNumber).sendKeys(numer);
    }
    // метод нажимает кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    // метод заполняет дату, когда привезти самокат
    public void setDateOrder() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        Date date = new Date();
        driver.findElement(dateOrder).click();
        driver.findElement(dateOrder).sendKeys(formatter.format(date));
        driver.findElement(dateOrder).sendKeys(Keys.ENTER);
    }
    // метод заполняет срок аренды
    public void setRentalPeriodTwoDays() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriod).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]")).click();
    }
    public void setRentalPeriodOneDays() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalPeriod).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
    }
    // метод выбирает цвет самоката
    public void setColourScooterBlack() {
        driver.findElement(colourScooter);
        driver.findElement(By.xpath("//*[@id=\"black\"]")).click();
    }
    public void setColourScooterGray() {
        driver.findElement(colourScooter);
        driver.findElement(By.xpath("//*[@id=\"grey\"]")).click();
    }
    // метод заполняет поля ввода Комментарий
    public void setCommentToCourier (String comment) {
        driver.findElement(commentToCourier).sendKeys(comment);
    }
    // метод нажимает на кнопку Заказать из второй формы
    public void clickOrderButton2() {
        driver.findElement(orderButton2).click();
    }
    // метод нажимает кнопку Да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    // метод проверяет, то появилось всплывающее окно с сообщением об успешном создании заказа
    public void setConfirmation() {
        String text = driver.findElement(confirmation).getText();
        System.out.println("Текст сообщения " + text);
    }
    // метод выполняет заполнение полей в перфой форме Заказа
    public void login (String firstName, String lastName, String addressName, String numer) {
        setFirstNameField(firstName);
        setLastNameField(lastName);
        setAddressNameField(addressName);
        setTelephoneNumber(numer);
    }
}
