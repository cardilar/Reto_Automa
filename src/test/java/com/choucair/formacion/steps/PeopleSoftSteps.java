package com.choucair.formacion.steps;

import net.thucydides.core.annotations.Step;
import com.choucair.formacion.pageobjects.PeopleSoftLoginPage;
import com.choucair.formacion.pageobjects.PeopleSoftMenu;

public class PeopleSoftSteps {
	
	PeopleSoftLoginPage peoplesoftloginpage;
	PeopleSoftMenu peoplesoftmenu;	
		@Step
		public void loginPeopleSoft(String strUsuario, String strPass) {
	
	peoplesoftloginpage.open();
	peoplesoftloginpage.IngresarDatos(strUsuario,strPass);
	
	//peoplesoftloginpage.VerificaHome();
	
}
		@Step
		public void ingresar_menu_people () {
			peoplesoftmenu.menupeopleclient();
		}

}
