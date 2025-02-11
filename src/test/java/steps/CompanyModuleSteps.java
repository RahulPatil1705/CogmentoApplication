package steps;



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
        BaseClass.initialization();  // Ensures browser starts before the test
        companyModulePage = new CompanyModulePage();  // Initialize the page object
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
}
