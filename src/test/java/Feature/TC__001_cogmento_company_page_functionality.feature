Feature: Validate Company Module Functionality  
   @Sanity @Regression
  Scenario: Verify that the user can create a company  
    Given the user is on the company page  
    When the user selects the Create button  
    And the user enters the company details  
    And the user clicks on the Save button  
    Then the company should be created successfully  