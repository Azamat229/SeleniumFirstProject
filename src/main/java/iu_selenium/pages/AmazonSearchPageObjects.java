package iu_selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class AmazonSearchPageObjects {
    WebDriver driver = null;
    String searchText = "selenium cookbook";
    ArrayList<WebElement> dollar;
    ArrayList<WebElement> cent;


    By textbox_search = By.id("twotabsearchtextbox");
    By button_search = By.id("nav-search-submit-button");
    By searchTextResult = By.xpath("//span[@class='a-color-state a-text-bold']");
    By dollarPath = By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small\"]//span[@class=\"a-price\"]//span[@class=\"a-price-whole\"]");
    By centPath = By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small\"]//span[@class=\"a-price\"]//span[@class=\"a-price-fraction\"]");

//            dollar = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small\"]//span[@class=\"a-price\"]//span[@class=\"a-price-whole\"]"));//*[contains(@class,'a-offscreen')]
//    cent = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small\"]//span[@class=\"a-price\"]//span[@class=\"a-price-fraction\"]"));//*[contains(@class,'a-offscreen')]


    public AmazonSearchPageObjects(WebDriver driver){
        this.driver = driver;
    }
    public void veryEqualResult(){
        String getString = driver.findElement(searchTextResult).getText();
        getString = getString.substring(1, getString.length() - 1);
        Assertions.assertEquals(getString, searchText);
    }

    public void setTextInSearchBox(String text){
        driver.findElement(textbox_search).sendKeys(text);

    }
    public void clickSearchButton(){
        driver.findElement(button_search).sendKeys(Keys.RETURN);//??
    }

    public String countSum(){
        dollar = (ArrayList<WebElement>) driver.findElements(dollarPath);
        cent = (ArrayList<WebElement>) driver.findElements(centPath);

        double ans = 0.0;
        for (int i = 0; i <= dollar.size() - 1; i++) {
            double newDollar = Double.parseDouble(dollar.get(i).getText());
            double newCent = Double.parseDouble(cent.get(i).getText());
            ans += newDollar + (newCent / 100);
        }
        return "SUM" + ans;


    }




}
