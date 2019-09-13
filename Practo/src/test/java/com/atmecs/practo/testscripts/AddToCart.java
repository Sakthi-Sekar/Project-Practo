package com.atmecs.practo.testscripts;


import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.atmecs.practo.constants.LogReports;
import com.atmecs.practo.helpers.ReadPropertiesFile;
import com.atmecs.practo.helpers.ValidatePracto;
import com.atmecs.practo.pages.PageActions;
import com.atmecs.practo.testbase.InvokeBrowser;
import com.atmecs.practo.utils.ValidateTestResult;

public class AddToCart extends InvokeBrowser {
	String Xpath;
	String cssSelector;
	ValidatePracto validata = new ValidatePracto();

	@Test(priority = 1)
	public void clickOnDiagnostics() throws Exception {

		ReadPropertiesFile read = new ReadPropertiesFile();

		Xpath = read.readPropertiesFile("loc.btn.diagnostics.xpath");
		PageActions.ClickElement(driver, Xpath);
		log.info("Clicked on Diagnostics...");
		Xpath = read.readPropertiesFile("loc.field.selectanycityorlocality.xpath");
		PageActions.ClickElement(driver, Xpath);
		Thread.sleep(3000);
		log.info("Selected city...");
		Xpath = read.readPropertiesFile("loc.field.searchfortestsandprofiles.xpath");
		PageActions.ClickElement(driver, Xpath);
		Thread.sleep(3000);
		log.info("Entered into next field to select test sample...");

//To select CBC Test

		// driver.findElement(By.cssSelector("#omniSearch")).sendKeys("CBC Test");
		cssSelector = read.readPropertiesFile("loc.field.cbctest.cssselector");
		PageActions.cssSendKeys(driver, cssSelector, "CBC Test");
		// driver.findElement(By.cssSelector("cssSelector")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		log.info("CBC Test sample selected...");
// Click on Add(CBC Test) to Cart

		Xpath = read.readPropertiesFile("loc.btn.addtocartclick.xpath");
		PageActions.clickOnElement(driver, Xpath);
		Thread.sleep(3000);
		log.info("CBC Test added to cart...");

//Remove previous search(CBC Test)
		Xpath = read.readPropertiesFile("loc.select.removesymbolcbctest.xpath");
		PageActions.clickOnElement(driver, Xpath);
		Thread.sleep(7000);
		log.info("CBC Test search removed from the field...");
// To select Serium Lipase 
		cssSelector = read.readPropertiesFile("loc.field.selecttestsseriumlipase.cssselector");
		Thread.sleep(3000);
		PageActions.cssSendKeys(driver, cssSelector, "Serum Lipase");
		Thread.sleep(7000);
		log.info("Serium Lipase sample selected...");

//Click on Add (serium Lipase) to Cart
		Xpath = read.readPropertiesFile("loc.addseriumlipasetocart.xpath");
		Thread.sleep(3000);
		PageActions.clickOnElement(driver, Xpath);
		Thread.sleep(3000);
		log.info("Serium Lipase added to cart...");
//To remove the last search(SeriumLipase)
		Xpath = read.readPropertiesFile("loc.select.removesymbolseriumlipase.xpath");
		PageActions.clickOnElement(driver, Xpath);
		log.info("Serium Lipase search removed from the field...");
// To select T3 T4 TSH test
		cssSelector = read.readPropertiesFile("loc.select.t3t4tsh.cssselector");
		Thread.sleep(3000);
		PageActions.cssSendKeys(driver, cssSelector, "T3 T4 TSH");
		Thread.sleep(5000);
		log.info("T3 T4 TSH sample selected...");
// Click on Add(T3 T4 TSH) to Cart
		Xpath = read.readPropertiesFile("loc.btn.addtocartt3t4tsh.xpath");
		Thread.sleep(3000);
		PageActions.clickOnElement(driver, Xpath);
		Thread.sleep(3000);
		log.info("T3 T4 TSH added to cart...");
	}

	@Test(priority = 2)
	public void validateAfterAdd() throws FileNotFoundException {
		validata.namesOfSampleEqual(driver);
		validata.numberOfTestsEqual(driver);
		validata.individualSamplePriceEqual(driver);
		validata.pickUpChargeEqual(driver);
		validata.initialTotalPriceEqual(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
