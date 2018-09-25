package test.service;


import org.junit.*;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class addNewProductToDbTest extends ScenarioTest<Given, When, Then> {
	WebDriver driver;
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/NameOfYourApplication/");
	}
	
	@After
	public void clean() {
	driver.quit();
	}
	
	@Test
	public void a_product_can_be_added_througthe_ui_and_be_retrieved_from_the_db() throws Exception {
		given().a_product_with_the_id_$_description_$_price_$_and_waardering_$_is_filled_in_on_the_addProduct_form("product83", "achtendertigste product", 83.83, 80).
		and().product_is_added();
		
		when().i_ask_for_the_details_of_the_product_using_its_id();
		
		then().the_product_can_be_retrieved_from_the_db_with_id_$_description_$_price_$_waardering_$("product83", "achtendertigste product",  83.83, 80).
		and().the_webDriver_is_on_the_overview_page();
	}

}
