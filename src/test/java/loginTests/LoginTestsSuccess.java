package loginTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FormAuthenticationPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTestsSuccess extends BaseTests {
    @Test
    public void loginTestsSuccessfully(){
        FormAuthenticationPage formAuthenticationPage = homePage.clickFormAuthenticationPage();
        formAuthenticationPage.setUserName("tomsmith");
        formAuthenticationPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = formAuthenticationPage.clickLoginButton();

        String actualLoginStatus = secureAreaPage.getFlashMessage();
        String expectedLoginStatus = "You logged into a secure area!";

        assertTrue(actualLoginStatus.contains(expectedLoginStatus),"The page couldn't Login");


    }
}
