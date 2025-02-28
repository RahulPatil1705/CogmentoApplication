package PageLayer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import utilsLayer.HandleActions;
import utilsLayer.HandleAlert;
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

	@FindBy(xpath = "//a[text()='DemoCompanyEdit']")
	private WebElement openCreatedEditCompany;

	@FindBy(xpath = "//div[text()='Name']/parent::div/div/div/p")
	private WebElement companyText;

	@FindBy(xpath = "//div[text()='Website']/parent::div/div/div/a")
	private WebElement webSiteText;

	@FindBy(xpath = "//div[text()='Email']/parent::div/descendant::div[@class='content']")
	private WebElement emailText;

	@FindBy(xpath = "//div[text()='Description']/parent::div/div/div/p")
	private WebElement hoverDescText;

	@FindBy(xpath = "textarea[@name='description']")
	private WebElement descText;

	@FindBy(xpath = "//button/i[@class='edit icon']")
	private WebElement editButton;

	@FindBy(xpath = "//input[@name='name']/parent::div[@class='ui right corner labeled input']/input")
	private WebElement editCompanyField;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement emailEditField;

	@FindBy(xpath = "//i[@class='trash icon']")
	private WebElement deleteButton;
	@FindBy(xpath="//p[text()='Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin.']")
	private WebElement popUpText;
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement deleteButtonPopUp;

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
		return Wait.getText(companyText);
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

	public void editCompanyDetails(String editCompany, String editWebSite, String editEmail, String editCompanyDesc) {
		// Wait.click(editCompanyField);
		HandleActions.selectElementClickCntAndA(editCompanyField, editCompany);
		// Wait.click(companyWebSiteField);
		HandleActions.selectElementClickCntAndA(companyWebSiteField, editWebSite);
		// Wait.click(emailEditField);
		HandleActions.selectElementClickCntAndA(emailEditField, editEmail);
//		Wait.click(companyDescField);
		HandleActions.selectElementClickCntAndA(companyDescField, editCompanyDesc);
		Wait.click(saveCompanyButton);

	}

	public Map<String, String> validateCompanyEditSuccefully() {
		Map<String, String> companyDetails = new HashMap<>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		companyDetails.put("Company", Wait.getText(companyText));
		companyDetails.put("Website", Wait.getText(webSiteText));
		companyDetails.put("Email", Wait.getText(emailText));

//		    HandleActions.moveToElement(descText);
//		    companyDetails.put("Description", Wait.getText(descText));
		return companyDetails;

	}

	public void openEditCompanyDetails() {

		Wait.click(company);
		HandleActions.moveToElement(createCompanyButton);

		Wait.click(openCreatedEditCompany);
	}

	public void clickOnDeleteButton() {
		Wait.click(deleteButton);
	}

	public String validatedDeletePopUpText() {
		String alertPopText = Wait.getText(popUpText);
		return alertPopText;
	}

	public void clickOnDeleteButtonOfAlertPopUp() {
		Wait.click(deleteButtonPopUp);
		//HandleAlert.accept();
	}

}
