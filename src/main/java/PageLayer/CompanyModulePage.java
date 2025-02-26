package PageLayer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import utilsLayer.HandleActions;
import utilsLayer.Wait;

public class CompanyModulePage extends BaseClass {
	
	

	@FindBy(xpath = "//span[text()='Companies']")
	private WebElement company;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createCompanyButton;

	@FindBy(name = "name")
	private WebElement companyNameFiled;

	@FindBy(name = "url")
	private WebElement companyWebSiteField;

	@FindBy(name = "value")
	private WebElement companyEmailField;

	@FindBy(name = "description")
	private WebElement companyDescField;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveCompanyButton;

	@FindBy(xpath = "//a[text()='DemoCompany']")
	private WebElement openCreatedCompany;

	@FindBy(xpath = "//div[text()='Name']/parent::div/div/div/p")
	private WebElement companyText;

	@FindBy(xpath = "//div[text()='Website']/parent::div/div/div/a")
	private WebElement webSiteText;
	
	@FindBy(xpath="//div[text()='Email']/parent::div/descendant::div[@class='content']")
	private WebElement emailText;
	
	
	@FindBy(xpath="//div[text()='Description']/parent::div/div/div/p")
	private WebElement hoverDescText;
	
	
	@FindBy(xpath="textarea[@name='description']")
	private WebElement descText;
 
	@FindBy(xpath = "//button/i[@class='edit icon']")
	private WebElement editButton;
	

	@FindBy(xpath = "//input[@name='name']/parent::div[@class='ui right corner labeled input']/input")
	private WebElement editCompanyField;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement emailEditField;

	public CompanyModulePage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateButton() {
		Wait.click(company);
		Wait.click(createCompanyButton);
	}

	public void enterCompanyDetails(String companyName, String webSite, String email, String desc) {
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
		return Wait.getText(companyText );
	}

	public void openCompanyDetails() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wait.click(company);
		HandleActions.moveToElement(createCompanyButton);
		Wait.click(openCreatedCompany);

	}

	public void clickOnEditButton() {
		Wait.click(editButton);
	}

	public void editCompanyDetails(String editCompany,String editWebSite,String editEmail,String editCompanyDesc ) {
	//	Wait.click(editCompanyField);
		HandleActions.selectElementClickCntAndA(editCompanyField, editCompany);
	//	Wait.click(companyWebSiteField);
		HandleActions.selectElementClickCntAndA(companyWebSiteField, editWebSite);
	//	Wait.click(emailEditField);
		HandleActions.selectElementClickCntAndA(emailEditField, editEmail);
//		Wait.click(companyDescField);
		HandleActions.selectElementClickCntAndA(companyDescField, editCompanyDesc);
		Wait.click(saveCompanyButton);

//		Wait.click(companyWebSiteField);
//		Wait.clear(companyWebSiteField);
//		Wait.sendKeys(companyWebSiteField, editWebSite);
//		Wait.click(emailEditField);
//		Wait.clear(emailEditField);
//		Wait.sendKeys(emailEditField, editEmail);
//     	Wait.click(companyDescField);
//		Wait.clear(companyDescField);
//		Wait.sendKeys(companyDescField, editCompanyDesc);
//		Wait.click(saveCompanyButton);

	}

	public Map<String, String> validateCompanyEditSuccefully() {
		 Map<String, String> companyDetails = new HashMap<>();
		    companyDetails.put("Company", Wait.getText(companyText));
		    companyDetails.put("Website", Wait.getText(webSiteText));
		    companyDetails.put("Email", Wait.getText(emailText));
			
//		    HandleActions.moveToElement(descText);
//		    companyDetails.put("Description", Wait.getText(descText));
		    return companyDetails;


	}

}
