package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AmazonPage;
import utils.Driver;

import java.util.List;

public class EvrakaTask {

    private static AmazonPage amazonPage;

    public static void main(String[] args) {
        amazonPage = new AmazonPage();

        //Open Amazon Page
        Driver.getDriver().get("https://www.amazon.com.tr/");
        //Accept Cookies
        amazonPage.acceptCookies.click();
        //Search "iPhone13 512" and press enter
        amazonPage.searchBox.sendKeys("iPhone13 512"+ Keys.ENTER);
        //Verify user see the searched vaule on the screen
        System.out.println("RESULTS ARE LISTED = " + amazonPage.searchedValue.getText());
        //Go to the first phone from the results
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        //Wait untill the result is visible
        wait.until(ExpectedConditions.visibilityOf(amazonPage.firstResult));
        //Click the first result
        amazonPage.firstResult.click();
        System.out.println("-------------------------------------------------------------------------------------------");



        for (WebElement each : amazonPage.getSizes()) {

            try {
                each.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("RESULTS FOR "+amazonPage.size.getText());
                System.out.println("iPhone 13   Size:"+amazonPage.size.getText());
                System.out.print(amazonPage.color.getText().replace("Renk","Color"));
                System.out.println(" Price:"+amazonPage.priceBig.getText()+","+ amazonPage.priceLittle.getText()+ amazonPage.priceSymbol.getText());
                System.out.println("Stock:"+amazonPage.stock.getText());
                System.out.println("-------------------------------------------------------------------------------------------");

            }catch (NoSuchElementException e){
                System.out.println();
                System.out.println("NO STOCKS FOR "+amazonPage.size.getText());
                System.out.println("-------------------------------------------------------------------------------------------");
            }
        }
        Driver.closeDriver();
    }
}
