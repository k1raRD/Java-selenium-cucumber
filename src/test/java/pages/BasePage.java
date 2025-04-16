package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Define the base of a webPage and useful methods.
 */
public class BasePage {

    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * This function is to close the webDriver and the browser.
     */
    public static void closeBrowser() {
        driver.quit();
    }

    /**
     * Look for a webElement on the web page by a locator.
     * @param locator xPath of the element to find.
     * @return {@link org.openqa.selenium.WebElement}
     */
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /**
     * Click an element specify by the locator argument.
     * @param locator xPath of the element to click.
     */
    public void clickElement(String locator) {
        find(locator).click();
    }

    /**
     * Write in an input element.
     * @param locator xPath of the input element.
     * @param valueToSend value to write in the input.
     */
    public void write(String locator, String valueToSend) {
        find(locator).clear();
        find(locator).sendKeys(valueToSend);
    }

    /**
     * Allow select an option on an HTML Select element by its value.
     * @param locator xPath of the select element.
     * @param value option value to select.
     */
    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(value);
    }

    /**
     * Allow select an option on an HTML Select element by its index.
     * @param locator xPath of the select element.
     * @param index option value to select.
     */
    public void selectFromDropdownByIndex(String locator, int index) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(index);
    }

    /**
     * Obtain how many options are in an HTML select element.
     * @param locator xPath of the select element.
     * @return {@link Integer} options size.
     */
    public int dropDownSize(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    /**
     * Get all options values from a HTML Select element.
     * @param locator xPath of the Select element.
     * @return {@link List}<{@link String}> with options values.
     */
    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.stream()
                              .map(WebElement::getText)
                              .toList();
    }
}