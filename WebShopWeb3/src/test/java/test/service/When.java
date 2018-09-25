package test.service;

import org.openqa.selenium.WebDriver;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import domain.model.Product;
import domain.service.ShopService;

public class When extends Stage<When> {
	@ExpectedScenarioState private WebDriver driver;
	@ExpectedScenarioState private String productId;
	@ProvidedScenarioState private Product productRetrieved;
	@ProvidedScenarioState private ShopService service;
	
	public When i_ask_for_the_details_of_the_product_using_its_id() {
		productRetrieved = service.getProduct(productId);
		return self();
	}
}
