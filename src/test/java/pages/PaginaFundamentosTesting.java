package pages;

import org.openqa.selenium.WebDriver;

public class PaginaFundamentosTesting extends BasePage{

    private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    public PaginaFundamentosTesting() {
        super(driver);
    }

    public void clickIntroduccionTestingLink() {
        clickElement(introduccionTestingLink);
    }
}
