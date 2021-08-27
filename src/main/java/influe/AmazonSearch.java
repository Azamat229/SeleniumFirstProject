package influe;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearch {

    private static Logger logger = LogManager.getLogger(AmazonSearch.class);
    ArrayList<WebElement> dollar;
    ArrayList<WebElement> cent;
    public ChromeDriver   driver;

    @Test
    public void firstText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aza\\IdeaProjects\\SeleriumFirstProject\\src\\main\\java\\influe\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        String searchText = "selenium cookbook";

        driver.get("https://www.amazon.com");

        WebElement waitSearch = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        // explicit wait
        // wait unit input field loaded to avoid no such element exception
        // WebDriverWait was deprecated! Does it okay?

        waitSearch.sendKeys(searchText);

        driver.findElement(By.id("nav-search-submit-button")).click();

        String searchTestResule = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        searchTestResule = searchTestResule.substring(1, searchTestResule.length() - 1);

        Assertions.assertEquals(searchTestResule, searchText);

        if (Objects.equals(searchTestResule, searchText)) {
            logger.info("Locate in expected page");
            Assertions.assertTrue(true);
        } else {
            logger.error("Search result isn't equal to request " + searchTestResule + " != " + searchText);
            Assertions.fail();
        }
        Thread.sleep(1000);

        dollar = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small\"]//span[@class=\"a-price\"]//span[@class=\"a-price-whole\"]"));// *[contains(@class,'a-offscreen')]
        cent = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small\"]//span[@class=\"a-price\"]//span[@class=\"a-price-fraction\"]"));// *[contains(@class,'a-offscreen')]

        Double ans = 0.0;
        for (int i = 0; i <= dollar.size() - 1; i++) {
            double newDollar = Double.parseDouble(dollar.get(i).getText());
            double newCent = Double.parseDouble(cent.get(i).getText());
            ans += newDollar + (newCent / 100);
        }
        System.out.println("Sum: $" + ans);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // this is implicit wait,

        driver.quit();

    }

    // @After
    // public void close() {
    //
    // }
}