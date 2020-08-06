package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import steps.Hooks;

import java.util.List;
import java.util.Random;

public class ProductSearchPage extends BasePage{
 private Hooks hooks;
    private static String searchProductField = "input[role='combobox']";
    private static String searchSubmitButton="button[type='submit']";
    private static String productList = "div[data-test='component-product-card']";
    private static String addToCart = "button[data-test='component-att-button']";
    private static String goToBasket = "a[data-test='component-att-button-basket']";
    private static String productPrice = "span[data-e2e='product-line-price']";
    private static String productQuantity = "select[data-e2e='product-quantity']";

    public void openURL() {
        hooks.getDriver().get(URL);
    }

    public void searchProduct(String productName){
        hooks.getDriver().findElement(By.cssSelector(searchProductField)).sendKeys(productName);
        hooks.getDriver().findElement(By.cssSelector(searchSubmitButton)).click();
    }

    public  void selectRandomProductInList(){
        Random rand = new Random();
        List<WebElement> pList = hooks.getDriver().findElements(By.cssSelector(productList));
        pList.get(rand.nextInt(pList.size()+1)).click();
    }

    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(2500);
        hooks.getDriver().findElement(By.cssSelector(addToCart)).click();
        Thread.sleep(2500);
        hooks.getDriver().findElement(By.cssSelector(goToBasket)).click();
        Thread.sleep(2000);
    }

    public void verifyProductPriceWithQuantity(Integer quantity){
       WebElement productValue =  hooks.getDriver().findElement(By.cssSelector(productPrice));
       String getPrice = productValue.getText();
       String[] split = getPrice.split("£");
       Double expectedPrice = Double.valueOf(split[1])*quantity;
       Select select = new Select(hooks.getDriver().findElement(By.cssSelector(productQuantity)));
       select.selectByValue(String.valueOf(quantity));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("£"+expectedPrice,productValue.getText());




    }



}
