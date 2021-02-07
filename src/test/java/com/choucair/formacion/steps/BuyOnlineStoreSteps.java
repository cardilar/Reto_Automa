package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.OnlineStorePage;
import com.choucair.formacion.pageobjects.OnlinStoreRegister;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;




public class BuyOnlineStoreSteps extends PageObject {
	
	OnlineStorePage onlinestorepage;
	OnlinStoreRegister onlinstoreregister;
	
	public void OpenOnlineStorePage (String Mail) {
		
		onlinestorepage.open();
		onlinestorepage.RegisterClient(Mail);
			
	}
	
	@Step
	public void ClintInformation (String Name, String LastName, String Pass, String Day, String Month, String Year, String Address, String City, String State, String CodePostal, String Phone_num) {
		onlinstoreregister.RegisterInfo(Name,LastName,Pass,Day,Month,Year,Address,City,State,CodePostal,Phone_num);
	}
	

}
