package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement acceptCookies;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = ".a-color-state.a-text-bold")
    public WebElement searchedValue;


    @FindBy(xpath = "(//span[@class='selection'])[1]")
    public WebElement size;

    @FindBy(id = "variation_color_name")
    public WebElement color;

    @FindBy(css = ".a-price-whole")
    public WebElement priceBig;

    @FindBy(css = ".a-price-fraction")
    public WebElement priceLittle;


    @FindBy(css = ".a-price-symbol")
    public WebElement priceSymbol;

    @FindBy(css = ".a-size-medium.a-color-success")
    public WebElement stock;

    @FindBy(id = "size_name_1")
    public WebElement button256;

    @FindBy(id = "size_name_0")
    public WebElement button128;

    @FindBy(id = "color_name_1")
    public WebElement colorRed;

    @FindBy(xpath = "//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']")
    public WebElement firstResult;


    public List<WebElement> getSizes(){
        return Driver.getDriver().findElements(By.xpath("//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal a-spacing-top-micro swatches swatchesSquare']//li"));
    }





}
