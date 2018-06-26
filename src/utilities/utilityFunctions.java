package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilityFunctions {

	static WebDriver driver;

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
			if (actualText == expectedText) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
