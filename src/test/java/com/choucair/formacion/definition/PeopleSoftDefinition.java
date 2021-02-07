package com.choucair.formacion.definition;

import java.util.List;

import com.choucair.formacion.steps.PeopleSoftSteps;
import com.choucair.formacion.steps.PeopleSoftValidSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PeopleSoftDefinition {
	
	@Steps
	PeopleSoftSteps peoplesoftSteps;
	@Steps
	PeopleSoftValidSteps peopleSoftValidSteps;
	
	@Given("^Autentico con usuario \"([^\"]*)\" y clave \"([^\"]*)\"$")
	public void AutenticoConUsuarioYClave (String Usuario, String Clave) {
		peoplesoftSteps.loginPeopleSoft(Usuario, Clave);
	}
	
	@Given("^Ingreso a Información General$")
	public void IngresoAInformacionGeneral() {
		peoplesoftSteps.ingresar_menu_people();
	}
	
	@When("^Diligencio el formulario$")
	public void DiligencioElFormulario(DataTable dtDatosForm) {
		List<List<String>> data= dtDatosForm.raw();
		
		for (int i=1;i<data.size();i++) {
			peopleSoftValidSteps.diliguenciar_datos(data,i);
		}
	}
	@When("^Diligencio el formularioo ID_Set \"([^\"]*)\" Tipo_Identificacion \"([^\"]*)\" Documento_Identidad \"([^\"]*)\" Primer_Nombre \"([^\"]*)\" Segundo_Nombre \"([^\"]*)\" Apellido \"([^\"]*)\" Apellido_dos \"([^\"]*)\" Tipo_Contribuyente \"([^\"]*)\" Regimen \"([^\"]*)\" Responsabilidad \"([^\"]*)\" Unidad_de_Negocio \"([^\"]*)\" Dirección \"([^\"]*)\" Estado \"([^\"]*)\" Ciudad \"([^\"]*)\" Barrio \"([^\"]*)\" Condicion_pago \"([^\"]*)\" Faceletronica \"([^\"]*)\" Subcliente \"([^\"]*)\" Rutas \"([^\"]*)\" Codigo \"([^\"]*)\"$")
	public void DiligencioElFormularioo(String ID_Set, String Tipo_Identificacion, String Documento_Identidad, String Primer_Nombre, String Segundo_Nombre, String Apellido, String Apellido_dos,String Tipo_Contribuyente,String Regimen,String Responsabilidad,String Unidad_de_Negocio,String Dirección,String Estado,String Ciudad,String Barrio,String Condicion_pago,String Faceletronica,String Subcliente,String Rutas,String Codigo) {
			
			peopleSoftValidSteps.diliguenciar_datos2(ID_Set,Tipo_Identificacion,Documento_Identidad,Primer_Nombre,Segundo_Nombre,Apellido,Apellido_dos,Tipo_Contribuyente,Regimen,Responsabilidad,Unidad_de_Negocio,Dirección,Estado,Ciudad,Barrio,Condicion_pago,Faceletronica,Subcliente,Rutas,Codigo);
		
	}
	
	@Then("Verfico creación exitosa$")
	public void VerficoreaciónExitosa() {
		peopleSoftValidSteps.verificar_ingreso_datos_exitoso();
	}
	
	
	
}
