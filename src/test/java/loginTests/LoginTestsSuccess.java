package loginTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FormAuthenticationPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTestsSuccess extends BaseTests {

    @Test(priority = 0)
    public void HomePageOpenSuccessfully(){

        String expectedLink = "https://the-internet.herokuapp.com/";
        String currentLink = driver.getCurrentUrl();

        assertEquals(expectedLink,currentLink,"Home Page couldn't oppen");

    }
    @Test(priority = 1 , dependsOnMethods = "HomePageOpenSuccessfully")
    public void loginTestsSuccessfully(){
        FormAuthenticationPage formAuthenticationPage = homePage.clickFormAuthenticationPage();
        formAuthenticationPage.setUserName("tomsmith");
        formAuthenticationPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = formAuthenticationPage.clickLoginButton();

        String actualLoginStatus = secureAreaPage.getFlashMessage();
        String expectedLoginStatus = "You logged into a secure area!";
        assertTrue(actualLoginStatus.contains(expectedLoginStatus),"The page couldn't Login");


    }
    @Test(priority = 2 , dependsOnMethods = "loginTestsSuccessfully" )
    public void logOutTestsSuccussfully(){
        FormAuthenticationPage formAuthenticationPage = homePage.clickFormAuthenticationPage();
        formAuthenticationPage.setUserName("tomsmith");
        formAuthenticationPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = formAuthenticationPage.clickLoginButton();

        formAuthenticationPage = secureAreaPage.clickLogOut();
        String actualLogOutStatus = secureAreaPage.getFlashMessage();
        String expectedLogOutStatus="You logged out of the secure area!";
        assertTrue(actualLogOutStatus.contains(expectedLogOutStatus),"The page couldn't Log out");


    }

}
