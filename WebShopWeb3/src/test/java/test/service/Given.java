package test.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;


public class Given extends Stage<Given> {	
	@ProvidedScenarioState private WebDriver driver;
	@ProvidedScenarioState private String productId;
	
	@BeforeScenario
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/NameOfYourApplication/");
	}
	
	 public Given a_product_with_the_id_$_description_$_price_$_and_waardering_$_is_filled_in_on_the_addProduct_form(String productId, String description , double price, int waardering) throws Exception {
		 	this.productId = productId;
		 	String priceString = Double.toString(price);
		 	String waarderingString = Integer.toString(waardering);
		 	driver.findElement(By.linkText("addProduct")).click();
		    driver.findElement(By.id("productid")).clear();
		    driver.findElement(By.id("productid")).sendKeys(productId);
		    driver.findElement(By.id("description")).clear();
		    driver.findElement(By.id("description")).sendKeys(description);
		    driver.findElement(By.id("price")).clear();
		    driver.findElement(By.id("price")).sendKeys(priceString);
		    driver.findElement(By.id("waardering")).clear();
		    driver.findElement(By.id("waardering")).sendKeys(waarderingString);
		    return self();
	 }
	 
	 public Given product_is_added()throws Exception{
		 driver.findElement(By.id("AddProduct")).click();
		 return self();
	 }
}
