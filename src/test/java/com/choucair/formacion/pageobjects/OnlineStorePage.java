package com.choucair.formacion.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://automationpractice.com/index.php")
public class OnlineStorePage extends PageObject{
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")////a[contains(text(),'Sign in')]---//[@class='login']
	public WebElementFacade buttonRegister;
	
	@FindBy(xpath="//*[@id='email_create']")
	public WebElementFacade emailclient;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	public WebElementFacade buttonCreate;
	
	

	
	public void RegisterClient (String Mail){
		buttonRegister.click();
		emailclient.sendKeys(Mail);
		buttonCreate.click();
		System.out.println("Clic");
		
	}
}
