## About
This repository contains a demonstration of automated end-to-end testing using Selenium in a Java Maven Project.
The test cases validate key functionalities of the Qubika oficial Website by focusing on the following scenarios:

### Contact Form Validations

The test case ensures that the contact form on the website behaves as expected:

- Form Submission: The form's submit button is enabled only when all required fields are filled out correctly.
- Field Validation: If any required field is left empty, the application displays a specific error message for each missing field, guiding the user to complete the necessary information.
- UI Feedback: The test verifies that dynamic validation messages appear next to empty fields, ensuring that users are informed of the missing data before submitting the form.


### Key Features in the Tests
- UI Interaction Testing: The tests simulate real user interactions with the contact form, such as filling in the fields, submitting the form, and verifying that the application responds correctly.
- Dynamic Form Validation: Ensures that error messages are displayed when required fields are left empty and the submit button is disabled until all fields are valid.
- Data-Driven Testing: Leverages dynamic test data to validate the form’s behavior for different types of user input, ensuring robust testing across multiple scenarios.
- Cross-Browser Testing: The tests ensure that the form’s validation works seamlessly across different browsers (Chrome, Firefox, etc.), providing a consistent user experience.

## Enhancements
Several enhancements were incorporated into the solution to improve usability and performance:

- Custom Test Configuration: Includes a config.properties file to easily configure test settings like timeouts, browser types, and base URLs.
- Page Object Model (POM): Implements the POM design pattern for improved code reusability, readability, and scalability.
- Parameterized Testing: Uses TestNG to enable parameterized test data and browser configuration for versatile execution.
- Flexible Suite Management: Runs tests by suites with customizable parameters directly from the console.

##  Setup and Instructions

Follow these steps to set up and run the tests:

1. Check Java is installed

Ensure Java is installed on your system. Run the following command to verify:

`java -version`

2. Check Maven is installed

Verify Maven is installed and accessible:

`mvn -version`

3. Install Dependencies 

Download the necessary project dependencies by running:

`mvn clean install`


4. Configure Test Parameters

Before running the tests, edit the testng.xml file to set your desired parameters:

Update the firstName parameter to customize the test data:

`<parameter name="firstName" value="Ignacia" />`

Optional. Update the browser parameter to specify the browser to use (e.g., Chrome, Firefox):

`<parameter name="browser" value="chrome" />` (optional)

5. Run the Test Suite

You can execute the tests in two ways:

*Option 1: Default Execution*

Run the test suite with the default parameters specified in the testng.xml file:

`mvn test -DsuiteXmlFile=src/test/resources/testng.xml`

*Option 2: Specify Browser from Console*

Override the browser parameter directly from the console:
`mvn test -DsuiteXmlFile=testng.xml -Dbrowser=chrome`

