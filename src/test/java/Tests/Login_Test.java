package Tests;

import Config.Configuration;
import Pages.Login_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Test extends Configuration{

    //1
    @Test
    public void Login_And_LogOut() throws InterruptedException, IOException, ParseException {
        Login_Page signIn = new Login_Page(driver);
        signIn.Launch_URL();
        signIn.Click_Sign_In_Button();
        signIn.Login_With_Facebook_With_Valid_Credentials();
        signIn.Like_Other_Person_Profile();
        signIn.DisLike_Other_Person_Profile();
        signIn.Logout();
    }

}