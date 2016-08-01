package br.com.desafio.desafio_meus_pedidos_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos_pages.NewSchedulingPage;
import br.com.desafio.desafio_meus_pedidos_pages.SchedulePage;

public class NewSchedulingByOtherUserTest extends DefaultClassTest{
	private static final String SUCCESS_TEXT_SAVE = "Visita cadastrada com sucesso!";
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private SchedulePage schedulePage;
	private NewSchedulingPage newSchedulingPage;
	
	@Test
	public void newSchedulingByOtherUser() {
		setupPages();
		schedulePage.goToSchedulePage();
		schedulePage.clickNewSchedulingButton();
		createSchedulingWithOtherUser();
		findAndDeleteSchedule();
		
	}

	private void findAndDeleteSchedule() {
		schedulePage.filterByUser();
		schedulePage.clickAlterScheduling();
		newSchedulingPage.deleteScheduling();
		Assert.assertEquals(schedulePage.isVisibleSchedulePage(),true);
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void createSchedulingWithOtherUser() {
		Assert.assertEquals(newSchedulingPage.isVisibleNewScheduling(), true);
		newSchedulingPage.changeUser();
		newSchedulingPage.clickSave();
		Assert.assertEquals(schedulePage.isVisibleToasterSuccess(), SUCCESS_TEXT_SAVE);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newSchedulingPage = new NewSchedulingPage(driver);
	}
}
