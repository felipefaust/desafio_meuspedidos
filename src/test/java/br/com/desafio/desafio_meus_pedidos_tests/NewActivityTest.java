package br.com.desafio.desafio_meus_pedidos_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.desafio.desafio_meus_pedidos_pages.NewActivityPage;
import br.com.desafio.desafio_meus_pedidos_pages.NewSchedulingPage;
import br.com.desafio.desafio_meus_pedidos_pages.SchedulePage;

public class NewActivityTest extends DefaultClassTest {
	private static final String EMPTY_LIST_TEXT = "Não possui atividade.";
	private static final String SUCCESS_TEXT_SAVE = "Visita cadastrada com sucesso!";
	private SchedulePage schedulePage;
	private NewActivityPage newActivityPage;

	@Test
	public void newActivityTest() {
		setupPages();
		schedulePage.goToSchedulePage();
		registerActivity();
		schedulePage.filterByCompletedActivity();
		deleteAndValidateActivity();
	}

	private void deleteAndValidateActivity() {
		schedulePage.alterSchedulingClick();
		newActivityPage.deleteActivity();
		Assert.assertEquals(schedulePage.schedulePageIsVisible(), true);
		Assert.assertEquals(schedulePage.getTextToListScheduleEmpty(), EMPTY_LIST_TEXT);
	}

	private void setupPages() {
		schedulePage = new SchedulePage(driver);
		newActivityPage = new NewActivityPage(driver);
	}

	private void registerActivity() {
		schedulePage.newActivityButtonClick();
		Assert.assertEquals(newActivityPage.newActivityIsVisible(), true);
		newActivityPage.descriptionSendKeys("Atividade teste");
		newActivityPage.clickSave();
		Assert.assertEquals(schedulePage.toasterSuccessIsVisible(), SUCCESS_TEXT_SAVE);

	}

}
