package com.choucair.formacion.definition;

import com.choucair.formacion.steps.BuyArticles;
import com.choucair.formacion.steps.BuyOnlineStoreSteps;
import com.choucair.formacion.steps.SucessfullBuy;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BuyOnlineStoreDefinitions {
	
	@Steps
	BuyOnlineStoreSteps buyonlinestoresteps; 
	
	@Steps
	BuyArticles buyarticles;
	
	@Steps
	SucessfullBuy successfulbuy;
	
	@Given("^Abrir pagina Your Logo con correo ([^\"]*)$")
	public void abrirPaginaYourLogoConCorreo(String Correo) {
	    // Write code here that turns the phrase above into concrete actions
		buyonlinestoresteps.OpenOnlineStorePage(Correo);
	   
	}

	@Given("^Realizar registro del cliente Nombre ([^\"]*) Apellido \"([^\"]*)\" Clave \"([^\"]*)\" Dia \"([^\"]*)\" Mes \"([^\"]*)\" Ano \"([^\"]*)\" Direccion \"([^\"]*)\" Ciudad \"([^\"]*)\" Estado \"([^\"]*)\" CodigoPostal \"([^\"]*)\" Telefono \"([^\"]*)\"$")
	public void realizarRegistroDelClienteNombreApellidoClaveDiaMesAnoDireccionCiudadEstadoTelefono(String Nombre, String Apellido, String Clave, String Dia, String Mes, String Ano, String Direccion, String Ciudad, String Estado, String CodigoPostal, String Telefono) {
	    buyonlinestoresteps.ClintInformation(Nombre, Apellido, Clave, Dia, Mes, Ano, Direccion, Ciudad, Estado, CodigoPostal, Telefono);
	    
	}

	@When("^Realizar compra de tres articulos$")
	public void realizarCompraDeTresArticulos() {
	    // Write code here that turns the phrase above into concrete actions
	    buyarticles.ChoiseArticles();
	}

	@When("^Ingresar medio de pago$")
	public void ingresarMedioDePago() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("^Verfico compra exitosa Mensaje \"([^\"]*)\"$")
	public void verficoCompraExitosaMensaje(String mensajeEsperado) {
	    // Write code here that turns the phrase above into concrete actions
	    successfulbuy.MessageSuccess(mensajeEsperado);
	}


}
