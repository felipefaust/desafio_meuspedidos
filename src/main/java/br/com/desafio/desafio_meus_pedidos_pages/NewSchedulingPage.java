package br.com.desafio.desafio_meus_pedidos_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewSchedulingPage {
	private static final String XPATH_DELETE_BUTTON = "//*[@id='form-cadastro']/div[9]/a[3]";
	private static final String ID_DELETE_BUTTON = "btn_excluir_atividade_modal";
	protected WebDriver driver;
	
	public NewSchedulingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isVisibleNewScheduling(){
		return driver.findElement(By.id("uniform-id_tipo_atividade_1")).isDisplayed();
	}
	
	public void clickTypeCallOption(){
		driver.findElement(By.id("uniform-id_tipo_atividade_1")).click();
	}

	public void setCostumer(String costumerName) {
		WebElement costumerInputText = driver.findElement(By.id("id_cliente_atividade"));
		costumerInputText.sendKeys(costumerName);	
		driver.findElement(By.partialLinkText("Supermercado do Bairro")).click();
	}

	public boolean isVisibleCostumerSelected() {
		return driver.findElement(By.id("selecionado_autocomplete_id_cliente_atividade")).isDisplayed();
	}

	public void sendKeysNote(String note) {
		 driver.findElement(By.id("id_observacao")).sendKeys(note);
	}

	public void clickSave() {
		 driver.findElement(By.linkText("Salvar")).click();		
	}
	
	public void clickDeleteCall() {
		driver.findElement(By.linkText("Excluir Ligação")).click();
	}
	
	public void deleteScheduling(){
		driver.findElement(By.xpath(XPATH_DELETE_BUTTON)).click();
		driver.findElement(By.id(ID_DELETE_BUTTON)).click();
	}

	public void closeScheduling() {
		driver.findElement(By.linkText("Cancelar")).click();
	}
	
	public void changeUser(){
		Select user = new Select(driver.findElement(By.xpath("//*[@id='form-cadastro']/div[5]/div[2]/select")));
		user.selectByVisibleText("Faust2");
	}
}
