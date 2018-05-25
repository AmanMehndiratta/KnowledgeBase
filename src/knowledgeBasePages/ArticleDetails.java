package knowledgeBasePages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Locators;
import utilities.utilityFunctions;

public class ArticleDetails {

	HomePage hp;
	WebDriver driver;

	public ArticleDetails(WebDriver driver) {
		this.driver = driver;
	}

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
	
	@FindBy(xpath = Locators.writeAnArticleTab)
	public WebElement writeAnArticleTab;
	
	@FindBy(xpath = Locators.deleteDraft)
	public WebElement deleteDraft;
	
	@FindBy(xpath = Locators.articleHeadline)
	public WebElement articleHeadline;
	
	@FindBy(xpath = Locators.articleDescription)
	public WebElement articleDescription;
	
	@FindBy(xpath = Locators.articleCategoryategoryDropdown)
	public WebElement articleCategoryategoryDropdown;
	
	@FindBy(xpath = Locators.postArticleButton)
	public WebElement postArticleButton;
	
	@FindBy(xpath = Locators.mobiControlArticleCategoryDropdown)
	public WebElement mobiControlArticleCategoryDropdown;
	
	@FindBy(xpath = Locators.askQuestionButton)
	public WebElement askQuestionButton;
	
	


	public void voteArticleWasHelpful() {
		try {

			utilityFunctions.waitForElementToBeClickable(Locators.articlesTabOnHomePage);
			articlesTabOnHomePage.click();
			utilityFunctions.waitForElementToBeClickable(Locators.firstArticleOnArticlesScreen);
			secondArticleOnArticlesScreen.click();
			utilityFunctions.waitForElementToBeClickable(Locators.yesArticleWasHelpful);
			yesArticleWasHelpful.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void voteArticleWasNotHelpful(WebDriver driver) {
		try {
			noArticleWasNotHelpful.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean presenceOfPercentArticleWasHelpful(WebDriver driver) {
		try {
			utilityFunctions.checkElementExistence(Locators.percentOfArticleHelpful);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean addArticleWithCorrectData(){
		try{
			utilityFunctions.waitForElementToBeClickable(Locators.askQuestionButton);
			askQuestionButton.click();
			utilityFunctions.waitForElementToBeClickable(Locators.writeAnArticleTab);
			writeAnArticleTab.click();
			if(utilityFunctions.checkElementExistence(Locators.deleteDraft) == true){
				deleteDraft.click();
			}
			articleHeadline.sendKeys(generateAutomatedPostTitle());
			articleDescription.sendKeys(generateAutomatedPostDesctiption(500));
			articleCategoryategoryDropdown.click();
			mobiControlArticleCategoryDropdown.click();
			postArticleButton.click();
			return true;
			
		}catch(Exception e){
			return false;
		}
		
	}
	
	public String generateAutomatedPostTitle() {
		try {
			String baseTitle = "This is an automated title ";
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String currentDateTimeStamp = baseTitle + dateFormat.format(date);
			return currentDateTimeStamp;
		} catch (Exception e) {
			return "can not generate the Automated Title due to following exception " + e;
		}
	}

	public static String[] generateRandomWords(int numberOfWords) {
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[random.nextInt(8) + 3]; //words of length 3 through 10. 
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) ('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}

	public String generateAutomatedPostDesctiption(int numberOfWords) {
		try {
			String baseTitle = "This is an automated desctiption " + "/n";
			String randomDescription = generateRandomWords(numberOfWords).toString();
			String finalDescription = baseTitle + randomDescription;
			return finalDescription;
		} catch (Exception e) {
			return "Can not generate the Desctiption Title due to following exception " + e;
		}
	}

}
