package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks {
  private RemoteWebDriver driver;
  public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

  public RemoteWebDriver getDriver() {
    return dr.get();
  }

  public void setDriver(RemoteWebDriver driver) {
    dr.set(driver);
  }

  @Before
  public void openBrowser() throws MalformedURLException {
    //WebDriverManager.chromedriver().setup();
    //driver = new ChromeDriver();
    //setDriver(driver);
    //driver.manage().window().maximize();
    DesiredCapabilities cap = DesiredCapabilities.chrome();
    URL u = new URL("http://localhost:4444/wd/hub");
    WebDriverManager.chromedriver().setup();
    driver = new RemoteWebDriver(u, cap);
    setDriver(driver);
  }

  @After
  public void tearDown() {
    getDriver().quit();

  }

}