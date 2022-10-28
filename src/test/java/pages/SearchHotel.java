package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchHotel {
	
	public SearchHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	WebElement loc;
	@FindBy(id = "Submit")
	WebElement submit;

	public void selectLocation() {
		new Select(loc).selectByVisibleText("Paris");
	}

	public void clickSearchBtn() {
		submit.click();

	}

}
