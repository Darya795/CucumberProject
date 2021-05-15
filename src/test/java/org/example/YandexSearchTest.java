package org.example;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class YandexSearchTest extends BaseTest{

    @Given("I browse to yandex.ru")
    public void i_browse_to_yandex_ru(){
        getDriver();
        driver.get("https://www.yandex.ru/");
    }

    @When("I enter \"(.*)\" in text field")
    public void i_enter_text_in_text_field(String text){
        driver.findElement(By.id("text")).sendKeys(text);
    }

    @When("I click \"Search\" button")
    public void i_click_search_button(){
        driver.findElement(By.cssSelector(".search2__button button[type=submit]")).click();
    }

    @Then("I see (.*) in results")
    public void i_see_domain_in_results(String domain){
        assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'path')]/a[contains(@class, 'link')]/b[contains(text(), '"+domain+"')]")).getText().contains(domain));
    }
}
