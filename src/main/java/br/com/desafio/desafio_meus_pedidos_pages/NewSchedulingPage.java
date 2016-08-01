package br.com.desafio.desafio_meus_pedidos_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewSchedulingPage {
	private static final String ID_NOTE = "id_observacao";
	private static final String LINK_DELETE_CALL = "Excluir Ligação";
	private static final String XPATH_USER_SELECT = "//*[@id='form-cadastro']/div[5]/div[2]/select";
	private static final String LINK_CANCEL = "Cancelar";
	private static final String LINK_SAVE = "Salvar";
	private static final String ID_COSTUMER_SELECTED = "selecionado_autocomplete_id_cliente_atividade";
	private static final String ID_COSTUMER_INPUT = "id_cliente_atividade";
	private static final String ID_ACTIVITY_OPTION_TYPE = "id_tipo_atividade_2";
	private static final String ID_CALL_OPTION_TYPE = "uniform-id_tipo_atividade_1";
	private static final String XPATH_DELETE_BUTTON = "//*[@id='form-cadastro']/div[9]/a[3]";
	private static final String ID_DELETE_BUTTON = "btn_excluir_atividade_modal";
	protected WebDriver driver;

	public NewSchedulingPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isVisibleNewScheduling() {
		return driver.findElement(By.id(ID_CALL_OPTION_TYPE)).isDisplayed();
	}

	public void clickTypeCallOption() {
		driver.findElement(By.id(ID_CALL_OPTION_TYPE)).click();
	}

	public void clickTypeActivityOption() {
		driver.findElement(By.id(ID_ACTIVITY_OPTION_TYPE)).click();
	}

	public void setCostumer(String costumerName) {
		WebElement costumerInputText = driver.findElement(By.id(ID_COSTUMER_INPUT));
		costumerInputText.sendKeys(costumerName);
		driver.findElement(By.partialLinkText(costumerName)).click();
	}

	public boolean isVisibleCostumerSelected() {
		return driver.findElement(By.id(ID_COSTUMER_SELECTED)).isDisplayed();
	}

	public void sendKeysNote(String note) {
		driver.findElement(By.id(ID_NOTE)).sendKeys(note);
	}

	public void clickSave() {
		driver.findElement(By.linkText(LINK_SAVE)).click();
	}

	public void clickDeleteCall() {
		driver.findElement(By.linkText(LINK_DELETE_CALL)).click();
	}

	public void deleteScheduling() {
		driver.findElement(By.xpath(XPATH_DELETE_BUTTON)).click();
		driver.findElement(By.id(ID_DELETE_BUTTON)).click();
	}

	public void closeScheduling() {
		driver.findElement(By.linkText(LINK_CANCEL)).click();
	}

	public void changeUser(String userName) {
		Select user = new Select(driver.findElement(By.xpath(XPATH_USER_SELECT)));
		user.selectByVisibleText(userName);
	}
}
