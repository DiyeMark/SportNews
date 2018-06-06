import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewsWebSite {
    public static void main(String[] args) throws AWTException, IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver NEWSDriver = new ChromeDriver();
        NEWSDriver.manage().window().maximize();
        //NEWSDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        NEWSDriver.get("http://www.goal.com/en/lists/mbappe-bentancur-and-10-young-stars-to-watch-out-for-at/1hv7oea5fgskd1qhsq6x576f20");
        //WebElement goalArticle= NEWSDriver.findElement(By.className("widget-slide-list__content"));
        //WebElement topYoungTalentsP = goalArticle.findElement(By.tagName("p"));
        //String topYoungTalents = topYoungTalentsP.getAttribute("innerHTML");
        WebElement titleHeader = NEWSDriver.findElement(By.className("article-headline"));
        String headerText = titleHeader.getText();

        //System.out.println(headerText);
        List<WebElement> youngPlayers = ((ChromeDriver) NEWSDriver).findElementsByClassName("widget-slide-list__content");
        String topYoungTalents= "";

        for (WebElement element: youngPlayers){
            String topYoungTalent = element.findElement(By.tagName("p")).getText();

            topYoungTalents = topYoungTalents.concat(topYoungTalent);
        }
        //System.out.println(topYoungTalents);

        NEWSDriver.get("https://www.bbc.com/sport/football/44366554");
        WebElement secondTitleHeader = NEWSDriver.findElement(By.className("story-headline"));
        String secondHeaderText = secondTitleHeader.getText();

        //System.out.println(secondHeaderText);

        WebElement manUnited = NEWSDriver.findElement(By.id("story-body"));
        List<WebElement> manUnitedArticle = manUnited.findElements(By.tagName("p"));
        String fredTheRed= "";

        for (WebElement element: manUnitedArticle){
            String youngFred = element.getText();
            fredTheRed = fredTheRed.concat(youngFred);
        }
        //System.out.println(fredTheRed);

        NEWSDriver.get("localhost:8080/postPage");

        WebElement firstEditText = NEWSDriver.findElement(By.id("input"));
        firstEditText.sendKeys(headerText);

        WebElement firstPostBtn = NEWSDriver.findElement(By.id("postBtn"));
        firstPostBtn.click();

        WebElement secondEditText = NEWSDriver.findElement(By.id("secondInput"));
        secondEditText.sendKeys(topYoungTalents);

        WebElement secondPostBtn= NEWSDriver.findElement(By.id("secondPostBtn"));
        secondPostBtn.click();

        WebElement thirdEditText = NEWSDriver.findElement(By.id("thirdInput"));
        thirdEditText.sendKeys(secondHeaderText);

        WebElement thirdPostBtn= NEWSDriver.findElement(By.id("thirdPostBtn"));
        thirdPostBtn.click();

        WebElement fourthEditText = NEWSDriver.findElement(By.id("fourthInput"));
        fourthEditText.sendKeys(fredTheRed);

        WebElement fourthPostBtn= NEWSDriver.findElement(By.id("fourthPostBtn"));
        fourthPostBtn.click();

        NEWSDriver.get("localhost:8080");


    }
}
