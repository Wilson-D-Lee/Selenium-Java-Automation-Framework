@smokeTests
Feature: The following tests are critical user journey for Unibuddy customers:

  #this is a simple run of the user story.
  @userStory
  Scenario: Running through the full user story
    Given the user is on the index page
    And the user filters area of study to 'BA Comparative Literature'
    And the user filters countries to 'United Kingdom'
    And the user filters levels to 'Alumni'
    And Buddy's card is visible
    And user clicks to read more about buddy
    When the user clicks Chat with button
    And a window should be visible to commence chat
    And the user navigates to the register page
    And user inputs sign-up information
    And User Completes the second registration form
    And setting tab should be visible
    Then user sends an introduction message to buddy

  @registerFunctionality
  Scenario: User enters information on the sign-up screen to create an account.
  Given the user navigates directly to the register page
  When user inputs sign-up information
  And User Completes the second registration form
  Then setting tab should be visible

  # In Progress
  @filterFunctionality
  Scenario: User selects appropriate values for the “Area of Study”, “Levels” and “Countries” filters.
    Given the user is on the index page
    When the user filters area of study to 'BA Comparative Literature'
    And the user filters countries to 'United Kingdom'
    And the user filters levels to 'Alumni'
    Then Buddy's card is visible

  @buddyCardFunctionality
  Scenario: User clicks on “Chat with ...” CTA on buddy card for any one of the buddies displayed.
  Given the user navigates directly to the a Buddy page
  When the user clicks Chat with button
  Then a window should be visible to commence chat

  @chatFunctionality
  Scenario: User sends a message in the chat window
  Given the user is on the chat window
  And a window should be visible to commence chat
  And the user navigates to the register page
  When user inputs sign-up information
  And User Completes the second registration form
  And setting tab should be visible
  Then user sends an introduction message to buddy







