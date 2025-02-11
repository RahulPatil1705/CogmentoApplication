package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import utilsLayer.Wait;

public class CompanyModulePage extends BaseClass   {

	@FindBy(xpath="//span[text()='Companies']")
	private WebElement company;
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement createCompanyButton; 
	
	@FindBy(name="name") 
	private WebElement companyNameFiled;
	
	@FindBy(name="url")
	private WebElement companyWebSiteField;
	
	@FindBy(name="value")
	private WebElement companyEmailField;

	@FindBy(name="description")
	private WebElement companyDescField;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveCompanyButton;
	
	@FindBy(xpath="//div[text()='Name']/parent::div/div/div/p")
	private WebElement createCompanyText;
	
	public CompanyModulePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateButton() {
	  Wait.click(company);
	  Wait.click(createCompanyButton);
	}
	
	public void enterCompanyDetails(String companyName,String webSite,String email,String desc) {
		Wait.sendKeys(companyNameFiled, companyName);
		Wait.sendKeys(companyWebSiteField, webSite);
		Wait.sendKeys(companyEmailField, email);
		Wait.sendKeys(companyDescField, desc);

		
	}
	public void clickOnSaveButton() {
		Wait.click(saveCompanyButton);
	}
	public String validateCompanyCreated() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Wait.getText(createCompanyText);
	}
		
	
}
