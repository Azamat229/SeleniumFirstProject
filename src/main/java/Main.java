//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nurbe\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        try {
//            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
//
//            Thread.sleep(2000);
//            WebElement element = driver.findElement(By.id("draggable"));
//            WebElement element2 = driver.findElement(By.id("droppable"));
//
//            Actions actions = new Actions(driver);
////            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();
//
//
//
//        } catch (InterruptedException e) {
//            System.out.println("EXEPTION SEKA");
//
//
//        } finally {
//            Thread.sleep(2000);
//            driver.quit();
//        }
//
//
//
//
//
//
//
//
//
////        input.sendKeys("Java", Keys.ENTER);
//
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////
////        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
////                .until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
////        String currentUrl = driver.getCurrentUrl();
////        String title = driver.getTitle(); // Return type of getTitle is String.
////        System.out.println(currentUrl + title);
////        WebElement element1 = driver.findElement(By.xpath("//button[@name='Регистрация']"));
////        Dimension elementSize = element1.getSize();
////        System.out.println("Height :" + elementSize.height + "Width : "+ elementSize.width);
//
////        Actions action = new Actions();
////        action.moveToElement()
////                .keyDown()
////                .keyUp()
////                .clickAndHold()
////                .release()
////                .build()
////                .perform();
//
//
//
////        } catch (Exception e) {
////            System.out.println("EXEPTION SEKA");
////            System.out.println("Massage" + e.getMessage());
////            System.out.println("Cause" + e.getCause());
////            e.printStackTrace();
////
////        }
//
//
////        WebDriverWait wait = new WebDriverWait(driver, 10); // wait for 10sec
////
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));
////
////        driver.findElement(By.id("name")).sendKeys("Azamat");
////        Random random = new Random();
////        int num = random.nextInt(100) + 1;
////        driver.findElement(By.id("email")).sendKeys("azamat"+ num +"@gmail.com");
////        driver.findElement(By.id("phone_number")).sendKeys("+996707444345");
////        driver.findElement(By.id("job_title")).sendKeys("Android developer");
////        driver.findElement(By.id("company")).sendKeys("IUCA");
//
//
////        driver.quit();
//
////    WebDriver driver = new ChromeDriver();
////        driver.get("https://www.hackerrank.com/");
////
////                WebElement header = driver.findElement(By.id("menu-item-2889"));
////                header.findElement(By.cssSelector("[href=\"/request-a-demo\"]")).click();
////
////                WebDriverWait wait = new WebDriverWait(driver, 10); // wait for 10sec
////
////                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));
////
////                driver.findElement(By.id("name")).sendKeys("Azamat");
////                Random random = new Random();
////                int num = random.nextInt(100) + 1;
////                driver.findElement(By.id("email")).sendKeys("azamat"+ num +"@gmail.com");
////                driver.findElement(By.id("phone_number")).sendKeys("+996707444345");
////                driver.findElement(By.id("job_title")).sendKeys("Android developer");
////                driver.findElement(By.id("company")).sendKeys("IUCA");
//    }
//}
