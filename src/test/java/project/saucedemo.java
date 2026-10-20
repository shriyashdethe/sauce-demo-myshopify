package project;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import saucedemo.com.qspider.JavaUtility;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class saucedemo {

    private static WebDriver driver;

    
    
    

    public static void main(String[] args) throws IOException, InterruptedException
 {
        ObjectMapper objectMapper = new ObjectMapper();
        FileReader fileReader = new FileReader("resources/CommanData1.json");
        JsonNode data = objectMapper.readTree(fileReader);

        String username1 = data.get("User1").asText();
        String username2 = data.get("User2").asText();
        String username3 = data.get("User3").asText();
        String username4 = data.get("User4").asText();
        String username5 = data.get("User5").asText();
        String username6 = data.get("User6").asText();    
        String browser = data.get("Browser").asText();
        String password = data.get("Password").asText();
        String wpassword = data.get("WPassword").asText();
        String url = data.get("url").asText();

        
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("safari")) {

            driver = new SafariDriver();

        } else {

            System.out.println("Invalid browser name: " + browser);
            return;
        }

        driver.manage().window().maximize();

        driver.get(url);

        JavaUtility obj = new JavaUtility(driver);
        Thread.sleep(2000);
        obj.standard_user(username1, password);
        
        driver.navigate().refresh();
        
        Thread.sleep(2000);
        obj.locked_out_user(username2, password);
        Thread.sleep(2000);
        
        driver.navigate().refresh();
        obj.problem_user( username3,  password);
        Thread.sleep(2000);
        
        driver.navigate().refresh();
        
        obj.performance_glitch_user(username4, password);
        Thread.sleep(2000);
        
        
        driver.navigate().refresh();
        obj.error_user(username5, password);
        Thread.sleep(2000);
        
        
        driver.navigate().refresh();
        obj.visual_user(username6, password);
        driver.quit();

    }
}

