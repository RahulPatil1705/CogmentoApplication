package utilsLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseLayer.BaseClass;

public class HandleActions extends BaseClass {

	public static void click(WebElement wb) {
		new Actions(driver).click(Wait.visiblityOf(wb)).build().perform();
	}

	public static void sendKeys(WebElement wb, String value) {
		new Actions(driver).sendKeys(Wait.visiblityOf(wb), value).build().perform();
	}

	public static void enterUpperCaseText(WebElement wb, String value) {
		new Actions(driver).keyDown(Keys.SHIFT).sendKeys(Wait.visiblityOf(wb), value).build().perform();
	}
	
	public static void selectElementClickCntAndA(WebElement wb, String value) {
	    Actions actions = new Actions(driver);
	    
	    actions.click(wb) // Click inside the input field
	           .keyDown(Keys.CONTROL) // Hold Ctrl
	           .sendKeys("a") // Press 'A' (Select all text)
	           .keyUp(Keys.CONTROL) // Release Ctrl
	           .sendKeys(Keys.DELETE) // Delete selected text
	           .sendKeys(value) // Enter new text
	           .build()
	           .perform();
	}


	public static void moveToElement(WebElement wb) {
		new Actions(driver).moveToElement(Wait.visiblityOf(wb)).build().perform();
	}

	public static void doubleClick(WebElement wb) {
		new Actions(driver).doubleClick(Wait.visiblityOf(wb)).build().perform();
	}

	public static void contextClick(WebElement wb) {
		new Actions(driver).contextClick(Wait.visiblityOf(wb)).build().perform();
	}

	public static void clickAndHold(WebElement wb) {
		new Actions(driver).clickAndHold(Wait.visiblityOf(wb)).build().perform();
	}

	public static void release(WebElement wb) {
		new Actions(driver).release(Wait.visiblityOf(wb)).build().perform();
	}

	public static void dragAndDrop(WebElement src, WebElement trg) {
		new Actions(driver).dragAndDrop(Wait.visiblityOf(src), Wait.visiblityOf(trg)).build().perform();
	}

}
