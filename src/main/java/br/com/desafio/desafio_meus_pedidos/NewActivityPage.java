package br.com.desafio.desafio_meus_pedidos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewActivityPage  {
	
	private static final String ID_CALL_OPTION_TYPE = "uniform-id_tipo_atividade_1";
	private static final String ID_DELETE_BUTTON = "btn_excluir_atividade_modal";
	private static final String ID_DESCRIPTION = "id_descricao";
	private static final String LINK_SAVE = "Salvar";
	private static final String XPATH_DELETE_BUTTON = "//*[@id='form-cadastro']/div[9]/a[3]";
	
	private WebDriver driver;

	public NewActivityPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean newActivityIsVisible() {
		return driver.findElement(By.id(ID_CALL_OPTION_TYPE)).isDisplayed();
	}

	public void descriptionSendKeys(String description) {
		driver.findElement(By.id(ID_DESCRIPTION)).sendKeys(description);
	}

	public void deleteActivity() {
		driver.findElement(By.xpath(XPATH_DELETE_BUTTON)).click();
		driver.findElement(By.id(ID_DELETE_BUTTON)).click();
	}

	public void clickSave() {
		driver.findElement(By.linkText(LINK_SAVE)).click();
	}

}
