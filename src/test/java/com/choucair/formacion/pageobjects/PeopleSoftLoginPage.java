package com.choucair.formacion.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://automationpractice.com/index.php")
public class PeopleSoftLoginPage extends PageObject{
	
	// campo usuario
	@FindBy(xpath="//*[@id=\'userid\']")
	public WebElementFacade txtUsername;
	
	//Campo password
	@FindBy(xpath="//*[@id=\'pwd\']")
	public WebElementFacade txtPassword;
	
	//Boton
	@FindBy(xpath="//*[@id=\'login\']/div/div[1]/div[8]/input")
	public WebElementFacade btnSignIn;
	
	//Laber del home Verificar
	/*@FindBy(xpath="//*[@id=/'pthdr2container/']")
	public WebElementFacade lblHomePpal;*/

	public void IngresarDatos(String strUsuario, String strPass) {
		Serenity.takeScreenshot();
		System.out.println("Entro los datos");
		txtUsername.sendKeys(strUsuario);
		txtPassword.sendKeys(strPass);
		Serenity.takeScreenshot();
		btnSignIn.click();
	}

	/*public void VerificaHome() {
		String labelv="ORACLE";
		String strMensaje= lblHomePpal.getText();
		assertThat(strMensaje, containsString(labelv));
	}*/
	
	
}
