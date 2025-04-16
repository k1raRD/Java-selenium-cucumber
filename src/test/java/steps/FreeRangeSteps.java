package steps;

import io.cucumber.java.en.*;
import static org.testng.Assert.*;

import org.testng.asserts.SoftAssert;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

import java.util.Arrays;
import java.util.List;

public class FreeRangeSteps {

    SoftAssert softAssert = new SoftAssert();
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos paginaCursos = new PaginaCursos();
    PaginaFundamentosTesting paginaFundamentosTesting = new PaginaFundamentosTesting();
    PaginaRegistro paginaRegistro = new PaginaRegistro();

    @Given("I navigates to to www.freerangetesters.com")
    public void navigateToFreerangetestersCaom() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to the {word} using the navigation bar")
    public void goToTheSectionUsingTheNavigationBar(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @And("^(?:I|The user) selects? Introduccion al testing$")
    public void selectIntroduccionAlTesting() {
        paginaCursos.clickFundamentosTestingLink();
        paginaFundamentosTesting.clickIntroduccionTestingLink();
    }

    @When("^(?:I|The user) selects? elegir Plan$")
    public void iSelectElegirPlan() {
        landingPage.clickOnElegirPlan();
    }

    @Then("^(?:I|The user) can validate the options in the checkout page$")
    public void iCanValidateTheOptionsInTheCheckoutPage() {
        List<String> list = paginaRegistro.getDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 12 productos",
                                                   "Academia: $178 / año • 12 productos",
                                                    "Free: Gratis • 3 productos");
        assertEquals(list, listaEsperada);
    }

    public void ejemplulis() {
        String palabraEsperada = "Pepe";
        String palabraObtenida = "Pepa";

        // Verificar que dos valores son iguales
        assertNotEquals(palabraObtenida, palabraEsperada);
        assertTrue(palabraEsperada.contains(palabraObtenida));

        // Soft assertions, no detiene la ejecucion al fallar, ideal para verificar muchas cosas pequenas a la vez
        softAssert.assertEquals(palabraObtenida, palabraEsperada);
        softAssert.assertTrue(palabraObtenida.contains(palabraEsperada));
        softAssert.assertNotEquals(palabraObtenida, palabraEsperada);
    }
}
