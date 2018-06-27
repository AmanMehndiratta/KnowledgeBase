package knowledgeBasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Locators;
import utilities.utilityFunctions;

public class PendingPosts {

	WebDriver driver;

	public PendingPosts(WebDriver driver) {
		this.driver = driver;
	}

	HomePage hp;

	@FindBy(xpath = Locators.approveFirstTopicOnPendingPostsScreen)
	public WebElement approveFirstTopicOnPendingPostsScreen;

	public boolean approveFirstPendingTopic() {
		try {
			utilityFunctions.waitForElementToBeClickable(Locators.approveFirstTopicOnPendingPostsScreen);
			approveFirstTopicOnPendingPostsScreen.click();
			return true;

		} catch (Exception e) {
			return false;

		}

	}

}
