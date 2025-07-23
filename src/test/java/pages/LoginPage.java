package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElements with @FindBy and @CacheLookup
	
	@FindBy(xpath ="//input[@name='username']")
	@CacheLookup
	private WebElement UserName;
	 
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	private WebElement PassWord;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement LoginButton;
	
	
	@FindBy(tagName="a")
	@CacheLookup
	private List<WebElement> Links;
	

	
	// Method for each action
	
	public void enterUserName(String uname)
	{
		UserName.sendKeys(uname);
	}
	
	public void enterPassword(String pWord)
	{
		PassWord.sendKeys(pWord);
	}
	
	public void clickLogin()
	{
		LoginButton.click();
	}
	
	public void getAllLinks()
	{
		System.out.println("Total links: " + Links.size());
		for( WebElement link: Links)
		{
			System.out.println("Link Text: " + link.getText());
            System.out.println("Link HREF: " + link.getAttribute("href"));
		}
	}
	

}
