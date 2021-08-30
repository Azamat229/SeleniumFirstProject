package iu_selenium.test;

import iu_selenium.pages.AmazonSearchPageObjects;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPageTest {
    private static WebDriver driver = null;

    public static void main(String[] args) {
        amazonSearchTest();

    }

    @Test
    public static void amazonSearchTest(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\java\\iu_selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        AmazonSearchPageObjects searchPageObj = new AmazonSearchPageObjects(driver);
        driver.get("https://www.amazon.com");

        String searchText = "selenium cookbook";

        searchPageObj.setTextInSearchBox(searchText);

        searchPageObj.clickSearchButton();

        searchPageObj.veryEqualResult();

        System.out.println(searchPageObj.countSum());

//        WebElement waitSearch = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

    }
    @After
    public void close(){
        driver.close();
    }
}
