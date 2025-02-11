package BaseLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
    protected static Properties prop;
    protected static WebDriver driver;

    // Constructor to load configuration properties
    public BaseClass() {
        prop = new Properties();
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\ConfigLayer\\Config.properties"; // Corrected path
        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Failed to load configuration file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to initialize WebDriver and launch the browser
    public static void initialization() {
        String browser = prop.getProperty("browser");

        // Initialize WebDriver based on properties file
        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\AllDrivers\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if ("edge".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\AllDrivers\\msedgedriver.exe"); // Edge Driver setup
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Configure WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Launch the application
        String url = prop.getProperty("url");
        if (url != null) {
            driver.get(url);
        } else {
            throw new IllegalStateException("URL not specified in the configuration file.");
        }

        // Perform login if username and password are available
        String username = prop.getProperty("userName");
        String password = prop.getProperty("Password");
        if (username != null && password != null) {
            driver.findElement(By.name("email")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.xpath("//div[text()='Login']")).click();
        } else {
            System.err.println("Login credentials are missing in the configuration file.");
        }
    }
}
