package browser_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
public class ChromeBrowserTest {

    public static void main(String[] args) {

        String baseUrl = "https://www.saucedemo.com/";
        WebDriver driver = new ChromeDriver();//launch the Chrome Browser
        driver.get(baseUrl);//open the URL into the Browser

        //maximise the Browser
        driver.manage().window().maximize();

        //we give implicit wait to Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //get the Title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //get the page source
        System.out.println("Page source: " + driver.getPageSource());

        //find the username field element
        WebElement usesrName = driver.findElement(By.id("user-name"));

        //type the email address to email field
        usesrName.sendKeys("standard_user");

        //find the password field element, and type the password into password field
        driver.findElement(By.id("password")).sendKeys("password");

        //closing the Browser
        //driver.close();
    }
}
