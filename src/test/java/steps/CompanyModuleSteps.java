package steps;

import java.util.Map;

import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.CompanyModulePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanyModuleSteps extends BaseClass {
	public CompanyModulePage companyModulePage;
	static String companyName;

	@Before
	public void setUp() {
		BaseClass.initialization(); // Ensures browser starts before the test
		companyModulePage = new CompanyModulePage(); // Initialize the page object
	}

	@After
	public void tearDownTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("the user is on the company page")
	public void the_user_is_on_the_company_page() {
		System.out.println("User is on the company page.");
	}

	@When("the user selects the Create button")
	public void the_user_selects_the_create_button() {
		companyModulePage.clickOnCreateButton();
	}

	@When("the user enters the company details")
	public void the_user_enters_the_company_details() {
		companyModulePage.enterCompanyDetails("DemoCompany", "https://www.demo.com", "demo@gmail.com", "desc");
	}

	@When("the user clicks on the Save button")
	public void the_user_clicks_on_the_save_button() {
		companyModulePage.clickOnSaveButton();
	}

	@Then("the company should be created successfully")
	public void the_company_should_be_created_successfully() {
		String actualCompanyName = companyModulePage.validateCompanyCreated();
		Assert.assertEquals("DemoCompany", actualCompanyName);
	}

	@Given("user open the company details")
	public void user_open_the_company_details() {
		companyModulePage.openCompanyDetails();
	}

	@When("user click on edit button")
	public void user_click_on_edit_button() {
		companyModulePage.clickOnEditButton();
	}

	@When("user edit the details of company")
	public void user_edit_the_details_of_company() {

		companyModulePage.editCompanyDetails("DemoCompanyEdit", "https://www.Editdemo.com", "editdemo@gmail.com",
				"editDesc");
	}

	@Then("validate company details edited succefully")
	public void validate_company_details_edited_succefully() {
		Map<String, String> validatebleResponse = companyModulePage.validateCompanyEditSuccefully();

		String companyName = validatebleResponse.get("Company");
		Assert.assertEquals(companyName, "DemoCompanyEdit");

		String webSite = validatebleResponse.get("Website");
		Assert.assertEquals(webSite, "https://www.Editdemo.com");

		String email = validatebleResponse.get("Email");
		boolean emailStatus = email.contains("editdemo@gmail.com");
		Assert.assertEquals(true, emailStatus);

//		String desc=validatebleResponse.get("Description");
//		Assert.assertEquals(desc, "editDesc");		

	}

	@Given("user open the edit company details")
	public void user_open_the_edit_company_details() {
		companyModulePage.openEditCompanyDetails();
	}

	@When("user click on delete button")
	public void user_click_on_delete_button() {
		companyModulePage.clickOnDeleteButton();
	}

	@Then("Confirm Deletion popup should be displayed")
	public void confirm_deletion_popup_should_be_displayed() {
		String alertPoppText = companyModulePage.validatedDeletePopUpText();
		boolean alertStatus = alertPoppText.contains(
				"Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin.");
		Assert.assertEquals(alertStatus, true);
	}

	@When("click on Ok button")
	public void click_on_ok_button() {
		companyModulePage.clickOnDeleteButtonOfAlertPopUp();
	}

	@Then("Entry should be deleted")
	public void entry_should_be_deleted() {
		System.out.println("Entry i deleted");
	}

}
