package knowledgeBasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testData.TestData;
import utilities.Locators;
import utilities.utilityFunctions;

public class ArticleDetails {
	
	HomePage hp;

	@FindBy(xpath = Locators.yesArticleWasHelpful)
	public WebElement yesArticleWasHelpful;
	
	@FindBy(xpath = Locators.noArticleWasNotHelpful)
	public WebElement noArticleWasNotHelpful;
	
	@FindBy(xpath = Locators.percentOfArticleHelpful)
	public WebElement percentOfArticleHelpful;
	
	@FindBy(xpath = Locators.articlesTabOnHomePage)
	public WebElement articlesTabOnHomePage;
		
	@FindBy(xpath = Locators.secondArticleOnArticlesScreen)
	public WebElement secondArticleOnArticlesScreen;
	
	public void voteArticleWasHelpful(WebDriver driver){
		try{
			
			utilityFunctions.waitForElementToBeClickable(driver, Locators.articlesTabOnHomePage);
			articlesTabOnHomePage.click();
			utilityFunctions.waitForElementToBeClickable(driver, Locators.firstArticleOnArticlesScreen);
			secondArticleOnArticlesScreen.click();
			utilityFunctions.waitForElementToBeClickable(driver, Locators.yesArticleWasHelpful);
			yesArticleWasHelpful.click();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void voteArticleWasNotHelpful(WebDriver driver){
		try{
			noArticleWasNotHelpful.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public boolean presenceOfPercentArticleWasHelpful(WebDriver driver){
		try{
			utilityFunctions.checkElementExistence(driver, Locators.percentOfArticleHelpful);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
}
