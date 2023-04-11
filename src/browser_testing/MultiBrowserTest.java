package browser_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-4 - Project Name: com-saucedemo BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class MultiBrowserTest {
   static String browser = "Chrome";

   static  String baseUrl = "https://www.saucedemo.com/";

   static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name: ");
        }

        //open the URL int Browser
        driver.get(baseUrl);

        //maximise the Browser
        driver.manage().window().maximize();

        //we give implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //get the Current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //get page source
        System.out.println("Page source: " + driver.getPageSource());

        //find the userName field element
        WebElement userName = driver.findElement(By.id("user-name"));

        //type the email address into userName field element
        userName.sendKeys("locked_out_user");

        //find the password field element, and type the password into password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //closing the Browser
        driver.close();
    }
}
