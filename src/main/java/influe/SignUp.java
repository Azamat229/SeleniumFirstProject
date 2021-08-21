package influe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SignUp {

    @Test
    public void signUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurbe\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.influential.co");

        WebElement header = driver.findElement(By.id("navbar"));
        header.findElement(By.cssSelector("[href=\"/request-a-demo\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10); // wait for 10sec

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));

        driver.findElement(By.id("name")).sendKeys("Azamat");
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        driver.findElement(By.id("email")).sendKeys("azamat"+ num +"@gmail.com");
        driver.findElement(By.id("phone_number")).sendKeys("+996707444345");
        driver.findElement(By.id("job_title")).sendKeys("Android developer");
        driver.findElement(By.id("company")).sendKeys("IUCA");




//        driver.quit();
    }
}
