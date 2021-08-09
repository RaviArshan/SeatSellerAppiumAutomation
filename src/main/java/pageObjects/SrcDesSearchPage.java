package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SrcDesSearchPage 
{
public SrcDesSearchPage(AppiumDriver driver)
{
	PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}
@AndroidFindBy(id= "psl.seatseller.android:id/home_edt_from")
public WebElement src;


@AndroidFindBy( id="psl.seatseller.android:id/home_edt_to")
public WebElement des;

@AndroidFindBy(id="psl.seatseller.android:id/home_btn_search")
public WebElement searchBtn;


}
