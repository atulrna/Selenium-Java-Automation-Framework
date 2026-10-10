import base.DriverFactory;
import utils.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String browser = ConfigReader.getProperty("browser");

        DriverFactory.initDriver(browser);

        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Closing browser...");
        DriverFactory.quitDriver();
        System.out.println("Browser closed.");
    }
}