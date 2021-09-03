package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By flashMessage = By.id("flash");
    private By logoutButton = By.xpath("//div[@id=\"content\"]/div/a");
    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }
    public String getFlashMessage(){
        return driver.findElement(flashMessage).getText();
    }
    public FormAuthenticationPage clickLogOut(){
        driver.findElement(logoutButton).click();
        return new FormAuthenticationPage(driver);
    }
}
