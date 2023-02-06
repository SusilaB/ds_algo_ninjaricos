package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_class.BaseClass;
import utils.ConfigReader;

public class SignIn_POM {

	public static WebDriver driver = BaseClass.getDriver();
	String loginurl = ConfigReader.loginPage();
	String registerurl = ConfigReader.registerPageURL();

	@FindBy(xpath = "//input[@id='id_username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='id_password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
	WebElement alertMsg;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/a[1]")
	WebElement registerlink;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	WebElement successLogin;
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	WebElement signout;
	@FindBy(xpath = "//div[contains(text(),'Logged out successfully')]")
	WebElement successLogout;

	public SignIn_POM() {

		PageFactory.initElements(driver, this);

	}
//To get LOg in URL
	public void getLoginurl() {
		driver.get(loginurl);
	}

	public void enterUsername(String userName) {

		username.sendKeys(userName);

	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		loginbtn.click();
	}

	public String successAlert() {
		String alert = successLogin.getText();
		return alert;
	}

	public String invalidAlert() {
		String alertMessage = alertMsg.getText();
		return alertMessage;
	}

	public String validateUsernamefield(String validationMessge) {
		String message = username.getAttribute("validationMessage");
		System.out.println("message");
		return message;

	}

	public String validatePasswordfield(String validationMessge) {
		String message = password.getAttribute("validationMessage");
		System.out.println("message");
		return message;

	}

	public void register() {
		registerlink.click();
	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}
	public void logout() {
		signout.click();
	}

	public String successLogout() {
		String alert = successLogout.getText();
		return alert;
	}

}
