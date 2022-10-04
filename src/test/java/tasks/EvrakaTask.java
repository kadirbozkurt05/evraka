package tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AmazonPage;
import utils.Driver;

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
        System.out.println("RESULTS FOR 512");



        System.out.println("iPhone 13   Size:"+amazonPage.size.getText());
        System.out.println(amazonPage.color.getText().replace("Renk","Color")+" Price:"+amazonPage.priceBig.getText()
                +","+ amazonPage.priceLittle.getText()+ amazonPage.priceSymbol.getText());
        System.out.println("Stock:"+amazonPage.stock.getText());

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("RESULTS FOR 256");
        amazonPage.button256.click();

        /*
        Thread.sleep for force driver to wait until presence of the new price
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("iPhone 13   Size:"+amazonPage.size.getText());
        System.out.println(amazonPage.color.getText().replace("Renk","Color")+" Price:"+amazonPage.priceBig.getText()
        +","+ amazonPage.priceLittle.getText()+ amazonPage.priceSymbol.getText());
        System.out.println("Stock:"+amazonPage.stock.getText());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("RESULTS FOR 128");
        amazonPage.button128.click();
        //No stock for this color, so need to change color to get price and stock
        amazonPage.colorRed.click();

        /*
        Thread.sleep for force driver to wait until presence of the new price
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("iPhone 13   Size:"+amazonPage.size.getText());
        System.out.println(amazonPage.color.getText().replace("Renk","Color")+" Price:"+amazonPage.priceBig.getText()
                +","+ amazonPage.priceLittle.getText()+ amazonPage.priceSymbol.getText());
        System.out.println("Stock:"+amazonPage.stock.getText());
        Driver.closeDriver();

    }
}
