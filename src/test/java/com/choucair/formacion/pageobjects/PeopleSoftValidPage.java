package com.choucair.formacion.pageobjects;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Factory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PeopleSoftValidPage extends PageObject{
	
	//Campo ID
	@FindBy(xpath="//*[@id='LC_CUSTOMER_AD_SETID']")
	public WebElementFacade idset;
	
	//Tipo de documento
	@FindBy(xpath="//*[@id='LC_CUSTOMER_AD_TIPO_IDENTIFICAC']") 
	public WebElementFacade tipodoc;
	
	//Numero documento
	@FindBy(xpath="//*[@id='LC_CUSTOMER_AD_NIT_PROVEEDOR']")
	public WebElementFacade numdoc;
	
	//Añadir
	@FindBy(xpath="//*[@id='#ICSearch']")
	public WebElementFacade anadir;
	
	//Primer Nombre
	@FindBy(xpath="//*[@id='LC_CUSTOM_NAME_LC_MMG_PRIM_NOMBRE$0']")
	public WebElementFacade nameone;
	
	//Segundo Nombre
	@FindBy(xpath="//*[@id='LC_CUSTOM_NAME_LC_MMG_SEGU_NOMBRE$0']")
	public WebElementFacade nametwo;
	
	//Apellido Uno
	@FindBy(xpath="//*[@id='LC_CUSTOM_NAME_LC_MMG_PRI_APELLID$0']")
	public WebElementFacade flastname;
	
	//Apellido Dos
	@FindBy(xpath="//*[@id='LC_CUSTOM_NAME_LC_MMG_SEG_APELLID$0']")
	public WebElementFacade slastname;
	
	//Actividad
	@FindBy(xpath="//a[contains(text(),'Actividad')]")
	public WebElementFacade activityt;
	
	//Tipo de Contribuyente
	@FindBy(xpath="//*[@id='LC_CUST_TAXTYPE_CTB_TYPE_HO$0']")
	public WebElementFacade tipoCont;
	
	//Tipo de Regimen
	@FindBy(xpath="//*[@id='CK_CUST_TAXT_WK_CK_CODIGO$0']")
	public WebElementFacade reg;
	
	//Tipo de Responsabilidad 
	@FindBy(xpath="//*[@id='CK_LC_CUST_TAXT_CK_CODIGO$0']")
	public WebElementFacade resp;
	
	//Pestaña Informacion General
	@FindBy(xpath="//a[contains(text(),'Información General')]")
	public WebElementFacade infogral;
	
	// Unidad de negocio
	@FindBy(xpath="//*[@id='CUSTOMER_CUST_FIELD_C6']")
	public WebElementFacade unineg;
	
	//Representante Legal
	@FindBy(xpath="//*[@id='CK_REPR_LEGAL_NAME1']")
	public WebElementFacade replegal;
	
	//Tipo Documento
	@FindBy(xpath="//*[@id='CK_REPR_LEGAL_TIPO_IDENTIFICAC']") 
	public WebElementFacade tipodoci;
	
	//Num doc
	@FindBy(xpath="//*[@id='CK_REPR_LEGAL_ID_NUMBER']")
	public WebElementFacade numdoci;
	
	// Equipo asistencia
	@FindBy(xpath="//*[@id=\"CUST_TEAM_SUPPORT_TEAM_CD$0\"]")
	public WebElementFacade equiasis;
	
	//Checkbox
	@FindBy(xpath="//*[@id='CUST_ADDR_SEQ_BILL_TO_ADDR$0']")
	public WebElementFacade check1;
	@FindBy(xpath="//*[@id='CUST_ADDR_SEQ_SHIP_TO_ADDR$0']")
	public WebElementFacade check2;
	@FindBy(xpath="//*[@id='CUST_ADDR_SEQ_SOLD_TO_ADDR$0']")
	public WebElementFacade check3;
	@FindBy(xpath="//*[@id='CUSTOMER_WRK_PRIMARY_BILL_TO$0']")
	public WebElementFacade check4;
	@FindBy(xpath="//*[@id='CUSTOMER_WRK_PRIMARY_SHIP_TO$0']")
	public WebElementFacade check5;
	@FindBy(xpath="//*[@id='CUSTOMER_WRK_PRIMARY_SOLD_TO$0']")
	public WebElementFacade check6;
	
	//direccion
	@FindBy(xpath="//*[@id='CUST_ADDRESS_ADDRESS1$0']")
	public WebElementFacade direc;
	
	//Estado
	@FindBy(xpath="//*[@id='CUST_ADDRESS_STATE$0']")
	public WebElementFacade state;
	/*@FindBy(xpath="//*[@id='CUST_ADDRESS_STATE$prompt$img$0']") 
	public WebElementFacade esta1;
	@FindBy(xpath="//a[contains(text(),'BOGOTA')]")
	public WebElementFacade esta2;*/
	
	//Ciudad
	@FindBy(xpath="//*[@id='CK_ADDRESS_WRK_CITY$0']")
	public WebElementFacade city;
	/*@FindBy(xpath="//*[@id='CK_ADDRESS_WRK_CITY$prompt$img$0']")
	public WebElementFacade city1;
	@FindBy(xpath="//a[contains(text(),'11001')]")
	public WebElementFacade city2;*/
	
	//Barrio
	@FindBy(xpath="//*[@id='CK_ADDRESS_WRK_COUNTY$0']")
	public WebElementFacade neighbor;
	/*@FindBy(xpath="//*[@id='CK_ADDRESS_WRK_COUNTY$prompt$img$0']")
	public WebElementFacade neig1;
	@FindBy(xpath="//*[@name='RESULT1$4']")
	public WebElementFacade neig2;*/
	
	//Opciones de Facturación
	@FindBy(xpath="//a[contains(text(),'Opciones de Facturación')]")
	public WebElementFacade opcfact;
	
	//Condicion de pago 
	@FindBy(xpath="//*[@id='CUST_OPTION_PYMNT_TERMS_CD$0']")
	public WebElementFacade paycond;
	
	//Metodo de pago 
	@FindBy(xpath="//*[@id='CUST_OPTION_PAYMENT_METHOD$92$$0']")
	public WebElementFacade paymeth;
	
	//Facturación Electronica
	@FindBy(xpath="//*[@id='CK_CUST_OP_WRK_CK_CUSTO_FACT_ELEC$0']")
	public WebElementFacade facel;
	//nombre de contacto
	@FindBy(xpath="//*[@id='CK_CUST_OP_WRK_NAME1$0']")
	public WebElementFacade contact;
	
	//Pestaña informacion general varios
	@FindBy(xpath="//a[contains(text(),'Información General Varios')]")
	public WebElementFacade infogralvarios;
	
	//Pestaña Rutas preventa
	@FindBy(xpath="//a[contains(text(),'Rutas preventa')]")
	public WebElementFacade preventa;
	
	//rutas
	@FindBy(xpath="//*[@id='CK_RUTA_VIS_VW_ROUTE_CD$0']")
	public WebElementFacade rutas;
	
	//visitas
	@FindBy(xpath="//*[@id='CK_RUTA_VIS_VW_SEQ_NBR$0']")
	public WebElementFacade visit;
	
	//Pestaña Ck Req Creditos
	@FindBy(xpath="//a[contains(text(),'Ck Req Creditos')]")
	public WebElementFacade ckcredi;
	
	//Cupo
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_CUPOS']")
	public WebElementFacade cupo;
	
	// documento de credito 
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_SOL_AFI']") //Solicitud afiliacion
	public WebElementFacade doc1;
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_FIR_AUT']") //Firma autorización
	public WebElementFacade doc2;
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_PAG_FIR']") //Pagare firmado
	public WebElementFacade doc3;
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_CAR_INS']") //Carta firmada
	public WebElementFacade doc4;
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_REF_BAN']") //Ref bancarias
	public WebElementFacade doc5;
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_REF_COM']") //Ref Comercial
	public WebElementFacade doc6;
	@FindBy(xpath="//*[@id='CK_REQ_CREDITOS_CK_ENTREG']") //Consulta entidad de Riesgo
	public WebElementFacade doc7;
	
	//Pestaña Cust Region Code
	@FindBy(xpath="//a[contains(text(),'Cust Region Code')]")
	public WebElementFacade custCode;
	
	//Codigo
	@FindBy(xpath="//*[@id='CUST_REGN_TYPE_REGION_CD_TYPE$0']")
	public WebElementFacade codec;
	
	//cd Región
	@FindBy(xpath="//*[@id='CUST_REGN_TYPE_REGION_CD$0']")
	public WebElementFacade cd_region;
	
	// Pestaña opciones de datafono
	@FindBy(xpath="//a[contains(text(),'Opciones Datafono')]")
	public WebElementFacade opcdataf;
	
	//Opcion perfil Crédito
	@FindBy(xpath="//a[contains(text(),'Perfil Crédito')]")
	public WebElementFacade perfcred;
	
	//Activar Flag de Comprobacion de credito
	@FindBy(xpath="//*[@id='CUST_CREDIT_CREDIT_CHECK$0']")
	public WebElementFacade compcred;
	
	// Activar corrección
	@FindBy(xpath="//*[@id='#ICCorrection']")
	public WebElementFacade corrections;
	@FindBy(xpath="//input[@id='#ALERTYES']")
	public WebElementFacade accepts;
	@FindBy(xpath="//*[@id='#ICOK']") //*[@id="ptifrmtemplate"] //*[@id="#ICOK"]
	public WebElementFacade accepts1;
	
	//Guardar
	@FindBy(xpath="//*[@id='#ICSave']")
	public WebElementFacade savec;
	
	public void ID_Set(String datoPrueba) {
		idset.click();
		idset.clear();
		idset.sendKeys(datoPrueba);
	}
	public void Tipo_Documento(String datoPrueba) {
		tipodoc.click();
		tipodoc.clear();
		tipodoc.typeAndTab(datoPrueba);
	}
	public void Documento_Identidad(String datoPrueba) {
		numdoc.click();
		numdoc.sendKeys(datoPrueba);
	}
	public void Primer_Nombre(String datoPrueba) {
		//nameone.click();
		waitFor(500).milliseconds();
		nameone.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void Segundo_Nombre(String datoPrueba) {
		//nametwo.click();
		waitFor(500).milliseconds();
		nametwo.typeAndTab(datoPrueba);
	}
	public void Apellido(String datoPrueba) {
		waitFor(500).milliseconds();
		flastname.click();
		waitFor(500).milliseconds();
		flastname.typeAndTab(datoPrueba);
	}
	public void Apellido_dos(String datoPrueba) {		
		waitFor(500).milliseconds();
		slastname.click();
		waitFor(500).milliseconds();
		slastname.typeAndTab(datoPrueba);
	}
	public void esperar(int segundos) {
		waitFor(segundos).seconds();	
	}
	public void Tipo_Contribuyente(String datoPrueba) {
		waitFor(500).milliseconds();
		tipoCont.click();
		tipoCont.typeAndTab(datoPrueba);
	}
	public void Regimen(String datoPrueba) {
		//reg.click();
		waitFor(500).milliseconds();
		reg.typeAndTab(datoPrueba);
	}
	public void Responsabilidad(String datoPrueba) {
		//resp.click();
		waitFor(500).milliseconds();
		resp.typeAndTab(datoPrueba);
	}
	public void unidadNegocio(String datoPrueba) {
		unineg.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void legal(String datoPrueba,String datoPrueba2) {
		replegal.typeAndTab(datoPrueba+" "+datoPrueba2);
	}
	public void Tipo_DocI(String datoPrueba) {
		//tipodoci.click();
		waitFor(500).milliseconds();
		tipodoci.sendKeys(datoPrueba);
	}
	public void Num_DocI(String datoPrueba) {
		numdoci.click();
		waitFor(500).milliseconds();
		numdoci.typeAndTab(datoPrueba);		
	}
	public void equipo_asistencia(String datoPrueba) {
		waitFor(500).milliseconds();
		equiasis.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void chechboxinfo() {
		waitFor(500).milliseconds();
		check1.click();
		waitFor(500).milliseconds();
		check2.click();
		waitFor(500).milliseconds();
		check3.click();
		waitFor(300).milliseconds();
		check4.click();
		waitFor(500).milliseconds();
		check5.click();
		waitFor(500).milliseconds();
		check6.click();
		waitFor(500).milliseconds();		
	}
	public void cambiarDeFrame(String xpathframe) {
		WebDriver d = this.getDriver();
		getDriver().switchTo().frame(d.findElement(By.xpath(xpathframe)));
	}
	public void cambiarDeFrame() {
		WebDriver d = this.getDriver();
		getDriver().switchTo().defaultContent();
	}
	public void Addresss(String datoPrueba) {
		direc.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void estado(String datoPrueba) {
		state.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void ciudad(String datoPrueba) {
		city.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void barrio(String datoPrueba) {
		neighbor.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void condicion_pago(String datoPrueba) {
		//paycond.click();
		waitFor(200).milliseconds();
		paycond.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void metodos_pago(String datoPrueba) {
		waitFor(500).milliseconds();
		paymeth.sendKeys(datoPrueba);
		waitFor(500).milliseconds();		
	}
	public void factura_Elec(String datoPrueba) {
		waitFor(500).milliseconds();
		facel.sendKeys(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void nombre_contacto(String datoPrueba,String datoPrueba2) {
		contact.typeAndTab(datoPrueba+" "+datoPrueba2);
	}
	public void rutas_preventa(String datoPrueba) {
		waitFor(500).milliseconds();
		rutas.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
		visit.typeAndTab(datoPrueba);
	}
	public void ck_Reg_Credito(String datoPrueba) {
		waitFor(500).milliseconds();
		cupo.sendKeys(datoPrueba);
		waitFor(500).milliseconds();
		doc1.click();
		waitFor(500).milliseconds();
		doc2.click();
		waitFor(500).milliseconds();
		doc3.click();
		waitFor(500).milliseconds();
		doc4.click();
		waitFor(500).milliseconds();
		doc5.click();
		waitFor(500).milliseconds();
		doc6.click();
		waitFor(500).milliseconds();
		doc7.click();
		waitFor(500).milliseconds();
	}
	public void codigo(String datoPrueba) {
		waitFor(500).milliseconds();
		codec.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	public void cdRegion(String datoPrueba) {
		waitFor(500).milliseconds();
		cd_region.typeAndTab(datoPrueba);
		waitFor(500).milliseconds();
	}
	
	//VALIDACION
	
	//GLOBO INFORMATIVO
	@FindBy(xpath="'//INPUT[@id='LC_CUSTOMER_AD_SETID']'")
	public WebElementFacade valid1;
	
	public void validacion_sin_errores() {
		assertThat(valid1.isCurrentlyVisible(), is(false));
	}
	public void validacion_con_errores() {
		assertThat(valid1.isCurrentlyVisible(), is(true));
	}
}
