package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.CompararMensaje;

import net.serenitybdd.core.pages.PageObject;

public class SucessfullBuy extends PageObject{
	
	CompararMensaje compararmensaje;

	public void MessageSuccess(String mensajeEsperado) {
		// TODO Auto-generated method stub
		compararmensaje.Compara(mensajeEsperado);
	}
	
	

}
