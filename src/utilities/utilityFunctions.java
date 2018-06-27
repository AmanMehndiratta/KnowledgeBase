package utilities;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import knowledgeBasePages.HomePage;
import testData.TestData;

public class utilityFunctions {

	static WebDriver driver;
	//HomePage hp;
	Properties prop;

	public utilityFunctions(WebDriver driver) {
		utilityFunctions.driver = driver;
	}

	// public static WebDriver driver;

	public static void waitForElementToBeClickable(String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));

	}

	public static boolean checkElementExistence(String elementXpath) {
		try {

			waitForElementToBeClickable(elementXpath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validateText(String elementXpath, String expectedText) {
		try {
			checkElementExistence(elementXpath);
			String actualText = driver.findElement(By.xpath(elementXpath)).getText();
			if (actualText.contains(expectedText)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public void loginUserIfNotLoggedIn(HomePage hp) throws Exception{
		if (checkElementExistence(Locators.userProfileIcon) != true) {
			hp.remainLoginMobiControl(TestData.correctUserName, TestData.correctPassword);
			checkElementExistence(Locators.userProfileIcon);
		} else {
			driver.navigate().to(prop.getProperty("testSiteURL"));
		}
	}
	
	public boolean logoutUser(HomePage hp){
		try{
			if (checkElementExistence(Locators.userProfileIcon) == true) {
				//driver.navigate().to(prop.getProperty("testSiteURL"));
				if(checkElementExistence(Locators.logoutButton) != true){
					hp.userProfileIcon.click();
				}
				hp.logoutLoggedInUser();
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
		
		
	}

}
