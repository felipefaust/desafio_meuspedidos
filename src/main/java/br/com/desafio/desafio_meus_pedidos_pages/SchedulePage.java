package br.com.desafio.desafio_meus_pedidos_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SchedulePage {
	private static final String CLASSNAME_ALTER_SCHEDULE = "icon-pencil";
	private static final String CLASSNAME_CHECK = "check_clear";
	private static final String CLASSNAME_CHECK_OUT = "check_out";
	private static final String CLASSNAME_SHOW_NOTE = "link_mostrar";
	private static final String CLASSNAME_TOASTER = "gritter-message";
	private static final String ID_ACTIVITY_BUTTON = "btn_registrar_atividade";
	private static final String ID_DESCRIPTION = "id_descricao";
	private static final String ID_MENU_SCHEDULE = "aba_agenda";
	private static final String ID_NEW_ACTIVITY_BUTTON = ID_ACTIVITY_BUTTON;
	private static final String ID_OPTION_2 = "id_status_chzn_o_2";
	private static final String ID_SCHEDULING_BUTTON = "btn_novo_agendamento";
	private static final String ID_SELECT_FILTER = "id_status_chzn";
	private static final String ID_SELECT_USER = "id_colaborador_chzn";
	private static final String ID_USER_2 = "id_colaborador_chzn_o_2";
	private static final String LINK_SAVE = "Salvar";
	private static final String XPATH_EMPTY_LIST = "//*[@id='atividades']/li/div";
	private static final String XPATH_NOTE_INPUT = "//*[@id='atividades']/li/div[2]/div/div[4]/textarea";
	private static final String XPATH_NOTE_ITEM_LIST = "//*[@id='atividades']/li/div[2]/div/div[3]/blockquote/div";
	
	
	private WebDriver driver;

	public SchedulePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToSchedulePage() {
		driver.findElement(By.id(ID_MENU_SCHEDULE)).click();
	}

	public void newSchedulingButtonClick() {
		driver.findElement(By.id(ID_SCHEDULING_BUTTON)).click();
	}

	public void newActivityButtonClick() {
		driver.findElement(By.id(ID_NEW_ACTIVITY_BUTTON)).click();
	}

	public boolean schedulePageIsVisible() {
		return driver.findElement(By.id(ID_SCHEDULING_BUTTON)).isDisplayed();
	}

	public String toasterSuccessIsVisible() {
		return driver.findElement(By.className(CLASSNAME_TOASTER)).getText();
	}

	public void alterSchedulingClick() {
		driver.findElement(By.className(CLASSNAME_ALTER_SCHEDULE)).click();
	}

	public String getTextToListScheduleEmpty() {
		return driver.findElement(By.xpath(XPATH_EMPTY_LIST)).getText();
	}

	public String getTextToNoteItemListSchedule() {
		return driver.findElement(By.xpath(XPATH_NOTE_ITEM_LIST)).getText();
	}

	public void setDoneCall() {
		driver.findElement(By.className(CLASSNAME_CHECK)).click();
	}

	public boolean callIsDone() {
		return driver.findElement(By.className(CLASSNAME_CHECK_OUT)).isDisplayed();
	}

	public void commentCall(String text) {
		driver.findElement(By.className(CLASSNAME_SHOW_NOTE)).click();
		driver.findElement(By.xpath(XPATH_NOTE_INPUT)).sendKeys(text);
		driver.findElement(By.linkText(LINK_SAVE)).click();
	}

	public String getCommentCall() {
		return driver.findElement(By.id(ID_DESCRIPTION)).getText();
	}

	public void filterByUser() {
		driver.findElement(By.id(ID_SELECT_USER)).click();
		driver.findElement(By.id(ID_USER_2)).click();
	}

	public void filterByCompletedActivity() {
		driver.findElement(By.id(ID_SELECT_FILTER)).click();
		driver.findElement(By.id(ID_OPTION_2)).click();
	}

	public boolean buttonActivityIsVisibe() {
		return driver.findElement(By.id(ID_ACTIVITY_BUTTON)).isDisplayed();
	}

}
