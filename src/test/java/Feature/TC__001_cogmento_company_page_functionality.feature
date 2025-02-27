Feature: Validate Company Module Functionality

  @Sanity @Regression
  Scenario: Verify that the user can create a company
    Given the user is on the company page
    When the user selects the Create button
    And the user enters the company details
    And the user clicks on the Save button
    Then the company should be created successfully
  @Sanity @Regression
  Scenario: Verify that user should be able to edit company
    Given the user is on the company page
    And user open the company details
    When user click on edit button
    And user edit the details of company
    Then validate company details edited succefully
