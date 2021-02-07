package com.choucair.formacion.pageobjects;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CompararMensaje extends PageObject{
	
	@FindBy(xpath="//p[@class='cheque-indent']//strong[@class='dark']")
	public WebElementFacade Confirmation;


	public void Compara(String mensajeEsperado) {
		// TODO Auto-generated method stub
		assertEquals(mensajeEsperado, Confirmation.getText());
	}

}
