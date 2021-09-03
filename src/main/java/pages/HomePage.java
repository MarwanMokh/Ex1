package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formAuthenticationLinkText = By.linkText("Form Authentication");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public FormAuthenticationPage clickFormAuthenticationPage(){
        driver.findElement(formAuthenticationLinkText).click();
        return new FormAuthenticationPage(driver);
    }



}
