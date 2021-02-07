package com.choucair.formacion.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OnlinStoreRegister extends PageObject{
	
	
	@FindBy(xpath="//*[@id='id_gender1']")
	public WebElementFacade gender;
	
	@FindBy(xpath="//*[@id='customer_firstname']")
	public WebElementFacade firstname;
	
	@FindBy(xpath="//*[@id='customer_lastname']")
	public WebElementFacade Lastname;
	
	@FindBy(xpath="//*[@id='passwd']")
	public WebElementFacade password;
	
	//@FindBy(xpath="//*[@id='days']//option[@value='1']") //
	//@FindBy(xpath="//*[@id='days']//option[@value='%s']")
	//public WebElementFacade day;
	
	String day= "//*[@id='days']//option[@value='%s']"; 
	
	/*@FindBy(xpath="//*[@id='months']//option[@value='11']")
	public WebElementFacade month;*/
	
	String month ="//*[@id='months']//option[@value='%s']";
	
	/*@FindBy(xpath="//*[@id='years']//option[@value='1984']") 
	public WebElementFacade year;*/
	
	String year ="//*[@id='years']//option[@value='%s']";
	
	@FindBy(xpath="//*[@id='firstname']")
	public WebElementFacade name;
	
	@FindBy(xpath="//*[@id='lastname']")
	public WebElementFacade lastname2;
	
	@FindBy(xpath="//*[@id='company']")
	public WebElementFacade company;
	
	@FindBy(xpath="//*[@id='address1']")
	public WebElementFacade address;
	
	@FindBy(xpath="//*[@id='city']")
	public WebElementFacade city;
	
	/*@FindBy(xpath="//*[@id='id_state']//option[@value='19']")
	public WebElementFacade state;*/
	
	String state ="//*[@id='id_state']//option[@value='%s']";
	
	@FindBy(xpath="//*[@id='postcode']")
	public WebElementFacade postcode;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	public WebElementFacade phone_mobile;
	
	@FindBy(xpath="//*[@id='alias']")
	public WebElementFacade alias;
	
	@FindBy(xpath="//*[contains(text(),'Register')]")
	public WebElementFacade submitAccount;
	
	@FindBy(xpath="//*[contains(text(),'Terms and conditions of use')]")
	public WebElementFacade TermsAndConditions;
	
	@FindBy(xpath="//*[@id='header_logo']")
	public WebElementFacade MainPage;
	
	public void RegisterInfo (String Name, String LastNa, String Pass, String DayB, String MonthB, String YearB, String AddressH, String CityH, String StateH, String CodePostal, String Phone_num) {
		
		gender.click();
		firstname.sendKeys(Name);
		Lastname.sendKeys(LastNa);
		password.sendKeys(Pass);
		//day.selectByValue(DayB);
		
		String DayBirth=String.format(day, DayB);
		WebElement daysb= getDriver().findElement(By.xpath(DayBirth));
		daysb.click();
		
		String MonthBirth=String.format(month, MonthB);
		WebElement monthb= getDriver().findElement(By.xpath(MonthBirth));
		monthb.click();
		//month.click();
		
		String YearBirth=String.format(year, YearB);
		WebElement yearb= getDriver().findElement(By.xpath(YearBirth));
		yearb.click();
		//year.click();
		
		address.sendKeys(AddressH);
		city.sendKeys(CityH);
		
		String StateHo=String.format(state, StateH);
		WebElement stateN= getDriver().findElement(By.xpath(StateHo));
		stateN.click();
		//state.click();
		
		waitFor(2);
		postcode.sendKeys(CodePostal);
		waitFor(2);
		phone_mobile.typeAndTab(Phone_num);
		submitAccount.click();
		TermsAndConditions.click();
		Serenity.takeScreenshot();
		MainPage.click();
	}
}
