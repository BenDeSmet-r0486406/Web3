package test.service;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import org.junit.After;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import domain.model.Product;

public class Then extends Stage<Then> {
	@ExpectedScenarioState private Product productRetrieved;
	@ExpectedScenarioState private WebDriver driver;
	
	@After
	public void clean() {
	driver.quit();
	}
	
	public Then the_product_can_be_retrieved_from_the_db_with_id_$_description_$_price_$_waardering_$(String productId, String description, double price, int waardering){
		assertEquals(productId, productRetrieved.getId());
		assertEquals(description, productRetrieved.getDescription());
		assertTrue(price == productRetrieved.getPrice());
		assertEquals(waardering, productRetrieved.getWaardering());
		return self();
	}
	
	public Then the_webDriver_is_on_the_overview_page(){
		assertEquals("http://localhost:8080/NameOfYourApplication/Controller?action=ProductOverview" ,driver.getCurrentUrl());
		return self();
	}
	
}
