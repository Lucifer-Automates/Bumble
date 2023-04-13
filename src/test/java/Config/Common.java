package Config;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Common extends Configuration{

    public WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
    }

    public Properties readConfigFile(String configFile) {
        Properties prop = null;
        try (InputStream input = new FileInputStream(new File("src/test/resources/" + configFile + ".properties").getAbsolutePath())) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public void click(String element){
        driver.findElement(By.xpath(element)).click();
    }

    public void type(String element, String input){
        driver.findElement(By.xpath(element)).sendKeys(input);
    }

    public void log(String log) {
        System.out.println(log);
        Reporter.log(log + "<br>");
    }

    public WebElement findElement(String elementName) {

        String locator;

        locator = elementName;

        int count = 0;
        while (count < 4) {
            try {
                if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
                    locator = locator.substring(5); // remove "link=" from
                    // locator
                    try {
                        if (locator.contains(" "))
                            return driver.findElement(By.partialLinkText(locator));

                        return driver.findElement(By.linkText(locator));
                    } catch (Exception e) {
                        return null;
                    }
                }
                if (locator.startsWith("id=")) {
                    locator = locator.substring(3); // remove "id=" from locator
                    try {
                        return driver.findElement(By.id(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("//")) {
                    try {
                        return driver.findElement(By.xpath(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("css=")) {

                    locator = locator.substring(4); // remove "css=" from
                    // locator
                    try {
                        return driver.findElement(By.cssSelector(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else if (locator.startsWith("name=")) {

                    locator = locator.substring(5); // remove "name=" from
                    // locator
                    try {
                        return driver.findElement(By.name(locator));
                    } catch (Exception e) {
                        return null;
                    }
                } else {
                    try {
                        return driver.findElement(By.id(locator));
                    } catch (Exception e) {
                        return null;
                    }

                }
            } catch (StaleElementReferenceException e) {
                e.toString();

                count = count + 1;
                // System.out.println("Trying["+
                // count+"] to recover from a stale element :" +
                // e.getMessage());
            }
            count = count + 4;
        }
        return null;

    }


    public void pause(int secs) {
        try {
            Thread.sleep(secs * 200);
        } catch (InterruptedException interruptedException) {

        }
    }

    public boolean isElementDisplayed(String elementLocator) {
        try {
            return driver.findElement(By.xpath(elementLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementIsNotDisplayed(String by) throws InterruptedException {

        for (int second = 0;; second++) {
            if (second >= 60) {

                break;
            }
            try {
                if (!isElementDisplayed(by))
                    break;
            } catch (Exception e) {
            }
            pause(1000);
        }
        return false;
    }

    public boolean isElementPresent(String locator) {

        WebElement webElement = this.findElement(locator);
        if (webElement != null) {
            return true;
        } else {

            return false;
        }
    }

    public static String generateRandomChars(int length) {
        String total = "iokijfmnbxcvfrpqsdfgvcxzdferiuytjndifur";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char _char = total.charAt((int) (Math.random() * 100) % total.length());
            buf.append(_char);
        }
        return buf.toString();
    }

    public static int GenerateRandomNumber(int length) {
        Random rand = new Random();
        int num = rand.nextInt(length);
        int numNoRange = rand.nextInt();
        return numNoRange;
    }

    public String read_json(String Json_Key) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/Static_Parameters.json");
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        JSONObject user = (JSONObject) usersList.get(0);
        String Name = (String)user.get(Json_Key);
        return Name;
    }

    public void makeScreenshot(WebDriver driver, String screenshotName) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";
        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "surefire-reports" + File.separator;
            File screenshotFolder = new File(reportFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot,
                    new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
        } catch (IOException e) {
            this.log("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public void Hove_Over_Elements(String element){
        WebElement ele = driver.findElement(By.xpath(element));
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    public void Hove_Over_Elements_And_ClickOn_Its_Sub_Element(String element, String subElement){
        WebElement MainTile = driver.findElement(By.xpath(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(MainTile);
        WebElement YesNoButton = driver.findElement(By.xpath(subElement));
        actions.moveToElement(YesNoButton);
        actions.click().build().perform();
    }


}