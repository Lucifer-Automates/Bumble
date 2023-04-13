package Pages;

import Config.Common;
import Config.Configuration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

public class Your_Beeline_Page extends Abstract{

    public WebDriver driver;
    Common common = new Common(driver);
    Configuration config = new Configuration();

    public Your_Beeline_Page(WebDriver driver) {
        this.driver=driver;
    }

    public void Navigate_To_Beeline_Page() throws InterruptedException, MalformedURLException {
        driver.findElement(By.xpath(MatchQueueFirstTile)).click();
        Thread.sleep(3000);
        common.log("Clicked Match Queue Queue First Tile To Open Beeline Page");
    }

    public void Close_Beeline_Page() throws InterruptedException {
        driver.findElement(By.xpath(Close_Icon)).click();
        Thread.sleep(3000);
        common.log("Clicked On Close Icon Of Beeline Page");
    }

    public void Accept_Matches_From_List() throws InterruptedException, IOException, ParseException {
        for(int i = 0; i<=10; i++){
            String MainTile = Figure_Icons+i+"]\"";
            common.Hove_Over_Elements_And_ClickOn_Its_Sub_Element(MainTile,Figure_Yes_Option);
            Thread.sleep(1000);
        }

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