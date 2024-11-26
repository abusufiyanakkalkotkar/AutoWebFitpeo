# FitPeo Web Automation with Selenium

This repository contains an automation script for testing the **FitPeo Revenue Calculator** using **Java**, **Selenium WebDriver**, and the **TestNG framework**. The script performs multiple automated interactions on the FitPeo website to ensure the correct functionality of the revenue calculator, including slider adjustments, text field updates, and CPT code selections.

## Objective

The objective of this project is to automate the following steps on the FitPeo Revenue Calculator page:

1. Navigate to the homepage.
2. Navigate to the Revenue Calculator page.
3. Adjust the slider value and update the associated text field.
4. Select specific CPT codes.
5. Validate the total recurring reimbursement.

## Features

- **Navigation to FitPeo Homepage**: Opens the homepage and accesses the Revenue Calculator page.
- **Slider Interaction**: Adjusts the slider to a set value (820) and validates that the associated text field updates accordingly.
- **Text Field Update**: Updates the text field and ensures the slider adjusts to reflect the new value.
- **CPT Code Selection**: Selects specified CPT codes (CPT-99091, CPT-99453, CPT-99454, CPT-99474).
- **Reimbursement Validation**: Validates that the total recurring reimbursement value is correct.

## Prerequisites

Before running the automation script, make sure you have the following installed:

- **Java 8 or higher**
- **Selenium WebDriver**
- **TestNG Framework**
- **ChromeDriver (or FirefoxDriver, depending on your browser)**

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/fitpeo-web-automation.git
   cd fitpeo-web-automation

# Step 2
Install Java: Ensure that Java is installed and added to your system’s PATH. You can download Java from the official site: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html.

# step 3
Add Dependencies: You need to add the following dependencies to your pom.xml file if you're using Maven:
  <dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

# step 4
Download ChromeDriver: Download the appropriate ChromeDriver (or GeckoDriver for Firefox) from here. Make sure the version matches the browser version you're using.

# step 5
Setup WebDriver: Set the WebDriver path in your code or as an environment variable:
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

# step 6
Running the Tests
1. Open the terminal or command prompt.
2. Navigate to the project directory.
3. To run the tests, use your IDE's TestNG runner or run the following Maven command:
   Alternatively, you can run the script directly using an IDE like IntelliJ IDEA or Eclipse.

# Test Cases
The script contains the following test cases:
1. Navigate to the Homepage: Opens the FitPeo homepage.
2. Navigate to the Revenue Calculator Page: Clicks the link to navigate to the Revenue Calculator page.
3. Adjust Slider and Update Text Field: Scrolls down to the slider section, adjusts the slider to the value 820, and validates that the associated text field updates accordingly. Then, it enters the value 560 in the text field and ensures the slider position updates.
4. Select CPT Codes and Validate Reimbursement: Scrolls down to the CPT codes section, selects specific CPT codes (CPT-99091, CPT-99453, CPT-99454, and CPT-99474), and validates that the Total Recurring Reimbursement is correctly displayed as $110700.

#Code Walkthrough
1. Test Setup (@BeforeClass):
Initializes the ChromeDriver, maximizes the window, and prepares the driver for testing
2. Test Case 1: Navigate to Homepage:
Opens the FitPeo homepage and waits for the page to load.
3. Test Case 2: Navigate to Revenue Calculator Page:
Clicks the "Revenue Calculator" link and navigates to the calculator page.
4. Test Case 3: Adjust Slider and Update Text Field:
Scrolls to the slider section, adjusts the slider to 820 using the Actions class, then clicks the text field, enters the value 560, and updates the slider position.
5. Test Case 4: Select CPT Codes and Validate Reimbursement:
Selects the relevant CPT codes (CPT-99091, CPT-99453, CPT-99454, and CPT-99474) and validates that the total recurring reimbursement matches the expected value of $110700.
6. Test Teardown (@AfterClass):
Quits the browser after all tests are executed.

# Conclusion
This repository automates the process of interacting with the FitPeo Revenue Calculator and validates important business logic such as slider adjustments, text field synchronization, and CPT code selection. The script can be extended for further test cases or integrated into continuous integration pipelines.

#License
This project is licensed under the MIT License - see the LICENSE file for details.


---

### How to Use:

1. **Clone the repository** using the command `git clone https://github.com/AbusufiyanAkkalkotkar/fitpeo-web-automation.git`.
2. **Install dependencies** in your project via Maven, or download and set up necessary libraries.
3. **Run tests** either via **IDE** or **command line** using `mvn test`.

Make sure to replace the placeholder links (e.g., the GitHub URL) with actual information when you upload the repository. Let me know if you need further adjustments or additions to the `README.md` file!
