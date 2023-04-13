package Tests;

import Config.Configuration;
import Pages.Login_Page;
import Pages.Your_Beeline_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Your_Beeline_Tests extends Configuration{

    //1
    @Test
    public void Navigate_To_Beeline_Page() throws InterruptedException, IOException, ParseException {
        Login_Page signIn = new Login_Page(driver);
        Your_Beeline_Page beeline = new Your_Beeline_Page(driver);
        signIn.Launch_URL();
        signIn.Click_Sign_In_Button();
        signIn.Login_With_Facebook_With_Valid_Credentials();
        beeline.Navigate_To_Beeline_Page();
    }

    //2
    @Test
    public void Close_Beeline_Page() throws InterruptedException, IOException, ParseException {
        Login_Page signIn = new Login_Page(driver);
        Your_Beeline_Page beeline = new Your_Beeline_Page(driver);
        signIn.Launch_URL();
        signIn.Click_Sign_In_Button();
        signIn.Login_With_Facebook_With_Valid_Credentials();
        beeline.Navigate_To_Beeline_Page();
        beeline.Close_Beeline_Page();
    }

    //2
    @Test
    public void Accept_Matches_From_Beeline_Tests() throws InterruptedException, IOException, ParseException {
        Login_Page signIn = new Login_Page(driver);
        Your_Beeline_Page beeline = new Your_Beeline_Page(driver);
        signIn.Launch_URL();
        signIn.Click_Sign_In_Button();
        signIn.Login_With_Facebook_With_Valid_Credentials();
        beeline.Navigate_To_Beeline_Page();
        beeline.Accept_Matches_From_List();
    }

}