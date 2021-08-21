
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurbe\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");

            Thread.sleep(2000);
            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
//            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();



        } catch (InterruptedException e) {
            e.printStackTrace();


        } finally {
            Thread.sleep(2000);
            driver.quit();
        }









//        input.sendKeys("Java", Keys.ENTER);

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
//        String currentUrl = driver.getCurrentUrl();
//        String title = driver.getTitle(); // Return type of getTitle is String.
//        System.out.println(currentUrl + title);
//        WebElement element1 = driver.findElement(By.xpath("//button[@name='Регистрация']"));
//        Dimension elementSize = element1.getSize();
//        System.out.println("Height :" + elementSize.height + "Width : "+ elementSize.width);

//        Actions action = new Actions();
//        action.moveToElement()
//                .keyDown()
//                .keyUp()
//                .clickAndHold()
//                .release()
//                .build()
//                .perform();
    }
}
