package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

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

    @FindBy(css = ".a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal")
    public WebElement firstResult;

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







}
