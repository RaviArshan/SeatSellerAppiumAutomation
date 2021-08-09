package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage 
{
public LoginPage(AppiumDriver driver)
{
PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

@AndroidFindBy(id ="psl.seatseller.android:id/edt_user_name")
public WebElement ssUserName;

@AndroidFindBy(id="psl.seatseller.android:id/edit_password")
public WebElement ssPassword;

@AndroidFindBy(id="psl.seatseller.android:id/btn_login")
public WebElement ssLoginBtn;
}
