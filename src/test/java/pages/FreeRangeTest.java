package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeRangeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Inicializa el webDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        // Navega a la pagina web
        driver.get("https://www.freerangetesters.com");
        // Encuentra un elemento utilizando su ID
        WebElement elementoPorId = driver.findElement(By.id("idDelELemento"));
        elementoPorId.click();
    }

    @Test
    public void test2() {
        driver.get("https://www.freerangetesters.com");
        WebElement elementoPorId = driver.findElement(By.id("idDelELemento"));
        elementoPorId.click();
    }

    @Test
    public void test3() {
        driver.get("https://www.freerangetesters.com");
        WebElement elementoPorId = driver.findElement(By.id("idDelELemento"));
        elementoPorId.click();
    }

    @AfterMethod
    public void tearDown() {
        // Cierra el navegador despues de la prueba
        if(driver != null) {
            driver.quit();
        }
    }
}
