package knowledgeBasePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Locators;

public class AddArticle {

	@FindBy(xpath = Locators.writeAnArticleTab)
	public WebElement writeAnArticleTab;
	
	@FindBy(xpath = Locators.deleteDraft)
	public WebElement deleteDraft;
	
	public void createAnArticle(){
		
	}
	
	
}
