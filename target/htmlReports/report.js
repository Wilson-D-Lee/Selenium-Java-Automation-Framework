$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/login.feature");
formatter.feature({
  "name": "feature to test the login functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "name": "Check login is successful with valid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smokeTest"
    },
    {
      "name": "@loginFunctionality"
    }
  ]
});
formatter.step({
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters valid username and password",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_enters_valid_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_clicks_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is navigated to the home page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.LoginSteps.user_is_navigated_to_the_home_page()"
});
formatter.result({
  "status": "passed"
});
});