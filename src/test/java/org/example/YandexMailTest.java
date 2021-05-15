package org.example;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;


public class YandexMailTest extends BaseTest{

    @Given("I browse to http://yandex.ru")
    public void i_browse_to_yandex_ru(){
        getDriver();
        driver.get("https://www.yandex.ru/");
    }

    @When("I click \"Log in\" button")
    public void i_click_log_in_button(){
        driver.findElement(By.cssSelector("div[role=form] a.button")).click();
    }

    @Then("I see passport page")
    public void i_see_passport_page(){
        assertTrue(driver.getCurrentUrl().contains("passport.yandex.ru"));
    }

    @When("I enter (.*) in login field")
    public void i_enter_username_in_login_field(String username){
        driver.findElement(By.cssSelector(".passport-Domik-Form-Field input[name=login]")).sendKeys(username);
    }

    @When("I enter (.*) in password field")
    public void i_enter_password_in_password_field(String password){
        driver.findElement(By.cssSelector(".passport-Domik-Form-Field input[name=passwd]")).sendKeys(password);
    }

    @When("I click \"Enter\" button")
    public void i_click_enter_button(){
        driver.findElement(By.cssSelector("button[type=submit]")).submit();
    }

    @Then("I see error message")
    public void i_see_error_message(){
        WebElement errorMessage = driver.findElement(By.cssSelector(".passport-Domik-Form-Error.passport-Domik-Form-Error_active"));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        assertTrue(errorMessage.getText().contains("Неверный пароль"));
    }

}