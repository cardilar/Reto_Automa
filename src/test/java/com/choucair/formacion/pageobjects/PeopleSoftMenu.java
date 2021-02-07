package com.choucair.formacion.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PeopleSoftMenu extends PageObject{
	//Desplegar menu
	@FindBy(xpath="//*[@id=\'pthnavbca_PORTAL_ROOT_OBJECT\']")
	public WebElementFacade menuPeople;
	
	//submenu cliente
	@FindBy(xpath="//*[@id=\'fldra_EPCO_CUSTOMERS\']")
	public WebElementFacade submenuclient;
	
	//Opcion Informacion General
	@FindBy(xpath="//*[@id=\'fldra_EPCO_CREATE_CUSTOMER_INFORMATI\']")
	public WebElementFacade infoclient;
	
	//Opcion Informacion General
		@FindBy(xpath="//*[@id=\'crefli_EP_CUSTOMER_GENERAL_GBL\']/a")
		public WebElementFacade infogral;
		
	//Añadir cliente
		@FindBy(xpath="//a[contains(text(),'Añadir un Valor')]") 
		public WebElementFacade anadircli; 

		public void menupeopleclient() {
			// TODO Auto-generated method stub
			menuPeople.click();
			submenuclient.click();
			infoclient.click();
			infogral.click();
			Serenity.takeScreenshot();
			waitFor(2).second();
			boolean dioClick = false;
			cambiarDeFrame();
			while(!dioClick) {
				if(anadircli.isVisible()) {
					anadircli.click();
					//anadircli.click();
					dioClick=true;
				}
			}
			Serenity.takeScreenshot();
			//waitFor(10).second();
		}

		public void cambiarDeFrame() {
			WebDriver d = this.getDriver();
			getDriver().switchTo().frame(d.findElement(By.xpath("(//iframe)[1]")));
		}
		
	
	 

}
