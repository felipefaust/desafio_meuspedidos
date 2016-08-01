package br.com.desafio.desafio_meus_pedidos_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos_pages.NewActivityPage;
import br.com.desafio.desafio_meus_pedidos_pages.NewSchedulingPage;
import br.com.desafio.desafio_meus_pedidos_pages.SchedulePage;

public class NewActivityTest extends DefaultClassTest{
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private SchedulePage schedulePage;
	private NewActivityPage newActivityPage;

	@Test
	public void newActivityTest(){
		setupPages();
		schedulePage.goToSchedulePage();
		registerActivity();
		schedulePage.filterByCompletedActivity();
		deleteAndValidateActivity();
	}

	private void deleteAndValidateActivity() {
		schedulePage.clickAlterScheduling();
		newActivityPage.deleteActivity();
		Assert.assertEquals(schedulePage.isVisibleSchedulePage(),true);
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}
	
	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newActivityPage = new NewActivityPage(driver);
	}
	
	private void registerActivity() {
		schedulePage.clickNewActivityButton();
		Assert.assertEquals(newActivityPage.isVisibleNewActivity(), true);
		newActivityPage.sendKeysDescription("Atividade teste");
		newActivityPage.clickSave();
		Assert.assertEquals(schedulePage.isVisibleToasterSuccess(), "Visita cadastrada com sucesso!");
		
	}
	
}
