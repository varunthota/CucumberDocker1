package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import steps.Hooks;

import static org.junit.Assert.assertTrue;

public class mainPage {
    private static final String URL = "https://www.google.ie";
    private Hooks hooks =  new Hooks();

    public void openGooglePage() {
        hooks.getDriver().get(URL);
        System.out.println(hooks.getDriver().getTitle());
    }

    public void i_print_title_and_URL() {
        assertTrue(hooks.getDriver().getCurrentUrl().contains(URL));
    }


    public void getCartValue(){
        hooks.getDriver().findElement(By.cssSelector(".add-to-trolley-main")).click();
        hooks.getDriver().findElement(By.cssSelector("a[data-test='component-att-button-basket']")).click();
        String cartText = hooks.getDriver().findElement(By.cssSelector("span[class*='ProductCard__productLinePrice']")).getText();
        String[] splitText = cartText.split(" ");
        Integer value = Integer.valueOf(splitText[1]);
        Integer expectedCartValue = value*2;
        Select select = new Select(hooks.getDriver().findElement(By.cssSelector("select[data-e2e='product-quantity']")));
        select.selectByValue("2");
        Assert.assertEquals(expectedCartValue,hooks.getDriver().findElement(By.cssSelector("span[class*='ProductCard__productLinePrice']")).getText());
    }
}
