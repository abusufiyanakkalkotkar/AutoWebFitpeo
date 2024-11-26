package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FitPeoAutomation {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void navigateToHomepage() throws InterruptedException {
    	// Navigating to FitPeo Home page
        driver.get("https://fitpeo.com"); 
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void navigateToRevenueCalculatorPage() throws InterruptedException{
    	// Navigating to the Revenue Calculator Page
        WebElement calculatorLink = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
        calculatorLink.click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void adjustSliderAndUpdateTextField() throws InterruptedException{
    	// Scrolling Down to the Slider section
		JavascriptExecutor jx = (JavascriptExecutor) driver;
		jx.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
		// Adjusting the Slider to 820
		Actions actions = new Actions(driver);
		for (int i = 1; i <= 13; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		jx.executeScript("window.scrollBy(0,300)");
		for (int i = 1; i <= 620; i++) {
			actions.sendKeys(Keys.ARROW_RIGHT).perform();
		}   
		WebElement sliderBar = driver.findElement(By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']"));
		WebElement sliderHilightedBar = driver.findElement(By.xpath("//span[@class='MuiSlider-track css-10opxo5']"));
		WebElement sliderPoint = driver.findElement(By.xpath("//span[@data-index='0']"));
		jx.executeScript("arguments[0].style.background = 'red';", sliderBar);
		jx.executeScript("arguments[0].style.background = 'red';", sliderHilightedBar);
		jx.executeScript("arguments[0].style.background = 'red';", sliderPoint);
		Thread.sleep(1000);
		
        // Updating the text field to 560
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textField = driver.findElement(By.xpath("//input[@type='number'][1]"));
		wait.until(ExpectedConditions.elementToBeClickable(textField)); // Replace with actual ID or locator
		textField.click();
		Thread.sleep(2000);
		textField.clear();
		textField.clear();
		Thread.sleep(2000);
        textField.sendKeys("560");
        JavascriptExecutor ji = (JavascriptExecutor) driver;
        ji.executeScript("arguments[0].value='560';", textField);
        //System.out.println("Entered value: " + textField.getAttribute("value"));
        Thread.sleep(2000);
        }

    @Test(priority = 4)
    public void selectCPTCodesAndValidateReimbursement() throws InterruptedException {
        // Scroll to CPT codes section
    	JavascriptExecutor jp=(JavascriptExecutor)driver;
		jp.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);

		// Selecting CPT Codes
		List<WebElement> cptCodes=driver.findElements(By.cssSelector("div.css-1p19z09> *>p:first-of-type"));
        List<WebElement> checkBoxes=driver.findElements(By.cssSelector("div.css-1p19z09> *>label input"));
        for (int i=0;i<cptCodes.size();i++){
        	String code=cptCodes.get(i).getText();
            if(code.equals("CPT-99091") || code.equals("CPT-99453")||code.equals("CPT-99454")||code.equals("CPT-99474")){
                checkBoxes.get(i).click();
                Thread.sleep(1000);
            }
        }
        Thread.sleep(2000);
        
        // Validating Total Recurring Reimbursement
        WebElement totalRecurringReimbursement=driver.findElement(By.cssSelector("div.css-m1khva>p:nth-of-type(2)"));
        String total= totalRecurringReimbursement.getText();
        String expecectedTotal="$110700";
        if(total.equals(expecectedTotal)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}