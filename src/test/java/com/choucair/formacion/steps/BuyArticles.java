package com.choucair.formacion.steps;

import com.choucair.formacion.pageobjects.ChoiseArticle;

import net.serenitybdd.core.pages.PageObject;

public class BuyArticles extends PageObject{
	
	ChoiseArticle choiceArticle;
	
	public void ChoiseArticles () {
		
		choiceArticle.SelectArticles();
		choiceArticle.PaymentMethod();
	}
	
	
		
		
	

}
