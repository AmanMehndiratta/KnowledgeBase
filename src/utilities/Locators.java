package utilities;

public class Locators {
	
	public static final String loginButton = "//*[@id='login-btnContent']";
	public static final String loginWithMobiControl = ".//*[@id='header']/div/div[2]/span[2]/div/div/ul/li[1]/a";
	public static final String mobiControlEnterEmail = ".//*[@id='mobicontrolEmail']";
	public static final String mobiControlEnterPassword = ".//*[@id='mobicontrolPassword']";
	public static final String mobiControlLoginButton = ".//*[@id='mobicontrolLoginFooter']/div/button[2]";
	public static final String closeMobiControlLoginPopup = ".//*[@id='mobicontrolLogin']/div[1]/button";
	
	//Buttons which are uniform all across the application
	public static final String logoutButton = ".//*[@id='header']/div/div[2]/span[3]/div[2]/div[2]/ul/li[9]/a";
	public static final String feedbackButton = "html/body/div[12]/a";
	public static final String userProfileIcon = ".//*[@id='user-manage-section']/div"; 
	
	
	//HomePage elements
	public static final String homePageTitle = "html/body/div[2]/div/ul/li[1]/h1";
	public static final String questionsForYou = "html/body/main/div/div/div[2]/div[3]/div/ul/li[3]/a/i";
	public static final String articlesTabOnHomePage = "html/body/main/div/div/div[1]/ul/li[2]/a";
	public static final String questionsTabOnHomePage = "html/body/main/div/div/div[1]/ul/li[1]/a";
	public static final String askQuestionButton = ".//*[@id='header']/div/div[2]/span[2]/a";
	public static final String answerButtonForFirstTopic = "/html/body/main/div/div/div[2]/div[4]/div/div[1]/div[2]/div[2]/div/ul/li[1]/a";
	public static final String answerTestFieldForFirstTopic = "//*[@id='tinymce']";
	public static final String cancelAnswerTestFieldForFirstTopic = "/html/body/main/div/div/div[2]/div[4]/div/div[1]/div[4]/div/form/div/div[3]/button";
	public static final String whiteSpaceForFirstAnswerTextField = "/html/body/main/div/div/div[2]/div[4]/div/div[1]/div[4]/div/form/div/div[3]";
	public static final String firstTopicOnHomePage = "/html/body/main/div/div/div[2]/div[4]/div/div[1]/div[2]/div[1]/h4/a";

	//Topic Detail screen
	public static final String answerButtonOnFirstTopicDetail = "/html/body/main/div[1]/div/div[4]/div[6]/div/ul/li[1]/font[1]/a";
	public static final String answerButtonOnTopicDetailScreen = "/html/body/main/div[1]/div/div[4]/div[6]/div/ul/li[1]/font[1]/a";
	public static final String answerTestFieldForFirstTopicOnTopicDetailScreen = "//*[@id='tinymce']";
	public static final String cancelAnswerTestFieldForFirstTopicOnTopicDetailScreen = "//*[@id='postcodeform']/div/div[2]/a";
	
	//Article Detial screen
	public static final String yesArticleWasHelpful = "html/body/main/div[1]/div/div[4]/div[3]/div/div/div[1]/ul/li/span[2]/button[1]";
	public static final String noArticleWasNotHelpful = "html/body/main/div[1]/div/div[4]/div[3]/div/div/div[1]/ul/li/span[2]/button[2]";
	public static final String percentOfArticleHelpful = "html/body/main/div[1]/div/div[4]/div[3]/div/div/div[2]";
	public static final String firstArticleOnArticlesScreen = "html/body/main/div/div/div[2]/div[4]/div[1]/div/div/div/h4/a";
	public static final String secondArticleOnArticlesScreen = "html/body/main/div/div/div[2]/div[4]/div[2]/div/div/div/h4/a";
	
	
	//Add article screen
	public static final String askQuestionTab = "html/body/main/div/div/div[3]/ul/li[1]/a";
	public static final String writeAnArticleTab = "html/body/main/div/div/div[3]/ul/li[2]/a";
	public static final String deleteDraft = "html/body/main/div/div/div[6]/div/div/div[2]/button";
	public static final String editDraft = ".//*[@id='edit-draft']";
	public static final String articleHeadline = ".//*[@id='nameCreateTopics']";
	public static final String articleDescription = ".//*[@id='tinymce']";
	public static final String articleCategoryategoryDropdown = ".//*[@id='articlecreator']/div[4]/div/button";
	public static final String postArticleButton = ".//*[@id='articlecreator']/div[6]/div/div/button";
	public static final String mobiControlArticleCategoryDropdown = ".//*[@id='articlecreator']/div[4]/div/div/ul/li[2]/a/span[1]";



	

}
