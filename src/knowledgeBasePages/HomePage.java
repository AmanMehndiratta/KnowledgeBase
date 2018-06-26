package knowledgeBasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Locators;
import utilities.utilityFunctions;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Locators.loginButton)
	public WebElement loginButton;

	@FindBy(xpath = Locators.loginWithMobiControl)
	public WebElement loginWithMobiControl;

	@FindBy(xpath = Locators.mobiControlEnterEmail)
	public WebElement mobiControlEnterEmail;

	@FindBy(xpath = Locators.mobiControlEnterPassword)
	public WebElement mobiControlEnterPassword;

	@FindBy(xpath = Locators.mobiControlLoginButton)
	public WebElement mobiControlLoginButton;

	@FindBy(xpath = Locators.userProfileIcon)
	public WebElement userProfileIcon;

	@FindBy(xpath = Locators.logoutButton)
	public WebElement logoutButton;

	@FindBy(xpath = Locators.closeMobiControlLoginPopup)
	public WebElement closeMobicontrolLoginPopup;

	@FindBy(xpath = Locators.articlesTabOnHomePage)
	public WebElement articlesTabOnHomePage;

	@FindBy(xpath = Locators.questionsTabOnHomePage)
	public WebElement questionsTabOnHomePage;

	@FindBy(xpath = Locators.answerButtonForFirstTopic)
	public WebElement answerButtonForFirstTopic;

	@FindBy(xpath = Locators.answerTestFieldForFirstTopic)
	public WebElement answerTestFieldForFirstTopic;

	@FindBy(xpath = Locators.cancelAnswerTestFieldForFirstTopic)
	public WebElement cancelAnswerTestFieldForFirstTopic;

	@FindBy(xpath = "whiteSpaceForFirstAnswerTextField")
	public WebElement whiteSpaceForFirstAnswerTextField;

	@FindBy(xpath = Locators.firstTopicOnHomePage)
	public WebElement firstTopicOnHomePage;

	public boolean loginMobiControl(String username, String password) throws Exception {

		utilityFunctions.waitForElementToBeClickable(Locators.loginButton);
		loginButton.click();
		loginWithMobiControl.click();
		utilityFunctions.waitForElementToBeClickable(Locators.mobiControlEnterEmail);
		mobiControlEnterEmail.sendKeys(username);

		mobiControlEnterPassword.sendKeys(password);
		mobiControlLoginButton.click();
		try {
			utilityFunctions.waitForElementToBeClickable(Locators.userProfileIcon);
			userProfileIcon.click();
			logoutButton.click();
			return true;
		} catch (Exception e) {

			closeMobicontrolLoginPopup.click();
			return false;
		}

	}

	public boolean remainLoginMobiControl(String username, String password) throws Exception {

		try {
			utilityFunctions.waitForElementToBeClickable(Locators.loginButton);
			loginButton.click();
			loginWithMobiControl.click();
			utilityFunctions.waitForElementToBeClickable(Locators.mobiControlEnterEmail);
			mobiControlEnterEmail.sendKeys(username);

			mobiControlEnterPassword.sendKeys(password);
			mobiControlLoginButton.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean goToArticlesTab() {
		try {
			articlesTabOnHomePage.click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean goToQuestionsTab() {
		try {
			utilityFunctions.waitForElementToBeClickable(Locators.questionsTabOnHomePage);
			questionsTabOnHomePage.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean createAnswerDraft() {
		try {
			if (answerButtonForFirstTopic.getText().contains("Answer")) {
				answerButtonForFirstTopic.click();
				driver.switchTo().frame("PostContent_ifr");
				answerTestFieldForFirstTopic.click();
				answerTestFieldForFirstTopic.sendKeys("random text");
				driver.navigate().to(driver.getCurrentUrl());
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean cancelEditDraft() {
		try {
			utilityFunctions.waitForElementToBeClickable(Locators.answerButtonForFirstTopic);
			answerButtonForFirstTopic.click();
			cancelAnswerTestFieldForFirstTopic.click();
			utilityFunctions.waitForElementToBeClickable(Locators.answerButtonForFirstTopic);
			if (answerButtonForFirstTopic.getText().contains("Edit Draft")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public boolean goToFirstTopicDetail() {
		try {
			
			goToQuestionsTab();
			utilityFunctions.waitForElementToBeClickable(Locators.firstTopicOnHomePage);
			firstTopicOnHomePage.click();
			utilityFunctions.waitForElementToBeClickable(Locators.answerButtonOnFirstTopicDetail);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
