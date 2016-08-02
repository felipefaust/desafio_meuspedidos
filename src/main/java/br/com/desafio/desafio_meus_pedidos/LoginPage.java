package br.com.desafio.desafio_meus_pedidos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static final String CLASSNAME_SAVE_BUTTON = "btn_verde";
	private static final String ID_PASSWORD_INPUT = "id_senha";
	private static final String ID_USERNAME_INPUT = "id_usuario";
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void doLogin(String email, String password) {
		driver.findElement(By.id(ID_USERNAME_INPUT)).sendKeys(email);
		driver.findElement(By.id(ID_PASSWORD_INPUT)).sendKeys(password);
		driver.findElement(By.className(CLASSNAME_SAVE_BUTTON)).click();
	}
}
