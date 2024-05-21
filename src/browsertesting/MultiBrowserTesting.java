package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

public class MultiBrowserTesting {
    static WebDriver driver;
    static String baseUrl = "https://demo.nopcommerce.com/";                        //Base Url

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter browser name to : ");
        String browser = scanner.nextLine();
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.get(baseUrl);                                                          //Open the url into browseer
        driver.manage().window().maximize();                                          //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));            //Implict wait
        System.out.println("Title of the page is : " + driver.getTitle());            //Print title
        System.out.println("Current Url is : " + driver.getCurrentUrl());             //Print current Url
        System.out.println("Page source is : " + driver.getPageSource());             //Print page source
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F"); //Navigate to Url
        System.out.println("Current Url is : " + driver.getCurrentUrl());             //Print Current Url
        driver.navigate().back();                                                     //Navigate to home page
        driver.navigate().forward();                                                  //Navigate to login page
        System.out.println("Current Url is : " + driver.getCurrentUrl());             //Print current url
        driver.navigate().refresh();                                                  //Refresh
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com"); //Write email
        driver.findElement(By.id("Password")).sendKeys("prime123");     //Write password
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();                            //Click login button
        driver.quit();                                                                 //Exit browser
        scanner.close();
    }
}

