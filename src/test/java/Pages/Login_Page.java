package Pages;

import Config.Common;
import Config.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

public class Login_Page extends Abstract{

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public Login_Page(WebDriver driver) {
        this.driver=driver;
    }

    public void Launch_URL() throws InterruptedException, MalformedURLException {
        URL url = new URL("https://bumble.com/en-in/");
        driver.get(String.valueOf(url));
        common.log("Url Launched.");
        Thread.sleep(3000);
    }

    public void Click_Sign_In_Button() throws InterruptedException {
        driver.findElement(By.xpath(SignInButton)).click();
        Thread.sleep(3000);
        common.log("Clicked On Sign In Button");
    }

    public void Login_With_Facebook_With_Valid_Credentials() throws InterruptedException, IOException, ParseException {
        // It will return the parent window name as a String
        String parent=driver.getWindowHandle();
        common.log("Window 1 is :- " + parent);
        common.log("window is now switching");

        driver.findElement(By.xpath(Continue_With_Facebook)).click();
        Thread.sleep(3000);
        Set<String> s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {

            String child_window=I1.next();
            common.log("Window 2 is :- " + child_window);

            if(!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                common.log("Switched to Window 2 is :- " + child_window);
            }
        }

        Thread.sleep(3000);
        common.log("Clicked On Continue with Facebook Button");
        String Email = common.read_json("UserEmail");
        String Password = common.read_json("UserPassword");
        driver.findElement(By.xpath(EmailFieldSignIn)).sendKeys(Email);
        common.log("Entered Email : "+ Email);
        driver.findElement(By.xpath(PasswordFieldSignIn)).sendKeys( Password);
        common.log("Entered Password : "+ Password);
        driver.findElement(By.xpath(LoginButton)).click();
        common.log("Clicked On Login Button");
        Thread.sleep(10000);
        driver.switchTo().window(parent);
    }

    public void Like_Other_Person_Profile() throws InterruptedException {
        driver.findElement(By.xpath(YesButton)).click();
        common.log("Clicked On Like Button");
        Thread.sleep(2000);
    }

    public void DisLike_Other_Person_Profile() throws InterruptedException {
        driver.findElement(By.xpath(NoButton)).click();
        common.log("Clicked On Dis-Like Button");
        Thread.sleep(2000);
    }

    public void Logout() throws InterruptedException {
        driver.findElement(By.xpath(Profile_SideBar)).click();
        common.log("Clicked On Profile Button");
        Thread.sleep(2000);
        driver.findElement(By.xpath(LogoutButtonSideBar)).click();
        common.log("Clicked On Logout");
        Thread.sleep(2000);
        driver.findElement(By.xpath(LogoutButton)).click();
        common.log("Clicked On Logout Button");
        Thread.sleep(4000);
        driver.findElement(By.xpath(Continue_With_Facebook)).isDisplayed();
        common.log("USer Logged Out");
    }

}