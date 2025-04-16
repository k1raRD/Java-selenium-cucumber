package pages;

public class PaginaPrincipal extends BasePage{

    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirPLanButton = "//a[normalize-space()='Elegir Plan' and @href]";
    //a[normalize-space()='']
    public PaginaPrincipal() {
        super(driver);
    }

    // Metodo para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
    }

    public void clickOnSectionNavigationBar(String section) {
        // Remplaza el marcador de posicion en sectionLInk con el nombre
        String xPathSection = String.format(sectionLink, section);
        clickElement(xPathSection);
    }

    public void clickOnElegirPlan() {
        clickElement(elegirPLanButton);
    }
}
