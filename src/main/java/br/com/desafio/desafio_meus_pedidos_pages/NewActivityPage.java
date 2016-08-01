package br.com.desafio.desafio_meus_pedidos_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewActivityPage extends NewSchedulingPage {

	private static final String ID_DESCRIPTION = "id_descricao";

	public NewActivityPage(WebDriver driver) {
		super(driver);
	}

	public boolean newActivityIsVisible() {
		return newSchedulingIsVisible();
	}

	public void descriptionSendKeys(String description) {
		driver.findElement(By.id(ID_DESCRIPTION)).sendKeys(description);
	}

	public void deleteActivity() {
		deleteScheduling();
	}

}
