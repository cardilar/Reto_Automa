package com.choucair.formacion.pageobjects;

import java.awt.peer.ScrollbarPeer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.model.screenshots.Screenshot;

public class ChoiseArticle extends PageObject{
	
	@FindBy(xpath="(//a[@class='button ajax_add_to_cart_button btn btn-default'])[1]")
	public WebElementFacade Article1;
	
	@FindBy(xpath="(//div[@class=\"button-container\"]//span[@class='continue btn btn-default button exclusive-medium'])[1]")
	public WebElementFacade continueShopping;
	
	@FindBy(xpath="(//div[@class=\"button-container\"]//a[@class='btn btn-default button button-medium'])[1]")
	public WebElementFacade BuyClothes;
	
	@FindBy(xpath="(//a[@class='button ajax_add_to_cart_button btn btn-default'])[2]")
	public WebElementFacade Article2;
	
	@FindBy(xpath="(//a[@class='button ajax_add_to_cart_button btn btn-default'])[3]")
	public WebElementFacade Article3;
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	public WebElementFacade continueprocess;
	
	@FindBy(xpath="//button[@name='processAddress']")
	public WebElementFacade continueprocess2;
	
	@FindBy(xpath="//div[@id='uniform-cgv']")
	public WebElementFacade AcceptedTerms;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	public WebElementFacade continueprocess3;
	
	@FindBy(xpath="//*[@class='bankwire']")
	public WebElementFacade MethodPayment;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	public WebElementFacade ConfirmPay;
	

	public void SelectArticles() {
		// TODO Auto-generated method stub
		
		Actions actions = new Actions(getDriver());
		//Article1.click();
		
		WebElement Image1 = getDriver().findElement(By.xpath("(//div[@class='product-container'])[1]"));
    	//Move mouse to x offset 50 i.e. in horizontal direction
    	actions.moveToElement(Image1).perform();;
    	
    	Article1.click();
    	continueShopping.click();
    	
    	WebElement Image2 = getDriver().findElement(By.xpath("(//div[@class='product-container'])[2]"));
    	//Move mouse to x offset 50 i.e. in horizontal direction
    	actions.moveToElement(Image2).perform();
    	
    	Article2.click();
    	continueShopping.click();
    	
    	WebElement Image3 = getDriver().findElement(By.xpath("(//div[@class='product-container'])[3]"));
    	//Move mouse to x offset 50 i.e. in horizontal direction
    	actions.moveToElement(Image3).perform();
    	
    	Article3.click();
    	BuyClothes.click();
    	continueprocess.click();
    	continueprocess2.click();
    	waitFor(2);
    	AcceptedTerms.click();
    	waitFor(2);
    	continueprocess3.click();    	
    	System.out.println("Compró");
    	
	}


	public void PaymentMethod() {
		// TODO Auto-generated method stub
		MethodPayment.click();
		ConfirmPay.click();
		Serenity.takeScreenshot();
	}
	
	
	

}
