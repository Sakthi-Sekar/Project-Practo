package com.atmecs.practo.testscripts;

import org.testng.annotations.Test;

import com.atmecs.practo.helpers.ValidatePracto;
import com.atmecs.practo.pages.PageActions;


public class RemoveFromCart extends AddToCart {
	ValidatePracto practo=new ValidatePracto();
	// Remove CBC Test from the cart

	@Test(priority = 3)
	public void cartAfterRemovalOfSample() throws Exception {
		Xpath = read.readPropertiesFile("loc.removecbcfromcart.xpath");
		Thread.sleep(3000);
		PageActions.clickOnElement(driver, Xpath);
		Thread.sleep(3000);
		log.info("CBC Test sample removed...");
	}

	// Validation of total price after removing one sample test

	@Test(priority = 4)
	public void validateCartAfterRemoval() {

	

	
	practo.validateRemainingSampleNames();
	practo.validateNumberOfTestCount();
	practo.validatePriceAfterRemoval();
	practo.validatePickupChargeAfterRemoval();
	practo.validateFinalPrice();
	

	

	}
}