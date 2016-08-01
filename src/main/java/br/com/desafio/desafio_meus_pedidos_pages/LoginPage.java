package br.com.desafio.desafio_meus_pedidos_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void doLogin(String email, String password){
		driver.findElement(By.id("id_usuario")).sendKeys(email);
		driver.findElement(By.id("id_senha")).sendKeys(password);
		driver.findElement(By.className("btn_verde")).click();
	}
}
