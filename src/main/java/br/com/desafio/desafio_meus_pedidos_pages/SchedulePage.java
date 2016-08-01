package br.com.desafio.desafio_meus_pedidos_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SchedulePage {
	private static final String ID_NEW_ACTIVITY_BUTTON = "btn_registrar_atividade";
	private static final String CLASS_CLOSE_TOASTER = "gritter-close";
	private static final String CLASS_TOASTER = "gritter-message";
	private static final String ID_MENU_SCHEDULE = "aba_agenda";
	private static final String ID_SCHEDULING_BUTTON = "btn_novo_agendamento";
	private WebElement newSchedulingButton;
	private WebDriver driver;
	
	public SchedulePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goToSchedulePage(){
		driver.findElement(By.id(ID_MENU_SCHEDULE)).click();
	}
	
	public void clickNewSchedulingButton(){
		driver.findElement(By.id(ID_SCHEDULING_BUTTON)).click();
	}

	public void clickNewActivityButton(){
		driver.findElement(By.id(ID_NEW_ACTIVITY_BUTTON)).click();
	}
	
	public boolean isVisibleSchedulePage(){
		return driver.findElement(By.id(ID_SCHEDULING_BUTTON)).isDisplayed();
	}

	public String isVisibleToasterSuccess() {
		return driver.findElement(By.className(CLASS_TOASTER)).getText();
	}

	public void clickAlterScheduling() {
		driver.findElement(By.className("icon-pencil")).click();
	}
	
	public String getTextToListScheduleEmpty(){
		return driver.findElement(By.xpath("//*[@id='atividades']/li/div")).getText();
	}
	public String getTextToNoteItemListSchedule(){
		return driver.findElement(By.xpath("//*[@id='atividades']/li/div[2]/div/div[3]/blockquote/div")).getText();
	}

	public void setDoneCall() {
		driver.findElement(By.className("check_clear")).click();
		
	}

	public boolean isDoneCall() {		
		return driver.findElement(By.className("check_out")).isDisplayed();
	}

	public void commentCall(String text) {
		driver.findElement(By.className("link_mostrar")).click();
		driver.findElement(By.xpath("//*[@id='atividades']/li/div[2]/div/div[4]/textarea")).sendKeys(text);
		driver.findElement(By.linkText("Salvar")).click();
	}

	public String getCommentCall() {
		return driver.findElement(By.id("id_descricao")).getText();
	}
	
	public void filterByUser(){
		driver.findElement(By.id("id_colaborador_chzn")).click();
		driver.findElement(By.id("id_colaborador_chzn_o_2")).click();
	}
	
	public void filterByCompletedActivity(){
		driver.findElement(By.id("id_status_chzn")).click();
		driver.findElement(By.id("id_status_chzn_o_2")).click();
	}

	public boolean isVisibleButtonActivity() {
		return driver.findElement(By.id("btn_registrar_atividade")).isDisplayed();
	}
	
	
}
