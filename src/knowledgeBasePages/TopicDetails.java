package knowledgeBasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Locators;
import utilities.utilityFunctions;

public class TopicDetails {
	WebDriver driver;

	public TopicDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "answerButtonOnTopicDetailScreen")
	public WebElement answerButtonOnTopicDetailScreen;
	
	@FindBy(xpath = "answerTestFieldForFirstTopicOnTopicDetailScreen")
	public WebElement answerTestFieldForFirstTopicOnTopicDetailScreen;
	
	@FindBy(xpath = "cancelAnswerTestFieldForFirstTopicOnTopicDetailScreen")
	public WebElement cancelAnswerTestFieldForFirstTopicOnTopicDetailScreen;
	
	
	public boolean createAnswerDraftOnTopicDetail() {
		try {
			if (answerButtonOnTopicDetailScreen.getText().contains("Answer")) {
				answerButtonOnTopicDetailScreen.click();
				driver.switchTo().frame("PostContent_ifr");
				answerTestFieldForFirstTopicOnTopicDetailScreen.click();
				answerTestFieldForFirstTopicOnTopicDetailScreen.sendKeys("random text");
				driver.navigate().to(driver.getCurrentUrl());
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean cancelEditDraftOnTopicDetail() {
		try {
			utilityFunctions.waitForElementToBeClickable(Locators.answerButtonOnTopicDetailScreen);
			answerButtonOnTopicDetailScreen.click();
			cancelAnswerTestFieldForFirstTopicOnTopicDetailScreen.click();
			utilityFunctions.waitForElementToBeClickable(Locators.answerButtonOnTopicDetailScreen);
			if (answerButtonOnTopicDetailScreen.getText().contains("Edit Draft")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
	
	
	
	
	
	
}
