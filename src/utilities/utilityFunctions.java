package utilities;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilityFunctions {

	// public static WebDriver driver;

	public static void waitForElementToBeClickable(WebDriver driver, String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));

	}

	public static boolean checkElementExistence(WebDriver driver, String elementXpath) {
		try {
			waitForElementToBeClickable(driver, elementXpath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validateText(WebDriver driver, String elementXpath, String expectedText) {
		try{
		waitForElementToBeClickable(driver, elementXpath);
		String actualText = driver.findElement(By.xpath(elementXpath)).getText();
		if(actualText == expectedText){
			return true;
		}else{
			return false;
		}
		}catch(Exception e){
			return false;
		}
	}
}
